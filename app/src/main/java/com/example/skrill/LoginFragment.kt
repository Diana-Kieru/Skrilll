package com.example.skrill

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class LoginFragment : Fragment() {

    private var currentPin = ""
    private val maxPinLength = 4

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupClickListeners()
        updatePinDots()
        
        // Make the PIN entry section clickable for testing
        setupPinSectionClick()
    }

    private fun setupClickListeners() {
        // Number keypad click listeners
        for (i in 0..9) {
            val numberId = when (i) {
                0 -> R.id.number_0
                else -> resources.getIdentifier("number_$i", "id", requireContext().packageName)
            }
            
            view?.findViewById<TextView>(numberId)?.setOnClickListener {
                onNumberClicked(i.toString())
            }
        }

        // Backspace button
        view?.findViewById<View>(R.id.backspace_button)?.setOnClickListener {
            onBackspaceClicked()
        }

        // Fingerprint button
        view?.findViewById<View>(R.id.fingerprint_button)?.setOnClickListener {
            onFingerprintClicked()
        }

        // Cancel button in fingerprint dialog
        view?.findViewById<TextView>(R.id.cancel_button)?.setOnClickListener {
            hideFingerprintDialog()
        }

        // Account selector
        view?.findViewById<View>(R.id.account_selector)?.setOnClickListener {
            onAccountSelectorClicked()
        }
    }

    private fun onNumberClicked(number: String) {
        if (currentPin.length < maxPinLength) {
            currentPin += number
            updatePinDots()
            
            if (currentPin.length == maxPinLength) {
                validatePin()
            }
        }
    }

    private fun onBackspaceClicked() {
        if (currentPin.isNotEmpty()) {
            currentPin = currentPin.dropLast(1)
            updatePinDots()
        }
    }

    private fun onFingerprintClicked() {
        showFingerprintDialog()
    }

    private fun onAccountSelectorClicked() {
        // Handle account selection
        Toast.makeText(context, "Account selector clicked", Toast.LENGTH_SHORT).show()
    }

    private fun updatePinDots() {
        // Update PIN dots to show filled/empty state
        for (i in 0 until maxPinLength) {
            val dotId = resources.getIdentifier("pin_dot_$i", "id", requireContext().packageName)
            val dot = view?.findViewById<View>(dotId)
            
            dot?.background = if (i < currentPin.length) {
                resources.getDrawable(R.drawable.pin_dot_filled, null)
            } else {
                resources.getDrawable(R.drawable.pin_dot_empty, null)
            }
        }
    }

    private fun validatePin() {
        // Here you would implement your PIN validation logic
        // For now, we'll just show a success message
        if (currentPin == "1234") { // Example PIN
            Toast.makeText(context, "PIN validated successfully!", Toast.LENGTH_SHORT).show()
            // Navigate to main app or perform login action
            (activity as? MainActivity)?.navigateToDashboard()
        } else {
            Toast.makeText(context, "Invalid PIN. Please try again.", Toast.LENGTH_SHORT).show()
            currentPin = ""
            updatePinDots()
        }
    }

    private fun showFingerprintDialog() {
        view?.findViewById<View>(R.id.fingerprint_dialog)?.visibility = View.VISIBLE
    }

    private fun hideFingerprintDialog() {
        view?.findViewById<View>(R.id.fingerprint_dialog)?.visibility = View.GONE
    }
    
    private fun setupPinSectionClick() {
        // Make the entire PIN entry section clickable for testing
        view?.findViewById<LinearLayout>(R.id.pin_entry_section)?.setOnClickListener {
            // For testing: directly navigate to dashboard
            Toast.makeText(context, "Login successful! Navigating to dashboard...", Toast.LENGTH_SHORT).show()
            (activity as? MainActivity)?.navigateToDashboard()
        }
    }
}
