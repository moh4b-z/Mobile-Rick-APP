package br.senai.sp.jandira.rick_mortyapi.service.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.rick_mortyapi.R
import coil.compose.AsyncImage


@Composable
fun CharacterCard(
    name: String = "Sem noeme",
    species: String = "Sem espece",
    status: String = "sem status",
    image: String = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .size(100.dp),
                shape =  CircleShape
            ) {
                AsyncImage(
                    model = image,
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center
            )  {
                Text(
                    text = name
                )
                Text(
                    text = species
                )
                Text(
                    text = status
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CharacterCardPreview(){
    CharacterCard(
        name = "Mohammad",
        species = "Humano",
        status = "Vivo",
        image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
    )
}
