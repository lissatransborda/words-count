package com.wordscounter.utils

fun String.stripAccents(): String{

    val chars: CharArray = this.toCharArray()

    val sb = StringBuilder(this)
    var cont = 0

    while (chars.size > cont) {
        var c: Char = chars[cont]
        var c2: String = c.toString()
        //these are my needs, in case you need to convert other accents just Add new entries aqui
        c2 = c2.replace("ã", "a", ignoreCase = true)
        c2 = c2.replace("õ", "o", ignoreCase = true)
        c2 = c2.replace("ç", "c", ignoreCase = true)
        c2 = c2.replace("á", "a", ignoreCase = true)
        c2 = c2.replace("à", "a", ignoreCase = true)
        c2 = c2.replace("ó", "o", ignoreCase = true)
        c2 = c2.replace("ê", "e", ignoreCase = true)
        c2 = c2.replace("é", "e", ignoreCase = true)
        c2 = c2.replace("ú", "u", ignoreCase = true)
        c2 = c2.replace("ü", "u", ignoreCase = true)

        c = c2.single()
        sb.setCharAt(cont, c)
        cont++
    }

    return sb.toString()
}