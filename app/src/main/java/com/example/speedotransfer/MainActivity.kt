package com.example.speedotransfer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.speedotransfer.ui.errorscreens.ErrorServer
import com.example.speedotransfer.ui.profile.ChangePasswordScreen
import com.example.speedotransfer.ui.profile.ProfileInformationScreen
import com.example.speedotransfer.ui.profile.ProfileScreen
import com.example.speedotransfer.ui.profile.SettingsScreen
import com.example.speedotransfer.ui.signinandup.SecondSignUp
import com.example.speedotransfer.ui.signinandup.SignUp
import com.example.speedotransfer.ui.theme.SpeedoTransferTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpeedoTransferTheme {
                ChangePasswordScreen()
            }
        }
    }
}

