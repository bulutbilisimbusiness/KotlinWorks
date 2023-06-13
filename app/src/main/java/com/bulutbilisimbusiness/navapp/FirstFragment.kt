package com.bulutbilisimbusiness.navapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.bulutbilisimbusiness.navapp.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentFirstBinding>(inflater, R.layout.fragment_first, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val ageInput = view.findViewById<EditText>(R.id.age_input)
        val button=view.findViewById<Button>(R.id.first_fragment_button)
        button.setOnClickListener {
            val ageString = ageInput.text.toString()
            val age = ageString.toIntOrNull()
            if (age != null) {
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(age)
            //action.age = 5
            Navigation.findNavController(it).navigate(action)
            } else {
                Toast.makeText(context, "Invalid age!", Toast.LENGTH_SHORT).show()
            }
        }

    }



}