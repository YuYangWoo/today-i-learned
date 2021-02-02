package com.cookandroid.navdrawer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs

class ThirdFragment : Fragment() {
    val args: ThirdFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_third, container, false)

        var tMsg = args.msg
        Toast.makeText(context, tMsg,Toast.LENGTH_LONG).show()
        return view
    }

}