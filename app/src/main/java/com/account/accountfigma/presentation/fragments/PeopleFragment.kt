package com.account.accountfigma.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.account.accountfigma.databinding.FragmentPeopleBinding
import com.account.accountfigma.presentation.adapters.PeopleAdapter
import com.account.accountfigma.presentation.viewmodels.ListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleFragment : Fragment() {

    private lateinit var adapterUser: PeopleAdapter

    private val binding by lazy {
        FragmentPeopleBinding.inflate(layoutInflater)
    }

    private val viewModel: ListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapterUser = PeopleAdapter()
        binding.recyclerPeople.apply {
            adapter = adapterUser
        }
        initViewModel()
    }

    private fun initViewModel() {

        with(viewModel) {
            adapterUser.onClick = {
                viewModel.changeEnableState(it)
            }
            userList.observe(viewLifecycleOwner) {
                adapterUser.submitList(it)
            }
        }
    }
}