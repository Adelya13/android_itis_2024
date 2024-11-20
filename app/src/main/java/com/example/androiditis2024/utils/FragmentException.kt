package com.example.androiditis2024.utils

import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

typealias DialogClick =  () -> Unit

fun Fragment.showDialog(
    title: String,
    message: String,
    positiveTitle: String? = null,
    negativeTitle: String? = null,
    neutralTitle: String? = null,
    positiveAction: DialogClick = {},
    negativeAction: DialogClick = {},
    neutralAction: DialogClick = {},
) {
    AlertDialog.Builder(requireContext())
        .setTitle(title)
        .setMessage(message)
        .setPositiveButton(positiveTitle) { dialog, _ ->
            positiveAction.invoke()
        }
        .setNegativeButton(negativeTitle) { dialog, _ ->
            negativeAction.invoke()
        }
        .setNeutralButton(neutralTitle)  { dialog, _ ->
            dialog.dismiss()
            neutralAction.invoke()
        }
        .show()
}