package com.example.projectpets.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.text.style.TextOverflow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReminderListScreen(
    reminders: List<Reminder>,
    onDelete: (Reminder) -> Unit,
    onBackClick: () -> Unit = {},
    onAddReminderClick: () -> Unit // Nuevo parámetro FormReminderScreen
) {
    var showBottomSheet by remember { mutableStateOf(false) }
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
                Text(text = "Lista de Recordatorios",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.surface,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold)
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
                IconButton(onClick = onAddReminderClick,
                    colors = IconButtonColors(
                        contentColor = MaterialTheme.colorScheme.surface,
                        containerColor = Color.Transparent,
                        disabledContentColor = MaterialTheme.colorScheme.surface,
                        disabledContainerColor = Color.Transparent
                    )
                    ) {
                    Icon(Icons.Default.Notifications, contentDescription = "Agregar recordatorio")
                }
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
            },

        )

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
            .padding(horizontal = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.DarkGray),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Recordatorio",
                    tint = Color.White,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Column {
                    Text(
                        "Visita de rutina al veterinario",
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        "Sonará el ${reminder.date} a las ${reminder.time}",
                        color = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Botón alineado a la derecha, mejor estilizado
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                OutlinedButton(
                    onClick = { onDelete(reminder) },
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = Color(0xFFB00020),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("🗑 Eliminar")
                }
            }
        }
    }
}
