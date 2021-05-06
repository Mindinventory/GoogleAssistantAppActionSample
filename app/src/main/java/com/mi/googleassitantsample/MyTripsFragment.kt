package com.mi.googleassitantsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.mi.googleassitantsample.databinding.FragmentMyTripsBinding

class MyTripsFragment : Fragment() {

    private lateinit var binding: FragmentMyTripsBinding

    private val args by navArgs<MyTripsFragmentArgs>()

    private val adapter by lazy {
        MyTripsAdapter(mutableListOf())
    }

    private val upcomingListData = mutableListOf(
        TripModal("Kerala to Delhi", "22th May 2021"),
        TripModal("Pondicherry to Assam", "5th September 2021"),
        TripModal("Bombay to Ahmadabad", "25th November 2021")
    )


    private val ongoingListData = mutableListOf(
        TripModal("Ahmadabad to Delhi", "3rd May 2021"),
    )

    private val completedListData = mutableListOf(
        TripModal("Delhi to Assam", "5th May 2020"),
        TripModal("Ahmadabad to Assam", "25th September 2020"),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyTripsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvTrips.adapter = adapter
        when (args.tripType) {
            TripsType.UPCOMING_TRIPS.value -> {
                setUpcomingTripData()
            }
            TripsType.ONGOING_TRIPS.value -> {
                setOngoingTripData()
            }
            TripsType.COMPLETED_TRIPS.value -> {
                setCompletedTripData()
            }
            else -> {
                setUpcomingTripData()
            }
        }
        handlePathParameterFromDeepLink()
    }

    private fun handlePathParameterFromDeepLink() {
        if (!activity?.intent?.data?.path.isNullOrEmpty()) {
            when (TripsType.find(activity?.intent?.data?.path)) {
                TripsType.UPCOMING_TRIPS -> {
                    setUpcomingTripData()
                }
                TripsType.ONGOING_TRIPS -> {
                    setOngoingTripData()
                }
                TripsType.COMPLETED_TRIPS -> {
                    setCompletedTripData()
                }
            }
            activity?.intent?.data = null
        }
    }

    private fun setUpcomingTripData() {
        binding.toolbar.title = getString(R.string.upcoming_trips)
        adapter.setItems(upcomingListData)
    }

    private fun setOngoingTripData() {
        binding.toolbar.title = getString(R.string.ongoing_trips)
        adapter.setItems(ongoingListData)
    }

    private fun setCompletedTripData() {
        binding.toolbar.title = getString(R.string.completed_trips)
        adapter.setItems(completedListData)
    }

}