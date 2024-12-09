package com.example.androiditis2024

import android.os.Bundle
import android.os.Message
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.example.androiditis2024.databinding.FragmentHomeBinding
import com.example.androiditis2024.utils.showDialog
import com.google.android.material.bottomsheet.BottomSheetDialog


class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val message = arguments?.getString(ARG_KEY)?: "NO ARGS"

        binding = FragmentHomeBinding.bind(view)


        parentFragmentManager.popBackStack()

        binding?.text1?.text = message

        binding?.text1?.setOnClickListener {
            showBottomSheet()
        }
    }


    private fun showBottomSheet(){
        val bottomSheet = BottomSheetDialog(requireContext())
        with(bottomSheet){
            setTitle("Hello")
            setContentView(R.layout.bottomsheet_view)
            show()
        }

    }

    private fun showDialog1(){
        AlertDialog.Builder(requireContext())
            .setTitle("TITLE")
            .setMessage("MESSAGE")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .setNegativeButton("NO") { dialog, _ ->
                dialog.dismiss()
            }
            .setNeutralButton("CAT")  { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    private fun showNewDialog(message: String){
        showDialog(
            title = "HAHAHA",
            message = message,
            positiveTitle = "OK",
            positiveAction = {
                parentFragmentManager
                    .beginTransaction()
                    .setCustomAnimations(
                        android.R.anim.fade_in,
                        android.R.anim.fade_out,
                        android.R.anim.fade_in,
                        android.R.anim.fade_out
                    )
                    .replace(R.id.fragment_container, ProfileFragment())
                    .addToBackStack(HOME_FRAGMENT_TAG)
                    .commit()
            }
        )
    }

    private fun showVerifyDialog(){
        val dialog = VerifyDialog()
        dialog.show(parentFragmentManager, "DIALOG")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object{
        const val HOME_FRAGMENT_TAG = "HomeFragment"
        const val ARG_KEY = "ARG_KEY"

        fun newInstance(arg: String): HomeFragment = HomeFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_KEY, arg)
            }
        }

        fun newInstance1(arg: String) : HomeFragment {
            val bundle = Bundle()
            val fragment = HomeFragment()
            bundle.putString(ARG_KEY, arg)
            fragment.arguments = bundle
            return fragment
        }
    }

}