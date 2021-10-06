package com.jef4tech.godmercy.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jef4tech.godmercy.databinding.FragmentHomeBinding
import com.jef4tech.godmercy.ui.adapter.PrayerAdapter
import com.jef4tech.godmercy.viewModel.HomeViewModel

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private lateinit var adapter: PrayerAdapter
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.xyz.layoutManager= LinearLayoutManager(activity)
        adapter=PrayerAdapter()
        binding.xyz.adapter=adapter
        homeViewModel.getPrayers().observe(viewLifecycleOwner, Observer {
//      val msg=serviceSetterGetter.value

            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
            }

        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}