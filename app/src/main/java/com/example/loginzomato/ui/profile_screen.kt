package com.example.loginzomato.ui

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorProducer
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginzomato.R
import com.example.loginzomato.ui.Carditem.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun profile_screen_ui(modifier: Modifier){

    Scaffold(modifier = Modifier.fillMaxWidth(),
        topBar = {
            TopAppBar(
               title = {},
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "ArrowBack")
                    }
                },



            )
        }



    ) {values->
    Column(modifier = Modifier.fillMaxWidth().padding(values)) {
        Card (modifier = Modifier.fillMaxWidth().height(110.dp).padding(start = 10.dp, end = 10.dp),shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp, bottomStart = 0.dp, bottomEnd = 0.dp),
            colors = CardDefaults.cardColors(Color.White)){
            Column (modifier = Modifier.padding(top = 15.dp, start = 7.dp, bottom = 5.dp)){
                Row (){
                    Icon(
                        modifier= Modifier.size(80.dp).clip(CircleShape)  ,painter = painterResource(id = R.drawable.profielogo),
                        contentDescription = "Profile Image",
                        tint = Color.Unspecified
                    )
                    Spacer(modifier = Modifier.width(7.dp))
                    Column {
                        Text(
                            text = "Ayush",
                            fontWeight = FontWeight.Bold,
                            fontSize = 23.sp
                        )
                        Text(
                            text = "amankumar9235959545@gmail.com",
                            fontSize = 12.sp
                        )
                        Row {
                            Text(
                                text = "View activity ",   // > THIS ARROW ONE TO ADD
                                fontSize = 13.sp,
                                color = colorResource(id = R.color.ViewActivityClickableColor)
                            )
                            Icon(imageVector = Icons.Default.PlayArrow, contentDescription = "Forward Arrow",
                                modifier = Modifier.size(height = 20.dp, width = 15.dp).padding(start = 0.dp, top = 5.dp, end = 5.dp))

                        }

                    }
                }
            }


        }
        //Here will be the lazy Column

        zomato_Gold()
      //  coulum_grid()
        lazycoloumm()
    }

    }
}


@Composable
fun zomato_Gold(){

    Card(colors = CardDefaults.cardColors(containerColor = Color.Black),
        modifier=Modifier.fillMaxWidth().padding(start = 10.dp,end = 10.dp).height(65.dp),shape = RoundedCornerShape(bottomEnd = 12.dp, bottomStart = 12.dp, topEnd = 0.dp, topStart = 0.dp)
    ){
        Column (modifier = Modifier.padding(10.dp)
           ){
            Row(modifier=Modifier.fillMaxWidth().padding(top=6.dp),
                verticalAlignment = Alignment.CenterVertically,
               ) {
                Icon(painter = painterResource(id = R.drawable.goldicon1),
                    contentDescription = "Zomato gold Image",
                    tint = Color.Unspecified,


                    //Adding the image of the Icon Zomato Gold
                )


                Text(text = "Join Zomato Gold",
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.ZomatoGold),
                    modifier = Modifier.padding(start = 10.dp, end = 120.dp),


                )

                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "Arrow right",
                    tint = Color.White
                    )
            }
        }




    }

}

