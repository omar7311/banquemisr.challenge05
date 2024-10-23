package com.example.banquemisrchallenge05.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.banquemisrchallenge05.R
import com.example.banquemisrchallenge05.model.NetworkObserver
import com.example.banquemisrchallenge05.view.ui.navigation.NavGraph
import com.example.banquemisrchallenge05.view.ui.theme.Banquemisrchallenge05Theme

class MainActivity : ComponentActivity() {
    private lateinit var networkObserver: NetworkObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkObserver = NetworkObserver(applicationContext)
        networkObserver.register()
        enableEdgeToEdge()
        setContent {
            Banquemisrchallenge05Theme {
                val controller= rememberNavController()
                NavGraph(networkObserver,controller,getString(R.string.api_key),this)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        networkObserver.unRegister()
    }
}

