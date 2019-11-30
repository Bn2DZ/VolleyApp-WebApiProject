package com.example.volleyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_rv.*

class RVAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv)

        var list = ArrayList<Driver>()

        var url:String="http://192.168.0.21:8090/WebAPIProject/all_drivers.php"

        var rq = Volley.newRequestQueue(this)

        var rv: RecyclerView = findViewById(R.id.rv)


        var jar = JsonArrayRequest(

            Request.Method.GET, url, null,
            Response.Listener { response ->

                for(x in 0 until response.length())
                    list.add(Driver(response.getJSONObject(x).getString("name"),
                        response.getJSONObject(x).getString("mobile")))

                var adp = DriverAdapter(this,list)
                rv.layoutManager = LinearLayoutManager(this)
                rv.adapter = adp

            },
            Response.ErrorListener {  })
        rq.add(jar)
    }
}
