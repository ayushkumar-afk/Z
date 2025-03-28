package com.example.loginzomato.ui

import android.widget.Toast
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginzomato.R

import org.intellij.lang.annotations.JdkConstants

@Composable
fun loginpage(modifier: Modifier){
    Column(){

        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.zomimg ),
                contentDescription = "BackgroudImage"
                , contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxWidth().height(350.dp).clip(RoundedCornerShape(0.dp))

            )

            Button(modifier = Modifier.align(Alignment.TopEnd).padding(top =48.dp, end = 25.dp).size(60.dp, 38.dp),
                contentPadding = PaddingValues(0.dp),
                //removers the Extra padding
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.SkipButtonColor)


                ),
                onClick = {}) {
                Text(text = "Skip",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.LightGray)
            }
        }
        Spacer(modifier = Modifier.padding(vertical = 15.dp))
        Text(
            text = "India's #1 Food Delivery",

            modifier = Modifier.fillMaxWidth()
            ,textAlign = TextAlign.Center,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineMedium



        )
   //     Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "and Dining App",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.fillMaxWidth()
            ,textAlign = TextAlign.Center,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold

        )
        Spacer(modifier = Modifier.padding(vertical = 13.dp))

        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically) {
            HorizontalDivider(thickness = 1.dp,
                modifier = Modifier.padding(start = 15.dp, end = 10.dp).fillMaxWidth(0.285f),
                color = Color.LightGray
            )
            Text(text = "Log in or Sign up",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray)

            HorizontalDivider(thickness = 1.dp,
                modifier = Modifier.padding(start = 10.dp, end = 15.dp).weight(1f),
                color = Color.LightGray
            )

        }
        Spacer(modifier = Modifier.padding(vertical = 5.dp))
        var valueemail by remember { mutableStateOf("") }
        var valuepass by remember { mutableStateOf("") }

        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(value = valueemail,
                onValueChange = {
                    valueemail = it
                },
                placeholder = {
                    Text(text = "Email",
                        color = Color.Gray)
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
                leadingIcon = {
                    Icon(imageVector = Icons.Outlined.Email,
                        contentDescription = "Emailicon",
                        tint = Color.Gray,
                        modifier = Modifier.size(20.dp))

                },
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = Color.LightGray, focusedBorderColor = Color.LightGray),
                shape = RoundedCornerShape(12.dp)

            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(value = valuepass,
                onValueChange = {
                    valuepass = it
                },
                placeholder = {
                    Text(text = "Password",
                        color = Color.Gray)
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                leadingIcon = {
                    Icon(imageVector = Icons.Outlined.Lock,
                        contentDescription = "PASSWORD ICON",
                        tint = Color.Gray)

                },
                visualTransformation = PasswordVisualTransformation(),
                colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color.LightGray, unfocusedBorderColor = Color.LightGray),
                shape = RoundedCornerShape(12.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.buttonColorred)

            ),
                onClick = {

                }
            ) {
                Text(text = "Login",
                    modifier= Modifier.padding(start = 100.dp, end = 100.dp),
                    fontSize = 16.sp,
                    letterSpacing = 1.sp
                    )

            }
            Row {
                Text(text = "Don't have an account?",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp)
                Text(text = "SignUp",
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(id = R.color.buttonColorred),
                    fontSize = 12.sp

                    )
            }
            Spacer(modifier = Modifier.height(25.dp))

            Text(text = "By continuing, you agree to our",

                fontSize = 12.sp
                )

val context = LocalContext.current
            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                Text(

                    text = "Terms of Services ",
                    fontSize = 12.sp,
                  textDecoration = TextDecoration.Underline,
                    modifier = Modifier.offset(y=(-6).dp)
                        .clickable {

                       Toast.makeText(context, "Terms and Conditions", Toast.LENGTH_SHORT).show()
                   }
                )

                Text(text = "Privacy Policy ",
                    fontSize = 12.sp,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.offset(y=(-6).dp)
                        .clickable {

                            Toast.makeText(context, "Privacy Policy", Toast.LENGTH_SHORT).show()
                        }
                )
                Text(text = "Content Policy ",
                    fontSize = 12.sp,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.offset(y=(-6).dp)
                        .clickable {

                            Toast.makeText(context, "Content Policy", Toast.LENGTH_SHORT).show()
                        }
                )


            }


        }







    }
    }



