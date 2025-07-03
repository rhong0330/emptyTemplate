package com.prep.fourtytwodot.prep.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.prep.fourtytwodot.prep.presentation.viewmodel.UserViewModel

@Composable
fun UserScreen(viewModel: UserViewModel = hiltViewModel() ){
    val users by viewModel.users.collectAsState()

    Column {
        LazyColumn {
            items(users) { user ->
                Card {
                    Text(text = user.name)
                    Text(text = user.email)
                }
            }
        }
    }
}