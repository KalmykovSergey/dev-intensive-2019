package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?>{
        val parts : List<String>? = fullName?.split(" ")
        val firstName = if(fullName.isNullOrBlank()) null else parts?.getOrNull(0)
        val lastName = if(fullName.isNullOrBlank()) null else parts?.getOrNull(1)
        return firstName to lastName
    }

    fun transliteration(payload: String?, divider: String = " "): String? {
        val traslateDict = mapOf<String, String>(
        "а" to "a",
        "б" to "b",
        "в" to "v",
        "г" to "g",
        "д" to "d",
        "е" to "e",
        "ё" to "e",
        "ж" to "zh",
        "з" to "z",
        "и" to "i",
        "й" to "i",
        "к" to "k",
        "л" to "l",
        "м" to "m",
        "н" to "n",
        "о" to "o",
        "п" to "p",
        "р" to "r",
        "с" to "s",
        "т" to "t",
        "у" to "u",
        "ф" to "f",
        "х" to "h",
        "ц" to "c",
        "ч" to "ch",
        "ш" to "sh",
        "щ" to "sh'",
        "ъ" to "",
        "ы" to "i",
        "ь" to "",
        "э" to "e",
        "ю" to "yu",
        "я" to "ya",
        " " to " "
        )
        val divider = divider
        val parts : List<String>? = payload?.split(" ")
        var firstName = if(payload.isNullOrBlank()) null else parts?.getOrNull(0)
        var lastName = if(payload.isNullOrBlank()) null else parts?.getOrNull(1)
        println("firstName - $firstName")
        println("lastName - $lastName")
        var translitefirstName: String = ""
        var translitelastName: String = ""
        if (firstName != "null") {
            firstName = firstName!!.toLowerCase()
            for (char in firstName) translitefirstName += traslateDict.getValue(char.toString())
            translitefirstName = translitefirstName.capitalize()
        }
        else translitefirstName = "null"

        if (lastName != "null") {
            lastName = lastName!!.toLowerCase()
            for (char in lastName) translitelastName += traslateDict.getValue(char.toString())
            translitelastName = translitelastName.capitalize()
        }
        else translitelastName = "null"
        val transliteName: String = if (translitelastName == "") "$translitefirstName" else "$translitefirstName$divider$translitelastName"
        return (transliteName)
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        val initial1: String? = if(firstName.isNullOrBlank()) null else firstName[0].toString()
        val initial2: String? = if(lastName.isNullOrBlank()) null else lastName[0].toString()
        var initials: String? = null
        if (initial1 == null) {
            if (initial2 != null) initials = initial2
        }
        else if (initial2 != null) initials = "$initial1$initial2"
        else initials = initial1
        if (initial1 == null && initial2 == null) initials = null

        return initials
    }
}