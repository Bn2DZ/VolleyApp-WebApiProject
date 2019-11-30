package com.example.volleyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_jo.*

class JOAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jo)

        btn_find.setOnClickListener {

            var url:String="http://192.168.0.21:8090/WebAPIProject/find.php?id=" +
                    et_id.text.toString()

            var rq= Volley.newRequestQueue(this)

            var jor = JsonObjectRequest(Request.Method.GET, url, null,
                Response.Listener { response ->
                    tv_name.text = response.getString("name")
                    tv_mobile.text = response.getString("mobile")
                },
                Response.ErrorListener {  })

            rq.add(jor)
        }


        btn_all.setOnClickListener {
            var result:String = ""
            var url:String = "http://192.168.0.21:8090/WebAPIProject/all_drivers.php"

            var rq = Volley.newRequestQueue(this)
                var jar = JsonArrayRequest(Request.Method.GET, url, null,
                Response.Listener { response ->

                    for (x in 0 until response.length()-1)
                        result += response.getJSONObject(x).getString("name") + "\n"

                    Toast.makeText(this,result,Toast.LENGTH_LONG).show()

                },
                Response.ErrorListener {  })

            rq.add(jar)
        }
    }
}
