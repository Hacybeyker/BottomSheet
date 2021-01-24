package com.hacybeyker.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.hacybeyker.bottomsheet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonBSDialogFragment.setOnClickListener { openBSDialogFragment() }
        binding.buttonBSDialog.setOnClickListener { openBSDialog() }
    }

    private fun openBSDialogFragment() {
        val bsf = BottomSheetFragment(
            themeParameter = R.style.BottomSheetDialogTheme,
            layoutParameter = R.layout.layout_avenger,
            cancelableParameter = true
        ) { dialog ->
            dialog.view?.findViewById<AppCompatImageView>(R.id.avengerImageClose)
                ?.setOnClickListener {
                    dialog.dismiss()
                }
            dialog.view?.findViewById<AppCompatImageView>(R.id.avengerImage)?.setOnClickListener {
                showToast()
            }
        }
        bsf.show(supportFragmentManager, BottomSheetFragment::class.java.name)
    }

    private fun openBSDialog() {
        val bottomSheetDialog = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)
        val bottomSheetView = LayoutInflater.from(this)
            .inflate(R.layout.layout_rating, findViewById(R.id.constraintContainerRating), false)
        bottomSheetView.findViewById<AppCompatImageView>(R.id.ratingImageClose)
            .setOnClickListener { bottomSheetDialog.dismiss() }
        bottomSheetDialog.setCancelable(true)
        bottomSheetDialog.setCanceledOnTouchOutside(false)
        bottomSheetDialog.setContentView(bottomSheetView)
        bottomSheetDialog.show()
    }

    private fun showToast() {
        Toast.makeText(this, "Helouda", Toast.LENGTH_SHORT).show()
    }
}