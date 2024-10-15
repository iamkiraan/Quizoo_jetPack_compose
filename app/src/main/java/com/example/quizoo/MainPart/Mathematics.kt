package com.example.quizoo.MainPart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.quizoo.Navigations.Screens
import com.example.quizoo.R
import com.example.quizoo.dataStore.StoreUserDetails
import com.example.quizoo.ui.theme.DarkPurple
import com.example.quizoo.ui.theme.OrangeQ
import com.example.quizoo.ui.theme.SkyBlue
import com.example.quizoo.ui.theme.blackq
import com.example.quizoo.ui.theme.lightPurple

@Composable
fun Mathematics() {
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    val dataStore = StoreUserDetails(context)
    //gettting the saved data
    val saveUsername = dataStore.getUserName.collectAsState(initial = "")
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(lightPurple)
    ){

        Text(text = "Hey,${saveUsername.value}",
            modifier = Modifier.padding(start =25.dp,top=10.dp),
            color=Color.White,
            fontSize = 16.sp)
        Column(
            modifier =Modifier,
            verticalArrangement = Arrangement.Center
        ){
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .padding(top = 35.dp, start = 20.dp, end = 20.dp),
                elevation =CardDefaults.cardElevation(100.dp),
                shape = RoundedCornerShape(10.dp)

            ){
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(DarkPurple)
                ) {


                    Row {
                        Column() {
                            Text(
                                text = "Let's play\ntogether",
                                modifier = Modifier.padding(18.dp),
                                fontSize = 24.sp,
                                color = Color.White)
                            Button(onClick = {},
                                modifier = Modifier
                                    .padding(top = 1.dp, start = 16.dp)
                                    .fillMaxWidth(.4f),
                                colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = DarkPurple)
                                ) {
                                Text(text="Play now")

                            }
                        }
                        Image(painter = painterResource(id = R.drawable.cup), contentDescription ="",
                            modifier = Modifier.padding(start =15.dp))
                    }
                }

            }
            Column(
                modifier = Modifier.padding(top=20.dp)
            ){
                Text(text = "Featured Categories",
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 20.dp)

                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(scrollState)
                        .padding(top = 10.dp, start = 5.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ){
                    Column(){
                    Card(
                        modifier = Modifier
                            .padding(4.dp)
                            .size(100.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.mathematics),
                            contentDescription = "",
                            modifier = Modifier
                                .fillMaxSize()
                                .clickable {
                                    //navController.navigate(Screens.quizMathematics.route)
                                },
                            contentScale = ContentScale.Crop)

                    }
                        Text(
                            text = "Mathematics",
                            modifier = Modifier.padding(top =10.dp,start = 10.dp),
                            style = MaterialTheme.typography.labelLarge,
                            color = Color.White
                        )

                    }






                    //second one image
                    Card(
                        modifier = Modifier
                            .padding(4.dp)
                            .size(100.dp)
                    ) {
                        Image(painter = painterResource(id = R.drawable.gk), contentDescription = "Mathematics",
                            modifier = Modifier.fillMaxSize()
                                .weight(1f),
                            contentScale = ContentScale.Crop)

                    }
                    Card(
                        modifier = Modifier
                            .padding(4.dp)
                            .size(100.dp)
                    ) {
                        Image(painter = painterResource(id = R.drawable.programming), contentDescription = "",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }
                    Card(
                        modifier = Modifier
                            .padding(4.dp)
                            .size(100.dp)
                    ) {
                        Image(painter = painterResource(id = R.drawable.science), contentDescription = "",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                }
                
            }


        }


    }

    }





