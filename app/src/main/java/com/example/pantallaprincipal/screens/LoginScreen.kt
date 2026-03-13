package com.example.pantallaprincipal.screens

import android.util.Patterns
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.foundation.clickable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation

@Composable
fun LoginScreen (navController: NavController){
    // Estados para los inputs
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Lógica de validación
    val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()
    val isPasswordNotEmpty = password.isNotEmpty()
    val isFormValid = isEmailValid && isPasswordNotEmpty

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Título
        Text(text = "Welcome Back", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Text(text = "Please sign in to your account", color = Color.Gray, fontSize = 16.sp)

        Spacer(modifier = Modifier.height(40.dp))

        // Campo de Email
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            isError = !isEmailValid && email.isNotEmpty(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de Contraseña
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(4.dp))

        //Olvido contraseña
        Text(text = "Forgot your password?", color = Color.Gray, fontSize = 14.sp)

        Spacer(modifier = Modifier.height(32.dp))

        // Botón Login
        Button(
            onClick = { /* Acción de login */ },
            enabled = isFormValid,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(28.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF5E50A5),
                disabledContainerColor = Color.LightGray
            )
        ) {
            Text(
                text = "Login",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        // Texto inferior
        Row {
            Text(text = "Don't have an account? ", color = Color.Gray)
            Text(
                text = "Create",
                color = Color(0xFF5E50A5),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    navController.navigate("signup")
                }
            )
        }
    }


}