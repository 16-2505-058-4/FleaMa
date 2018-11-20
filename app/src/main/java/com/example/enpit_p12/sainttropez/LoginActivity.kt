package com.example.enpit_p12.sainttropez

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return  true
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.top -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.log -> {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.sell -> {
                val intent = Intent(this, SellActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.history -> {
                val intent = Intent(this, HistoryActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onContextItemSelected(item)
    }
}
