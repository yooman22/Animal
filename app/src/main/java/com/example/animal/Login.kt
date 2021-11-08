package com.example.animal

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        back_view.setOnClickListener{
            var view = this.currentFocus
            imm.hideSoftInputFromWindow(view?.windowToken,0)
        }

        signUp.setOnClickListener{
            val nextIntent = Intent(this, SignUp::class.java)
            startActivity(nextIntent)
        }



    }
}