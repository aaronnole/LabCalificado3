package com.nole.aaron.laboratoriocalificado03

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class TeacherAdapter(private val teachers: List<TeacherResponse>) :
    RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder>() {

    inner class TeacherViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.text_name)
        val specialty: TextView = view.findViewById(R.id.text_specialty)
        val phone: TextView = view.findViewById(R.id.text_phone)
        val email: TextView = view.findViewById(R.id.text_email)
        val card: CardView = view.findViewById(R.id.card) // Aquí se hace referencia al ID `card`
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_teacher_card, parent, false)
        return TeacherViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeacherViewHolder, position: Int) {
        val teacher = teachers[position]
        holder.name.text = "${teacher.name} ${teacher.last_name}"
        holder.specialty.text = "Specialty: Teacher"
        holder.phone.text = teacher.phone_number
        holder.email.text = teacher.email

        // Fondo dinámico para las tarjetas
        val colors = listOf(
            R.color.blue_card,
            R.color.red_card,
            R.color.yellow_card
        )
        holder.card.setCardBackgroundColor(
            ContextCompat.getColor(holder.itemView.context, colors[position % colors.size])
        )
    }

    override fun getItemCount() = teachers.size
}

