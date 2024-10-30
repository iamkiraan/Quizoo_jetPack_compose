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
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.navigation.compose.rememberNavController
import com.example.quizoo.Navigations.Screens
import com.example.quizoo.R
import com.example.quizoo.dataStore.StoreUserDetails
import com.example.quizoo.ui.theme.DarkPurple
import com.example.quizoo.ui.theme.lightPurple
import kotlinx.coroutines.launch

@Composable
fun Mathematics(
    navController: NavHostController = rememberNavController()

) {


    val scrollState = rememberScrollState()
    val context = LocalContext.current
    val dataStore = StoreUserDetails(context)
    val scope = rememberCoroutineScope()
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
            ) {
                Text(
                    text = "Featured Categories",
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
                ) {
                    Column() {
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
                                        scope.launch {
                                            dataStore.saveID("mathematics")
                                        }
                                        val route = Screens.MathematicsStart.getTopic(
                                            topic = "Mathematics",
                                            image = R.drawable.mathematics,
                                            id = 1)
                                        navController.navigate(route)

                                    },
                                contentScale = ContentScale.Crop)

                        }
                        Text(
                            text = "Mathematics",
                            modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                            style = MaterialTheme.typography.labelLarge,
                            color = Color.White
                        )

                    }


                    //second one image
                    Column() {
                        Card(
                            modifier = Modifier
                                .padding(4.dp)
                                .size(100.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.gk),
                                contentDescription = "",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clickable {
                                        scope.launch {
                                            dataStore.saveID("programming")
                                        }
                                        val route = Screens.MathematicsStart.getTopic(
                                            topic = "programming",
                                            image = R.drawable.gk,
                                            id = 2)
                                        navController.navigate(route)


                                    },
                                contentScale = ContentScale.Crop)

                        }
                        Text(
                            text = "Programming",
                            modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                            style = MaterialTheme.typography.labelLarge,
                            color = Color.White
                        )

                    }
                    Column() {
                        Card(
                            modifier = Modifier
                                .padding(4.dp)
                                .size(100.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.science),
                                contentDescription = "",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clickable {
                                        scope.launch {
                                            dataStore.saveID("science")
                                        }
                                        val route = Screens.MathematicsStart.getTopic(
                                            topic = "Science",
                                            image = R.drawable.programming,
                                            id = 3)
                                        navController.navigate(route)

                                    },
                                contentScale = ContentScale.Crop)

                        }
                        Text(
                            text = "Science",
                            modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                            style = MaterialTheme.typography.labelLarge,
                            color = Color.White
                        )

                    }
                    Column() {
                        Card(
                            modifier = Modifier
                                .padding(4.dp)
                                .size(100.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.programming),
                                contentDescription = "",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clickable {
                                        scope.launch {
                                            dataStore.saveID("knowledge")
                                        }
                                        val route = Screens.MathematicsStart.getTopic(
                                            topic = "General Knowledge",
                                            image = R.drawable.programming,
                                            id = 4)
                                        navController.navigate(route)

                                    },
                                contentScale = ContentScale.Crop)

                        }
                        Text(
                            text = "General Knowledge",
                            modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                            style = MaterialTheme.typography.labelLarge,
                            color = Color.White
                        )

                    }

                }
            }


        }


    }

    }







