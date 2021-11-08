package com.example.animal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.server.conn.ServerAPI
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        signUp.setOnClickListener{
            val nextIntent = Intent(this, SignUp::class.java)
            startActivity(nextIntent)
        }

        loginButton.setOnClickListener {
            var hashMap  = HashMap<String,String>()

            hashMap.put("id",loginId.text.toString());
            hashMap.put("pwd",loginPwd.text.toString());

            var serverAPI: ServerAPI = ServerAPI(2,hashMap)
            serverAPI.start();
            serverAPI.join();
        }

    }
}