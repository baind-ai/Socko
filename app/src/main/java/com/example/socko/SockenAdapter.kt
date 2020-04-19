package com.example.socko

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.socken_layout.view.*

class SockenAdapter(private val socken: List<Socke>, private val sockeClicked: (i: Int) -> Unit) : RecyclerView.Adapter<SockenAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.socken_layout, parent, false)
        return  ViewHolder(layoutView)
    }

    override fun getItemCount() = socken.size

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val socke = socken[position]
        holder.view.textViewNameSocke.text = "${socke.name} \n $ ${socke.kosten}"
        holder.view.imageView.setImageDrawable(holder.view.context.getDrawable(socke.sockePhoto))
        holder.view.setOnClickListener{
            sockeClicked.invoke(socke.kosten)
        }
    }

    class ViewHolder (val view: View) : RecyclerView.ViewHolder(view)
}