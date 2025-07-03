package com.fourtytwodot.prep.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.fourtytwodot.prep.data.model.User
import com.fourtytwodot.prep.presentation.viewmodel.UserViewModel

@Composable
fun UserScreen(viewModel: UserViewModel = hiltViewModel()) {
    val users by viewModel.users.collectAsState()

    Column {
        LazyColumn {
            items(users, key = { it.id }){ user ->
                UserCard(user, viewModel)
            }
        }
    }
}

@Composable
fun UserCard(user: User, viewModel: UserViewModel) {
    Card() {
        Row() {
            Column {
                Text(text = user.name, style = MaterialTheme.typography.headlineSmall)
                Text(text = user.email, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}