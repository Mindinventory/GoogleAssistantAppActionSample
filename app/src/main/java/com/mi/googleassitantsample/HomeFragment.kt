package com.mi.googleassitantsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mi.googleassitantsample.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnUpcomingTrips.setOnClickListener(this)
        binding.btnCompletedTrips.setOnClickListener(this)
        binding.btnOnGoingTrips.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.btnUpcomingTrips.id -> {
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToMyTripsFragment(
                        TripsType.UPCOMING_TRIPS.value
                    )
                )
            }
            binding.btnCompletedTrips.id -> {
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToMyTripsFragment(
                        TripsType.COMPLETED_TRIPS.value
                    )
                )
            }
            binding.btnOnGoingTrips.id -> {
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToMyTripsFragment(
                        TripsType.ONGOING_TRIPS.value
                    )
                )
            }
            else -> {
            }
        }
    }

}