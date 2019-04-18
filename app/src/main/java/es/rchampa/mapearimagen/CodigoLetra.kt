package es.rchampa.mapearimagen

/*

255 = 0
254 = 1

000	A = 255 255 255
001	B = 255 255 254
010	C = 255 254 255
011 D = 255 254 254
100	E = 254 255 255
101	F = 254 255 254
110	G = 254 254 255
111	H = 254 254 254

*/

object CodigoLetra {


    val A = arrayOf(255,255,255)
    val B = arrayOf(253,253,253)
    val C = arrayOf(239,239,239)
    val D = arrayOf(249,249,249)
    val E = arrayOf(247,247,247)
    val F = arrayOf(245,245,245)
    val G = arrayOf(235,235,235)
    val H = arrayOf(231,231,231)
    val NADA = arrayOf(10000,10000,10000)
    val letras = arrayOf(A,B,C,D,E,F,G,H)



    fun toString(code:Array<Int>):String{
        println("CODEEEEEE: "+code[0]+ " " + code[1]+ " "+code[2])
        return when(compare(code)){
            A -> "A"
            B -> "B"
            C -> "C"
            D -> "D"
            E -> "E"
            F -> "F"
            G -> "G"
            H -> "H"
            else -> "NADA"
        }
    }

    private fun compare(code:Array<Int>):Array<Int>{
        for (letra in letras){
            if(code[0]==letra[0] && code[1]==letra[1] && code[2]==letra[2]){
                return letra
            }
        }
        return NADA
    }

}


