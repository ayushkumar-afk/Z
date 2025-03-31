package com.example.loginzomato.ui.theme

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginzomato.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriesScreen(modifier: Modifier = Modifier) {

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White),
                title = { SearchBar() },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.padding(end = 12.dp)

                    )
                },

            )
        }
    ) { padding ->
        val listOfFoodCategories = listOf(
            ImageSection(image1 = R.drawable.pizzacat, text1 = "Pizza"),
            ImageSection(image1 = R.drawable.icecreamm, text1 = "Icecream"),
            ImageSection(image1 = R.drawable.thali, text1 = "Thali"),
            ImageSection(image1 = R.drawable.pizzacat, text1 = "Pizza"),
            ImageSection(image1 = R.drawable.icecreamm, text1 = "Icecream"),
            ImageSection(image1 = R.drawable.thali, text1 = "Thali")
        )



        var selectedTabIndex by remember { mutableStateOf(0) }

        Column(modifier = Modifier.padding(padding)) {
            // TabRow for Food Categories
            TabRow(
                selectedTabIndex = selectedTabIndex,
                containerColor = Color.White,
                contentColor = Color.Black
            ) {
                listOfFoodCategories.forEachIndexed { index, item ->


                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        modifier = Modifier.padding(vertical = 8.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(id = item.image1),
                                contentDescription = item.text1,
                                modifier = Modifier
                                    .size(45.dp)
                                    .padding(bottom = 4.dp)
                            )
                            Text(
                                text = item.text1,
                                fontSize = 12.sp,
                                color = if (selectedTabIndex == index) Color.Red else Color.Gray,
                                fontWeight = if (selectedTabIndex == index) FontWeight.Bold else FontWeight.Normal
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            // LazyRow for Filter Cards


            // Content based on selected tab
            when (selectedTabIndex) {
                0 -> RollsContent()
                1 -> IcecreamContent()
                2 -> ThaliContent()
                3 -> ThaliContent()
                else -> DefaultContent()
            }
        }
    }
}

@Composable
fun SearchBar() {
    var searchValue by remember { mutableStateOf("") }
    OutlinedTextField(
        value = searchValue,
        onValueChange = { searchValue = it },
        placeholder = {
            Text(
                text = "Restaurant name or a dish",
                fontSize = 16.sp,
                color = Color.LightGray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Color.Red
            )
        },
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color.LightGray,
            focusedBorderColor = Color.Gray
        ),
        modifier = Modifier
            .fillMaxWidth()
            .size(width = 350.dp, height = 49.dp),
        shape = RoundedCornerShape(12.dp),
        trailingIcon = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                VerticalDivider(
                    thickness = 1.dp,
                    modifier = Modifier
                        .height(23.dp)
                        .padding(top = 2.dp, end = 10.dp),
                    color = Color.LightGray.copy(alpha = 0.60f)
                )
                Icon(
                    painter = painterResource(R.drawable.mic),
                    contentDescription = "Mic",
                    modifier = Modifier.size(14.dp),
                    tint = Color.Red
                )
            }
        }
    )
}

