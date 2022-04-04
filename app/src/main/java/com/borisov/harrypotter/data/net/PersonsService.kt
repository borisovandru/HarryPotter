package com.borisov.harrypotter.data.net

import retrofit2.http.GET

/**
 * @author Borisov Andrey on 03.04.2022
 **/
interface PersonsService {

    @GET("characters ")
    suspend fun fetchBooks(): List<PersonCloud>
}