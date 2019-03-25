package com.uandes.moviles.lab1final

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.content.Intent
import android.app.Activity
import android.widget.Toast


import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var isLoggedIn = false
    private var username = ""
    private var password = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainLogin.setOnClickListener { view ->
            //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            //        .setAction("Action", null).show()
            val askLogin = Intent(this, LoginActivity::class.java)
            if (!isLoggedIn) {
                startActivityForResult(askLogin, 1)
            } else {
                Toast.makeText(this, "You logged out!.", Toast.LENGTH_LONG).show()
                this.username = ""
                this.password = ""
                mainLogin.text = "Log In"
                lblAccion.text = "Use the button to Log In"
                isLoggedIn = false;
            }
        }
    }


    // https://stackoverflow.com/questions/10407159/how-to-manage-startactivityforresult-on-android
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                isLoggedIn = true
                this.username = data!!.getStringExtra("username")
                this.password = data.getStringExtra("password")
                Toast.makeText(this, "Logged in successfully! User:" + this.username, Toast.LENGTH_LONG).show()
                mainLogin.text = "Logout"
                lblAccion.text = "Welcome, " + this.username;
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
                isLoggedIn = false
            }
        }
    }//onActivityResult
}
