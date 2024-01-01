package com.vk.directop.validateform.presentation.social_network

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vk.directop.validateform.R
import com.vk.directop.validateform.presentation.books.BooksMainScreen


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SocialNetworksListScreen(
    //viewModel: SocialNetworksListViewModel = viewModel(),
) {
    val scrollState = rememberScrollState()

//    Scaffold(// рабочая версия из socialNetworksList
//        modifier = modifier.fillMaxSize(),
//        topBar = {
//            TopAppBar (
//                title = {
//                    Text(text = stringResource(id = R.string.book_title))
//                }
//            )
//        }
//
//    ) {
//        Surface(modifier = modifier
//            .fillMaxSize()
//            .padding(it),
//            color = MaterialTheme.colorScheme.background
//        ) {
//            // content here
//
//        }
//    }

//    Scaffold (
//        content = {
//
//            val socialNetworksState = viewModel.state.collectAsState()
//
//            val allSocialNetworks = socialNetworksState.value.allSocialNetworks
//            val favourite = socialNetworksState.value.favourite
//
//            Column(modifier = Modifier.verticalScroll(scrollState)) {
//                allSocialNetworks.forEach {
//                    ListItem(
//                        modifier = Modifier.clickable(
//                            interactionSource = remember { MutableInteractionSource() },
//                            indication = rememberRipple(bounded = true),
//                        ) {
//                            viewModel.setFavourite(it)
//                        },
//                        icon = {
//                            SocialNetworkIcon(
//                                text = it.name.take(1),
//                                backgroundColor = Color(it.backgroundColorHex),
//                            )
//                        },
//                        text = {
//                            Text(it.name)
//                        },
//                        secondaryText = {
//                            Text(it.url)
//                        },
//                        trailing = {
//                            if (it == favourite) {
//                                FavouriteIcon()
//                            }
//                        }
//                    )
//                }
//            }
//        }
//    )
//
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = { Text(stringResource(R.string.social_networks_list_title)) },
//            )
//        },
//    ) {
//        val socialNetworksState = viewModel.state.collectAsState()
//
//        val allSocialNetworks = socialNetworksState.value.allSocialNetworks
//        val favourite = socialNetworksState.value.favourite
//
//        Column(modifier = Modifier.verticalScroll(scrollState)) {
//            allSocialNetworks.forEach {
//                ListItem(
//                    modifier = Modifier.clickable(
//                        interactionSource = remember { MutableInteractionSource() },
//                        indication = rememberRipple(bounded = true),
//                    ) {
//                        viewModel.setFavourite(it)
//                    },
//                    icon = {
//                        SocialNetworkIcon(
//                            text = it.name.take(1),
//                            backgroundColor = Color(it.backgroundColorHex),
//                        )
//                    },
//                    text = {
//                        Text(it.name)
//                    },
//                    secondaryText = {
//                        Text(it.url)
//                    },
//                    trailing = {
//                        if (it == favourite) {
//                            FavouriteIcon()
//                        }
//                    }
//                )
//            }
//        }
//    }
}

@Composable
private fun FavouriteIcon() {
    Icon(
        imageVector = Icons.Filled.Favorite,
        contentDescription = stringResource(R.string.favourite),
        tint = Color.Red,
    )
}

@Composable
private fun SocialNetworkIcon(
    text: String = "A",
    backgroundColor: Color,
) {
    Box(
        modifier = Modifier
            .size(42.dp)
            .clip(CircleShape)
            .background(backgroundColor)
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                shadow = Shadow(
                    color = Color.DarkGray,
                    offset = Offset(6f, 4f),
                    blurRadius = 6f,
                )
            ),
            modifier = Modifier.align(Alignment.Center)
        )
    }
}