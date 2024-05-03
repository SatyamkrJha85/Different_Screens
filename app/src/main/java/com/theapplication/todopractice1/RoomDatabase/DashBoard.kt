package com.theapplication.todopractice1.RoomDatabase

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.theapplication.todopractice1.R
import com.theapplication.todopractice1.smallDatas.GreedCellData
import com.theapplication.todopractice1.smallDatas.GreedData
import com.theapplication.todopractice1.ui.theme.LightBlue
import com.theapplication.todopractice1.ui.theme.LightGreen
import com.theapplication.todopractice1.ui.theme.LightPurple
import com.theapplication.todopractice1.ui.theme.Purple40
import com.theapplication.todopractice1.ui.theme.Purple80
import com.theapplication.todopractice1.ui.theme.ownfont

@Composable
fun DashBoard(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(LightPurple),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        ConstraintLayout {
            val (topimg, profile) = createRefs()

            Box(
                modifier =
                Modifier
                    .fillMaxWidth()
                    .height(230.dp)
                    .constrainAs(topimg) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
                    .background(
                        Purple40, shape = RoundedCornerShape(bottomEnd = 30.dp, bottomStart = 30.dp)
                    ),
            )

            Row(
                modifier = Modifier
                    .padding(top = 44.dp, start = 30.dp, end = 20.dp)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .height(100.dp)
                        .weight(0.7f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Hello",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = ownfont
                    )
                    Text(
                        text = "Satyam Jha",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = ownfont
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.profile), contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(shape = CircleShape)
                        .border(
                            2.dp, Color.White,
                            CircleShape
                        ), contentScale = ContentScale.Crop
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(top = 24.dp, start = 24.dp, end = 24.dp)
                    .shadow(3.dp, shape = RoundedCornerShape(20.dp))
                    .constrainAs(profile) {
                        top.linkTo(topimg.bottom)
                        bottom.linkTo(topimg.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(Color.White)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {

                        Column(
                            modifier = Modifier
                                .background(LightPurple, shape = RoundedCornerShape(12.dp))
                                .padding(5.dp)
                                .padding(bottom = 5.dp, start = 2.dp, end = 2.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.music),
                                contentDescription = null,
                                modifier = Modifier.size(50.dp)
                            )

                            Text(text = "Music", fontFamily = ownfont, color = Color.Black)
                        }

                        Column(
                            modifier = Modifier
                                .padding(10.dp)
                                .background(LightPurple, shape = RoundedCornerShape(12.dp))
                                .padding(bottom = 5.dp, start = 2.dp, end = 2.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.cal),
                                contentDescription = null,
                                modifier = Modifier.size(50.dp)
                            )

                            Text(text = "Calendar", fontFamily = ownfont, color = Color.Black)
                        }

                        Column(
                            modifier = Modifier
                                .padding(10.dp)
                                .background(LightPurple, shape = RoundedCornerShape(12.dp))
                                .padding(bottom = 5.dp, start = 2.dp, end = 2.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.onboardscreen1),
                                contentDescription = null,
                                modifier = Modifier.size(50.dp)
                            )
                            Text(text = "Boarding", fontFamily = ownfont, color = Color.Black)
                        }
                    }
                }
            }
        }

        var name by remember {
            mutableStateOf("")
        }

        Spacer(modifier = Modifier.height(30.dp))

        TextField(value = name, onValueChange = { name = it }, trailingIcon = {
            Image(
                painter = painterResource(id = R.drawable.search2), contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clickable {
                        navController.navigate("Emoji")
                    }
                    .padding(end = 5.dp),
            )

        }, placeholder = {
            Text(text = "Searching for...")
        }, colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.White,
            disabledContainerColor = Color.White,
            unfocusedIndicatorColor = Color.White,
            focusedTextColor = Color.Black,
            unfocusedLabelColor = LightBlue,
            focusedPlaceholderColor = Color.Black,
            disabledPlaceholderColor = Color.Black,
            unfocusedPlaceholderColor = Color.Black,
            errorPlaceholderColor = Color.Black
        ), shape = CircleShape, modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp)
            .background(Color.White, shape = CircleShape)
            .shadow(
                3.dp,
                CircleShape
            )
        )

        Spacer(modifier = Modifier.height(30.dp))


        Box(
            modifier = Modifier
                .width(350.dp)
                .height(140.dp)
                .padding(start = 10.dp, end = 10.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Purple40,
                            Purple80
                        )
                    ), RoundedCornerShape(16.dp)
                ),
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, start = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Column(
                ) {
                    Text(
                        text = "To Get Unlimited",
                        color = Color.White,
                        fontFamily = ownfont,
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "Upgrade Your Account",
                        color = Color.White,
                        fontFamily = ownfont,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 19.sp
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.onboardscreen3),
                    contentDescription = null,
                    modifier = Modifier
                        .size(90.dp)
                        .padding(start = 10.dp)

                )
            }


        }
        Spacer(modifier = Modifier.height(5.dp))


        // Grid

        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            content = {
                items(GreedData) { grid ->
                    gridimg(grid = grid)
                }
            }
        )


    }

}

@Composable
fun gridimg(grid: GreedCellData) {
    Column(

        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(
                    Color.White, RoundedCornerShape(10.dp)
                )
                .padding(7.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(
                painter = painterResource(id = grid.image),
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )

        }
        Text(text = grid.title, color = Color.Black, fontFamily = ownfont, fontSize = 13.sp)
    }
}


@Preview(showSystemUi = true)
@Composable
fun dashpreview() {
    DashBoard(navController = rememberNavController())
}