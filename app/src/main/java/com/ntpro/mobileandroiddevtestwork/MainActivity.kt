package com.ntpro.mobileandroiddevtestwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.ntpro.mobileandroiddevtestwork.ui.screen.deals.DealsScreen
import com.ntpro.mobileandroiddevtestwork.ui.screen.deals.DealsScreenViewModel
import com.ntpro.mobileandroiddevtestwork.ui.theme.MyAppTheme

class MainActivity : AppCompatActivity() {
    private val viewModel: DealsScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DealsScreen(viewModel)
                }
            }
        }
    }
}