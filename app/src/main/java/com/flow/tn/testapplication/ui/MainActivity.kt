package com.flow.tn.testapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.flow.tn.testapplication.R
import com.flow.tn.testapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeContentView()

    }

    private fun initializeContentView() {
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            lifecycleOwner = this@MainActivity
        }
        binding.materialCardView2.setOnClickListener {
            modifierRateFragment()
        }
    }

    private fun modifierRateFragment() {
        val mBottomSheetDialog =
                ModifierBottomSheet.newInstance()

        mBottomSheetDialog.setOnClickListener(object :
                ModifierBottomSheet.OnClickListener {
            override fun onClickListener(index: String) {

                    binding.baseRateText.text = index

            }
        })


        mBottomSheetDialog.show(this.supportFragmentManager)
    }

}