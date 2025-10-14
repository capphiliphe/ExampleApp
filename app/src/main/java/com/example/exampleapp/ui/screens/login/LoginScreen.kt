package com.example.exampleapp.ui.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Kitchen
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exampleapp.ui.components.PasswordTextField

@Composable
fun LoginScreen(onGo: (String) -> Unit, onGoToRegister: () -> Unit) {
    var username by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf("") }

    // Fondo degradado suave (verdes y blancos frescos)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFE8F5E9), // verde menta claro
                        Color(0xFFFFFFFF)  // blanco limpio
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(24.dp)
        ) {
            // Ícono vectorial de refrigerador (Kitchen)
            Icon(
                imageVector = Icons.Default.Kitchen,
                contentDescription = "Logo refrigerador",
                tint = Color(0xFF66BB6A), // verde suave
                modifier = Modifier
                    .size(96.dp)
                    .padding(bottom = 8.dp)
            )

            // Título
            Text(
                text = "FreshKeeper",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2E7D32),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Subtítulo
            Text(
                text = "Organiza tus alimentos y evita el desperdicio 🍎",
                fontSize = 14.sp,
                color = Color(0xFF4CAF50),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Tarjeta contenedora con campos de texto
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(elevation = 8.dp, shape = RoundedCornerShape(24.dp)),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(24.dp)) {
                    TextField(
                        value = username,
                        onValueChange = { username = it },
                        label = { Text("Usuario") },
                        singleLine = true,
                        shape = RoundedCornerShape(12.dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color(0xFFF1F8E9),
                            unfocusedContainerColor = Color(0xFFF1F8E9),
                            focusedIndicatorColor = Color(0xFF81C784),
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedLabelColor = Color(0xFF388E3C),
                            cursorColor = Color(0xFF388E3C)
                        )

                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    PasswordTextField(
                        value = password,
                        onValueChange = { password = it }
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Botón principal
            Button(
                onClick = { onGo(username.text) },
                enabled = username.text.isNotEmpty() && password.isNotEmpty(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF81C784),
                    disabledContainerColor = Color(0xFFBDBDBD)
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(48.dp)
            ) {
                Text(
                    text = "Iniciar sesión",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Enlace a registro
            TextButton(onClick = { onGoToRegister() }) {
                Text(
                    text = "¿No tienes cuenta? Regístrate",
                    color = Color(0xFF2E7D32),
                    fontSize = 14.sp
                )
            }
        }
    }
}
