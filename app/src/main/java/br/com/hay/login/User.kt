package br.com.hay.login

data class User(val id: Long, val name: String,
                val email: String, val password: String, val picture: String) {

    companion object {
        fun empty() = User(0, String.empty(), String.empty(), String.empty(), String.empty())
    }
}

fun String.Companion.empty() = ""