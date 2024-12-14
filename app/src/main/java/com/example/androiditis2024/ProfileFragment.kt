package com.example.androiditis2024

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androiditis2024.databinding.FragmentPofileBinding


class ProfileFragment : Fragment() {

    private var profilebinding: FragmentPofileBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pofile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profilebinding =  FragmentPofileBinding.bind(view)


//        findNavController().navigate(R.id.action_profileFragment_to_homeFragment, HomeFragment.bundleArgs(true))

//        profilebinding?.text?.setOnClickListener{
//            Toast.makeText(requireContext(), "HELLO", Toast.LENGTH_LONG).show()
//        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        profilebinding = null
    }

    companion object {

    }
}