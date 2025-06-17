package com.example.projectpets.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPetScreen() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                    scrolledContainerColor = MaterialTheme.colorScheme.primary
                ),
                title = {
                    Text(
                        "Añadir Mascota",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = MaterialTheme.colorScheme.surface
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        //Volver atras
                    },
                        colors = IconButtonColors(
                            contentColor = MaterialTheme.colorScheme.surface,
                            containerColor = Color.Transparent,
                            disabledContentColor = MaterialTheme.colorScheme.surface,
                            disabledContainerColor = Color.Transparent
                        )
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {
                        //Acciones
                    },
                        colors = IconButtonColors(
                            contentColor = MaterialTheme.colorScheme.surface,
                            containerColor = Color.Transparent,
                            disabledContentColor = MaterialTheme.colorScheme.surface,
                            disabledContainerColor = Color.Transparent
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        },
    ) { innerPadding ->
        ScrollContent(innerPadding)
    }
}

@Composable
fun ScrollContent(innerPadding: PaddingValues) {
    var petName by remember { mutableStateOf("") }
    var petDescription by remember { mutableStateOf("") }
    var petType by remember { mutableStateOf("") }
    var showModalInput by remember { mutableStateOf(false) }
    var petBirthDate by remember { mutableStateOf<Long?>(null) }
    val formattedDate = remember(petBirthDate) { formatDate(petBirthDate) }

    LazyColumn(
        modifier = Modifier
            .padding(top = 16.dp, bottom = 16.dp, start = 8.dp, end = 8.dp)
            .fillMaxSize(),
        contentPadding = innerPadding,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(count = 1) {
            Text(
                text = "Nombre",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )
            OutlinedTextField(
                value = petName,
                onValueChange = { petName = it },
                label = { Text("Nombre", color = MaterialTheme.colorScheme.primary) },
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth()
            )
            Text(
                text = "Descripción",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )
            OutlinedTextField(
                value = petDescription,
                onValueChange = { petDescription = it },
                label = { Text("Descripcion", color = MaterialTheme.colorScheme.primary) },
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth()
            )
            Text(
                text = "Fecha de Nacimiento",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Button(
                onClick = { showModalInput = true },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth()
                    .border(border = BorderStroke(8.dp, color = MaterialTheme.colorScheme.primary),shape = RectangleShape)
            ) {
                if (petBirthDate != null) {
                    Text(formattedDate)
                } else {
                    Text("Sin fecha seleccionada", color = MaterialTheme.colorScheme.surface)
                }
            }
            Text(
                text = "Tipo",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )
            OutlinedTextField(
                value = petType,
                onValueChange = { petType = it },
                label = { Text("Tipo", color = MaterialTheme.colorScheme.primary) },
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth()
            )
            Button(
                onClick = {
                    //Agregar mascota a BD y volver a MyPetsScreen
                },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Confirmar",
                    color = MaterialTheme.colorScheme.surface,
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }
    }
    if (showModalInput) {
        DatePickerModalInput(
            onDateSelected = {
                petBirthDate = it
                showModalInput = false
            },
            onDismiss = { showModalInput = false }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerModalInput(
    onDateSelected: (Long?) -> Unit,
    onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState(initialDisplayMode = DisplayMode.Input)

    DatePickerDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = {
                onDateSelected(datePickerState.selectedDateMillis)
                onDismiss()
            }) {
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    ) {
        DatePicker(state = datePickerState)
    }
}

fun formatDate(millis: Long?): String {
    if (millis == null) return "Sin fecha seleccionada"
    val date = Date(millis)
    val format = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return format.format(date)
}

@Preview
@Composable
fun AddPetScreenPreview() {
    AddPetScreen()
}