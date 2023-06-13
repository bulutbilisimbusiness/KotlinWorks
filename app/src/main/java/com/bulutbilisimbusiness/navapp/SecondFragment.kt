package com.bulutbilisimbusiness.navapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs

class SecondFragment : Fragment() {

    private var myAge = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView = view.findViewById<TextView>(R.id.age_text_view)
        val args: SecondFragmentArgs by navArgs()
        arguments?.let {
            myAge = SecondFragmentArgs.fromBundle(it).age
            println(myAge)
        }

        val button=view.findViewById<Button>(R.id.second_fragment_button)
        button.setOnClickListener {
            val action = SecondFragmentDirections.actionSecondFragmentToFirstFragment()
            Navigation.findNavController(it).navigate(action)
        }
        textView.text = "Age: ${args.age}"
    }
}