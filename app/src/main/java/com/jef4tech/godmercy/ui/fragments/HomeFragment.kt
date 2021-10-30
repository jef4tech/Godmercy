package com.jef4tech.godmercy.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.jef4tech.godmercy.R
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
        setupUI()
        setupViewModel()

        return root
    }

    private fun setupViewModel() {
        adapter = PrayerAdapter{position -> onClick(position)}
        binding.xyz.layoutManager= LinearLayoutManager(activity)
        binding.xyz.adapter=adapter
    }

    private fun onClick(position: String) {
//        Toast.makeText(context,position,Toast.LENGTH_SHORT).show()
        view?.let { Navigation.findNavController(it).navigate(R.id.action_navigation_home_to_prayerFragment) };
    }

    private fun setupUI() {
        binding.pBar.visibility=View.INVISIBLE
        homeViewModel.getPrayers().observe(viewLifecycleOwner, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}