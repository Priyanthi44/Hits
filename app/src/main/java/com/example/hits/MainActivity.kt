package com.example.hits

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.hits.navigation.HitsNavigaton

import com.example.hits.screens.home.MainScreenViewModel
import com.example.hits.ui.theme.HitsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var viewModel: MainScreenViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            initViewModel()
            HitsApp {

                HitsNavigaton(viewModel)
            }
        }
    }


    @Composable
    fun initViewModel() {
        viewModel = viewModel<MainScreenViewModel>(
            factory = viewModelFactory {
                    MainScreenViewModel(HitsApplication.instance.provideHitsRepository)
            })
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun HitsApp(content: @Composable () -> Unit) {
        HitsTheme {
            HitsNavigaton(viewModel)
        }


    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        HitsTheme {
            HitsNavigaton(viewModel)
        }
    }
}

