package com.example.quizoo.Multiplayer

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.View.OnClickListener
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import kotlin.random.Random
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowCircleLeft
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.CancelPresentation
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.example.quizoo.R
import com.example.quizoo.ui.theme.DarkPurple
import com.example.quizoo.ui.theme.lightPurple


@Composable
fun LandingPage(navController : NavHostController){
    val showDialog = remember { mutableStateOf(false) }
    val joinDialog = remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkPurple)
        ){

        Box(
            Modifier
                .background(DarkPurple)
                .fillMaxSize()) {
            Image(
                imageVector = Icons.Default.ArrowCircleLeft,
                contentDescription = "Back",
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp)
                    .clickable { navController.popBackStack() },
                colorFilter = ColorFilter.tint(Color.White)

            )


            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp)) {
                Box(modifier =Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Column(modifier = Modifier.padding(top=130.dp)) {
                        Text(text = "Friendly Challenge", fontSize = 24.sp,color = Color.White)
                        Image(
                            painter = painterResource(id = R.drawable.cup),
                            contentDescription = "",
                            modifier = Modifier.padding(start = 20.dp,top = 20.dp)
                        )
                    }
                }



                Button(
                    onClick = {
                        showDialog.value= true

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp)
                        .height(50.dp),
                    shape = RoundedCornerShape(6.dp)

                ) {
                    Text(text = "Create Room", fontSize = 22.sp)

                }
                Button(
                    onClick = {
                        joinDialog.value = true
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp)
                        .height(50.dp),
                    shape = RoundedCornerShape(6.dp)

                ) {
                    Text(text = "Join Room", fontSize = 22.sp)

                }
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)){
                    Text(text = "Rules and Regulations:", color = Color.White, fontSize = 12.sp,modifier = Modifier.padding(start = 20.dp))
                    Text(text = "1. Only two players are allowed to join the room at a time.", fontSize = 12.sp,color = Color.White,modifier = Modifier.padding(start = 20.dp))
                    Text(text = "2. The time limit is 5 Minutes.", fontSize = 12.sp,color = Color.White,modifier = Modifier.padding(start = 20.dp))
                    Text(text = "3. There will be 10 questions randomly from any topic.", fontSize = 12.sp,color = Color.White,modifier = Modifier.padding(start = 20.dp))
                    Text(text = "4. For each question the time limit is 30 seconds.", fontSize = 12.sp,color = Color.White,modifier = Modifier.padding(start = 20.dp))


                }

            }
        }
        if(showDialog.value){
            DialogBox(onDismiss = {showDialog.value =false})
        }
        if(joinDialog.value){
            JoinRoom(onDismiss = {joinDialog.value =false})
        }

    }
}


@Composable
fun DialogBox(onDismiss: () -> Unit) {
    val context = LocalContext.current
    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val number = remember { mutableStateOf(GenerateCode()) }

    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .height(200.dp)
                .width(300.dp),
            shape = RoundedCornerShape(6.dp),
            backgroundColor = lightPurple
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.TopEnd,
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(60.dp)) {
                    Text(
                        text = "Custom Room",
                        fontSize = 20.sp,
                        color = Color.White,
                        modifier = Modifier.padding(top = 5.dp)
                    )
                    Image(
                        imageVector = Icons.Default.Cancel,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(top = 5.dp, end = 5.dp)
                            .clickable { onDismiss() },
                        colorFilter = ColorFilter.tint(DarkPurple)
                    )
                }
            }
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    OutlinedCard(
                        onClick = { },
                        border = BorderStroke(2.dp, DarkPurple),
                        modifier = Modifier.fillMaxWidth(.8f)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                                Image(
                                    imageVector = Icons.Default.ContentCopy,
                                    contentDescription = "",
                                    modifier = Modifier.clickable {
                                        val clip = ClipData.newPlainText("copied code", number.value.toString())
                                        clipboard.setPrimaryClip(clip)
                                    }
                                )
                                Text(
                                    text = "${number.value}",
                                    fontSize = 20.sp,
                                )
                            }
                        }
                    }
                    Row() {
                        Text(text = "*", modifier = Modifier.padding(top = 10.dp), color = Color.Red)
                        Text(text = "Copy the code and share with friend to play", modifier = Modifier.padding(top = 10.dp), color = Color.White)
                    }
                    Row(
                        modifier = Modifier.padding(top = 20.dp, start = 200.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(
                            text = "Regenerate",
                            fontSize = 14.sp,
                            color = DarkPurple,
                            modifier = Modifier.clickable {
                                number.value = GenerateCode()
                            }
                        )
                    }
                }
            }
        }
    }
}

fun GenerateCode(): Int {
    return Random.nextInt(100000, 1000000)
}



//join room wala dialog box



@Composable
fun JoinRoom(onDismiss: () -> Unit) {
    val textState = remember {
        mutableStateOf("")
    }

    Dialog(onDismissRequest = onDismiss) { // This should dismiss when you click outside the dialog
        Card(
            modifier = Modifier
                .height(180.dp)
                .width(300.dp),
            shape = RoundedCornerShape(6.dp),
            backgroundColor = lightPurple
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.TopEnd
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(80.dp)) {
                    Text(
                        text = "Join Room",
                        fontSize = 20.sp,
                        color = Color.White,
                        modifier = Modifier.padding(top = 5.dp)
                    )
                    Image(
                        imageVector = Icons.Default.Cancel,
                        contentDescription = "Close dialog",
                        modifier = Modifier
                            .padding(top = 5.dp, end = 5.dp)
                            .clickable { onDismiss() }, // This should trigger dialog dismissal
                        colorFilter = ColorFilter.tint(DarkPurple)
                    )
                }
            }
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp)
                ) {
                    Text("Enter your code here",color = Color.White)
                    OutlinedTextField(
                        value = textState.value,
                        onValueChange = { newValue -> textState.value = newValue },
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .border(2.dp, DarkPurple),
                        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White),
                        shape = RoundedCornerShape(12.dp),

                    )
                    Row(
                        modifier = Modifier.padding(top = 20.dp, start = 200.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Button(
                            onClick = { /* Action on join */ },
                            modifier = Modifier.fillMaxWidth(0.8f),
                            shape = RoundedCornerShape(6.dp)
                        ) {
                            Text(text = "JOIN")
                        }
                    }
                }
            }
        }
    }
}
