package com.sportclientapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import com.sportsdk.SportSDK

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sportsSDk = SportSDK.getInstance()

        setContent {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(getString(R.string.sports_client_app_title)) },
                        actions = {
                            IconButton(onClick = { sportsSDk.refreshSportScreen() }) {
                                Icon(Icons.Default.Refresh, "")
                            }
                        }
                    )
                },
                content = {
                    sportsSDk.renderSportScreen()
                }
            )
        }
    }
}