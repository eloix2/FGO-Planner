package com.eloix.fgoplanner.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.eloix.fgoplanner.model.Banner
import com.eloix.fgoplanner.repository.BannerRepository

@Composable
fun BannerListScreen(onBannerClick: (Int) -> Unit) {
    val banners = BannerRepository.getAllBanners()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(banners) { banner ->
            BannerCard(banner, onBannerClick)
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
fun BannerCard(banner: Banner, onBannerClick: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onBannerClick(banner.id) }, // 👈 clic en la card
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = banner.name, style = MaterialTheme.typography.titleLarge)
            Text(text = "Tipo: ${banner.type}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
