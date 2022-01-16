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

class FirstFragment : Fragment() {

    private var listener: FirstListener? = null
    var tvFirst: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        tvFirst = view.findViewById(R.id.text_first)
        val bFirst = view.findViewById<Button>(R.id.b_first)
        bFirst.setOnClickListener {
            listener!!.onFirstSend("PDP")
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is FirstListener) {
            context
        }else {
            throw RuntimeException("$context must implement FirsListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    fun updateFirstText(string: String) {
        tvFirst!!.text = string
    }

    interface FirstListener {
        fun onFirstSend(string: String)
    }
}