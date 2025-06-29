package com.example.projectpets.models

data class Reminder(
    val id: Int = 0,
    val title: String = "Visita al de rutina al veterinario",
    val date: String,
    val time: String
)