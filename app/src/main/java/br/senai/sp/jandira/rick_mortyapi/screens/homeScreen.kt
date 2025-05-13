package br.senai.sp.jandira.rick_mortyapi.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.rick_mortyapi.R
import br.senai.sp.jandira.rick_mortyapi.model.Character
import br.senai.sp.jandira.rick_mortyapi.model.Result
import br.senai.sp.jandira.rick_mortyapi.service.RetrofitFactory
import br.senai.sp.jandira.rick_mortyapi.service.components.CharacterCard
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    //Variavel para amazenar a lista de personagens da API
    var characterList by remember {
        mutableStateOf(listOf<Character>())
    }

    //Fazer uma chamadada na API
    val call = RetrofitFactory()
        .getCharacterService()
        .listAllCharacter()

    call.enqueue(object : Callback<Result> {
        override fun onResponse(call: Call<Result>, response: Response<Result>) {
            characterList = response.body()!!.results!!
        }

        override fun onFailure(p0: Call<Result>, p1: Throwable) {
            TODO("Not yet implemented")
        }

    })

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(R.drawable.rickandmorty1),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xAA0000000))
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)
        ){
            Text(
                text = "Rick-Morty",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth(),
                trailingIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "",
                            tint = Color.White
                        )
                    }
                }
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Characters",
                fontSize = 24.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(24.dp))
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                items(characterList){
                    CharacterCard(
                        name = it.name,
                        species = it.species,
                        status = it.status,
                        image = it.image
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private  fun HomeScreenPreview(){
    HomeScreen()
}