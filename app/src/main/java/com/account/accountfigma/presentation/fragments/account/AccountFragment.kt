package com.account.accountfigma.presentation.fragments.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getColorStateList
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.account.accountfigma.R
import com.account.accountfigma.databinding.FragmentAccountBinding
import com.account.accountfigma.presentation.adapters.account.ChroniclesAdapter
import com.account.accountfigma.presentation.adapters.account.MomentsAdapter
import com.account.accountfigma.presentation.adapters.account.ProfileAdapter


class AccountFragment : Fragment() {

    private val binding by lazy {
        FragmentAccountBinding.inflate(layoutInflater)
    }

    private var adapterPhoto = ProfileAdapter(listOf(1,2,3,4))
    private var adapterMoment = MomentsAdapter(listOf(1,2,3,4,5,6))
    private var adapterChronicles = ChroniclesAdapter(listOf(1,2,3,4,5,6,7,8,9,10,11,12))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapters()
        changeColorCounter()
        binding.buttonPeople.setOnClickListener {
            launchPeopleFragment()
        }
    }

    private fun initAdapters() {
        binding.apply {
            recyclerView.adapter = adapterPhoto
            recyclerMoments.adapter = adapterMoment
            recyclerChronicles.adapter = adapterChronicles
        }
    }

    private fun changeColorCounter() {
        binding.textEdit.onFocusChangeListener = View.OnFocusChangeListener { _, isActive ->
            if (isActive) {
                binding.textInputLayout.counterTextColor =
                    getColorStateList(requireContext(), R.color.violet)
            } else {
                binding.textInputLayout.counterTextColor =
                    getColorStateList(requireContext(), R.color.white_60)
            }
        }
    }

    private fun launchPeopleFragment() {
        findNavController().navigate(R.id.action_accountFragment_to_rootFragment)
    }
}