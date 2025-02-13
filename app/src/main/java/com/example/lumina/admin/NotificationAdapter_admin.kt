package com.example.lumina.admin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lumina.R

class NotificationAdapterAdmin(
    private val notificationList: List<NotificationItemViewsAdmin>
) : RecyclerView.Adapter<NotificationAdapterAdmin.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.notification_item_views_admin, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val notification = notificationList[position]
        holder.title.text = notification.title
        holder.body.text = notification.body
        holder.time.text = notification.timestamp
    }

    override fun getItemCount(): Int {
        return notificationList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.notification_title)
        val body: TextView = itemView.findViewById(R.id.notification_body)
        val time: TextView = itemView.findViewById(R.id.notification_timestamp)
    }
}
