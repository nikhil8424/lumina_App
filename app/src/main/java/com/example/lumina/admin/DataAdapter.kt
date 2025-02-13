package com.example.lumina.admin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lumina.ExamSchedule
import com.example.lumina.R

class DataAdapter(private val dataList: List<ExamSchedule>) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.nameTextView)
        val dateTextView: TextView = view.findViewById(R.id.dateTextView)
        val timeTextView: TextView = view.findViewById(R.id.timeTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.table_row_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val examSchedule = dataList[position]
        holder.nameTextView.text = examSchedule.subject ?: "N/A"
        holder.dateTextView.text = examSchedule.date ?: "N/A"
        holder.timeTextView.text = examSchedule.time ?: "N/A"

        holder.itemView.setPadding(0, 0, 0, 0)
    }

    override fun getItemCount() = dataList.size
}
