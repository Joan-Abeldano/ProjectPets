package com.example.projectpets.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.projectpets.models.Pet

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
    var petBirthDate by remember { mutableStateOf("") }
    var petType by remember { mutableStateOf("") }

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
            OutlinedTextField(
                value = petBirthDate,
                onValueChange = { petBirthDate = it },
                label = { Text("Fecha de Nacimiento", color = MaterialTheme.colorScheme.primary) },
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth()
            )
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
        }
    }
}