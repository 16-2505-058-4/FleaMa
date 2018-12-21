package com.example.enpit_p12.sainttropez

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.view.*
import android.widget.EditText
import com.example.enpit_p12.sainttropez.R.id.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    fun onMainButtonChat(view: View?){
        val intent = Intent(this, ChatActivity::class.java)
        startActivity(intent)
    }
    fun onMainButtonSell(view: View?){
        val intent = Intent(this, SellActivity::class.java)
        startActivity(intent)
    }

    fun onMainButtonBuy(view: View?){
        val intent = Intent(this, buyctivity::class.java)
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
        menuInflater.inflate(R.menu.main, menu)
        return  true
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }

}

