package com.example.projectpets.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projectpets.models.Reminder
import androidx.compose.ui.text.font.FontWeight

@Composable
fun ReminderListScreen(
    reminders: List<Reminder>,
    onDelete: (Reminder) -> Unit,
    onBackClick: () -> Unit = {}
) {
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
            IconButton(onClick = onBackClick) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Atrás", tint = Color.White)
            }
            Text(
                text = "Recordatorios",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Notificación",
                tint = Color.White
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            items(reminders) { reminder ->
                ReminderItem(reminder = reminder, onDelete = onDelete)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun ReminderItem(reminder: Reminder, onDelete: (Reminder) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Recordatorio",
                    tint = Color.Black,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Column {
                    Text("Visita al de rutina al veterinario", fontWeight = FontWeight.Bold)
                    Text("Sonará el ${reminder.date} a las ${reminder.time}")
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { onDelete(reminder) },
                modifier = Modifier.align(Alignment.End),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {
                Text("🗑 Delete Reminder", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReminderListScreenPreview() {
    val sampleReminders = listOf(
        Reminder(date = "23/06/2024", time = "11:00 a.m"),
        Reminder(date = "29/02/2024", time = "9:00 a.m"),
        Reminder(date = "20/06/2024", time = "10:00 a.m"),
        Reminder(date = "07/12/2024", time = "2:00 p.m")
    )

    ReminderListScreen(
        reminders = sampleReminders,
        onDelete = {}
    )
}
