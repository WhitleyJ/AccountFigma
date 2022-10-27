package com.account.accountfigma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.account.accountfigma.adapters.ChroniclesAdapter
import com.account.accountfigma.adapters.MomentsAdapter
import com.account.accountfigma.adapters.ProfileAdapter
import com.account.accountfigma.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var adapterPhoto = ProfileAdapter()
    private var adapterMoments = MomentsAdapter()
    private var adapterChronicles = ChroniclesAdapter()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapters()
    }

    private fun initAdapters() {
        binding.apply {
            recyclerView.adapter = adapterPhoto
            recyclerMoments.adapter = adapterMoments
            recyclerChronicles.adapter = adapterChronicles
        }

    }
}