@Composable
fun DemoCard(image: Int, text: String) {
    Card(shape = RoundedCornerShape(10.dp),
        modifier = Modifier.size(width = 100.dp, height = 30.dp).padding(start = 5.dp).border(0.1.dp, color = Color.LightGray, shape = RoundedCornerShape(10.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(1.dp),

    ) {
        Row(
            modifier = Modifier.padding(top = 3.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(id = image),
                contentDescription = text,
                modifier = Modifier.size(15.dp)
            )
            Text(
                text = text,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

// Data classes
data class ImageSection(
    val image1: Int,
    val text1: String
)

data class CardData(
    val image: Int,
    val text: String
)

data class categorycard(
    val foodimagebackground1: Int,
   val textblackone1: String,
    val cardtextname1: String,
   val timingtext1: String,
    val timerimage1:Int,


    val foodimagebackground2: Int,
    val textblackone2: String,
    val cardtextname2: String,
    val timingtext2: String,
    val timerimage2:Int

)

// Content composables
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable


fun RollsContent() {
    var scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val LazyListState  = rememberLazyListState()
LazyColumn(modifier = Modifier.fillMaxSize().background(Color.White)) {

     item {
    val filterCards = listOf(
        CardData(image = R.drawable.img, text = "Filters"),
        CardData(image = R.drawable.img, text = "Flash Sale"),
        CardData(image = R.drawable.img, text = "Under 30 mins"),
        CardData(image = R.drawable.img, text = "Rating 4.0+"),
        CardData(image = R.drawable.img, text = "Schedule")
    )
    LazyRow(modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        contentPadding = PaddingValues(horizontal = 6.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),

        ) {
        items(filterCards) { card ->
            DemoCard(image = card.image, text = card.text)
        }
    }
}


  item {
      Text(
          text = "RECOMMENDED FOR YOU",
          style = TextStyle(
              fontSize = 14.sp,
              color = Color.Gray,
              fontWeight = FontWeight.Normal,
              letterSpacing = 2.sp,
              fontFamily = FontFamily.SansSerif
          ),
          modifier = Modifier.padding(vertical = 16.dp).padding(start = 10.dp),
          textAlign = TextAlign.Center
      )
  }
item {
    //  categoryCard()
    val ListofCardDetailsFood = listOf<categorycard>(
        categorycard(
            foodimagebackground1 = R.drawable.pizza1,
            textblackone1 = "60% OFF up to ₹120",
            cardtextname1 = "Rominus Pizz..",
            timingtext1 = "10 mins",
            timerimage1 = R.drawable.timer10,
            foodimagebackground2 = R.drawable.pizza5,
            textblackone2 = "50% OFF up to ₹100",
            cardtextname2 = "Dominozz Pizz..",
            timingtext2 = "30 mins",
            timerimage2 = R.drawable.timer60
        ),
        categorycard(
            foodimagebackground1 = R.drawable.pizza2,
            textblackone1 = "FLAT 60% OFF",
            cardtextname1 = "Burger villa..",
            timingtext1 = "60 mins",
            timerimage1 = R.drawable.timer60,
            foodimagebackground2 = R.drawable.pizza1,
            textblackone2 = "Flat ₹120",
            cardtextname2 = "Piza Hut..",
            timingtext2 = "30 mins",
            timerimage2 = R.drawable.timer60
        ),
        categorycard(
            foodimagebackground1 = R.drawable.pizza3,
            textblackone1 = "Get items @₹50 only",
            cardtextname1 = "Dominozz Pizz..",
            timingtext1 = "30 mins",
            timerimage1 = R.drawable.timer30,
            foodimagebackground2 = R.drawable.pizza2,
            textblackone2 = "FLAT 60% OFF",
            cardtextname2 = "Burger villa..",
            timingtext2 = "30 mins",
            timerimage2 = R.drawable.timer60
        ),
        categorycard(
            foodimagebackground1 = R.drawable.pizza4,
            textblackone1 = "60% OFF up to ₹120",
            cardtextname1 = "Piza Hut..",
            timingtext1 = "80 mins",
            timerimage1 = R.drawable.timerred,
            foodimagebackground2 = R.drawable.pizza3,
            textblackone2 = "Flat ₹120 OF",
            cardtextname2 = "Pizza Lariya..",
            timingtext2 = "30 mins",
            timerimage2 = R.drawable.timer60
        ),
        categorycard(
            foodimagebackground1 = R.drawable.pizza5,
            textblackone1 = "60% OFF up to ₹120",
            cardtextname1 = "Pizza Virus..",
            timingtext1 = "90 mins",
            timerimage1 = R.drawable.timer90,
            foodimagebackground2 = R.drawable.pizza4,
            textblackone2 = "Flat ₹120",
            cardtextname2 = "Pizza Lariya..",
            timingtext2 = "30 mins",
            timerimage2 = R.drawable.timer60
        ),
        categorycard(
            foodimagebackground1 = R.drawable.pizza1,
            textblackone1 = "60% OFF up to ₹120",
            cardtextname1 = "Burger King..",
            timingtext1 = "60 mins",
            timerimage1 = R.drawable.timer60,
            foodimagebackground2 = R.drawable.pizza5,
            textblackone2 = "Flat ₹120",
            cardtextname2 = "Pizza Virus..",
            timingtext2 = "30 mins",
            timerimage2 = R.drawable.timer60
        )
    )


    LazyRow(
        contentPadding = PaddingValues(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        state = LazyListState
    ) {
        items(ListofCardDetailsFood) { items ->
            categoryCard(
                foodimagebackground1 = items.foodimagebackground1,
                textblackone1 = items.textblackone1,
                cardtextname1 = items.cardtextname1,
                timingtext1 = items.timingtext1,
                timerimage1 = items.timerimage1,
                foodimagebackground2 = items.foodimagebackground2,
                textblackone2 = items.textblackone2,
                cardtextname2 = items.cardtextname2,
                timingtext2 = items.timingtext2,
                timerimage2 = items.timerimage2
            )

        }

    }
}

item{
    Text(
        text = "ALL RESTAURANTS",
        style = TextStyle(
            fontSize = 14.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Normal,
            letterSpacing = 2.sp,
            fontFamily = FontFamily.SansSerif
        ),
        modifier = Modifier.padding(vertical = 25.dp).padding(start = 10.dp),
        textAlign = TextAlign.Center
    )
}


    item{
        Text(
            text = "Card Displayed",
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Normal,
                letterSpacing = 2.sp,
                fontFamily = FontFamily.SansSerif
            ),
            modifier = Modifier.padding(vertical = 25.dp).padding(start = 10.dp),
            textAlign = TextAlign.Center
        )

        Text(
            text = "Card Displayed",
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Normal,
                letterSpacing = 2.sp,
                fontFamily = FontFamily.SansSerif
            ),
            modifier = Modifier.padding(vertical = 25.dp).padding(start = 10.dp),
            textAlign = TextAlign.Center
        )

        Text(
            text = "Card Displayed",
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Normal,
                letterSpacing = 2.sp,
                fontFamily = FontFamily.SansSerif
            ),
            modifier = Modifier.padding(vertical = 25.dp).padding(start = 10.dp),
            textAlign = TextAlign.Center
        )

        Text(
            text = "Card Displayed",
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Normal,
                letterSpacing = 2.sp,
                fontFamily = FontFamily.SansSerif
            ),
            modifier = Modifier.padding(vertical = 25.dp).padding(start = 10.dp),
            textAlign = TextAlign.Center
        )
        Text(
            text = "Card Displayed",
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Normal,
                letterSpacing = 2.sp,
                fontFamily = FontFamily.SansSerif
            ),
            modifier = Modifier.padding(vertical = 25.dp).padding(start = 10.dp),
            textAlign = TextAlign.Center
        )
        Text(
            text = "Card Displayed",
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Normal,
                letterSpacing = 2.sp,
                fontFamily = FontFamily.SansSerif
            ),
            modifier = Modifier.padding(vertical = 25.dp).padding(start = 10.dp),
            textAlign = TextAlign.Center
        )

        Text(
            text = "Card Displayed",
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Normal,
                letterSpacing = 2.sp,
                fontFamily = FontFamily.SansSerif
            ),
            modifier = Modifier.padding(vertical = 25.dp).padding(start = 10.dp),
            textAlign = TextAlign.Center
        )



    }






}

}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun IcecreamContent() {
    var scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val LazyListState  = rememberLazyListState()
    LazyColumn(modifier = Modifier.fillMaxSize().background(Color.White)) {

        stickyHeader {
            val filterCards = listOf(
                CardData(image = R.drawable.img, text = "Filters"),
                CardData(image = R.drawable.img, text = "Flash Sale"),
                CardData(image = R.drawable.img, text = "Under 30 mins"),
                CardData(image = R.drawable.img, text = "Rating 4.0+"),
                CardData(image = R.drawable.img, text = "Schedule")
            )
            LazyRow(modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                contentPadding = PaddingValues(horizontal = 6.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp),

                ) {
                items(filterCards) { card ->
                    DemoCard(image = card.image, text = card.text)
                }
            }
        }


        item {
            Text(
                text = "RECOMMENDED FOR YOU",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 2.sp,
                    fontFamily = FontFamily.SansSerif
                ),
                modifier = Modifier.padding(vertical = 16.dp).padding(start = 10.dp),
                textAlign = TextAlign.Center
            )
        }
        stickyHeader {
            //  categoryCard()
            val ListofCardDetailsFood = listOf<categorycard>(
                categorycard(
                    foodimagebackground1 = R.drawable.sundaes,
                    textblackone1 = "60% OFF up to ₹120",
                    cardtextname1 = "Rancho..",
                    timingtext1 = "10 mins",
                    timerimage1 = R.drawable.timer10,
                    foodimagebackground2 = R.drawable.icecreamm,
                    textblackone2 = "50% OFF up to ₹100",
                    cardtextname2 = "Cups And Cones..",
                    timingtext2 = "30 mins",
                    timerimage2 = R.drawable.timer60
                ),
                categorycard(
                    foodimagebackground1 = R.drawable.icecreamm,
                    textblackone1 = "FLAT 60% OFF",
                    cardtextname1 = "Ice Cream Parlor..",
                    timingtext1 = "60 mins",
                    timerimage1 = R.drawable.timer60,
                    foodimagebackground2 = R.drawable.icecream,
                    textblackone2 = "Flat ₹120",
                    cardtextname2 = "Cups And Cones..",
                    timingtext2 = "30 mins",
                    timerimage2 = R.drawable.timer60
                ),
                categorycard(
                    foodimagebackground1 = R.drawable.sundaes,
                    textblackone1 = "Get items @₹50 only",
                    cardtextname1 = "Sundaes Shop..",
                    timingtext1 = "30 mins",
                    timerimage1 = R.drawable.timer30,
                    foodimagebackground2 = R.drawable.sundaes,
                    textblackone2 = "FLAT 60% OFF",
                    cardtextname2 = "Vanila..",
                    timingtext2 = "30 mins",
                    timerimage2 = R.drawable.timer60
                ),
                categorycard(
                    foodimagebackground1 = R.drawable.img_5,
                    textblackone1 = "60% OFF up to ₹120",
                    cardtextname1 = "Rancho..",
                    timingtext1 = "80 mins",
                    timerimage1 = R.drawable.timerred,
                    foodimagebackground2 = R.drawable.sundaes,
                    textblackone2 = "Flat ₹120 OF",
                    cardtextname2 = "Pizza Lariya..",
                    timingtext2 = "30 mins",
                    timerimage2 = R.drawable.timer60
                ),
                categorycard(
                    foodimagebackground1 = R.drawable.vanilla,
                    textblackone1 = "60% OFF up to ₹120",
                    cardtextname1 = "Tempest shop..",
                    timingtext1 = "90 mins",
                    timerimage1 = R.drawable.timer90,
                    foodimagebackground2 = R.drawable.icecreamm,
                    textblackone2 = "Flat ₹120",
                    cardtextname2 = "Rancho..",
                    timingtext2 = "30 mins",
                    timerimage2 = R.drawable.timer60
                ),
                categorycard(
                    foodimagebackground1 = R.drawable.icecreamm,
                    textblackone1 = "60% OFF up to ₹120",
                    cardtextname1 = "Sundaes..",
                    timingtext1 = "60 mins",
                    timerimage1 = R.drawable.timer60,
                    foodimagebackground2 = R.drawable.img_5,
                    textblackone2 = "Flat ₹120",
                    cardtextname2 = "Vanila Burst..",
                    timingtext2 = "30 mins",
                    timerimage2 = R.drawable.timer60
                )
            )


            LazyRow(
                contentPadding = PaddingValues(horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                state = LazyListState
            ) {
                items(ListofCardDetailsFood) { items ->
                    categoryCard(
                        foodimagebackground1 = items.foodimagebackground1,
                        textblackone1 = items.textblackone1,
                        cardtextname1 = items.cardtextname1,
                        timingtext1 = items.timingtext1,
                        timerimage1 = items.timerimage1,
                        foodimagebackground2 = items.foodimagebackground2,
                        textblackone2 = items.textblackone2,
                        cardtextname2 = items.cardtextname2,
                        timingtext2 = items.timingtext2,
                        timerimage2 = items.timerimage2
                    )

                }

            }
        }

        item{
            Text(
                text = "ALL RESTAURANTS",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 2.sp,
                    fontFamily = FontFamily.SansSerif
                ),
                modifier = Modifier.padding(vertical = 25.dp).padding(start = 10.dp),
                textAlign = TextAlign.Center
            )
        }


        item{
            Text(
                text = "Card Displayed",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 2.sp,
                    fontFamily = FontFamily.SansSerif
                ),
                modifier = Modifier.padding(vertical = 25.dp).padding(start = 10.dp),
                textAlign = TextAlign.Center
            )

            Text(
                text = "Card Displayed",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 2.sp,
                    fontFamily = FontFamily.SansSerif
                ),
                modifier = Modifier.padding(vertical = 25.dp).padding(start = 10.dp),
                textAlign = TextAlign.Center
            )

            Text(
                text = "Card Displayed",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 2.sp,
                    fontFamily = FontFamily.SansSerif
                ),
                modifier = Modifier.padding(vertical = 25.dp).padding(start = 10.dp),
                textAlign = TextAlign.Center
            )

            Text(
                text = "Card Displayed",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 2.sp,
                    fontFamily = FontFamily.SansSerif
                ),
                modifier = Modifier.padding(vertical = 25.dp).padding(start = 10.dp),
                textAlign = TextAlign.Center
            )
            Text(
                text = "Card Displayed",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 2.sp,
                    fontFamily = FontFamily.SansSerif
                ),
                modifier = Modifier.padding(vertical = 25.dp).padding(start = 10.dp),
                textAlign = TextAlign.Center
            )
            Text(
                text = "Card Displayed",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 2.sp,
                    fontFamily = FontFamily.SansSerif
                ),
                modifier = Modifier.padding(vertical = 25.dp).padding(start = 10.dp),
                textAlign = TextAlign.Center
            )

            Text(
                text = "Card Displayed",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 2.sp,
                    fontFamily = FontFamily.SansSerif
                ),
                modifier = Modifier.padding(vertical = 25.dp).padding(start = 10.dp),
                textAlign = TextAlign.Center
            )



        }






    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun ThaliContent() {
    var scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val LazyListState  = rememberLazyListState()
    LazyColumn(modifier = Modifier.fillMaxSize().background(Color.White)) {

        stickyHeader {
            val filterCards = listOf(
                CardData(image = R.drawable.img, text = "Filters"),
                CardData(image = R.drawable.img, text = "Flash Sale"),
                CardData(image = R.drawable.img, text = "Under 30 mins"),
                CardData(image = R.drawable.img, text = "Rating 4.0+"),
                CardData(image = R.drawable.img, text = "Schedule")
            )
            LazyRow(modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                contentPadding = PaddingValues(horizontal = 6.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp),

                ) {
                items(filterCards) { card ->
                    DemoCard(image = card.image, text = card.text)
                }
            }
        }


        item {
            Text(
                text = "RECOMMENDED FOR YOU",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 2.sp,
                    fontFamily = FontFamily.SansSerif
                ),
                modifier = Modifier.padding(vertical = 16.dp).padding(start = 10.dp),
                textAlign = TextAlign.Center
            )
        }
        stickyHeader {
            //  categoryCard()
            val ListofCardDetailsFood = listOf<categorycard>(
                categorycard(
                    foodimagebackground1 = R.drawable.dosa,
                    textblackone1 = "60% OFF up to ₹120",
                    cardtextname1 = "Dosa King..",
                    timingtext1 = "10 mins",
                    timerimage1 = R.drawable.timer10,
                    foodimagebackground2 = R.drawable.idli,
                    textblackone2 = "50% OFF up to ₹100",
                    cardtextname2 = "Idi apam..",
                    timingtext2 = "30 mins",
                    timerimage2 = R.drawable.timer60
                ),
                categorycard(
                    foodimagebackground1 = R.drawable.parotha,
                    textblackone1 = "FLAT 60% OFF",
                    cardtextname1 = "Meenakshi Dosa..",
                    timingtext1 = "60 mins",
                    timerimage1 = R.drawable.timer60,
                    foodimagebackground2 = R.drawable.ricecurry,
                    textblackone2 = "Flat ₹120",
                    cardtextname2 = "Parotha Corner..",
                    timingtext2 = "30 mins",
                    timerimage2 = R.drawable.timer60
                ),
                categorycard(
                    foodimagebackground1 = R.drawable.vadda,
                    textblackone1 = "Get items @₹50 only",
                    cardtextname1 = "Dosa King..",
                    timingtext1 = "30 mins",
                    timerimage1 = R.drawable.timer30,
                    foodimagebackground2 = R.drawable.parotha,
                    textblackone2 = "FLAT 60% OFF",
                    cardtextname2 = "Parotha Corner..",
                    timingtext2 = "30 mins",
                    timerimage2 = R.drawable.timer60
                ),
                categorycard(
                    foodimagebackground1 = R.drawable.dosa,
                    textblackone1 = "60% OFF up to ₹120",
                    cardtextname1 = "Dosa Corner..",
                    timingtext1 = "80 mins",
                    timerimage1 = R.drawable.timerred,
                    foodimagebackground2 = R.drawable.idli,
                    textblackone2 = "Flat ₹120 OF",
                    cardtextname2 = "iddi apam..",
                    timingtext2 = "30 mins",
                    timerimage2 = R.drawable.timer60
                ),
                categorycard(
                    foodimagebackground1 = R.drawable.ricecurry,
                    textblackone1 = "60% OFF up to ₹120",
                    cardtextname1 = "Biryani Badsha..",
                    timingtext1 = "90 mins",
                    timerimage1 = R.drawable.timer90,
                    foodimagebackground2 = R.drawable.vadda,
                    textblackone2 = "Flat ₹120",
                    cardtextname2 = "Pizza Lariya..",
                    timingtext2 = "30 mins",
                    timerimage2 = R.drawable.timer60
                ),
                categorycard(
                    foodimagebackground1 = R.drawable.thali,
                    textblackone1 = "60% OFF up to ₹120",
                    cardtextname1 = "Burger King..",
                    timingtext1 = "60 mins",
                    timerimage1 = R.drawable.timer60,
                    foodimagebackground2 = R.drawable.ricecurry,
                    textblackone2 = "Flat ₹120",
                    cardtextname2 = "Pizza Virus..",
                    timingtext2 = "30 mins",
                    timerimage2 = R.drawable.timer60
                )
            )


            LazyRow(
                contentPadding = PaddingValues(horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                state = LazyListState
            ) {
                items(ListofCardDetailsFood) { items ->
                    categoryCard(
                        foodimagebackground1 = items.foodimagebackground1,
                        textblackone1 = items.textblackone1,
                        cardtextname1 = items.cardtextname1,
                        timingtext1 = items.timingtext1,
                        timerimage1 = items.timerimage1,
                        foodimagebackground2 = items.foodimagebackground2,
                        textblackone2 = items.textblackone2,
                        cardtextname2 = items.cardtextname2,
                        timingtext2 = items.timingtext2,
                        timerimage2 = items.timerimage2
                    )

                }

            }
        }

        item{
            Text(
                text = "ALL RESTAURANTS",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 2.sp,
                    fontFamily = FontFamily.SansSerif
                ),
                modifier = Modifier.padding(vertical = 25.dp).padding(start = 10.dp),
                textAlign = TextAlign.Center
            )
        }


        item{
            Text(
                text = "Card Displayed",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 2.sp,
                    fontFamily = FontFamily.SansSerif
                ),
                modifier = Modifier.padding(vertical = 25.dp).padding(start = 10.dp),
                textAlign = TextAlign.Center
            )

            Text(
                text = "Card Displayed",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 2.sp,
                    fontFamily = FontFamily.SansSerif
                ),
                modifier = Modifier.padding(vertical = 25.dp).padding(start = 10.dp),
                textAlign = TextAlign.Center
            )

            Text(
                text = "Card Displayed",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 2.sp,
                    fontFamily = FontFamily.SansSerif
                ),
                modifier = Modifier.padding(vertical = 25.dp).padding(start = 10.dp),
                textAlign = TextAlign.Center
            )

            Text(
                text = "Card Displayed",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 2.sp,
                    fontFamily = FontFamily.SansSerif
                ),
                modifier = Modifier.padding(vertical = 25.dp).padding(start = 10.dp),
                textAlign = TextAlign.Center
            )
            Text(
                text = "Card Displayed",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 2.sp,
                    fontFamily = FontFamily.SansSerif
                ),
                modifier = Modifier.padding(vertical = 25.dp).padding(start = 10.dp),
                textAlign = TextAlign.Center
            )
            Text(
                text = "Card Displayed",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 2.sp,
                    fontFamily = FontFamily.SansSerif
                ),
                modifier = Modifier.padding(vertical = 25.dp).padding(start = 10.dp),
                textAlign = TextAlign.Center
            )

            Text(
                text = "Card Displayed",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 2.sp,
                    fontFamily = FontFamily.SansSerif
                ),
                modifier = Modifier.padding(vertical = 25.dp).padding(start = 10.dp),
                textAlign = TextAlign.Center
            )



        }






    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun DefaultContent() {
    var scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val LazyListState  = rememberLazyListState()
    LazyColumn(modifier = Modifier.fillMaxSize().background(Color.White)) {

        stickyHeader {
            val filterCards = listOf(
                CardData(image = R.drawable.img, text = "Filters"),
                CardData(image = R.drawable.img, text = "Flash Sale"),
                CardData(image = R.drawable.img, text = "Under 30 mins"),
                CardData(image = R.drawable.img, text = "Rating 4.0+"),
                CardData(image = R.drawable.img, text = "Schedule")
            )
            LazyRow(modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                contentPadding = PaddingValues(horizontal = 6.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp),

                ) {
                items(filterCards) { card ->
                    DemoCard(image = card.image, text = card.text)
                }
            }
        }


        item {
            Text(
                text = "RECOMMENDED FOR YOU",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 2.sp,
                    fontFamily = FontFamily.SansSerif
                ),
                modifier = Modifier.padding(vertical = 16.dp).padding(start = 10.dp),
                textAlign = TextAlign.Center
            )
        }
        stickyHeader {
            //  categoryCard()
            val ListofCardDetailsFood = listOf<categorycard>(
                categorycard(
                    foodimagebackground1 = R.drawable.pizza1,
                    textblackone1 = "60% OFF up to ₹120",
                    cardtextname1 = "Rominus Pizz..",
                    timingtext1 = "10 mins",
                    timerimage1 = R.drawable.timer10,
                    foodimagebackground2 = R.drawable.pizza5,
                    textblackone2 = "50% OFF up to ₹100",
                    cardtextname2 = "Dominozz Pizz..",
                    timingtext2 = "30 mins",
                    timerimage2 = R.drawable.timer60
                ),
                categorycard(
                    foodimagebackground1 = R.drawable.pizza2,
                    textblackone1 = "FLAT 60% OFF",
                    cardtextname1 = "Burger villa..",
                    timingtext1 = "60 mins",
                    timerimage1 = R.drawable.timer60,
                    foodimagebackground2 = R.drawable.pizza1,
                    textblackone2 = "Flat ₹120",
                    cardtextname2 = "Piza Hut..",
                    timingtext2 = "30 mins",
                    timerimage2 = R.drawable.timer60
                ),
                categorycard(
                    foodimagebackground1 = R.drawable.pizza3,
                    textblackone1 = "Get items @₹50 only",
                    cardtextname1 = "Dominozz Pizz..",
                    timingtext1 = "30 mins",
                    timerimage1 = R.drawable.timer30,
                    foodimagebackground2 = R.drawable.pizza2,
                    textblackone2 = "FLAT 60% OFF",
                    cardtextname2 = "Burger villa..",
                    timingtext2 = "30 mins",
                    timerimage2 = R.drawable.timer60
                ),
                categorycard(
                    foodimagebackground1 = R.drawable.pizza4,
                    textblackone1 = "60% OFF up to ₹120",
                    cardtextname1 = "Piza Hut..",
                    timingtext1 = "80 mins",
                    timerimage1 = R.drawable.timerred,
                    foodimagebackground2 = R.drawable.pizza3,
                    textblackone2 = "Flat ₹120 OF",
                    cardtextname2 = "Pizza Lariya..",
                    timingtext2 = "30 mins",
                    timerimage2 = R.drawable.timer60
                ),
                categorycard(
                    foodimagebackground1 = R.drawable.pizza5,
                    textblackone1 = "60% OFF up to ₹120",
                    cardtextname1 = "Pizza Virus..",
                    timingtext1 = "90 mins",
                    timerimage1 = R.drawable.timer90,
                    foodimagebackground2 = R.drawable.pizza4,
                    textblackone2 = "Flat ₹120",
                    cardtextname2 = "Pizza Lariya..",
                    timingtext2 = "30 mins",
                    timerimage2 = R.drawable.timer60
                ),
                categorycard(
                    foodimagebackground1 = R.drawable.pizza1,
                    textblackone1 = "60% OFF up to ₹120",
                    cardtextname1 = "Burger King..",
                    timingtext1 = "60 mins",
                    timerimage1 = R.drawable.timer60,
                    foodimagebackground2 = R.drawable.pizza5,
                    textblackone2 = "Flat ₹120",
                    cardtextname2 = "Pizza Virus..",
                    timingtext2 = "30 mins",
                    timerimage2 = R.drawable.timer60
                )
            )


            LazyRow(
                contentPadding = PaddingValues(horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                state = LazyListState
            ) {
                items(ListofCardDetailsFood) { items ->
                    categoryCard(
                        foodimagebackground1 = items.foodimagebackground1,
                        textblackone1 = items.textblackone1,
                        cardtextname1 = items.cardtextname1,
                        timingtext1 = items.timingtext1,
                        timerimage1 = items.timerimage1,
                        foodimagebackground2 = items.foodimagebackground2,
                        textblackone2 = items.textblackone2,
                        cardtextname2 = items.cardtextname2,
                        timingtext2 = items.timingtext2,
                        timerimage2 = items.timerimage2
                    )

                }

            }
        }

        item{
            Text(
                text = "ALL RESTAURANTS",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 2.sp,
                    fontFamily = FontFamily.SansSerif
                ),
                modifier = Modifier.padding(vertical = 25.dp).padding(start = 10.dp),
                textAlign = TextAlign.Center
            )
        }


        item{
            Text(
                text = "Card Displayed",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 2.sp,
                    fontFamily = FontFamily.SansSerif
                ),
                modifier = Modifier.padding(vertical = 25.dp).padding(start = 10.dp),
                textAlign = TextAlign.Center
            )

            Text(
                text = "Card Displayed",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 2.sp,
                    fontFamily = FontFamily.SansSerif
                ),
                modifier = Modifier.padding(vertical = 25.dp).padding(start = 10.dp),
                textAlign = TextAlign.Center
            )

            Text(
                text = "Card Displayed",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 2.sp,
                    fontFamily = FontFamily.SansSerif
                ),
                modifier = Modifier.padding(vertical = 25.dp).padding(start = 10.dp),
                textAlign = TextAlign.Center
            )

            Text(
                text = "Card Displayed",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 2.sp,
                    fontFamily = FontFamily.SansSerif
                ),
                modifier = Modifier.padding(vertical = 25.dp).padding(start = 10.dp),
                textAlign = TextAlign.Center
            )
            Text(
                text = "Card Displayed",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 2.sp,
                    fontFamily = FontFamily.SansSerif
                ),
                modifier = Modifier.padding(vertical = 25.dp).padding(start = 10.dp),
                textAlign = TextAlign.Center
            )
            Text(
                text = "Card Displayed",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 2.sp,
                    fontFamily = FontFamily.SansSerif
                ),
                modifier = Modifier.padding(vertical = 25.dp).padding(start = 10.dp),
                textAlign = TextAlign.Center
            )

            Text(
                text = "Card Displayed",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 2.sp,
                    fontFamily = FontFamily.SansSerif
                ),
                modifier = Modifier.padding(vertical = 25.dp).padding(start = 10.dp),
                textAlign = TextAlign.Center
            )



        }






    }
}


