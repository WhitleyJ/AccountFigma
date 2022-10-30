package com.account.accountfigma.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.account.accountfigma.databinding.FragmentPeopleBinding
import com.account.accountfigma.domain.model.User
import com.account.accountfigma.presentation.adapters.PeopleAdapter
import com.account.accountfigma.presentation.viewmodels.ListViewModel


class PeopleFragment : Fragment() {

    private lateinit var adapterUser: PeopleAdapter

    private val binding by lazy {
        FragmentPeopleBinding.inflate(layoutInflater)
    }
    private val viewModel by lazy {
        ViewModelProvider(this)[ListViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView() {
        adapterUser = PeopleAdapter()
        binding.recyclerPeople.adapter = adapterUser
    }

    private fun initViewModel() {
        with(viewModel) {
            userList.observe(viewLifecycleOwner) {
                adapterUser.setData(it)
                Log.d("userList", it.toString() )
            }
            getUserList()
        }
        adapterUser.onClick = {
            viewModel.changeEnableState(it)
            Log.d("enableState", it.toString())
        }
    }
}