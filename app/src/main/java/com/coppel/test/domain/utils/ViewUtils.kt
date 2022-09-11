package com.coppel.test.domain.utils

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.coppel.test.R

object ViewUtils {
    fun buildProgressDialog(inflater: LayoutInflater, context: Context): AlertDialog {
        val dialogView: View = inflater.inflate(R.layout.dialog_progress, null)

        val progressDialog = AlertDialog.Builder(context).apply {
            setView(dialogView)
            setCancelable(false)
        }.create()
        progressDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return progressDialog
    }
}