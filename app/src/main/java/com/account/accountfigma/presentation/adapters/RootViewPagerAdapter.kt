package com.account.accountfigma.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.account.accountfigma.presentation.fragments.AccountFragment
import com.account.accountfigma.presentation.fragments.PeopleFragment
import javax.inject.Inject

class RootViewPagerAdapter @Inject constructor(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PeopleFragment()
            1 -> PeopleFragment()
            2 -> PeopleFragment()
            else -> PeopleFragment()
        }
    }
}