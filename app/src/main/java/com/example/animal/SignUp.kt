package com.example.animal

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        back_view.setOnClickListener{
            var view = this.currentFocus
            imm.hideSoftInputFromWindow(view?.windowToken,0)
        }

    }
}