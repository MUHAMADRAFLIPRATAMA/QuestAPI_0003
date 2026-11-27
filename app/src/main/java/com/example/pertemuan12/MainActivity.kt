package com.example.pertemuan12

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import android.content.pm.PackageManager
import com.example.pertemuan12.ui.theme.Pertemuan12Theme
import com.example.pertemuan12.uicontroller.route.DataSiswaApp

class MainActivity : ComponentActivity() {
    private val izinJaringanLokal =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Android 17 (API 37)+: minta izin akses jaringan lokal agar bisa konek ke server PHP
        if (Build.VERSION.SDK_INT >= 37 &&
            ContextCompat.checkSelfPermission(this, IZIN_LOCAL_NETWORK) != PackageManager.PERMISSION_GRANTED
        ) {
            izinJaringanLokal.launch(IZIN_LOCAL_NETWORK)
        }
        enableEdgeToEdge()
        setContent {
            Pertemuan12Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DataSiswaApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
private const val IZIN_LOCAL_NETWORK = "android.permission.ACCESS_LOCAL_NETWORK"