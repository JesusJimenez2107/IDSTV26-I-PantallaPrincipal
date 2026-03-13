package com.example.pantallaprincipal.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import android.util.Patterns
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation

@Composable
fun SingUpScreen(navController: NavController){
    // Definición de Estados para los inputs
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    // Lógica de Validación
    val isNameValid = name.all { it.isLetter() || it.isWhitespace() } && name.isNotBlank()
    val isEmailValid = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    val isPhoneValid = phone.length == 10 && phone.all { it.isDigit() }
    val passwordsMatch = password == confirmPassword && password.isNotEmpty()

    // validacion para boton
    val isFormValid = isNameValid && isEmailValid && isPhoneValid && passwordsMatch

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        Text(text = "Create Account", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(32.dp))

        // Campo Nombre
        OutlinedTextField(
            value = name ,
            onValueChange = {name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            isError = !isNameValid && name.isNotEmpty()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo Email
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email Address") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            isError = !isEmailValid && email.isNotEmpty()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo Teléfono
        OutlinedTextField(
            value = phone,
            onValueChange = { if (it.length <= 10) phone = it },
            label = { Text("Phone (10 digits)") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            isError = !isPhoneValid && phone.isNotEmpty()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo Password
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo Repeat Password
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Repeat Password") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            visualTransformation = PasswordVisualTransformation(),
            isError = !passwordsMatch && confirmPassword.isNotEmpty()
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Botón Sign Up
        Button(
            onClick = { navController.navigate("login") },
            enabled = isFormValid,
            modifier = Modifier.fillMaxWidth().height(56.dp),
            shape = RoundedCornerShape(28.dp),
            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                containerColor = Color(0xFF5E50A5),
                disabledContainerColor = Color.Gray
            )
        ) {
            Text(
                text = "Sign Up",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        // Texto inferior
        Row {
            Text(text = "Already have an account? ", color = Color.Gray)
            Text(
                text = "Login",
                color = Color(0xFF5E50A5),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    navController.navigate("login")
                }
            )
        }
    }
}