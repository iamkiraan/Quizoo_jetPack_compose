package com.example.quizoo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quizoo.ui.theme.OrangeQ
import com.example.quizoo.ui.theme.blackq


@Composable
fun Mathematics(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(blackq)
    ) {
        Column() {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                shape = RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp),
                colors = CardDefaults.cardColors(containerColor = OrangeQ)
            ) {
                Box(
                    modifier = Modifier
                        .padding(20.dp)
                        .background(blackq, shape = RoundedCornerShape(100.dp))
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.round_arrow_back_ios_24),
                        contentDescription = "",
                        alignment = Alignment.TopStart,
                        modifier = Modifier
                            .size(48.dp)
                            .padding(8.dp)
                            .clickable {
                                navController.popBackStack()

                            }
                    )
                }

                Text(
                    text = "Mathematics",
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold

                )

            }
            Card(
                modifier = Modifier
                    .padding(top = 80.dp, start = 40.dp,end =40.dp),
                colors = CardDefaults.cardColors(containerColor = blackq)
            ) {

                Column(
                ) {
                    Text(text = "Chapter Name:",
                        color =Color.White)
                    Text(text = "12",
                        color = OrangeQ,
                        modifier = Modifier.padding(top=10.dp)
                    )
                    Text(text = "Topic Name:",
                        color =Color.White,
                        modifier = Modifier.padding(top = 20.dp))
                    Text(text = "Pair of Linear Equation in two variables",
                        color = OrangeQ,
                        modifier = Modifier.padding(top=10.dp)
                    )
                    Text(text = "Number of Questions:",
                        color =Color.White,
                        modifier = Modifier.padding(top = 20.dp))
                    Text(text = "06",
                        color = OrangeQ,
                        modifier = Modifier.padding(top=10.dp)
                    )
                    Text(text = "Total Time:",
                        color =Color.White,
                        modifier = Modifier.padding(top = 20.dp))
                    Text(text = "15 Min",
                        color = OrangeQ,
                        modifier = Modifier.padding(top=10.dp)
                    )

                    Button(onClick = {},
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 60.dp)
                            .height(60.dp),
                        colors =ButtonDefaults.buttonColors(OrangeQ)






                    ) {
                        Text(text = "Start",
                            fontSize = 24.sp,
                            color =Color.Black



                        )
                        
                    }
                }


            }
        }
    }

}
