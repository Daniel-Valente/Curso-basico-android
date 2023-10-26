package com.cdanielvalente.androidmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.cdanielvalente.androidmaster.firstapp.FirstAppActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        val btnSaludApp = findViewById<AppCompatButton>(R.id.btnSaludApp);
        btnSaludApp.setOnClickListener{ navigateToSaludApp() };

    };
    private fun navigateToSaludApp () {
        val intent = Intent(this, FirstAppActivity::class.java);
        startActivity( intent );
    }
}