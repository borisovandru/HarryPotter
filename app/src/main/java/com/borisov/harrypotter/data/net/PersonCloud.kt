package com.borisov.harrypotter.data.net

import com.borisov.harrypotter.core.Abstract
import com.borisov.harrypotter.data.ToPersonMapper
import com.google.gson.annotations.SerializedName

/**
 * @author Borisov Andrey on 03.04.2022
 **/
/*
* "name":"Harry Potter",
      "alternate_names":[      ],
      "species":"human",
      "gender":"male",
      "house":"Gryffindor",
      "dateOfBirth":"31-07-1980",
      "yearOfBirth":1980,
      "wizard":true,
      "ancestry":"half-blood",
      "eyeColour":"green",
      "hairColour":"black",
      "wand":{
         "wood":"holly",
         "core":"phoenix feather",
         "length":11
      },
      "patronus":"stag",
      "hogwartsStudent":true,
      "hogwartsStaff":false,
      "actor":"Daniel Radcliffe",
      "alternate_actors":[
      ],
      "alive":true,
      "image":"http://hp-api.herokuapp.com/images/harry.jpg"
   },
 */
class PersonCloud(
    @SerializedName("name")
    private val name: String,
    @SerializedName("image")
    private val image: String,
) : Abstract.Object<PersonData, ToPersonMapper> {
    override fun map(mapper: ToPersonMapper) = mapper.map(name, image)
}