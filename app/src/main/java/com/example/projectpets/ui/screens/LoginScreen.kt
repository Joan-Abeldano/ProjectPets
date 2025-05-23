package com.example.projectpets.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import com.example.projectpets.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TextButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun LoginScreen() {
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val mContext = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .padding(16.dp)
            .imePadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            colors = CardDefaults.elevatedCardColors(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text(
                text = "Mis Mascotas",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
            Image(
                painter = painterResource(R.drawable.user_image),
                contentDescription = null,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
            )
            OutlinedTextField(
                value = user,
                onValueChange = { user = it },
                label = { Text("Usuario", color = MaterialTheme.colorScheme.primary) },
                leadingIcon = { Icon(Icons.Default.Person, "Usuario") },
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth(fraction = 0.9f)
                    .align(Alignment.CenterHorizontally)
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña", color = MaterialTheme.colorScheme.primary) },
                leadingIcon = { Icon(Icons.Default.Lock, "Contraseña") },
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth(fraction = 0.9f)
                    .align(Alignment.CenterHorizontally)
            )
            TextButton(
                onClick = {
                    //Funcionamiento del boton
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Text("Olvidé mi Contraseña",
                    color = MaterialTheme.colorScheme.secondary
                )
            }
            Button(
                onClick = {
                    if (user.isEmpty()) {
                        Toast.makeText(mContext, "Ingresa un usuario", Toast.LENGTH_SHORT).show()
                    }
                    else if (password.isEmpty()) {
                        Toast.makeText(mContext, "Ingresa una contraseña", Toast.LENGTH_SHORT)
                            .show()
                    }
                },
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "Iniciar Sesión",
                    fontSize = 24.sp
                )
            }
        }
    }

}


@Composable
@Preview
fun SplashScreen() {
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
                Text("Login", color = Color.Black)
            }
            Spacer(modifier = Modifier.width(5.dp))
            Button(
                onClick = { /* TODO: Navegar a Signup */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC107))
            ) {
                Text("Signup", color = Color.Black)
            }
        }

        // Nombre del animal en la parte inferior izquierda
        Text(
            text = "name",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(6.dp,5.dp,10.dp)
                .background(Color(0xAAFFFFFF), shape = RoundedCornerShape(8.dp))
                .padding(horizontal = 8.dp, vertical = 4.dp)
        )
    }
}
