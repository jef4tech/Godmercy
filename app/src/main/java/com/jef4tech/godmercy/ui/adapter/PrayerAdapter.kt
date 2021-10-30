package com.jef4tech.godmercy.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jef4tech.godmercy.databinding.PrayeradapterBinding
import com.jef4tech.godmercy.model.Prayer
import com.jef4tech.godmercy.model.PrayerSet
import com.jef4tech.godmercy.utils.sample.Extensions

class PrayerAdapter(private val listener: (position: String) -> Unit) :RecyclerView.Adapter<PrayerAdapter.PrayersViewHolder>() {
    private val prayerList = ArrayList<Prayer>()
    inner class PrayersViewHolder(val custombind:PrayeradapterBinding): RecyclerView.ViewHolder
        (custombind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrayersViewHolder {
        val itemBinding =   PrayeradapterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PrayersViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: PrayersViewHolder, position: Int) {
        val current=prayerList[position]
        holder.custombind.placeNameTextView.text=current.prayer
//        Glide.with(holder.custombind.imageView.context).load(current.img).fitCenter().into(holder.custombind.imageView)
        Extensions.loadImagefromUrl(holder.custombind.placeImageView.context,holder.custombind.placeImageView,current.img)
        holder.custombind.placeImageView.setOnClickListener {
            listener.invoke(current.prayer)
        }
    }

    override fun getItemCount(): Int {
        return prayerList.size
    }

    fun setList(it: PrayerSet) {
        prayerList.clear()
        prayerList.addAll(it.prayers)
    }
}