package com.eloix.fgoplanner.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.eloix.fgoplanner.model.Banner

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BannerDetailScreen(banner: Banner, onBackClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(banner.name) },
                navigationIcon = {
                    IconButton(onClick = { onBackClick() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            Text("Tipo: ${banner.type}", style = MaterialTheme.typography.bodyMedium)
            Text("Inicio: ${banner.startDate}", style = MaterialTheme.typography.bodySmall)
            Text("Fin: ${banner.endDate}", style = MaterialTheme.typography.bodySmall)

            Spacer(modifier = Modifier.height(12.dp))

            Text("Servants destacados:", style = MaterialTheme.typography.titleMedium)
            banner.featuredServants.forEach { servant ->
                Text("- ${servant.name} (${servant.rarity}★ ${servant.classType})")
            }
        }
    }
}
