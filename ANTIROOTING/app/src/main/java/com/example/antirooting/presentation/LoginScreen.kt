package com.example.antirooting.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: ViewModel
) {
    val user by viewModel.user.collectAsState()
    val password by viewModel.password.collectAsState()

    val textFieldStyle = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = Color.Magenta,
        unfocusedBorderColor = Color.Magenta,
        focusedTextColor = Color.White,
        unfocusedTextColor = Color.White,
        focusedLabelColor = Color.Magenta.copy(alpha = 0.7f),
        unfocusedLabelColor = Color.Magenta.copy(alpha = 0.7f)
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(15.dp)
    ) {
        item{
            Text(
                text = "FOR TESTING",
                style = MaterialTheme.typography.headlineLarge,
                color = Color.Magenta,
                fontWeight = FontWeight.Bold
            )
        }

        item{
            Text(
                text = "Con SSL y Antirooting",
                style = MaterialTheme.typography.labelMedium,
                color = Color.Magenta,
                fontWeight = FontWeight.Bold
            )
        }
        item {
            OutlinedTextField(
                value = user,
                onValueChange = {
                    viewModel.userChange(it)
                },
                modifier = Modifier
                    .fillMaxWidth(0.8f),
                label = {
                    Text("Usuario: ")
                },
                colors = textFieldStyle,
                shape = RoundedCornerShape(25.dp)
            )
        }
        item {
            OutlinedTextField(
                value = password,
                onValueChange = {
                    viewModel.passwordChange(it)
                },
                modifier = Modifier
                    .fillMaxWidth(0.8f),
                label = {
                    Text("Contraseña: ")
                },
                visualTransformation =  PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Send
                ),
                colors = textFieldStyle,
                shape = RoundedCornerShape(25.dp)
            )
        }
        item {
            Button(
                modifier = Modifier
                    .fillMaxWidth(0.8f),
                onClick = {
                    viewModel.login()
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Color.Magenta
                )
            ) {
                Text(
                    "Login",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}