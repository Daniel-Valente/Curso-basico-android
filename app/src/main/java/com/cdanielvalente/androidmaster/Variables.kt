package com.cdanielvalente.androidmaster
// val constante
// var
/**
 * Variables
 */
fun main() {
    variablesNumericas();
    println( stringText("HOLA MUNDO"));
}

fun variablesNumericas () {
    /**
     * Variables Numericas
     */
    //Int -2,147,483,647 a 2,147,483,647
    val age: Int = 30;
    var age1: Int = 10;
    //Long -9,223,372,036,854,775,807 a 9,223,372,036,854,775,807
    val example: Long = 30;
    //Float
    val pi: Float = 3.1416f;
    //Double
    val doubleExample: Double = 3.1416;

    /**
     * Utilidad de variables
     */
    println( age + age1);
    println( age - age1 );
    println( age * age1 );
    println( age / age1 );
    println( age % age1 );
}

fun variablesAlfanumericas () {
    /**
     * Variables Alfanúmericas
     */
    //Char
    val character: Char = 'a';
    //String
    val name: String = "cdanielvalente";
}

fun stringText (test: String): String {
    return test;
}

fun variablesBoolean () {
    //Boolean
    val flag: Boolean = true;
}