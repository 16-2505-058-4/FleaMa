package com.example.enpit_p12.sainttropez

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View

class SellActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sell)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return  true
    }
    fun onMainButtonLogin(view: View?){
        val intent = Intent(this, LoginActivity::class.java)
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
}
