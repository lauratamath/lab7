package com.example.labo5.views


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.ButterKnife

import com.example.labo5.R
import com.example.labo5.dataBase.Answer
import com.example.labo5.dataBase.SurveyDataBase
import com.example.labo5.databinding.FragmentSeeResultsBinding
import com.example.labo5.recycler.SurveyAdapter
import com.example.labo5.recycler.TopSpacingItemDecoration
import com.example.labo5.viewmodels.QuestionsViewModel
import kotlinx.android.synthetic.main.fragment_see_results.*

/**
 * A simple [Fragment] subclass.
 */
class SeeResultsFragment : Fragment() {
    private lateinit var binding: FragmentSeeResultsBinding
    private lateinit var answerAdapter: SurveyAdapter



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_see_results, container, false)
        //Calling db
        val db = SurveyDataBase(context!!)
        val answers = db.getDataAdded() //Getting list

        //Recycler View
        ButterKnife.bind(activity!!)
        val recycler = binding.RecyclerViewSeeResults

        Log.d("tamano data", answers.size.toString())

        recycler.apply {
            layoutManager = LinearLayoutManager(this.context!!)
            val topSpacingDecorator = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingDecorator)
            answerAdapter = SurveyAdapter()
            adapter = answerAdapter
            answerAdapter.submitList(answers)

        }




        return binding.root
    }

}
