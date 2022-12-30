package com.flow.tn.testapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import com.flow.tn.testapplication.R
import com.flow.tn.testapplication.databinding.BottomSheetModifierBinding
import com.flow.tn.testapplication.utils.RoundedBottomSheetDialogFragment

class ModifierBottomSheet : RoundedBottomSheetDialogFragment() {


    private var onClickListener: OnClickListener? = null

    interface OnClickListener {
        fun onClickListener(index: String)

    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }




    private lateinit var mBinding: BottomSheetModifierBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.bottom_sheet_modifier,
                container,
                false
        )
        val view = mBinding.root


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.btnConfirmer.setOnClickListener {
            onClickListener?.onClickListener(mBinding.textFr.text.toString())
            dismiss()
        }

    }

    fun show(fragmentManager: FragmentManager) {
        super.show(fragmentManager, TAG)
    }

    companion object {

        val TAG = ModifierBottomSheet::class.java.simpleName
        fun newInstance(): ModifierBottomSheet {
            val fragment = ModifierBottomSheet()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }

    }


}