package com.example.antirooting

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.antirooting.presentation.CheckEmulator
import com.example.antirooting.presentation.CheckRooted
import com.example.antirooting.presentation.LoginScreen
import com.example.antirooting.presentation.ViewModel
import com.example.antirooting.ui.theme.ANTIROOTINGTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: ViewModel = hiltViewModel()
            ANTIROOTINGTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginScreen(viewModel = viewModel)
                }

                if(CheckEmulator().checkEmulatorFiles()){
                    AlertDialog(
                        onDismissRequest = {},
                        confirmButton = {
                            Button(
                                onClick = {
                                    this.finish()
                                }
                            ) {
                                Text("Ok")
                            }
                        },
                        title = {
                            Text("This devices is an emulator!!")
                        },
                        text = {
                            Text("This application will be closed.")
                        }
                    )
                }

                if(CheckRooted().checkIfDeviceIsRooted()) {
                    AlertDialog(
                        onDismissRequest = {},
                        confirmButton = {
                            Button(
                                onClick = {
                                    this.finish()
                                }
                            ) {
                                Text("Ok")
                            }
                        },
                        title = {
                            Text("This devices is rooted!!")
                        },
                        text = {
                            Text("This application will be closed.")
                        }
                    )
                }
            }
        }
    }

}