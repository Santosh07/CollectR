package com.santosh.collectr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.odk.collect.android.activities.FormEntryActivity
import org.odk.collect.android.activities.MainMenuActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hello_world.setOnClickListener {
            startActivity(Intent(this, MainMenuActivity::class.java))
        }
    }
}
