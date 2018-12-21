package com.example.enpit_p12.sainttropez

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_sell.*
import java.util.*

class SellActivity : AppCompatActivity() {
    companion object {
        val TAG = "SellActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sell)

        selectphoto_button_register.setOnClickListener {
            Log.d(TAG, "Try to show photo selector")

            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 0)
            performRegister()
        }
    }

    var selectedPhotoUri: Uri? = null

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 0 && resultCode == Activity.RESULT_OK && data != null) {
            // proceed and check what the selected image was....
            Log.d(TAG, "Photo was selected")

            selectedPhotoUri = data.data

            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, selectedPhotoUri)




//
//
   val bitmapDrawable = BitmapDrawable(bitmap)
            selectphoto_button_register.setBackgroundDrawable(bitmapDrawable)
        }
    }

    private fun performRegister() {


                    uploadImageToFirebaseStorage()


    }

    private fun uploadImageToFirebaseStorage() {
        if (selectedPhotoUri == null) return

        val filename = UUID.randomUUID().toString()
        val ref = FirebaseStorage.getInstance().getReference("/sell/$filename")

        ref.putFile(selectedPhotoUri!!)
                .addOnSuccessListener {
                    Log.d(TAG, "Successfully uploaded image: ${it.metadata?.path}")

                    ref.downloadUrl.addOnSuccessListener {
                        Log.d(TAG, "File Location: $it")


                    }
                }
                .addOnFailureListener {
                    Log.d(TAG, "Failed to upload image to storage: ${it.message}")
                }
    }

    fun onMainButtonSelll(view: View?){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
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
}
