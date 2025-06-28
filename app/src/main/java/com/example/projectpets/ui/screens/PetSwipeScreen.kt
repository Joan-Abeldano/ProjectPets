package com.example.projectpets.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.projectpets.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember




@Composable
fun SplashScreen(onLoginClick: () -> Unit, onRegisterClick: () -> Unit) {
    val petImages = listOf(
        R.drawable.kaliman,
        R.drawable.pettwo,
        R.drawable.petthree,
        R.drawable.petfor
    )
    val namePets = listOf(
        "Kaliman",
        "Dorian",
        "Curry",
        "Bear"
    )
    var currentImageIndex by remember { mutableStateOf(0) }
    var namePetsIndex by remember { mutableStateOf(0) }
    Box(
        modifier = Modifier
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        // Avanzar a la siguiente imagen
                        currentImageIndex = (currentImageIndex + 1) % petImages.size
                        namePetsIndex = (namePetsIndex + 1) % namePets.size
                    }
                )
            }
            .fillMaxSize()
    ) {
        // Imagen de fondo
        Image (
            painter = painterResource(id = petImages[currentImageIndex]),
            contentDescription = "Pet image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Botones Login y SignUp
        Row (
            modifier = Modifier
                .size(230.dp)
                .padding(20.dp)
                .align(Alignment.TopEnd),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button (
                onClick = onLoginClick,
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

        // Nombre de la mascota en la parte inferior izquierda
        Text(
            text = namePets[namePetsIndex],
            fontWeight = FontWeight.ExtraBold,
            fontSize = 40.sp,
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