package com.example.projectpets.ui.screens

import androidx.compose.ui.tooling.preview.Preview

//@file:OptIn(ExperimentalMaterial3Api::class)


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddVaccineForm(
    onBackClick: () -> Unit = {},
    onGuardarClick: (String, String, String, Boolean, Boolean) -> Unit = { _, _, _, _, _ -> }
) {
    var nombreVacuna by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var marcarAdministrada by remember { mutableStateOf(false) }
    var tachar by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Top App Bar
        TopAppBar(
            title = {
                Text(
                    text = "Agregar vacunas",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
            },
            navigationIcon = {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Volver",
                        tint = Color.White
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFF5A8DBE)
            )
        )

        // Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Nombre de la vacuna
            Column {
                Text(
                    text = "Nombre de la vacuna:",
                    fontSize = 14.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                OutlinedTextField(
                    value = nombreVacuna,
                    onValueChange = { nombreVacuna = it },
                    placeholder = {
                        Text(
                            text = "Nombre",
                            color = Color.Gray
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF5A8DBE),
                        unfocusedBorderColor = Color.Gray.copy(alpha = 0.5f)
                    )
                )
            }

            // Fecha
            Column {
                Text(
                    text = "Fecha",
                    fontSize = 14.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                OutlinedTextField(
                    value = fecha,
                    onValueChange = { fecha = it },
                    placeholder = {
                        Text(
                            text = "Date",
                            color = Color.Gray
                        )
                    },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = "Seleccionar fecha",
                            tint = Color.Gray
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF5A8DBE),
                        unfocusedBorderColor = Color.Gray.copy(alpha = 0.5f)
                    )
                )
            }

            // Descripción
            Column {
                Text(
                    text = "Descripción",
                    fontSize = 14.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                OutlinedTextField(
                    value = descripcion,
                    onValueChange = { descripcion = it },
                    placeholder = {
                        Text(
                            text = "Descripción",
                            color = Color.Gray
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF5A8DBE),
                        unfocusedBorderColor = Color.Gray.copy(alpha = 0.5f)
                    ),
                    maxLines = 4
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Checkboxes
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = marcarAdministrada,
                    onCheckedChange = { marcarAdministrada = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(0xFF5A8DBE),
                        uncheckedColor = Color.Gray
                    )
                )
                Text(
                    text = "Marcar como administrada",
                    fontSize = 14.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = tachar,
                    onCheckedChange = { tachar = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(0xFF5A8DBE),
                        uncheckedColor = Color.Gray
                    )
                )
                Text(
                    text = "Tachar",
                    fontSize = 14.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Botón Guardar
            Button(
                onClick = {
                    onGuardarClick(nombreVacuna, fecha, descripcion, marcarAdministrada, tachar)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2E2E2E)
                )
            ) {
                Text(
                    text = "Guardar aplicación de vacuna",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

// Preview
@Preview(showBackground = true)
@Composable
fun AgregarVacunasScreenPreview() {
    MaterialTheme {
        AddVaccineForm()
    }
}