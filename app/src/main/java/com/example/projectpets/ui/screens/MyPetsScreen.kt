package com.example.projectpets.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projectpets.models.PetData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyPetsScreen(petData: List<PetData>, onPetClick: () -> Unit) {
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
                        "Mis Mascotas",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = MaterialTheme.colorScheme.surface,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
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
                    IconButton(
                        onClick = {
                            // Acción para el menú (si se usa)
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
                            contentDescription = "Menú"
                        )
                    }

                    IconButton(
                        onClick = onAddPetClick,
                        colors = IconButtonColors(
                            contentColor = MaterialTheme.colorScheme.surface,
                            containerColor = Color.Transparent,
                            disabledContentColor = MaterialTheme.colorScheme.surface,
                            disabledContainerColor = Color.Transparent
                        )
                    ) {
                        Icon(Icons.Default.Add, contentDescription = "Agregar Mascota")
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        },
    ) { innerPadding ->
        ScrollContent(innerPadding,petData,onPetClick)
    }
}



@Composable
fun ScrollContent(innerPadding: PaddingValues, petsList: List<PetData>, onPetClick: () -> Unit) {
    LazyColumn(
        modifier = Modifier
            .padding(top = 16.dp, bottom = 16.dp, start = 8.dp, end = 8.dp)
            .fillMaxSize(),
        contentPadding = innerPadding,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(petsList.size) { index ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxSize()
                    .clickable { onPetClick()},
                colors = CardDefaults.elevatedCardColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    contentColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Column{
                    Text(
                        text = petsList[index].name,
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier
                            .padding(start = 20.dp)
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 15.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary

                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = petsList[index].description,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }



                }
            }
        }
    }
}