package com.example.androiditis2024

object AnimeRepository {

    val anime = arrayListOf(
        Anime(
            id = 0,
            name = "Naruto",
            description = "Я наруто",
            imagePath = "https://static.wikia.nocookie.net/naruto/images/0/09/Naruto_newshot.png/revision/latest/scale-to-width/360?cb=20210213224703&path-prefix=ru"
        ),
        Anime(
            id = 0,
            name = "Code Geass",
            description = "Код Гиас",
            imagePath = "https://upload.wikimedia.org/wikipedia/en/7/74/Code_Geass_R1_box_set_cover.jpg"
        ),
        Anime(
            id = 0,
            name = "FairyTail",
            description = "Хвост Феи",
            imagePath = "https://kinocensor.ru/cache/videos/12931/29c5c1d17214df20b6f037a283652db5-367x550.jpg"
        ),
        Anime(
            id = 0,
            name = "Attack on titan",
            description = "Атака титанов",
            imagePath = "https://moe.shikimori.one/uploads/poster/animes/16498/main_2x-3eaf768f3122e9c016485cbb9deebde1.webp"
        ),
        Anime(
            id = 0,
            name = "Naruto",
            description = "Я наруто",
            imagePath = "https://static.wikia.nocookie.net/naruto/images/0/09/Naruto_newshot.png/revision/latest/scale-to-width/360?cb=20210213224703&path-prefix=ru"
        ),
        Anime(
            id = 0,
            name = "Code Geass",
            description = "Код Гиас",
            imagePath = "https://upload.wikimedia.org/wikipedia/en/7/74/Code_Geass_R1_box_set_cover.jpg"
        ),
        Anime(
            id = 0,
            name = "FairyTail",
            description = "Хвост Феи",
            imagePath = "https://kinocensor.ru/cache/videos/12931/29c5c1d17214df20b6f037a283652db5-367x550.jpg"
        ),
        Anime(
            id = 0,
            name = "Attack on titan",
            description = "Атака титанов",
            imagePath = "https://moe.shikimori.one/uploads/poster/animes/16498/main_2x-3eaf768f3122e9c016485cbb9deebde1.webp"
        ),
        Anime(
            id = 0,
            name = "Naruto",
            description = "Я наруто",
            imagePath = "https://static.wikia.nocookie.net/naruto/images/0/09/Naruto_newshot.png/revision/latest/scale-to-width/360?cb=20210213224703&path-prefix=ru"
        ),
        Anime(
            id = 0,
            name = "Code Geass",
            description = "Код Гиас",
            imagePath = "https://upload.wikimedia.org/wikipedia/en/7/74/Code_Geass_R1_box_set_cover.jpg"
        ),
        Anime(
            id = 0,
            name = "FairyTail",
            description = "Хвост Феи",
            imagePath = "https://kinocensor.ru/cache/videos/12931/29c5c1d17214df20b6f037a283652db5-367x550.jpg"
        ),
        Anime(
            id = 0,
            name = "Attack on titan",
            description = "Атака титанов",
            imagePath = "https://moe.shikimori.one/uploads/poster/animes/16498/main_2x-3eaf768f3122e9c016485cbb9deebde1.webp"
        )
    )

    val animeUI = anime.map {
        val titleColor = if(it.name == "Naruto"){
            R.color.purple_200
        } else R.color.black

        BaseItemModel.AnimeUiModel(
            id = it.id,
            name = it.name,
            description = it.description,
            imagePath = it.imagePath,
            titleColor = titleColor
        )
    }

    val baseItems = arrayListOf<BaseItemModel>().apply {
        add(BaseItemModel.Title("Избранное"))
        addAll(animeUI.take(4))
        add(BaseItemModel.Title("Популярное"))
        addAll(animeUI.subList(4, animeUI.size))
    }
}