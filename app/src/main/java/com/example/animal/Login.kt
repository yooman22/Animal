package com.example.animal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        signUp.setOnClickListener{
            val nextIntent = Intent(this, SignUp::class.java)
            startActivity(nextIntent)
        }



    }
}