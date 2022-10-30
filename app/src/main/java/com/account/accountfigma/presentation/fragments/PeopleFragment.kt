package com.account.accountfigma.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.account.accountfigma.App
import com.account.accountfigma.databinding.FragmentPeopleBinding
import com.account.accountfigma.presentation.adapters.PeopleAdapter
import com.account.accountfigma.presentation.viewmodels.ListViewModel
import com.account.accountfigma.presentation.viewmodels.ViewModelFactory
import javax.inject.Inject


class PeopleFragment : Fragment() {

    private lateinit var adapterUser: PeopleAdapter

    private val binding by lazy {
        FragmentPeopleBinding.inflate(layoutInflater)
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[ListViewModel::class.java]
    }

    private val component by lazy {
        (requireActivity().application as App).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
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
        popBackStack()
    }

    private fun initRecyclerView() {
        adapterUser = PeopleAdapter()
        binding.recyclerPeople.apply {
            adapter = adapterUser
        }
    }

    private fun initViewModel() {
        with(viewModel) {
            userList.observe(viewLifecycleOwner) {
                adapterUser.setData(it)
            }
        }
        adapterUser.onClick = {
            viewModel.changeEnableState(it)
        }
    }

    private fun popBackStack() {
        binding.toolbarUser.toolbarPeople.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }
}