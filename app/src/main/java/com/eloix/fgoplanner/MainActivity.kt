package com.eloix.fgoplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.eloix.fgoplanner.model.Banner
import com.eloix.fgoplanner.repository.BannerRepository

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                BannerListScreen()
            }
        }
    }
}

@Composable
fun BannerListScreen() {
    val banners = BannerRepository.getAllBanners()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(banners) { banner ->
            BannerCard(banner)
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
fun BannerCard(banner: Banner) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = banner.name, style = MaterialTheme.typography.titleLarge)
            Text(text = "Tipo: ${banner.type}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Del ${banner.startDate} al ${banner.endDate}", style = MaterialTheme.typography.bodySmall)

            Spacer(modifier = Modifier.height(8.dp))

            Text("Servants destacados:", style = MaterialTheme.typography.bodyMedium)
            banner.featuredServants.forEach { servant ->
                Text("- ${servant.name} (${servant.rarity}★ ${servant.classType})")
            }
        }
    }
}