@Composable
fun coulum_grid(card:ColoumnGrid) {
    Card(modifier = Modifier.padding(bottom = 7.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(R.color.offwhitebackgorund))) {


        Row {
            Card(
                modifier = Modifier.size(height = 110.dp, width = 170.dp)
                    .padding(start = 10.dp, top = 10.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column() {
                    Icon(
                        painter = painterResource(R.drawable.bookmark1),
                        contentDescription = "bookmark",
                        tint = Color.LightGray,
                        modifier = Modifier.padding(start = 20.dp, top = 15.dp, bottom = 5.dp)
                            .size(25.dp),
                    )
                    Text(
                        text = "Collections",
                        fontSize = 15.sp,
                        modifier = Modifier.padding(start = 20.dp, top = 10.dp),
                        fontWeight = FontWeight.SemiBold
                    )
                }

            }
            Card(
                modifier = Modifier.size(height = 110.dp, width = 190.dp)
                    .padding(start = 10.dp, top = 10.dp, end = 10.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column() {
                    Icon(
                        painter = painterResource(R.drawable.rupeesymbol),
                        contentDescription = "Money",
                        tint = Color.LightGray,
                        modifier = Modifier.padding(start = 20.dp, top = 15.dp, bottom = 5.dp)
                            .size(30.dp)
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    )
                    {
                        Text(
                            text = "Money",
                            fontSize = 15.sp,
                            modifier = Modifier.padding(start = 20.dp, top = 10.dp, end = 3.dp)
                                .alignByBaseline(),
                            fontWeight = FontWeight.SemiBold
                        )

                        Card(
                            modifier = Modifier.size(width = 35.dp, height = 20.dp)
                                .alignByBaseline(),
                            colors = CardDefaults.cardColors(
                                containerColor = colorResource(R.color.greenlight),
                            )

                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Start
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.img),
                                    contentDescription = "rupess sysmbol",
                                    tint = colorResource(R.color.ViewActivityClickableColor),
                                    modifier = Modifier.size(15.dp)
                                )
                                Text(
                                    text = "O",
                                    color = colorResource(R.color.ViewActivityClickableColor),
                                    fontSize = 12.sp
                                )

                            }

                        }
                    }

                }

            }
        }
    }
}

@Composable
fun lazycoloumm(){
        val cardlist = listOf(
            ColoumnGrid(name = "AYush"),
            FirstCard( Profilename = "Your Profile", percentagetext = "48%Completed"),
            SecondCard( vegtext = "Veg Mode"),
            ThirdCard(Apprearnece = "Appearance"),
            FouthCard(rating = "Your rating"),
            FifthCard(
                Food_Order = "Food Orders"
            ),
            SixethCard(Titilename = "Dining and Experience"),
            SeventhCard(titile = "done"),
            eightcard(Title = "done"),
            ninthCard(Title = "done"),
            tenthcard(Title = "done"),
            eleventhcard(Title = "eleventhdone")

    )

         LazyColumn {
        items(cardlist){item->
            when(item){
                is ColoumnGrid->coulum_grid(item)
                is FirstCard-> firstCard(item)
                is SecondCard -> seoncdcard(item)
                is ThirdCard -> thirdcard(item)
                is FouthCard -> fourthcard(item)
                is FifthCard -> fifthcard(item)
                is SixethCard-> sixthcard(item)
                is SeventhCard-> seventhcard(item)
                is eightcard-> eigthcard(item)
                is ninthCard-> ninthcard(item)
                is tenthcard-> tenthcardd(item)
                is eleventhcard -> eleventhcardd(item)

            }

        }
         }

}

@Composable
fun firstCard(card: FirstCard){
    Card(modifier = Modifier.padding(start = 10.dp,top =13.dp, end = 10.dp).fillMaxWidth().height(50.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Your Profile", modifier = Modifier.padding( start =5.dp, top = 10.dp , end = 5.dp).size(25.dp),
                tint = Color.LightGray)

            Text(text = "Your Porfile",modifier = Modifier.padding(start =5.dp, top = 10.dp ,end = 35.dp))
            Text(text = "48% Completed",modifier = Modifier.clip(shape = RoundedCornerShape(12.dp)).padding(start =5.dp, top = 10.dp ,end = 5.dp).background(color = colorResource(R.color.completedpercentageback)),
                color = colorResource(R.color.percentage), fontWeight = FontWeight.SemiBold, fontSize = 15.sp
                )
            Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                modifier = Modifier.padding(start =5.dp, top = 10.dp ),
                tint = Color.DarkGray)
        }


    }
}
@Composable
fun seoncdcard(card: SecondCard){
    var  switch1 by remember { mutableStateOf(false) }
    Card(modifier = Modifier.padding(start = 10.dp,top =13.dp, end = 10.dp).fillMaxWidth().height(50.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically) {
            Icon(painter = painterResource(R.drawable.vegicon), contentDescription = "Your Profile", modifier = Modifier.padding( start =5.dp, top = 10.dp , end = 5.dp).size(25.dp),
                tint = colorResource(R.color.greendivider))

            Text(text = "Veg Mode",modifier = Modifier.padding(start =5.dp, top = 10.dp ,end = 150.dp))
            //Toggle Button for the veg mode
            Switch(checked = switch1,
                onCheckedChange = {switch1 = it} ,
                colors = SwitchDefaults.colors(checkedIconColor = Color.Green),
                modifier = Modifier.size(30.dp).padding(top = 15.dp))

        }


    }
}
@Composable
fun thirdcard(card: ThirdCard){
    Card(modifier = Modifier.padding(start = 10.dp,top =13.dp, end = 10.dp).fillMaxWidth().height(50.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically) {
            //Appracece one icon need to bee added donwload
            Icon(painter = painterResource(R.drawable.paint), contentDescription = "Your Profile", modifier = Modifier.padding( start =5.dp, top = 10.dp , end = 5.dp).size(21.dp),
                tint = Color.LightGray)

            Text(text = "Appearance",modifier = Modifier.padding(start =5.dp, top = 10.dp ,end = 105.dp))
            Text(text = "LIGHT",modifier = Modifier.padding(start =5.dp, top = 10.dp ,end = 5.dp),
                color = Color.Gray,
            )
            Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                modifier = Modifier.padding(start =5.dp, top = 10.dp ),
                tint = Color.Gray)
        }


    }
}
@Composable
fun fourthcard(card: FouthCard){

    Card(modifier = Modifier.padding(start = 10.dp,top =13.dp, end = 10.dp).fillMaxWidth().height(50.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically) {
            //Rating icon need to bee added donwload
            Icon(painter = painterResource(R.drawable.rating), contentDescription = "Your Profile", modifier = Modifier.padding( start =5.dp, top = 10.dp , end = 5.dp).size(25.dp),
                tint = Color.LightGray)

            Text(text = "Your rating",modifier = Modifier.padding(start =5.dp, top = 10.dp ,end = 160.dp))
            Icon(painter = painterResource(R.drawable.startrating), contentDescription = "star rating", modifier = Modifier.padding(end = 5.dp, top = 6.dp).size(40.dp),
                tint = Color.Unspecified)

        }


    }
}

