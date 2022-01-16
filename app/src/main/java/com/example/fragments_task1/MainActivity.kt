package com.example.fragments_task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragments_task1.fragment.FirstFragment
import com.example.fragments_task1.fragment.SecondFragment

class MainActivity : AppCompatActivity(), FirstFragment.FirstListener,
    SecondFragment.SecondListener {
    private lateinit var firstFragment: FirstFragment
    private lateinit var secondFragment: SecondFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    override fun onFirstSend(string: String) {
        secondFragment.updateSecondText(string)
    }

    override fun onSecondSend(string: String) {
        firstFragment.updateFirstText(string)
    }

    private fun initViews() {
        firstFragment = FirstFragment()
        secondFragment = SecondFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameFirst, firstFragment)
            .replace(R.id.frameSecond, secondFragment)
            .commit()
    }
}