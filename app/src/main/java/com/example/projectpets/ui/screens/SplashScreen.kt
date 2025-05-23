package com.example.projectpets.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.projectpets.R


@Composable
fun SplashScreen(petName: String, imagePet: Int) {
    //le podemos meter un parametro imagePet: String
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Imagen de fondo
        Image (//aqui si se puede pondriamos el nombre del parametro en vez del R.drawable.kaliman
            painter = painterResource(id = imagePet),
            contentDescription = "Pet image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Botones en la parte superior
        Row (
            modifier = Modifier
                .size(230.dp)
                .padding(20.dp)
                .align(Alignment.TopEnd)
            ,

            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button (
                onClick = { /* TODO: Navegar a Login */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC107)),

                ) {
                Text("Login", color = Color.Black, fontWeight = FontWeight.W900)
            }
            Spacer(modifier = Modifier.width(5.dp))
            Button(
                onClick = { /* TODO: Navegar a Signup */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC107))
            ) {
                Text("Signup", color = Color.Black, fontWeight = FontWeight.W900)
            }
        }

        // Nombre del animal en la parte inferior izquierda
        Text(
            text = "name",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 60.sp,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(0.dp,525.dp,20.dp,0.dp)
                .background(Color(0xAAFFFFFF), shape = RoundedCornerShape(0.dp,8.dp,8.dp,0.dp))
                .border(
                    width = 2.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp)
                )
                .padding(horizontal = 18.dp, vertical = 4.dp)
        )
    }
}

@Composable
@Preview
fun SplashScreenPreview() {
    //le podemos meter un parametro imagePet: String
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Imagen de fondo
        Image (//aqui si se puede pondriamos el nombre del parametro en vez del R.drawable.kaliman
            painter = painterResource(id = R.drawable.kaliman),
            contentDescription = "Pet image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Botones en la parte superior
        Row (
            modifier = Modifier
                .size(230.dp)
                .padding(20.dp)
                .align(Alignment.TopEnd)
            ,

            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button (
                onClick = { /* TODO: Navegar a Login */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC107)),

                ) {
                Text("Login", color = Color.Black, fontWeight = FontWeight.W900)
            }
            Spacer(modifier = Modifier.width(5.dp))
            Button(
                onClick = { /* TODO: Navegar a Signup */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC107))
            ) {
                Text("Signup", color = Color.Black, fontWeight = FontWeight.W900)
            }
        }

        // Nombre del animal en la parte inferior izquierda
        Text(
            text = "name",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 60.sp,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(0.dp,525.dp,20.dp,0.dp)
                .background(Color(0xAAFFFFFF), shape = RoundedCornerShape(0.dp,8.dp,8.dp,0.dp))
                .border(
                    width = 2.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp)
                )
                .padding(horizontal = 18.dp, vertical = 4.dp)
        )
    }
}
