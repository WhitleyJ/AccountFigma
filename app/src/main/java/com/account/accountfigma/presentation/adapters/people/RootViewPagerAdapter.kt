package com.account.accountfigma.presentation.adapters.people

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.account.accountfigma.presentation.fragments.people.MutuallyFragment
import com.account.accountfigma.presentation.fragments.people.PeopleFragment
import com.account.accountfigma.presentation.fragments.people.SubscriberFragment

class RootViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PeopleFragment()
            1 -> SubscriberFragment()
            2 -> MutuallyFragment()
            else -> {
                throw RuntimeException("not found fragment")
            }
        }
    }
}