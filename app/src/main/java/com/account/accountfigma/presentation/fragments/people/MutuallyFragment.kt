package com.account.accountfigma.presentation.fragments.people

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.account.accountfigma.databinding.FragmentMutuallyBinding
import com.account.accountfigma.presentation.adapters.people.PeopleAdapter
import com.account.accountfigma.presentation.viewmodels.ListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MutuallyFragment: Fragment() {

    lateinit var adapterMutually: PeopleAdapter

    private val binding by lazy {
        FragmentMutuallyBinding.inflate(layoutInflater)
    }

    private val viewModel: ListViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
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
    }

    private fun initRecyclerView() {
        adapterMutually = PeopleAdapter()
        binding.recyclerMutually.apply {
            adapter = adapterMutually
        }
        initViewModel()
    }

    private fun initViewModel() {

        with(viewModel) {
            adapterMutually.onClick = {
                viewModel.changeEnableState(it)
            }
            userList.observe(viewLifecycleOwner) {
                adapterMutually.modifyList(it)

            }
            getQuery().observe(viewLifecycleOwner) {
                adapterMutually.filter(it)
            }
        }
    }
}
