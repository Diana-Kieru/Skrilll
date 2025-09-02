package com.example.skrill

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        // Show LoginFragment by default
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main, LoginFragment())
                .commit()
        }
    }
    
    fun navigateToHome() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main, DashboardFragment())
            .commit()
    }
    
    fun navigateToProfile() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main, ProfileFragment())
            .commit()
    }
    
    fun navigateToDashboard() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main, DashboardFragment())
            .commit()
    }
}