package com.example.projectpets.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VaccinesControlScreen(onBackClick: () -> Unit) {
    val vaccines = listOf(
        Vaccine("Vacuna contra el distemper", false),
        Vaccine("Vacuna contra parvovirus", true),
        Vaccine("Vacuna contra la hepatitis infecciosa canina o adenovirus canino 2 (AVC-2)", true),
        Vaccine("Vacuna contra la leptospirosis", false),
        Vaccine("Vacuna contra la rabia. Esta vacuna debe ser aplicada anualmente por ley en todos los caninos", true)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Vacunas") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                },
                actions = {
                    IconButton(onClick = { /* agregar */ }) {
                        Icon(Icons.Default.Add, contentDescription = "Agregar")
                    }
                    IconButton(onClick = { /* perfil */ }) {
                        Icon(Icons.Default.Person, contentDescription = "Perfil")
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color(0xFF8CB1C7))
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White) // <-- FONDO BLANCO APLICADO AQUÍ
                .padding(16.dp)
        ) {

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Edit, contentDescription = null, tint = Color(0xFFB49165))
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    "Vacunas esenciales",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(vaccines) { vaccine ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 4.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(20.dp)
                                .background(if (vaccine.applied) Color.Yellow else Color(0xFFE57373))
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = vaccine.name,
                            style = TextStyle(
                                color = if (vaccine.applied) Color(0xFF66BB6A) else Color.Black,
                                textDecoration = if (vaccine.applied) TextDecoration.LineThrough else null
                            )
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                "Las vacunas deben comenzar a administrarse entre las 6 y 9 semanas de vida de los cachorros",
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "“Las vacunas deben comenzar a administrarse entre las 6 y 9 semanas de vida de los cachorros.”",
                fontSize = 16.sp,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

data class Vaccine(val name: String, val applied: Boolean)