@Composable
fun categoryCard(foodimagebackground1: Int,textblackone1: String,cardtextname1: String,timingtext1: String,timerimage1:Int,foodimagebackground2: Int,textblackone2: String,cardtextname2: String,timingtext2: String,timerimage2:Int){
    Column {
        Card (modifier = Modifier.width(120.dp).height(90.dp).padding(start = 3.dp),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)){

            Box(
                modifier = Modifier.fillMaxSize()
            ){
                Image(painter = painterResource(id = foodimagebackground1)
                    , contentDescription = "Burger",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Text(text = textblackone1,
                    modifier = Modifier.align(Alignment.BottomStart).padding(bottom = 8.dp).background(Color.Black.copy(alpha = 0.80f)),
                    color = Color.White,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold)
                Icon(painter = painterResource(R.drawable.bookmark1), contentDescription = "bookmark",
                    modifier = Modifier.size(30.dp).align(Alignment.TopEnd).padding(8.dp),
                    tint = Color.White
                )
            }
        }
        Column {
            Text(text = cardtextname1,
                modifier = Modifier.padding(start = 10.dp),
                fontSize = 14.sp,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold)
            Row (modifier = Modifier.padding(start = 8.dp)){
                Icon(painter = painterResource(id = timerimage1), contentDescription = "timer",
                    modifier = Modifier.size(20.dp),
                    tint = Color.Unspecified)
                Text(text = timingtext1,
                    fontSize = 12.sp,
                    color = Color.LightGray,
                )
            }

        }

       Spacer(modifier = Modifier.height(14.dp))
        Card (modifier = Modifier.width(120.dp).height(90.dp).padding(start = 3.dp),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)){
            Box(
                modifier = Modifier.fillMaxSize()
            ){
                Image(painter = painterResource(id = foodimagebackground2)
                    , contentDescription = "Burger",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Text(text = textblackone2,
                    modifier = Modifier.align(Alignment.BottomStart).padding(bottom = 8.dp).background(Color.Black.copy(alpha = 0.80f)),
                    color = Color.White,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold)
                Icon(painter = painterResource(R.drawable.bookmark1), contentDescription = "bookmark",
                    modifier = Modifier.size(30.dp).align(Alignment.TopEnd).padding(8.dp),
                    tint = Color.White
                )
            }
        }
        Column {
            Text(text = cardtextname2,
                modifier = Modifier.padding(start = 10.dp),
                fontSize = 14.sp,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold)
            Row (modifier = Modifier.padding(start = 8.dp)){
                Icon(painter = painterResource(id = timerimage2), contentDescription = "timer",
                    modifier = Modifier.size(20.dp),
                    tint = Color.Unspecified)
                Text(text = timingtext2,
                    fontSize = 12.sp,
                    color = Color.LightGray,
                )
            }

        }
    }

}




