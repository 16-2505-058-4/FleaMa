package com.example.enpit_p12.sainttropez

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.letsbuildthatapp.kotlinmessenger.registerlogin.RegisterActivity
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : AppCompatActivity() {

    fun onMainButtonChat(view: View?){
        val intent = Intent(this, ChatActivity::class.java)
        startActivity(intent)
    }
    fun onMainButtonSell(view: View?){
        val intent = Intent(this, SellActivity::class.java)
        startActivity(intent)
    }
    fun onMainButtonHistory(view: View?){
        val intent = Intent(this, HistoryActivity::class.java)
        startActivity(intent)
    }
    fun onMainButtonTapped(view: View?){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.logingmain, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu_new_message -> {
                val intent = Intent(this, NewMessageActivity::class.java)
                startActivity(intent)
            }
            R.id.menu_sign_out -> {
                FirebaseAuth.getInstance().signOut()
                val intent = Intent(this, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        verifyUserIsLoggedIn()
    }

    private fun verifyUserIsLoggedIn() {
        val uid = FirebaseAuth.getInstance().uid
        if (uid == null) {
            val intent = Intent(this, RegisterActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
        

    }





}
