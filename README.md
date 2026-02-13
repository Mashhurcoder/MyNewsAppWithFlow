
<img width="300" height="500" alt="image" src="https://github.com/user-attachments/assets/645fc619-e4c6-46f6-8892-794fd7bce379" />
<img width="300" height="500" alt="image" src="https://github.com/user-attachments/assets/3aeda74e-d9e0-4992-ba6f-9d2ff53b8ef3" />





📰 News App
Bu loyiha Modern Android Development prinsiplari asosida yaratilgan yangiliklar ilovasi. Ilovada yangiliklarni masofaviy API orqali olish, ularni filtrlash va o'qish imkoniyatlari mavjud.

🚀 Texnologiyalar to'plami (Tech Stack)
Loyiha quyidagi zamonaviy kutubxonalar va yondashuvlar yordamida qurilgan:

Kotlin - Asosiy dasturlash tili.

Hilt (Dagger) - Dependency Injection (DI) uchun, loyihani modullarga ajratish va testlashni osonlashtirish uchun.

Retrofit - REST API bilan ishlash va tarmoq so'rovlarini boshqarish uchun.

Coroutines - Asinxron amallarni (background tasks) yengil va samarali bajarish uchun.

Flow - Ma'lumotlar oqimini (data streams) reaktiv usulda boshqarish va UI-ni yangilash uchun.

MVVM Architecture - Kodni toza saqlash va mantiqni UI-dan ajratish uchun.

🏗 Arxitektura
Ilova MVVM (Model-View-ViewModel) arxitekturasiga asoslangan. Ma'lumotlar oqimi quyidagicha tashkil etilgan:

Remote Data Source: Retrofit orqali API-dan ma'lumotlarni oladi.

Repository: Ma'lumotlarni manbasidan oladi va Flow orqali ViewModel-ga uzatadi.

ViewModel: Coroutines yordamida repository-dan ma'lumotni chaqiradi va UI holatini (StateFlow) boshqaradi.

UI (Activity/Fragment): ViewModel-dagi oqimni kuzatadi va ma'lumotlarni ekranda ko'rsatadi.
