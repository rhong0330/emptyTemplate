package com.fourtytwodot.prep.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.fourtytwodot.prep.presentation.viewmodel.UserViewModel
import javax.inject.Inject

@Composable
fun UserScreen (viewModel: UserViewModel = hiltViewModel()){
    val users by viewModel.users.collectAsState()

    Column {
        LazyColumn {
            items(users) { user ->
                Card {
                    Text(user.name)
                    Text(user.email)
                }
            }
        }
    }
}