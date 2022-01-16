package com.example.fragments_task1.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.fragments_task1.R
import java.lang.RuntimeException

class SecondFragment : Fragment() {

    private var listener: SecondListener? = null
    var tvSecond: TextView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        tvSecond = view.findViewById(R.id.text_second)
        val btn = view.findViewById<Button>(R.id.b_second)
        btn.setOnClickListener {
            listener!!.onSecondSend("Academy")
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is SecondListener) {
            context
        } else {
            throw RuntimeException("$context must implement SecondListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    fun updateSecondText(string: String) {
        tvSecond!!.text = string
    }

    interface SecondListener {
        fun onSecondSend(string: String)
    }
}