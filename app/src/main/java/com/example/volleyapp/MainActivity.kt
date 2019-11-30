package com.example.volleyapp

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.textclassifier.TextLinks
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        btn_save.setOnClickListener {

            var url:String = "http://192.168.0.21:8090/WebAPIProject/add.php" +
                    "?name=" + et_name.text.toString() + "&mobile=" + et_mobile.text.toString()

            var rq = Volley.newRequestQueue(this)

            var sr = StringRequest(

                Request.Method.GET, url,

                Response.Listener { response ->
                    Toast.makeText(this, response,
                        Toast.LENGTH_LONG).show()
                },
                Response.ErrorListener { error ->
                    Toast.makeText(this, error.message,
                        Toast.LENGTH_LONG).show()
                }
            )

            rq.add(sr)



        }




    }
}
