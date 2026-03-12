package com.example.pantallaprincipal.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pantallaprincipal.R

@Composable
fun WelcomeScreen (navController: NavController){

    val mainPurple = Color(0xFF4B49C8)
    val textGray = Color(0xFF7A7A7A)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 26.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Espacio superior
            Box(modifier = Modifier.height(20.dp))

            // Imagen
            Image(
                painter = painterResource(id = R.drawable.welcome_illustration),
                contentDescription = "Welcome illustration",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                contentScale = ContentScale.Fit
            )

            Box(modifier = Modifier.height(15.dp))

            // Título
            androidx.compose.material3.Text(
                text = "Hello",
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1E1E1E)
            )

            Box(modifier = Modifier.height(10.dp))

            // Descripción
            androidx.compose.material3.Text(
                text = "Welcome To Little Drop, where\nyou manage you daily tasks",
                fontSize = 14.sp,
                color = textGray,
                textAlign = TextAlign.Center,
                lineHeight = 18.sp
            )

            Box(modifier = Modifier.height(25.dp))

            // Login
            Button(
                onClick = {
                    navController.navigate("login")
                },
                modifier = Modifier
                    .fillMaxWidth(0.78f)
                    .height(50.dp),
                shape = RoundedCornerShape(26.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = mainPurple,
                    contentColor = Color.White
                ),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = "Login",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }


            Box(modifier = Modifier.height(15.dp))

            // Sign Up
            Button(
                onClick = {
                    navController.navigate("signup")
                },
                modifier = Modifier
                    .fillMaxWidth(0.78f)
                    .height(50.dp),
                shape = RoundedCornerShape(26.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,    // Fondo blanco
                    contentColor = mainPurple        // Color del texto
                ),
                border = BorderStroke(1.5.dp, mainPurple),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = "Sign Up",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Box(modifier = Modifier.height(20.dp))

            // Texto inferior
            androidx.compose.material3.Text(
                text = "Sign up using",
                fontSize = 12.sp,
                color = Color(0xFF9A9A9A)
            )

            Box(modifier = Modifier.height(15.dp))

            // Iconos redes sociales
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                SocialCircle("f", Color(0xFF1877F2))
                SocialCircle("G+", Color(0xFFEA4335))
                SocialCircle("in", Color(0xFF0A66C2))
            }
        }
    }
}

@Composable
fun SocialCircle(text: String, bg: Color) {
    Box(
        modifier = Modifier
            .size(42.dp)
            .background(bg, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        androidx.compose.material3.Text(
            text = text,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
    }
}