package com.account.accountfigma.presentation.fragments.people

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.account.accountfigma.R
import com.account.accountfigma.databinding.FragmentRootBinding
import com.account.accountfigma.presentation.adapters.people.RootViewPagerAdapter
import com.account.accountfigma.presentation.viewmodels.ListViewModel
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RootFragment : Fragment() {

    private var ctx: Context? = null

    private val binding by lazy {
        FragmentRootBinding.inflate(layoutInflater)
    }
    private val viewModel: ListViewModel by activityViewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ctx = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        popBackStack()
        initViewPager()


        return binding.root
    }

    private fun initViewPager() {
        with(binding) {
            val searchView = binding.toolbarUser.toolbarPeople.menu.findItem(R.id.search).actionView as SearchView
            viewPager.adapter = RootViewPagerAdapter(ctx as FragmentActivity)
            tabLayout.tabIconTint = null
            TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, pos ->
                when (pos) {
                    0 -> tab.text = getString(R.string.subscribers)
                    1 -> tab.text = getString(R.string.subscriptions)
                    2 -> tab.text = getString(R.string.mutually)
                }
            }.attach()
            initSearchView(searchView)
        }
    }
    private fun initSearchView(searchView: SearchView) {
        searchView.queryHint = "Поиск"
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(newText: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    viewModel.setQuery(newText)
                }
                return false
            }
        })
    }

    private fun popBackStack() {
        binding.toolbarUser.toolbarPeople.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }
}