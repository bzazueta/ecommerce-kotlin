package com.monosoft.ecommercebenja.presentation.screens.profile.info.components

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.monosoft.ecommercebenja.R
import com.monosoft.ecommercebenja.presentation.MainActivity
import com.monosoft.ecommercebenja.presentation.components.DefaultButton
import com.monosoft.ecommercebenja.presentation.components.DialogCapturePicture
import com.monosoft.ecommercebenja.presentation.components.DialogDeleteUser
import com.monosoft.ecommercebenja.presentation.navigation.Graph
import com.monosoft.ecommercebenja.presentation.navigation.screen.profile.ProfileScreen
import com.monosoft.ecommercebenja.presentation.navigation.screens.client.ClientProductScreen
import com.monosoft.ecommercebenja.presentation.screens.profile.info.ProfileViewModel
import com.monosoft.ecommercebenja.presentation.screens.profile.update.ProfileUpdateViewModel


@Composable
fun ProfileContent(paddingValues: PaddingValues, navController: NavHostController, vm: ProfileViewModel = hiltViewModel(), vmp: ProfileUpdateViewModel= hiltViewModel()) {
    val activity = LocalContext.current as? Activity

    val stateDialog = remember { mutableStateOf(false) }

    DialogDeleteUser(
        state = stateDialog,
        idUser = vm.user?.id!!,
        deleteUser = { vm.user?.id?.let { vm.deletUser(it) } },
        vm  = vm
    )

    Box(modifier = Modifier
        .padding(paddingValues)
        .padding(bottom = 70.dp)) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.profile_background),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(
                ColorMatrix().apply {
                    setToScale(0.6f, 0.6f, 0.6f, 1f)
                }
            )
        )

        Column(modifier = Modifier.fillMaxWidth()) {
            IconButton(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 15.dp, top = 15.dp),
                onClick = {
                    vm.logout()
                    activity?.finish()
                    activity?.startActivity(Intent(activity, MainActivity::class.java))
                }
            ) {
                Image(
                    modifier = Modifier.size(35.dp),
                    painter = painterResource(id = R.drawable.logout),
                    contentDescription = "",
                )
            }
            IconButton(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 15.dp, top = 0.dp),
                onClick = {
                    activity?.finish()
                    activity?.startActivity(Intent(activity, MainActivity::class.java))
                }
            ) {
                Icon(
                    modifier = Modifier.size(35.dp),
                    imageVector = Icons.Default.ExitToApp,
                    contentDescription = "",
                    tint = Color.White,
                )
            }
            IconButton(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 15.dp, top = 0.dp),
                onClick = {
                       stateDialog.value=true
                }
            ) {
                Icon(
                    modifier = Modifier.size(35.dp),
                    imageVector = Icons.Default.Delete,
                    contentDescription = "",
                    tint = Color.White,
                )
            }
            if (!vm.user?.image.isNullOrBlank()) {
                AsyncImage(
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally),
                    model = vm.user?.image,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }
            else {
                Image(
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally),
                    painter = painterResource(id = R.drawable.user_image),
                    contentDescription = ""
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(
                    topEnd = 40.dp,
                    topStart = 40.dp
                ),
                colors = CardDefaults.cardColors(
                   containerColor = Color.White, //Card background color opacidad
                    //contentColor = Color.White  //Card content color,e.g.text
                )
            ) {
                
                Column(
                    modifier = Modifier.padding(horizontal = 30.dp, vertical = 20.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = ""
                        )
                        Column(modifier = Modifier.padding(horizontal = 10.dp)) {
                            Text(text = "${vm.user?.name} ${vm.user?.lastname}" )
                            Text(
                                text = "Nombre de usuario",
                                fontSize = 12.sp,
                                color = Color.Gray
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = ""
                        )
                        Column(modifier = Modifier.padding(horizontal = 10.dp)) {
                            Text(text = vm.user?.email ?: "")
                            Text(
                                text = "Correo electronico",
                                fontSize = 12.sp,
                                color = Color.Gray
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Phone,
                            contentDescription = ""
                        )
                        Column(modifier = Modifier.padding(horizontal = 10.dp)) {
                            Text(text = vm.user?.phone ?: "")
                            Text(
                                text = "Telefono",
                                fontSize = 12.sp,
                                color = Color.Gray
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(40.dp))
                    DefaultButton(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Actualizar informacion",
                        onClick = {
                            val x = vm.user?.toJson().toString()
                           // vm.user?.let { vmp.params(it) }
                            navController.navigate(route = "${Graph.PROFILE}/gjhgjhgh")
//                            navController.navigate(
//                                route = ProfileScreen.ProfileUpdate.passUser("vm.user!!.toJson()")
//                            )
                        }
                    )
                }
                


            }
        }
    }

}

