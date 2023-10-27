package com.cdanielvalente.androidmaster.imccalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.cdanielvalente.androidmaster.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {
    private var isMaleSelected: Boolean = true;
    private var isFemaleSelected: Boolean = false;

    private var currentHeight: Int = 120;
    private var currentWeight: Int = 60;
    private var currentAge: Int = 24;

    private lateinit var viewMale: CardView;
    private lateinit var viewFemale: CardView;

    private lateinit var tvHeight: TextView;
    private lateinit var rsHeight: RangeSlider;

    private lateinit var tvWeight: TextView;
    private lateinit var btnPlusWeight: FloatingActionButton;
    private lateinit var btnSubtractWeight: FloatingActionButton;

    private lateinit var tvAge: TextView;
    private lateinit var btnPlusAge: FloatingActionButton;
    private lateinit var btnSubtractAge: FloatingActionButton;

    private lateinit var btnCalculate: AppCompatButton;

    companion object {
        const val IMC_KEY: String = "IMC_RESULT";
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc_calculator);

        initComponents();
        initListeners();
        initUI();
    }

    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale);
        viewFemale = findViewById(R.id.viewFemale);

        tvHeight = findViewById(R.id.tvHeight);
        rsHeight = findViewById(R.id.rsHeight);

        tvWeight = findViewById(R.id.tvWeight);
        btnPlusWeight = findViewById(R.id.btnPlusWeight);
        btnSubtractWeight = findViewById(R.id.btnSubtractWeight);

        tvAge = findViewById(R.id.tvAge);
        btnPlusAge = findViewById(R.id.btnPlusAge);
        btnSubtractAge = findViewById(R.id.btnSubtractAge);

        btnCalculate = findViewById(R.id.btnCalculate);
    };

    private fun initListeners() {
        viewMale.setOnClickListener {
            changeGender();
            setGenderColor();
        };
        viewFemale.setOnClickListener {
            changeGender();
            setGenderColor();
        };

        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##");
            currentHeight = df.format(value).toInt();
            tvHeight.text = "${currentHeight.toString()} cm";
        };

        btnPlusWeight.setOnClickListener {
            currentWeight += 1;
            setWeight();
        };
        btnSubtractWeight.setOnClickListener {
            currentWeight -= 1;
            setWeight();
        };

        btnPlusAge.setOnClickListener {
            currentAge += 1;
            setAge();
        };
        btnSubtractAge.setOnClickListener {
            currentAge -= 1;
            setAge();
        };

        btnCalculate.setOnClickListener {
            val result: Double = calculateIMC();
            navigateToResult( result );
        };
    };

    private fun initUI() {
        setGenderColor();
        setWeight();
        setAge();
    };

    private fun navigateToResult( result: Double ) {
        val intent = Intent( this, ResultIMCActivity::class.java);
        intent.putExtra(IMC_KEY, result);
        startActivity( intent );
    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected;
        isFemaleSelected = !isFemaleSelected;
    }

    private fun setGenderColor() {
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected));
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected));
    };

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {
        val colorReference = if (isSelectedComponent) {
            R.color.background_component_selected;
        } else {
            R.color.background_component;
        };

        return ContextCompat.getColor(this, colorReference);
    };

    private fun setWeight() {
        tvWeight.text = currentWeight.toString();
    };

    private fun setAge() {
        tvAge.text = currentAge.toString();
    };

    private fun calculateIMC(): Double {
        val df = DecimalFormat( "#.##" );
        val imc = currentWeight / ( currentHeight.toDouble()/100 * currentHeight.toDouble()/100 );
        return df.format( imc ).toDouble();
    };
};