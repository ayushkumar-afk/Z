package com.example.loginzomato.ui.theme

import android.provider.MediaStore
import android.view.View
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginzomato.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun categoriescreen(modifier: Modifier) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    searchbar()
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "icon arrow back",
                        modifier = Modifier.padding(end = 12.dp)
                    )
                }
            )
        }
    ) { padding ->
        var ListOfFoodCatergories = mutableListOf<imageSection>()

        ListOfFoodCatergories.add(imageSection(
            image = R.drawable.rolsss,
            text = "Rolls"
        ))
        ListOfFoodCatergories.add(imageSection(
            image = R.drawable.icecream,
            text = "Icecream"
        ))
        ListOfFoodCatergories.add(imageSection(
            image = R.drawable.thali,
            text = "Thali"
        ))
        ListOfFoodCatergories.add(imageSection(
            image = R.drawable.icecream,
            text = "Icecream"
        ))

        ListOfFoodCatergories.add(imageSection(
            image = R.drawable.icecream,
            text = "Icecream"
        ))
        ListOfFoodCatergories.add(imageSection(
            image = R.drawable.thali,
            text = "Thali"
        ))

        var (SelectedOption)= remember { mutableStateOf(ListOfFoodCatergories[0]) }

        // Use the padding in your LazyRow or content
        LazyRow(modifier = Modifier.padding(padding)) {
            // Add your items here
            itemsIndexed(ListOfFoodCatergories) {index,items->
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.clickable{SelectedOption = items}) {

                    demoImage(
                        imageresourse = items.image,
                        demoText = items.text,
                        )
//                    if(SelectedOption.text ==items.text) {
//                        HorizontalDivider(
//                            thickness = 2.dp,
//                            modifier = Modifier
//                                .width(30.dp)
//                                .padding(top = 4.dp),
//                            color = Color.Red
//                        )
//                    }

                }


            }

        }

    }
}

@Composable
fun searchbar() {
    var searchvalue by remember { mutableStateOf("") }
    OutlinedTextField(
        value = searchvalue,
        onValueChange = { searchvalue = it },
        placeholder = {
            Text(
                text = "Restaurant name or a dish",
                fontSize = 15.sp,
                color = Color.LightGray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth()
            )

        },
        leadingIcon = {


            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Icons Search",
                tint = Color.Red

            )
        },
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color.LightGray,
            focusedBorderColor = Color.Gray
        ),
        modifier = Modifier
            .height(45.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),

        trailingIcon = {


            Row(verticalAlignment = Alignment.CenterVertically) {
                VerticalDivider(
                    thickness = 1.dp,
                    modifier = Modifier.height(23.dp).padding(top = 2.dp, end = 10.dp),
                    color = Color.LightGray.copy(alpha = 0.60f),

                    )
                Icon(painter = painterResource(R.drawable.mic),
                    contentDescription = "mci",
                    modifier = Modifier.size(14.dp),
                    tint = Color.Red)
            }

        }
    )
}

@Composable
fun demoImage(imageresourse: Int, demoText : String){
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = imageresourse),
            contentDescription = "DemoImage",
            modifier = Modifier.padding(end = 5.dp, start = 5.dp, top = 10.dp).size(65.dp)

            )

        Text(
            text = demoText,
            fontSize = 10.sp,
            color = Color.Gray,
            fontWeight = FontWeight.SemiBold
        )





    }


}


data class imageSection(
    val image : Int,
    val text:String
)