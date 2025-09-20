package com.example.lab_week_04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class DetailFragment : Fragment() {
    private var titleResId: Int = 0
    private var descriptionResId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            titleResId = it.getInt(ARG_TITLE_RES_ID)
            descriptionResId = it.getInt(ARG_DESCRIPTION_RES_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val titleTextView = view.findViewById<TextView>(R.id.coffee_title)
        val descriptionTextView = view.findViewById<TextView>(R.id.coffee_desc)

        if (titleResId != 0) {
            titleTextView.text = getString(titleResId)
        } else {
            titleTextView.text = "No Title"
        }

        if (descriptionResId != 0) {
            descriptionTextView.text = getString(descriptionResId)
        } else {
            descriptionTextView.text = "No Description"
        }
    }

    companion object {
        private const val ARG_TITLE_RES_ID = "title_res_id"
        private const val ARG_DESCRIPTION_RES_ID = "description_res_id"

        @JvmStatic
        fun newInstance(titleResId: Int, descriptionResId: Int) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_TITLE_RES_ID, titleResId)
                    putInt(ARG_DESCRIPTION_RES_ID, descriptionResId)
                }
            }
    }
}