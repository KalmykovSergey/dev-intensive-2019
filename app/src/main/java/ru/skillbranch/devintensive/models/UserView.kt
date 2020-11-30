package ru.skillbranch.devintensive.models

class UserView(
        val id: String,
        val fullName: String,
        val nickName: String?,
        var avatar: String? = null,
        var status: String? = "offline",
        var initials: String? = null
){
    fun printMe() {
        println("""
            id: $id
            fullName: $fullName
            nickname: $nickName
            avatar: $avatar
            status: $status
            initials: $initials
        """.trimIndent())
    }
}