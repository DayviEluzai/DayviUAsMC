package com.example.dayvi_uas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class Detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val detail = intent.getParcelableExtra<DataResep>(MainActivity.INTENT_PARCELABLE)

        val img = findViewById<ImageView>(R.id.d_img)
        val name = findViewById<TextView>(R.id.d_title)
        val dec = findViewById<TextView>(R.id.d_dec)

        img.setImageResource(detail!!.img)
        name.text = detail.title
        dec.text = detail.des

        val back = findViewById<ImageView>(R.id.kembali)
        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }



    }


    }
