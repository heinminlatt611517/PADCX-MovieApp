package com.example.padcx_movieapp_assignment.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun showSnackBar (message: String) {
        Snackbar.make(window.decorView, message, Snackbar.LENGTH_SHORT).show()
    }
}