@Composable
fun fifthcard(card: FifthCard){

    Card(modifier = Modifier.padding(start = 10.dp,top =13.dp, end = 10.dp).fillMaxWidth().height(400.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {
            Row {
                VerticalDivider(
                    thickness = 3.dp,
                    modifier = Modifier.height(34.dp).padding(top = 12.dp).clip(shape = RoundedCornerShape(10.dp)),
                    color = colorResource(R.color.greendivider)
                )
                Text(text = "Food orders",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp,top = 10.dp))
            }

            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                //Rating icon need to bee added donwload
                Icon(painter = painterResource(R.drawable.order), contentDescription = "Your orders", modifier = Modifier.padding( start =5.dp, top = 10.dp , end = 5.dp).size(25.dp),
                    tint = Color.LightGray)

                Text(text = "Your orders",modifier = Modifier.padding(start =5.dp, top = 10.dp).weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    modifier = Modifier.padding(start =5.dp, top = 10.dp ),
                    tint = Color.Gray)



            }
            HorizontalDivider(thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp, top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                //Rating icon need to bee added donwload
                Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = "Your Profile", modifier = Modifier.padding( start =5.dp, top = 10.dp , end = 5.dp).size(25.dp),
                    tint = Color.LightGray)

                Text(text = "Favorite orders",modifier = Modifier.padding(start =5.dp, top = 10.dp ).weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    modifier = Modifier.padding(start =5.dp, top = 10.dp ),
                    tint = Color.Gray)


            }
            HorizontalDivider(thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp, top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                //Rating icon need to bee added donwload
                Icon(painter = painterResource(R.drawable.thumbs), contentDescription = "Your Profile", modifier = Modifier.padding( start =5.dp, top = 10.dp , end = 5.dp).size(25.dp),
                    tint = Color.LightGray)

                Text(text = "Manage recommendations",modifier = Modifier.padding(start =5.dp, top = 10.dp).weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    modifier = Modifier.padding(start =5.dp, top = 10.dp ),
                    tint = Color.Gray)


            }
            HorizontalDivider(thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp, top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                //Rating icon need to bee added donwload
                Icon(painter = painterResource(R.drawable.train), contentDescription = "Your Profile", modifier = Modifier.padding( start =5.dp, top = 10.dp , end = 5.dp).size(25.dp),
                    tint = Color.LightGray)

                Text(text = "Order on train",modifier = Modifier.padding(start =5.dp, top = 10.dp ).weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    modifier = Modifier.padding(start =5.dp, top = 10.dp ),
                    tint = Color.Gray)


            }
            HorizontalDivider(thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp, top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                //Rating icon need to bee added donwload
                Icon(painter = painterResource(R.drawable.addressbook), contentDescription = "Your Profile", modifier = Modifier.padding( start =5.dp, top = 10.dp , end = 5.dp).size(25.dp),
                    tint = Color.LightGray)

                Text(text = "Address book",modifier = Modifier.padding(start =5.dp, top = 10.dp).weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    modifier = Modifier.padding(start =5.dp, top = 10.dp ),
                    tint = Color.Gray)


            }
            HorizontalDivider(thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp, top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                //Rating icon need to bee added donwload
                Icon(painter = painterResource(R.drawable.hiddden), contentDescription = "Your Profile", modifier = Modifier.padding( start =5.dp, top = 10.dp , end = 5.dp).size(25.dp),
                    tint = Color.LightGray)

                Text(text = "Hidden Restaurants",modifier = Modifier.padding(start =5.dp, top = 10.dp).weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    modifier = Modifier.padding(start =5.dp, top = 10.dp ),
                    tint = Color.Gray)


            }
            HorizontalDivider(thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp, top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                //Rating icon need to bee added donwload
                Icon(painter = painterResource(R.drawable.message), contentDescription = "Your Profile", modifier = Modifier.padding( start =5.dp, top = 10.dp , end = 5.dp).size(25.dp),
                    tint = Color.LightGray)

                Text(text = "Online ordering help",modifier = Modifier.padding(start =5.dp, top = 10.dp ).weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    modifier = Modifier.padding(start =5.dp, top = 10.dp ),
                    tint = Color.Gray)


            }



        }



    }
}
@Composable
fun sixthcard(card: SixethCard){

    Card(modifier = Modifier.padding(start = 10.dp,top =13.dp, end = 10.dp).fillMaxWidth().height(350.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {

            Row {
                VerticalDivider(
                    thickness = 3.dp,
                    modifier = Modifier.height(34.dp).padding(top = 12.dp).clip(shape = RoundedCornerShape(10.dp)),
                    color = colorResource(R.color.greendivider)
                )
                Text(text = "Dining and Experiences",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp,top = 10.dp))
            }


            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                //Rating icon need to bee added donwload
                Icon(painter = painterResource(R.drawable.hiddden), contentDescription = "Your orders", modifier = Modifier.padding( start =5.dp, top = 10.dp , end = 5.dp).size(25.dp),
                    tint = Color.LightGray)

                Text(text = "Your dining transactions",modifier = Modifier.padding(start =5.dp, top = 10.dp).weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    modifier = Modifier.padding(start =5.dp, top = 10.dp ),
                    tint = Color.Gray)



            }
            HorizontalDivider(thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp, top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                //Rating icon need to bee added donwload
                Icon(painter = painterResource(R.drawable.gift), contentDescription = "Your Profile", modifier = Modifier.padding( start =5.dp, top = 10.dp , end = 5.dp).size(25.dp),
                    tint = Color.LightGray)

                Text(text = "Your dining rewards",modifier = Modifier.padding(start =5.dp, top = 10.dp ).weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    modifier = Modifier.padding(start =5.dp, top = 10.dp ),
                    tint = Color.Gray)


            }
            HorizontalDivider(thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp, top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                //Rating icon need to bee added donwload
                Icon( painter = painterResource(R.drawable.dining), contentDescription = "Your Profile", modifier = Modifier.padding( start =5.dp, top = 10.dp , end = 5.dp).size(25.dp),
                    tint = Color.LightGray)

                Text(text = "Your bookings",modifier = Modifier.padding(start =5.dp, top = 10.dp).weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    modifier = Modifier.padding(start =5.dp, top = 10.dp ),
                    tint = Color.Gray)


            }
            HorizontalDivider(thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp, top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                //Rating icon need to bee added donwload
                Icon(painter = painterResource(R.drawable.message), contentDescription = "Your Profile", modifier = Modifier.padding( start =5.dp, top = 10.dp , end = 5.dp).size(25.dp),
                    tint = Color.LightGray)

                Text(text = "Dining help",modifier = Modifier.padding(start =5.dp, top = 10.dp ).weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    modifier = Modifier.padding(start =5.dp, top = 10.dp ),
                    tint = Color.Gray)


            }
            HorizontalDivider(thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp, top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                //Rating icon need to bee added donwload
                Icon(imageVector = Icons.Default.Settings, contentDescription = "Your Profile", modifier = Modifier.padding( start =5.dp, top = 10.dp , end = 5.dp).size(25.dp),
                    tint = Color.LightGray)

                Text(text = "Dining settings",modifier = Modifier.padding(start =5.dp, top = 10.dp).weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    modifier = Modifier.padding(start =5.dp, top = 10.dp ),
                    tint = Color.Gray)


            }
            HorizontalDivider(thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp, top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                //Rating icon need to bee added donwload
                Icon(imageVector = Icons.Default.Info, contentDescription = "Your Profile", modifier = Modifier.padding( start =5.dp, top = 10.dp , end = 5.dp).size(25.dp),
                    tint = Color.LightGray)

                Text(text = "Frequently asked questions",modifier = Modifier.padding(start =5.dp, top = 10.dp).weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    modifier = Modifier.padding(start =5.dp, top = 10.dp ),
                    tint = Color.Gray)


            }




        }



    }
}
@Composable
fun seventhcard(card: SeventhCard){

    Card(modifier = Modifier.padding(start = 10.dp,top =13.dp, end = 10.dp).fillMaxWidth().height(120.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {

            Row {
                VerticalDivider(
                    thickness = 3.dp,
                    modifier = Modifier.height(34.dp).padding(top = 12.dp).clip(shape = RoundedCornerShape(10.dp)),
                    color = colorResource(R.color.greendivider)
                )
                Text(text = "Feeding India",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp,top = 10.dp))
            }


            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                //Rating icon need to bee added donwload
                Icon(painter = painterResource(R.drawable.impact), contentDescription = "Your orders", modifier = Modifier.padding( start =5.dp, top = 10.dp , end = 5.dp).size(25.dp),
                    tint = Color.LightGray)

                Text(text = "Your impact",modifier = Modifier.padding(start =5.dp, top = 10.dp).weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    modifier = Modifier.padding(start =5.dp, top = 10.dp ),
                    tint = Color.Gray)



            }
            HorizontalDivider(thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp, top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                //Rating icon need to bee added donwload
                Icon(painter = painterResource(R.drawable.reciept), contentDescription = "Your orders", modifier = Modifier.padding( start =5.dp, top = 10.dp , end = 5.dp).size(25.dp),
                    tint = Color.LightGray)

                Text(text = "Get Feeding India receipt",modifier = Modifier.padding(start =5.dp, top = 10.dp).weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    modifier = Modifier.padding(start =5.dp, top = 10.dp ),
                    tint = Color.Gray)



            }


        }



    }
}
@Composable
fun eigthcard(card: eightcard){

    Card(modifier = Modifier.padding(start = 10.dp,top =13.dp, end = 10.dp).fillMaxWidth().height(310.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {
            Row {
                VerticalDivider(
                    thickness = 3.dp,
                    modifier = Modifier.height(34.dp).padding(top = 12.dp).clip(shape = RoundedCornerShape(10.dp)),
                    color = colorResource(R.color.greendivider)
                )
                Text(text = "Money",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp,top = 10.dp))
            }

            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                //Rating icon need to bee added donwload
                Icon(painter = painterResource(R.drawable.rupeesymbol), contentDescription = "Your orders", modifier = Modifier.padding( start =5.dp, top = 10.dp , end = 5.dp).size(25.dp),
                    tint = Color.LightGray)

                Text(text = "Zomato Money",modifier = Modifier.padding(start =5.dp, top = 10.dp).weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    modifier = Modifier.padding(start =5.dp, top = 10.dp ),
                    tint = Color.Gray)



            }
            HorizontalDivider(thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp, top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                //Rating icon need to bee added donwload
                Icon(painter = painterResource(R.drawable.giftcard), contentDescription = "Your Profile", modifier = Modifier.padding( start =5.dp, top = 10.dp , end = 5.dp).size(25.dp),
                    tint = Color.LightGray)

                Text(text = "Buy Gift Card",modifier = Modifier.padding(start =5.dp, top = 10.dp ).weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    modifier = Modifier.padding(start =5.dp, top = 10.dp ),
                    tint = Color.Gray)


            }
            HorizontalDivider(thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp, top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                //Rating icon need to bee added donwload
                Icon(painter = painterResource(R.drawable.claimgiftcard), contentDescription = "Your Profile", modifier = Modifier.padding( start =5.dp, top = 10.dp , end = 5.dp).size(25.dp),
                    tint = Color.LightGray)

                Text(text = "Claim Gift Card",modifier = Modifier.padding(start =5.dp, top = 10.dp).weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    modifier = Modifier.padding(start =5.dp, top = 10.dp ),
                    tint = Color.Gray)


            }
            HorizontalDivider(thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp, top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                //Rating icon need to bee added donwload
                Icon(painter = painterResource(R.drawable.z), contentDescription = "Your Profile", modifier = Modifier.padding( start =5.dp, top = 10.dp , end = 5.dp).size(25.dp),
                    tint = Color.LightGray)

                Text(text = "Zomato Credits",modifier = Modifier.padding(start =5.dp, top = 10.dp ).weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    modifier = Modifier.padding(start =5.dp, top = 10.dp ),
                    tint = Color.Gray)


            }
            HorizontalDivider(thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp, top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                //Rating icon need to bee added donwload
                Icon(painter = painterResource(R.drawable.payment), contentDescription = "Your Profile", modifier = Modifier.padding( start =5.dp, top = 10.dp , end = 5.dp).size(25.dp),
                    tint = Color.LightGray)

                Text(text = "Payment settings",modifier = Modifier.padding(start =5.dp, top = 10.dp).weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    modifier = Modifier.padding(start =5.dp, top = 10.dp ),
                    tint = Color.Gray)


            }




        }



    }
}
@Composable
fun ninthcard(card: ninthCard){

    Card(modifier = Modifier.padding(start = 10.dp,top =13.dp, end = 10.dp).fillMaxWidth().height(120.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {

            Row {
                VerticalDivider(
                    thickness = 3.dp,
                    modifier = Modifier.height(34.dp).padding(top = 12.dp).clip(shape = RoundedCornerShape(10.dp)),
                    color = colorResource(R.color.greendivider)
                )
                Text(text = "Zomato For Enterprise",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp,top = 10.dp))
            }


            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                //Rating icon need to bee added donwload
                Icon(painter = painterResource(R.drawable.building), contentDescription = "Your orders", modifier = Modifier.padding( start =5.dp, top = 10.dp , end = 5.dp).size(25.dp),
                    tint = Color.LightGray)

                Text(text = "For employes",modifier = Modifier.padding(start =5.dp, top = 10.dp).weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    modifier = Modifier.padding(start =5.dp, top = 10.dp ),
                    tint = Color.Gray)



            }
            HorizontalDivider(thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp, top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                //Rating icon need to bee added donwload
                Icon(painter = painterResource(R.drawable.empcard), contentDescription = "Your orders", modifier = Modifier.padding( start =5.dp, top = 10.dp , end = 5.dp).size(25.dp),
                    tint = Color.LightGray)

                Text(text = "For employess",modifier = Modifier.padding(start =5.dp, top = 10.dp).weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    modifier = Modifier.padding(start =5.dp, top = 10.dp ),
                    tint = Color.Gray)



            }


        }



    }
}
@Composable
fun tenthcardd(card: tenthcard){

    Card(modifier = Modifier.padding(start = 10.dp,top =13.dp, end = 10.dp).fillMaxWidth().height(120.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {

            Row {
                VerticalDivider(
                    thickness = 3.dp,
                    modifier = Modifier.height(34.dp).padding(top = 12.dp).clip(shape = RoundedCornerShape(10.dp)),
                    color = colorResource(R.color.greendivider)
                )
                Text(text = "Coupons",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp,top = 10.dp))
            }


            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                //Rating icon need to bee added donwload
                Icon(painter = painterResource(R.drawable.coupons), contentDescription = "Your orders", modifier = Modifier.padding( start =5.dp, top = 10.dp , end = 5.dp).size(25.dp),
                    tint = Color.LightGray)

                Text(text = "Collected coupouns",modifier = Modifier.padding(start =5.dp, top = 10.dp).weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    modifier = Modifier.padding(start =5.dp, top = 10.dp ),
                    tint = Color.Gray)



            }
            HorizontalDivider(thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp, top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                //Rating icon need to bee added donwload
                Icon(painter = painterResource(R.drawable.coupons), contentDescription = "Your orders", modifier = Modifier.padding( start =5.dp, top = 10.dp , end = 5.dp).size(25.dp),
                    tint = Color.LightGray)

                Text(text = "Redeem Gold coupons",modifier = Modifier.padding(start =5.dp, top = 10.dp).weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    modifier = Modifier.padding(start =5.dp, top = 10.dp ),
                    tint = Color.Gray)



            }


        }



    }
}
@Composable
fun eleventhcardd (card: eleventhcard){

    Card(modifier = Modifier.padding(start = 10.dp,top =13.dp, end = 10.dp).fillMaxWidth().height(300.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {

            Row {
                VerticalDivider(
                    thickness = 3.dp,
                    modifier = Modifier.height(34.dp).padding(top = 12.dp).clip(shape = RoundedCornerShape(10.dp)),
                    color = colorResource(R.color.greendivider)
                )
                Text(text = "More",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp,top = 10.dp))
            }


            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                //Rating icon need to bee added donwload
                Icon(imageVector = Icons.Default.Info, contentDescription = "Your orders", modifier = Modifier.padding( start =5.dp, top = 10.dp , end = 5.dp).size(25.dp),
                    tint = Color.LightGray)

                Text(text = "About ",modifier = Modifier.padding(start =5.dp, top = 10.dp).weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    modifier = Modifier.padding(start =5.dp, top = 10.dp ),
                    tint = Color.Gray)



            }
            HorizontalDivider(thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp, top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                //Rating icon need to bee added donwload
                Icon(painter = painterResource(R.drawable.feedback), contentDescription = "Your Profile", modifier = Modifier.padding( start =5.dp, top = 10.dp , end = 5.dp).size(25.dp),
                    tint = Color.LightGray)

                Text(text = "Send feedback  ",modifier = Modifier.padding(start =5.dp, top = 10.dp ).weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    modifier = Modifier.padding(start =5.dp, top = 10.dp ),
                    tint = Color.Gray)


            }
            HorizontalDivider(thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp, top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                //Rating icon need to bee added donwload
                Icon(imageVector = Icons.Default.Info, contentDescription = "Your Profile", modifier = Modifier.padding( start =5.dp, top = 10.dp , end = 5.dp).size(25.dp),
                    tint = Color.LightGray)

                Text(text = "Report a safety emergency",modifier = Modifier.padding(start =5.dp, top = 10.dp).weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    modifier = Modifier.padding(start =5.dp, top = 10.dp ),
                    tint = Color.Gray)


            }
            HorizontalDivider(thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp, top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                //Rating icon need to bee added donwload
                Icon(imageVector = Icons.Default.Settings, contentDescription = "Your Profile", modifier = Modifier.padding( start =5.dp, top = 10.dp , end = 5.dp).size(25.dp),
                    tint = Color.LightGray)

                Text(text = "Settings",modifier = Modifier.padding(start =5.dp, top = 10.dp ).weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    modifier = Modifier.padding(start =5.dp, top = 10.dp ),
                    tint = Color.Gray)


            }
            HorizontalDivider(thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp, top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                //Rating icon need to bee added donwload
                Icon(painter = painterResource(R.drawable.logout), contentDescription = "Your Profile", modifier = Modifier.padding( start =5.dp, top = 10.dp , end = 5.dp).size(25.dp),
                    tint = Color.LightGray)

                Text(text = "Logout",modifier = Modifier.padding(start =5.dp, top = 10.dp).weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "forward arrow",
                    modifier = Modifier.padding(start =5.dp, top = 10.dp ),
                    tint = Color.Gray)


            }





        }



    }
}





sealed class Carditem {
    data class FirstCard(

        val Profilename: String,
        val percentagetext: String
    ): Carditem()
    data class ColoumnGrid(val name:String)
    data class SecondCard( val vegtext: String): Carditem()
    data class ThirdCard( val Apprearnece: String): Carditem()
    data class FouthCard(var rating:String)
    data class FifthCard(var Food_Order:String)
    data class SixethCard( var Titilename:String)
    data class SeventhCard(var titile:String)
    data class eightcard(var Title:String)
    data class ninthCard(var Title:String)
    data class tenthcard(var Title:String)
    data class eleventhcard(var Title:String)

}






















