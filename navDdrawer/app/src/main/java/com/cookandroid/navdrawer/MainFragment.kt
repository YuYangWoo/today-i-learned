package com.cookandroid.navdrawer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_main, container, false)
        view.findViewById<Button>(R.id.btnGo).setOnClickListener {
          var action =  MainFragmentDirections.actionMainToThirdFragment("빠끄")
            findNavController().navigate(action)
        }
        return view
    }
}