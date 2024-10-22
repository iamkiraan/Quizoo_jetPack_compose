package com.example.quizoo.Screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quizoo.Navigations.Screens
import com.example.quizoo.dataStore.StoreUserDetails
import com.example.quizoo.ui.theme.OrangeQ
import com.example.quizoo.ui.theme.SkyBlue
import com.example.quizoo.ui.theme.blackq
import kotlinx.coroutines.launch


@Composable
fun SignUpScreen(
    navController: NavController
) {
    val context = LocalContext.current
    val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex()

    // Coroutine scope
    val scope = rememberCoroutineScope()
    // DataStore
    val dataStore = StoreUserDetails(context)


    // State variables for form fields
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(blackq),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Hey there,",
                fontSize = 18.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 40.dp)
            )
            Text(
                text = "Create an Account",
                color = Color.White,
                fontSize = 24.sp,
                modifier = Modifier.padding(top = 30.dp)
            )
        }
        Column(
            modifier = Modifier
                .padding(top = 230.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Full Name Field
            OutlinedTextField(
                value = fullName,
                textStyle = TextStyle(Color.White),
                leadingIcon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "account") },
                label = { Text(text = "Enter your full name", color = Color.White) },
                onValueChange = { fullName = it }
            )

            // Email Field
            OutlinedTextField(
                value = email,
                textStyle = TextStyle(Color.White),
                label = { Text(text = "Enter your Email", color = Color.White) },
                onValueChange = { email = it },
                modifier = Modifier.padding(top = 20.dp),
                placeholder = { Text(text = "xyz@gmail.com", color = Color.White) },
                leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "email") }
            )

            // Password Field
            PasswordTextField(password, onPasswordChange = { password = it })

            // Sign Up Button
            Button(
                onClick = {
                    when {
                        fullName.isEmpty() -> showToast(context, "Full name is required.")
                        email.isEmpty() -> showToast(context, "Email is required.")
                        !email.matches(emailRegex) -> showToast(context, "Invalid email format.")
                        password.isEmpty() -> showToast(context, "Password is required.")
                        else -> {
                            // Save user details to DataStore
                            scope.launch {
                                dataStore.saveUserName(fullName)
                                dataStore.saveUserEmail(email)
                                navController.navigate(route= Screens.mathematics.route)
                            }
                        }
                    }
                },
                modifier = Modifier
                    .padding(top = 60.dp)
                    .fillMaxWidth(.8f)
                    .height(60.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(OrangeQ)
            ) {
                Text(
                    text = "Sign up",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Column(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth(.8f)
            ) {
                Divider(
                    color = Color.Gray,
                    thickness = 3.dp
                )
            }

            Row(
                modifier = Modifier.padding(top = 20.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                Text(
                    text = "Already have an account?",
                    color = Color.White,
                    fontSize = 16.sp
                )
                Text(
                    text = "Login",
                    color = SkyBlue,
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .clickable {
                            navController.navigate(Screens.Login.route)
                        },
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
fun PasswordTextField(password: String, onPasswordChange: (String) -> Unit) {
    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = password,
        onValueChange = { onPasswordChange(it) },
        label = { Text("Enter your Password", color = Color.White) },
        textStyle = TextStyle(color = Color.White),
        placeholder = { Text(text = "Password", color = Color.LightGray) },
        leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "password") },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val image = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
            val description = if (passwordVisible) "Hide password" else "Show password"
            Icon(
                imageVector = image,
                contentDescription = description,
                modifier = Modifier.clickable { passwordVisible = !passwordVisible }
            )
        },
        modifier = Modifier.padding(top = 20.dp)
    )
}

// Helper function to show Toast messages
private fun showToast(context: android.content.Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}
