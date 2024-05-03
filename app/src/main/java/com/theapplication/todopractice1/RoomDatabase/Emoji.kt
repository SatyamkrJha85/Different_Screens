package com.theapplication.todopractice1.RoomDatabase

import android.graphics.drawable.Icon
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.theapplication.todopractice1.R
import com.theapplication.todopractice1.ui.theme.LightBlue
import com.theapplication.todopractice1.ui.theme.LightPurple
import com.theapplication.todopractice1.ui.theme.LightWhite
import com.theapplication.todopractice1.ui.theme.Orange
import com.theapplication.todopractice1.ui.theme.card1
import com.theapplication.todopractice1.ui.theme.card2
import com.theapplication.todopractice1.ui.theme.card3
import com.theapplication.todopractice1.ui.theme.midami
import com.theapplication.todopractice1.ui.theme.ownfont


@Preview(showSystemUi = true)
@Composable
fun Emoji() {



    val img = listOf(
        R.drawable.race3,
        R.drawable.race4
    )


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(LightWhite)
            .padding(top = 10.dp, start = 10.dp, end = 10.dp)
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            Texteditorbold(title = "Hi Satyam")

            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Icon(
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .background(Color.White, CircleShape)
                        .size(35.dp)
                        .padding(4.dp),
                )
                Icon(
                    imageVector = Icons.Filled.DateRange, contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .background(Color.White, CircleShape)
                        .size(35.dp)
                        .padding(4.dp),
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        Texteditor(title = "How Are you feeling today", size = 17)
        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Iconsmultiples(
                R.drawable.love, "In Love"
            )

            Iconsmultiples(
                R.drawable.oooo, "Surprise"
            )

            Iconsmultiples(
                R.drawable.cute, "Cute"
            )

            Iconsmultiples(
                R.drawable.mesmrize, "mesmerize"
            )

            Iconsmultiples(
                R.drawable.wow, "Wow"
            )

            Iconsmultiples(
                R.drawable.smile, "Happy"
            )

        }

        Spacer(modifier = Modifier.height(10.dp))
        Texteditor(title = "Daily Check-ins & Challenges", size = 17)
        Spacer(modifier = Modifier.height(10.dp))

        LazyRow {
            item {
                iconcard("Daily Brain \n Teaser", R.drawable.lamp, card1)
                iconcard("Walk & Earn", R.drawable.footsteps, card2)
                iconcard("Flower Love", R.drawable.sunflower, card3)

            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Row for trending text

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Texteditor(title = "Trending Activities", size = 18)
            Texteditor(
                title = "View All",
                size = 15,
                fontStyle = FontStyle.Normal,
                textDecoration = TextDecoration.Underline
            )

        }

        Spacer(modifier = Modifier.height(10.dp))

        LazyRow(

        ) {
            item {
                boximg(R.drawable.race1, "43rd Delta Century", "Date:Sat,May 04, 2024")
                boximg(R.drawable.race2, "2024 Best Buddies ", "Date:Sat,May 18, 2024")
                boximg(R.drawable.race3, "43rd Delta Century", "Date:Sat,May 04, 2024")

            }
        }
        Spacer(modifier = Modifier.height(18.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Row {
                Iconstwo(image = R.drawable.camera, title = "Feed")
                Spacer(modifier = Modifier.width(20.dp))
                Iconstwo(image = R.drawable.forum, title = "Forum")
            }
            Texteditor(
                title = "Post",
                size = 15,
                fontStyle = FontStyle.Normal,
                textDecoration = TextDecoration.Underline
            )
        }
        Spacer(modifier = Modifier.height(18.dp))


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(1.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            boximgbasic(img = R.drawable.race3)

            boximgbasic(img = R.drawable.race4)

        }
        Spacer(modifier = Modifier.height(10.dp))


        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ){
            bottombar(Icons.Filled.Home,"Home", FontWeight.Bold, tintcolor = Orange)
            bottombar(Icons.Filled.LocationOn,"Nearby", FontWeight.Bold, tintcolor = Color.Gray)
            bottombar(Icons.Filled.ShoppingCart,"Rewards", FontWeight.Bold, tintcolor = Color.Gray)
            bottombar(Icons.Filled.Email,"Chat", FontWeight.Bold, tintcolor = Color.Gray)
            bottombar(Icons.Filled.Person,"Profile", FontWeight.Bold, tintcolor = Color.Gray)

        }
        Spacer(modifier = Modifier.height(5.dp))

    }
}




