package com.cookandroid.navcontroller

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(context, "dd", Toast.LENGTH_SHORT).show()
        button.setOnClickListener {
//            view.findNavController().navigate(R.id.action_mainFragment_to_secondFragment)
//
//            var action = MainFragmentDirections.actionMainFragmentToSecondFragment(5)
//            view.findNavController().navigate(action)
            var ab = "SetMesage"
            var b = "빠끄"
            var action = MainFragmentDirections.actionMainFragmentToSecondFragment(ab,b)
            view.findNavController().navigate(action)
        }
    }
}