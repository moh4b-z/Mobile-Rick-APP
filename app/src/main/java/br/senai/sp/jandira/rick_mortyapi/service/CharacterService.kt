package br.senai.sp.jandira.rick_mortyapi.service

import br.senai.sp.jandira.rick_mortyapi.model.Character
import br.senai.sp.jandira.rick_mortyapi.model.Result
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface CharacterService {

    @GET("character")
    fun listAllCharacter(): Call<Result>

    @GET("character/{id}")
    fun getCharacterById(@Path("") id: Int): Call<Character>

    // @POST("character")
    // fun saveUser(@Body  character: Character): Call<Character>
}