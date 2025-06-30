package com.example.projectpets.ui.screens

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormReminderScreen(onBackClick: () -> Unit = {}) {
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var date by remember { mutableStateOf("") }
    var description by remember { mutableStateOf(TextFieldValue("")) }

    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            date = "$dayOfMonth/${month + 1}/$year"
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.primary,
                scrolledContainerColor = MaterialTheme.colorScheme.primary
            ),
            title = {
                Text(text = "Agregar recordatorio",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.surface,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            },
            navigationIcon = {
                IconButton(onClick = onBackClick,
                    colors = IconButtonColors(
                        contentColor = MaterialTheme.colorScheme.surface,
                        containerColor = Color.Transparent,
                        disabledContentColor = MaterialTheme.colorScheme.surface,
                        disabledContainerColor = Color.Transparent
                    )
                    ) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Atrás")
                }
            },
            actions = {
                IconButton(onClick = { /* perfil */ },
                    colors = IconButtonColors(
                        contentColor = MaterialTheme.colorScheme.surface,
                        containerColor = Color.Transparent,
                        disabledContentColor = MaterialTheme.colorScheme.surface,
                        disabledContainerColor = Color.Transparent
                    )
                ) {
                    Icon(Icons.Default.Person, contentDescription = "Perfil")
                }
            }
        )

        Spacer(modifier = Modifier.height(24.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
        Text(text = "Nombre:")
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            placeholder = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Fecha")
            OutlinedTextField(
                value = date,
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { datePickerDialog.show() },
                readOnly = true,
                placeholder = { Text("Date") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Descripción")
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                placeholder = { Text("Descripción") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    // Acción para guardar recordatorio
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Text(text = "Guardar recordatorio", color = Color.White)
            }
        }
    }
}