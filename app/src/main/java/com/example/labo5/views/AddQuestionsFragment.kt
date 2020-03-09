package com.example.labo5.views


import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.labo5.viewmodels.QuestionsViewModel
import com.example.labo5.R
import com.example.labo5.dataBase.Question
import com.example.labo5.databinding.FragmentAddQuestionsBinding
import kotlinx.android.synthetic.main.fragment_add_questions.*

/**
 * A simple [Fragment] subclass.
 */
class AddQuestionsFragment : Fragment() {
    private lateinit var binding: FragmentAddQuestionsBinding
    private lateinit var viewModelQuestion: QuestionsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_add_questions, container, false)
        //Keyboard
        getActivity()?.getWindow()?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

        //Spinner values
        val spinner: Spinner = binding.spinnerQuestionType
        val myAdapter = ArrayAdapter<String>(context!!, android.R.layout.simple_list_item_1, resources.getStringArray(R.array.types))
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = myAdapter

        //DAO
        viewModelQuestion = ViewModelProvider(activity!!).get(QuestionsViewModel::class.java)



        //Menu
        setHasOptionsMenu(true)


        return binding.root
    }
    //Menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.save_question, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        //Get question from edit text
        val lastQuestion = EditTextNewQuestion.getText().toString()
        //Get type of question on spinner
        val typeQuestion = spinnerQuestionType.getSelectedItem().toString()
        //Set new question
        if (item.itemId == R.id.saveQuestion){
            viewModelQuestion.addQuestion(lastQuestion)
            //Insert question
            Question(lastQuestion, typeQuestion,false)

            Toast.makeText(activity, "$lastQuestion was added", Toast.LENGTH_SHORT).show()
            EditTextNewQuestion.getText().clear()
        }


        return NavigationUI.onNavDestinationSelected(item, view!!.findNavController())
    }

}
