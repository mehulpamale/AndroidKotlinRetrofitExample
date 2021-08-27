package com.msp.restapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.msp.restapi.postman.PMServiceBuilder
import com.msp.restapi.postman.PMUser
import com.msp.restapi.postman.PostmanService
import com.msp.restapi.restgo.RGService
import com.msp.restapi.restgo.RGServiceBuilder
import com.msp.restapi.restgo.RGUser1
import com.msp.restapi.restgo.RGUserList
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadPMUser()
        loadRGUsers()
    }

    private fun loadRGUsers() {

        val service = RGServiceBuilder.buildService(RGService::class.java) as RGService

        val call = service.getUsers()
        call.enqueue(object : Callback<RGUserList> {
            override fun onResponse(call: Call<RGUserList>, response: Response<RGUserList>) {
                if (response.isSuccessful) {
                    val userList = response.body()?.data
                    rv.layoutManager = LinearLayoutManager(applicationContext)
                    rv.adapter = RVAdapter(userList!!)
                } else {
                    AlertDialog.Builder(this@MainActivity).setMessage(call.request().toString())
                }
            }

            override fun onFailure(call: Call<RGUserList>, t: Throwable) {
                t.printStackTrace()
                tv.text = t.toString()
                AlertDialog.Builder(this@MainActivity).setMessage(call.request().toString())
            }
        })

    }

    private fun loadRGUser() {

        val service = RGServiceBuilder.buildService(RGService::class.java) as RGService

        val call = service.getUser()
        call.enqueue(object : Callback<RGUser1> {
            override fun onResponse(call: Call<RGUser1>, response: Response<RGUser1>) {
                if (response.isSuccessful)
                    tv.text = (response.body() as RGUser1).data.toString()
                AlertDialog.Builder(this@MainActivity).setMessage(call.request().toString())
            }

            override fun onFailure(call: Call<RGUser1>, t: Throwable) {
                t.printStackTrace()
                tv.text = t.toString()
                AlertDialog.Builder(this@MainActivity).setMessage(call.request().toString())
            }
        })

    }

    private fun loadPMUser() {
        val service =
            PMServiceBuilder.buildService(PostmanService::class.java) as PostmanService
        val requestCall = service.getUser()

        requestCall.enqueue(object : Callback<PMUser> {
            override fun onResponse(call: Call<PMUser>, response: Response<PMUser>) {
//                AlertDialog.Builder(this@MainActivity).setMessage(call.toString()).show()
                val user = response.body()
                tv.text = "${user?.fname} ${user?.lname}"
            }

            override fun onFailure(call: Call<PMUser>, t: Throwable) {
                t.printStackTrace()
                tv.text = t.toString()
            }
        })
    }
}