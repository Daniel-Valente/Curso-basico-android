package com.cdanielvalente.androidmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.cdanielvalente.androidmaster.firstapp.FirstAppActivity
import com.cdanielvalente.androidmaster.imccalculator.ImcCalculatorActivity
import com.cdanielvalente.androidmaster.todoapp.TodoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        val btnSaludApp = findViewById<AppCompatButton>(R.id.btnSaludApp);
        btnSaludApp.setOnClickListener{ navigateToSaludApp() };

        val btnIMCApp = findViewById<AppCompatButton>(R.id.btnIMCApp);
        btnIMCApp.setOnClickListener{ navigateToIMCApp() };

        val btnTodoApp = findViewById<AppCompatButton>(R.id.btnTodoApp);
        btnTodoApp.setOnClickListener{ navigateToTodoApp() };
    };

    private fun navigateToSaludApp () {
        val intent = Intent(this, FirstAppActivity::class.java);
        startActivity( intent );
    };

    private fun navigateToIMCApp() {
        val intent = Intent(this, ImcCalculatorActivity::class.java);
        startActivity( intent );
    };
    private fun navigateToTodoApp() {
        val intent = Intent( this, TodoActivity::class.java );
        startActivity( intent );
    };
}