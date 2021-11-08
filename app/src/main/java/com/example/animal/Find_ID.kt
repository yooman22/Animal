package com.example.animal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.server.conn.ServerAPI
import kotlinx.android.synthetic.main.activity_find_id.*
import kotlinx.android.synthetic.main.activity_login.*

class Find_ID : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_id)

        phoneAuthBotton.setOnClickListener{
            var smsAPI:SmsAPI = SmsAPI(phoneNumber_txt.text.toString());
            smsAPI.start();
            smsAPI.join();

            var authNum = smsAPI.authNum;

            var hashMap  = HashMap<String,String>();
            hashMap.put("findId",findId.text.toString());
            hashMap.put("authNum",authNum);

            var serverAPI: ServerAPI = ServerAPI(3,hashMap)
            serverAPI.start();
            serverAPI.join();
        }


        findIdButton.setOnClickListener{

            var hashMap  = HashMap<String,String>()

            hashMap.put("findId",findId.text.toString());
            hashMap.put("phoneNumber_txt",phoneNumber_txt.text.toString());
            hashMap.put("AuthNum",AuthNum.text.toString());

            var serverAPI: ServerAPI = ServerAPI(4,hashMap)
            serverAPI.start();
            serverAPI.join();

        }
    }
}