package com.jef4tech.godmercy.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jef4tech.godmercy.databinding.PrayeradapterBinding
import com.jef4tech.godmercy.model.Prayer
import com.jef4tech.godmercy.model.PrayerSet

class PrayerAdapter():RecyclerView.Adapter<PrayerAdapter.PrayersViewHolder>() {
    private val prayerList = ArrayList<Prayer>()
    inner class PrayersViewHolder(val custombind:PrayeradapterBinding): RecyclerView.ViewHolder
        (custombind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrayersViewHolder {
        val itemBinding =   PrayeradapterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PrayersViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: PrayersViewHolder, position: Int) {
        val current=prayerList[position]
        holder.custombind.textView.text=current.img
    }

    override fun getItemCount(): Int {
        return prayerList.size
    }

    fun setList(it: PrayerSet) {
        prayerList.clear()
        prayerList.addAll(it.prayers)
    }
}