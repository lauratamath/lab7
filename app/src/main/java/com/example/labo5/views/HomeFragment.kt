package com.example.labo5.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.labo5.R
import com.example.labo5.databinding.FragmentHomeBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_home, container, false)

        binding.fab.setOnClickListener {
            view!!.findNavController().navigate(R.id.addQuestionFragment)
        }
        //Keyboard
        getActivity()?.getWindow()?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

        binding.buttonStartSurvey.setOnClickListener{
            startSurvey()
        }


        return binding.root
    }
    //Show questions
    private fun startSurvey(){
        view!!.findNavController().navigate(R.id.action_nav_home_to_answersFragment)
    }
}