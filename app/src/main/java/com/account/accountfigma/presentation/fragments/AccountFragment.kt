package com.account.accountfigma.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.account.accountfigma.R
import com.account.accountfigma.databinding.FragmentAccountBinding
import com.account.accountfigma.presentation.adapters.ChroniclesAdapter
import com.account.accountfigma.presentation.adapters.MomentsAdapter
import com.account.accountfigma.presentation.adapters.ProfileAdapter


class AccountFragment : Fragment() {

    private val listPhotos = listOf(1, 2, 3, 4)
    private val listMoments = listOf(1, 2, 3, 4, 5, 6)
    private val listChronicles = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)

    private val binding by lazy {
        FragmentAccountBinding.inflate(layoutInflater)
    }
    private var adapterPhoto = ProfileAdapter(listPhotos)
    private var adapterMoments = MomentsAdapter(listMoments)
    private var adapterChronicles = ChroniclesAdapter(listChronicles)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapters()
        binding.buttonPeople.setOnClickListener {
            launchPeopleFragment()
        }
    }

    private fun initAdapters() {
        binding.apply {
            recyclerView.adapter = adapterPhoto
            recyclerMoments.adapter = adapterMoments
            recyclerChronicles.adapter = adapterChronicles
        }
    }

    private fun launchPeopleFragment() {
        findNavController().navigate(R.id.action_accountFragment_to_peopleFragment)
    }
}