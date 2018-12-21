package com.example.enpit_p12.sainttropez

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class HistoryActivity : AppCompatActivity() {
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){



        }
        return super.onContextItemSelected(item)
    }
}
