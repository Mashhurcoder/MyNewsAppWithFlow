package com.example.mynewsappwithflow.data.repository

    import com.example.mynewsappwithflow.data.remote.model.param.NewsParam
    import com.example.mynewsappwithflow.data.remote.model.param.QueryItemsParam
    import com.example.mynewsappwithflow.data.remote.model.param.TopNewsParam
    import com.example.mynewsappwithflow.data.remote.model.response.ErrorResponse
    import com.example.mynewsappwithflow.data.remote.service.ApiService
    import com.google.gson.Gson
    import com.mashhurbek.myinfoaplication.data.repository.AppRepository
    import kotlinx.coroutines.Dispatchers
    import kotlinx.coroutines.flow.Flow
    import kotlinx.coroutines.flow.flow
    import kotlinx.coroutines.flow.flowOn
    import retrofit2.HttpException
    import javax.inject.Inject
    import javax.inject.Singleton

@Singleton
    class AppRepositoryImpl @Inject constructor(private val api: ApiService) : AppRepository {

        override fun getNews(): Flow<TopNewsParam> = flow {
           try {
               val response = api.getTopNews()
               val newList = response.top_news
                   ?.firstOrNull()
                   ?.news
                   ?.map { newsItem ->
                       NewsParam(
                           id = newsItem.id,
                           author = newsItem.author?: "",
                           image = newsItem.image,
                           date = newsItem.publish_date,
                           name = newsItem.title,
                           desc = newsItem.text,
                           url = newsItem.url
                       )
                   }
                   .orEmpty()
               emit(
                   TopNewsParam(
                       isSuccess = true,
                       message = "success",
                       topNews = newList
                   )
               )
           }catch (e: HttpException){
               val errorBody = e.response()?.errorBody()?.string()
               val errorResponse = Gson().fromJson(errorBody, ErrorResponse::class.java)
               emit(TopNewsParam(isSuccess = false, message = errorResponse.message?:"HTTP Error", topNews = emptyList()))
           }
           catch (e: Throwable){
               emit(TopNewsParam(isSuccess = false, message = e.message ?: "Unknown error", topNews = emptyList()))
           }
        }.flowOn(Dispatchers.IO)


        override fun getTextByQuery(text: String): Flow<QueryItemsParam> = flow {

            try {
                val response = api.getWords(text = text)
                val newList = response.news?.map { newsItem ->
                    NewsParam(
                        id = newsItem.id,
                        author = newsItem.author ?: "",
                        image = newsItem.image,
                        date = newsItem.publish_date,
                        name = newsItem.title,
                        desc = newsItem.text,
                        url = newsItem.url
                    )
                }.orEmpty()
                emit(QueryItemsParam(true,"Success!",newList))

            }catch (e: HttpException) {
                val errorBody = e.response()?.errorBody()?.string()
                val errorResponse = Gson().fromJson(errorBody, ErrorResponse::class.java)
                emit(
                    QueryItemsParam(
                        isSuccess = false,
                        message = errorResponse.message ?: "HTTP Error",
                        topNews = emptyList()
                    )
                )
            }catch (e: Throwable){
                emit(QueryItemsParam(false, e.message ?: "Unknown error", emptyList()))
            }
        }.flowOn(Dispatchers.IO)
    }