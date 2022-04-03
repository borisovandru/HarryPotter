package com.borisov.harrypotter.core

import android.app.Application

/**
 * @author Borisov Andrey on 03.04.2022
 **/
class PotterApp:Application() {
    private companion object{
        const val BASE_URL = "http://hp-api.herokuapp.com/api/"
    }
}