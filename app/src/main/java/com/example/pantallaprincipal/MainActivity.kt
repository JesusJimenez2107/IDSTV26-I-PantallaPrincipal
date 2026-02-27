package com.example.pantallaprincipal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WelcomeScreen()
        }
    }
}

@Composable
fun WelcomeScreen() {

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
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.78f)
                    .height(50.dp)
                    .background(mainPurple, RoundedCornerShape(26.dp)),
                contentAlignment = Alignment.Center
            ) {
                androidx.compose.material3.Text(
                    text = "Login",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Box(modifier = Modifier.height(15.dp))

            // Sign Up
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.78f)
                    .height(50.dp)
                    .background(Color.White, RoundedCornerShape(26.dp))
                    .border(1.5.dp, mainPurple, RoundedCornerShape(26.dp)),
                contentAlignment = Alignment.Center
            ) {
                androidx.compose.material3.Text(
                    text = "Sign Up",
                    color = mainPurple,
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