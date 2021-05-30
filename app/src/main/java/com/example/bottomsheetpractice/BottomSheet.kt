package com.example.bottomsheetpractice

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheet(var array: Array<String>) : BottomSheetDialogFragment(){
    private var listener: BottomSheetListener? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.bottom_sheet_layout, container, false)
        var button1 = v.findViewById<Button>(R.id.button2)
        var button2 = v.findViewById<Button>(R.id.button3)

        button1.setOnClickListener {
            listener?.buttonClicked("Val1")
            dismiss()
        }
        button2.setOnClickListener {
            listener?.buttonClicked("Val2")
            dismiss()

        }
        val rv_tV = v.findViewById<RecyclerView>(R.id.rv_tV)
        rv_tV.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(v.context, LinearLayoutManager.VERTICAL, false)
            itemAnimator = null
            adapter = DummyAdapter(array) {
                listener?.buttonClicked(it)
                dismiss()
            }
        }
        return v
    }

    interface BottomSheetListener {
        fun buttonClicked(text: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {

            listener = context as BottomSheetListener
        } catch (e: Exception) {
            throw ClassCastException(context.toString() + "must implement BottomSheet")
        }
    }

}