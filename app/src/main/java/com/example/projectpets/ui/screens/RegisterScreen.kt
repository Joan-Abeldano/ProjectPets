package com.example.projectpets.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.DropdownMenuItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(onRegisterSuccess: () -> Unit) {
    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var sexo by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }
    var confirmarContrasena by remember { mutableStateOf("") }

    val context = LocalContext.current
    val sexos = listOf("Masculino", "Femenino", "Otro")
    var expanded by remember { mutableStateOf(false) }

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
                .padding(4.dp)
                .verticalScroll(rememberScrollState()),
            colors = CardDefaults.elevatedCardColors()
        ) {
            Icon(
                Icons.Default.Person,
                contentDescription = null,
                modifier = Modifier
                    .size(128.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            )
            Text(
                text = "Registra una cuenta para acceder",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            )
            Text(
                text = "Introduce tu usuario y contraseña para acceder",
                fontSize = 16.sp,
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            )

            // Nombre
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre") },
                leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
                modifier = Modifier
                    .padding(vertical = 4.dp)
                    .fillMaxWidth(0.9f)
                    .align(Alignment.CenterHorizontally)
            )

            // Correo o teléfono
            OutlinedTextField(
                value = correo,
                onValueChange = { correo = it },
                label = { Text("Correo o teléfono") },
                leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
                modifier = Modifier
                    .padding(vertical = 4.dp)
                    .fillMaxWidth(0.9f)
                    .align(Alignment.CenterHorizontally)
            )

            // Selector de sexo
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded },
                modifier = Modifier
                    .padding(vertical = 4.dp)
                    .fillMaxWidth(0.9f)
                    .align(Alignment.CenterHorizontally)
            ) {
                OutlinedTextField(
                    readOnly = true,
                    value = sexo,
                    onValueChange = {},
                    label = { Text("Sexo") },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                    },
                    modifier = Modifier.menuAnchor()
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    sexos.forEach { opcion ->
                        DropdownMenuItem(
                            text = { Text(opcion) },
                            onClick = {
                                sexo = opcion
                                expanded = false
                            }
                        )
                    }
                }
            }

            // Contraseña
            OutlinedTextField(
                value = contrasena,
                onValueChange = { contrasena = it },
                label = { Text("Contraseña") },
                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
                modifier = Modifier
                    .padding(vertical = 4.dp)
                    .fillMaxWidth(0.9f)
                    .align(Alignment.CenterHorizontally),
                visualTransformation = PasswordVisualTransformation()
            )

            // Confirmar contraseña
            OutlinedTextField(
                value = confirmarContrasena,
                onValueChange = { confirmarContrasena = it },
                label = { Text("Confirmar contraseña") },
                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
                modifier = Modifier
                    .padding(vertical = 4.dp)
                    .fillMaxWidth(0.9f)
                    .align(Alignment.CenterHorizontally),
                visualTransformation = PasswordVisualTransformation()
            )

            // Botón de registro
            Button(
                onClick = {
                    when {
                        nombre.isBlank() -> Toast.makeText(context, "Nombre requerido", Toast.LENGTH_SHORT).show()
                        correo.isBlank() -> Toast.makeText(context, "Correo o teléfono requerido", Toast.LENGTH_SHORT).show()
                        sexo.isBlank() -> Toast.makeText(context, "Selecciona un sexo", Toast.LENGTH_SHORT).show()
                        contrasena.isBlank() -> Toast.makeText(context, "Contraseña requerida", Toast.LENGTH_SHORT).show()
                        contrasena != confirmarContrasena -> Toast.makeText(context, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                        else -> onRegisterSuccess()
                    }
                },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(0.9f)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text("Signup", fontSize = 20.sp, color = Color.White)
            }

            // Separador
            HorizontalDivider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.padding(16.dp)
            )

            // Botones sociales
            OutlinedButton(
                onClick = { /* TODO: login Google */ },
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(0.9f)
                    .align(Alignment.CenterHorizontally)
            ) {
                Icon(Icons.Default.Email, contentDescription = null)
                Text("Continuar con Google")
            }

            OutlinedButton(
                onClick = { /* TODO: login Facebook */ },
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(0.9f)
                    .align(Alignment.CenterHorizontally)
            ) {
                Icon(Icons.Default.Email, contentDescription = null)
                Text("Continuar con Facebook")
            }
        }
    }
}
