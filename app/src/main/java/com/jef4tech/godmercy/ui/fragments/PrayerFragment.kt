package com.jef4tech.godmercy.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jef4tech.godmercy.R

class PrayerFragment : Fragment() {

    companion object {
        fun newInstance() = PrayerFragment()
    }

    private lateinit var viewModel: PrayerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_prayer, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PrayerViewModel::class.java)
        // TODO: Use the ViewModel
    }

}