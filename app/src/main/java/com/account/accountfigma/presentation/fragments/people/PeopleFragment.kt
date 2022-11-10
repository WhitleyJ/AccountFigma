package com.account.accountfigma.presentation.fragments.people

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.account.accountfigma.databinding.FragmentPeopleBinding
import com.account.accountfigma.presentation.adapters.people.PeopleAdapter
import com.account.accountfigma.presentation.viewmodels.ListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleFragment : Fragment() {

    lateinit var adapterUser: PeopleAdapter

    private val binding by lazy {
        FragmentPeopleBinding.inflate(layoutInflater)
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
                val newList = it.filter { it.subscribed }
                adapterUser.modifyList(newList)
            }
            getQuery().observe(viewLifecycleOwner) {
                adapterUser.filter(it)
            }
        }
    }
}














// Dagger
//private val component by lazy {
//    (requireActivity().application as App).component
//}
//
//override fun onAttach(context: Context) {
//    component.inject(this)
//    super.onAttach(context)
//}
//
////    @Inject
////    lateinit var viewModelFactory: ViewModelFactory
////
////    private val viewModel by lazy {
////        ViewModelProvider(this,viewModelFactory)[ListViewModel::class.java]
////    }
