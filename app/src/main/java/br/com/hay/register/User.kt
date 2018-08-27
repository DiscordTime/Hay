package br.com.hay.register

data class User(val id: Long, val name: String,
                val email: String, val password: String, val picture: String) {

    companion object {
        fun empty() = User(0, String.empty(), String.empty(), String.empty(), String.empty())
    }

    fun toUser() = User(id, name, email, password, picture)
}

fun String.Companion.empty() = ""