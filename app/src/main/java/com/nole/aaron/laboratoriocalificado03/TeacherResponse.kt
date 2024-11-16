package com.nole.aaron.laboratoriocalificado03

data class TeacherResponse(
    val name: String,
    val last_name: String,
    val phone_number: String,
    val email: String,
    val image_url: String
) {
    // Método opcional para obtener la URL de la imagen
    fun getTeacherImage(): String = image_url

    // Método para combinar nombre y apellido si es necesario
    fun getFullName(): String = "$name $last_name"
}

