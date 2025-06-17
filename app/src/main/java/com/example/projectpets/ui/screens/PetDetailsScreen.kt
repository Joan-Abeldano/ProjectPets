package com.example.projectpets.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetDetailScreen(
    petName: String,
    petDescription: String,
    petPhotos: List<String>
) {
    var selectedIndex by remember { mutableStateOf(0) }
    var showBottomSheet by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7F7))
    ) {
        TopAppBar(
            title = {
                Text(text = petName, fontWeight = FontWeight.Bold)
            },
            navigationIcon = {
                IconButton(onClick = { /* acción atrás */ }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Atrás")
                }
            },
            actions = {
                IconButton(onClick = { showBottomSheet = true }) {
                    Icon(Icons.Default.MoreVert, contentDescription = "Más")
                }
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color(0xFF8CB1C7))
        )

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = petDescription,
                fontSize = 16.sp,
                lineHeight = 22.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            Box {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp),
                ) {
                    itemsIndexed(petPhotos) { index, photoUrl ->
                        Image(
                            painter = rememberAsyncImagePainter(model = photoUrl),
                            contentDescription = "Foto de mascota",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .width(300.dp)
                                .clip(MaterialTheme.shapes.medium)
                                .padding(end = 8.dp)
                                .clickable { selectedIndex = index }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                petPhotos.forEachIndexed { index, _ ->
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(if (index == selectedIndex) Color.Black else Color.LightGray)
                            .padding(4.dp)
                            .padding(horizontal = 4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Botón para mostrar detalles
            Button(
                onClick = { showBottomSheet = true },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8CB1C7))
            ) {
                Text("Detalles del control de $petName", color = Color.White)
            }
        }
    }

    // ModalBottomSheet
    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            containerColor = Color.White
        ) {
            PetDetailsBottomSheetContent(
                petName = petName,
                onDismiss = { showBottomSheet = false }
            )
        }
    }
}

@Composable
fun PetDetailsBottomSheetContent(
    petName: String,
    onDismiss: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Indicador visual (línea arriba)
        Box(
            modifier = Modifier
                .width(40.dp)
                .height(4.dp)
                .clip(CircleShape)
                .background(Color.LightGray)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Opciones del menú
        BottomSheetOption(
            icon = "💉",
            text = "Seguimiento Control de Vacuna",
            onClick = {
                // Acción para vacunas
                onDismiss()
            }
        )

        BottomSheetOption(
            icon = "🏷️",
            text = "Recordatorios",
            onClick = {
                // Acción para recordatorios
                onDismiss()
            }
        )

        BottomSheetOption(
            icon = "📋",
            text = "Exportar historial de vacunación de $petName",
            onClick = {
                // Acción para exportar
                onDismiss()
            }
        )

        // Espacio adicional al final
        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun BottomSheetOption(
    icon: String,
    text: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = icon,
            fontSize = 20.sp,
            modifier = Modifier.padding(end = 16.dp)
        )
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }
}