@Composable
fun Texteditor(
    title: String,
    size: Int,
    fontStyle: FontStyle? = null,
    textDecoration: TextDecoration? = null,
    fontWeight: FontWeight? = null

) {

    Text(
        text = title,
        color = Color.Black,
        fontStyle = fontStyle,
        fontWeight = FontWeight.Bold,
        fontFamily = ownfont,
        fontSize = size.sp,
        textDecoration = textDecoration
    )
}


@Composable
fun Texteditorbold(title: String) {

    Text(
        text = title,
        color = Color.Black,
        fontWeight = FontWeight.SemiBold,
        fontFamily = midami,
        fontSize = 24.sp
    )
}

@Composable
fun Iconsmultiples(image: Int, title: String) {
    Column(
        modifier = Modifier.padding(start = 10.dp, end = 7.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier.size(35.dp)
        )
        Text(
            text = title,
            fontSize = 10.sp,
            fontStyle = FontStyle.Normal,
            fontFamily = ownfont,
            color = Color.Black
        )


    }

}


@Composable
fun Iconstwo(image: Int, title: String) {
    Column(
        modifier = Modifier.padding(start = 10.dp, end = 7.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier.size(25.dp)
        )
        Text(
            text = title,
            fontSize = 13.sp,
            fontStyle = FontStyle.Normal,
            fontFamily = ownfont,
            color = Color.Black
        )


    }

}

@Composable
fun iconcard(title: String, img: Int, color: Color) {
    Box(
        modifier = Modifier
            .padding(7.dp)
            .width(140.dp)
            .height(100.dp)
            .background(color, RoundedCornerShape(12.dp))
    ) {

        androidx.compose.foundation.Image(
            painter = painterResource(id = img),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 5.dp, start = 5.dp)
                .size(50.dp)
                .align(Alignment.TopStart)
        )

        Text(
            text = title,
            fontFamily = midami,
            fontSize = 13.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(end = 10.dp, top = 5.dp, bottom = 10.dp)
                .align(Alignment.BottomEnd)
        )

    }
}

@Composable
fun boximg(img: Int, title: String, dis: String) {
    Column(
        modifier = Modifier.padding(start = 6.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(13.dp))
                .width(140.dp)
                .height(150.dp)
        ) {

            androidx.compose.foundation.Image(
                painter = painterResource(id = img),
                contentDescription = null,
                modifier = Modifier,
                contentScale = ContentScale.Crop

            )

            Icon(
                imageVector = Icons.Rounded.Favorite,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .padding(5.dp)
                    .background(
                        Color.Gray, CircleShape
                    )
                    .padding(5.dp)
                    .size(30.dp)
                    .align(Alignment.TopEnd)
                    .padding(1.dp)
            )
        }
        Spacer(modifier = Modifier.height(5.dp))

        Texteditor(title = title, size = 14, fontWeight = FontWeight.Bold)
        Texteditor(title = dis, size = 12, fontWeight = FontWeight.Normal)
    }
}

@Composable
fun boximgbasic(img: Int) {
    Column(
        modifier = Modifier.padding(start = 6.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(13.dp))
                .width(170.dp)
                .height(90.dp)
        ) {

            androidx.compose.foundation.Image(
                painter = painterResource(id = img),
                contentDescription = null,
                modifier = Modifier,
                contentScale = ContentScale.Crop
            )

        }
    }
}

@Composable
fun bottombar(icon:ImageVector,title: String,fontWeight: FontWeight?=null,tintcolor:Color) {
    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(imageVector = icon, contentDescription =null, tint = tintcolor )
        Text(text = title, color =tintcolor )
    }
}



