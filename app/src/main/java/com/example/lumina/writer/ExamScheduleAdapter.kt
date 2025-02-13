package com.example.lumina.writer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lumina.ExamSchedule
import com.example.lumina.R

class ExamScheduleAdapter(private val examScheduleList: List<ExamSchedule>) : RecyclerView.Adapter<ExamScheduleAdapter.ExamScheduleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExamScheduleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_exam_schedule_writer, parent, false)
        return ExamScheduleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExamScheduleViewHolder, position: Int) {
        val examSchedule = examScheduleList[position]
        holder.subjectTextView.text = examSchedule.subject
        holder.dateTextView.text = examSchedule.date
        holder.timeTextView.text = examSchedule.time
    }

    override fun getItemCount(): Int {
        return examScheduleList.size
    }

    class ExamScheduleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val subjectTextView: TextView = itemView.findViewById(R.id.subjectTextView)
        val dateTextView: TextView = itemView.findViewById(R.id.dateTextView)
        val timeTextView: TextView = itemView.findViewById(R.id.timeTextView)
    }
}
