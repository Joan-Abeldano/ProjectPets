package com.example.projectpets.ui.screens

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.*

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
        // Encabezado
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF6A9EBB))
                .padding(12.dp)
        ) {
            IconButton(onClick = { onBackClick() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Atrás", tint = Color.White)
            }
            Text(
                text = "Agregar recordatorio",
                color = Color.White,
                fontSize = 18.sp
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

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
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Guardar recordatorio", color = Color.White)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun FormReminderScreenPreview() {
    FormReminderScreen()
}