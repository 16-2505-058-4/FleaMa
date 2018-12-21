package com.example.enpit_p12.sainttropez

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.letsbuildthatapp.kotlinmessenger.messages.LatestMessagesActivity
import kotlinx.android.synthetic.main.activity_login.*

import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login_button_login.setOnClickListener {
            performLogin()
        }


    }

    private fun performLogin() {
        val email = email_edittext_login.text.toString()
        val password = password_edittext_login.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "パスワードとメールを入力してください", Toast.LENGTH_SHORT).show()
            return
        }

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (!it.isSuccessful) return@addOnCompleteListener

                    Log.d("Login", "ログイン成功しました: ${it.result.user.uid}")

                    val intent = Intent(this, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                }
                .addOnFailureListener {
                    Toast.makeText(this, "ログイン失敗した: ${it.message}", Toast.LENGTH_SHORT).show()
                }
    }



    fun onMainButtonNew(view: View?) {
        val intent = Intent(this, LoginMakeActivity::class.java)
        startActivity(intent)
    }
}

