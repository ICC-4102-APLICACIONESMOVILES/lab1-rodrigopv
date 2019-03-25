package com.uandes.moviles.lab1final

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.content.Intent
import android.app.Activity
import android.widget.Toast


import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //setSupportActionBar(toolbar)


        btnLogin.setOnClickListener { view ->
            //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            //        .setAction("Action", null).show()

            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            if((!email.contains("@")) or password.isEmpty()) {
                Toast.makeText(this, "Please use a valid e-mail and non-blank password", Toast.LENGTH_LONG).show()
            } else {
                val returnIntent = Intent()
                returnIntent.putExtra("username", editTextEmail.text.toString())
                returnIntent.putExtra("password", editTextPassword.text.toString())
                setResult(Activity.RESULT_OK, returnIntent)
                finish()

            }



        }
    }

}
