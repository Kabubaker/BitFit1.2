package com.example.bitfit1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SleepAdapter(private val sleepInfo: MutableList<DisplaySleepData>):RecyclerView.Adapter<SleepAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val HoursTV: TextView
        val TypeTV: TextView
        val FeelingTV: TextView
        val ReasonTV: TextView

        init {
            HoursTV = itemView.findViewById(R.id.hoursTV)
            TypeTV = itemView.findViewById(R.id.typeTV)
            FeelingTV = itemView.findViewById(R.id.feelingTV)
            ReasonTV = itemView.findViewById(R.id.reasonTV)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.sleep_list,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return sleepInfo.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val items = sleepInfo[position]

        holder.HoursTV.text = items.hoursSleep.toString()
        holder.TypeTV.text = items.typeSleep
        holder.FeelingTV.text = items.feelingSleep
        holder.ReasonTV.text = items.reasonSleep
    }


}