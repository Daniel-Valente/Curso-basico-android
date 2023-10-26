package com.cdanielvalente.androidmaster.exercises

fun main () {

}

fun fetMonth ( month: Int ) {
    when( month ) {
        1 -> println( "enero" );
        2 -> println( "febrero" );
        3 -> println( "marzo" );
        4 -> println( "abril" );
        4 -> {
            println( "abril" );
            println( "abril" );
        };
        else -> println( "no es valido" );
    }
}

fun getTrimestre ( month: Int ) : String {
    when( month ) {
        1, 2, 3 -> return "Primer trimestre";
        4, 5, 6 -> return "Segundo trimestre";
        7, 8, 10 -> return "Tercer trimestre";
        else -> return "No valido";
    }
}

fun getSemestre ( month: Int ) : String {
    when( month ) {
        in 1..6 -> return "Primer Semestre";
         in 7..12 -> return "Segundo Semestre";
        else -> return "No valido";
    }
}

fun resultado ( value: Any ) {
    when( value ) {
        is Int -> value + value;
        is String -> println( value );
        is Boolean -> if ( value ) println("hola");
    }
}