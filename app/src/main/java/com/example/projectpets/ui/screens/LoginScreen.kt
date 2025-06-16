package com.example.projectpets.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun LoginScreen() {
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val mContext = LocalContext.current
    var remPassword by remember { mutableStateOf(false) }

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
            colors = CardDefaults.elevatedCardColors(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.primary
            )
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
                text = "Iniciar sesión en tu cuenta",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            )
            Text(
                text = "Introduce tu usuario y contraseña para acceder",
                fontSize = 16.sp,
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
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
            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                LabeledCheckbox(
                    label = "Recordar contraseña",
                    isChecked = false,
                    onCheckedChange = {remPassword = it}
                )
                TextButton(
                    onClick = {
                        //Funcionamiento del boton
                    }
                ) {
                    Text(
                        text = "Olvidé mi Contraseña",
                        maxLines = 1,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }
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
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Iniciar Sesión",
                    fontSize = 24.sp
                )
            }
            HorizontalDivider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 16.dp, start = 8.dp, end = 8.dp)
            )
            OutlinedButton(
                onClick = {

                },
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            ) {
                Icon(Icons.Default.Email,contentDescription = null) //Cambiar por icono de Google
                Text(
                    text = "Continuar con Google"
                )
            }
            OutlinedButton(
                onClick = {

                },
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            ) {
                Icon(Icons.Default.Email,contentDescription = null) //Cambiar por icono de Facebook
                Text(
                    text = "Continuar con Facebook"
                )
            }
            TextButton(
                onClick = {
                    //Funcionamiento del boton
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "¿No tengo una cuenta?, Registrarse",
                    maxLines = 1,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}

@Composable
fun LabeledCheckbox(
    label: String,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = onCheckedChange
        )
        Text(
            text = label,
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier
                .clickable { onCheckedChange(!isChecked) }
        )
    }
}
