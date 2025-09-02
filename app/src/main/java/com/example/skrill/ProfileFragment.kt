package com.example.skrill

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Switch
import android.widget.TextView
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupViews(view)
        setupClickListeners(view)
    }

    private fun setupViews(view: View) {
        // Initialize views if needed
        val profileImage = view.findViewById<ImageView>(R.id.profileImage)
        val userName = view.findViewById<TextView>(R.id.userName)
        val customerId = view.findViewById<TextView>(R.id.customerId)
        val skillerBadge = view.findViewById<TextView>(R.id.skillerBadge)
        val biometricsSwitch = view.findViewById<Switch>(R.id.biometricsSwitch)
        val notificationsSwitch = view.findViewById<Switch>(R.id.notificationsSwitch)
    }

    private fun setupClickListeners(view: View) {
        // Back button click listener
        view.findViewById<ImageView>(R.id.backButton).setOnClickListener {
            // Navigate to homepage
            (activity as? MainActivity)?.navigateToHome()
        }

        // Menu item click listeners
        view.findViewById<LinearLayout>(R.id.verificationItem).setOnClickListener {
            // Handle verification and features click
        }

        view.findViewById<LinearLayout>(R.id.paymentControlsItem).setOnClickListener {
            // Handle payment controls click
        }

        view.findViewById<LinearLayout>(R.id.skillLevelsItem).setOnClickListener {
            // Handle skill levels click
        }

        view.findViewById<LinearLayout>(R.id.themeModeItem).setOnClickListener {
            // Handle theme mode click
        }

        view.findViewById<LinearLayout>(R.id.personalDetailsItem).setOnClickListener {
            // Handle personal details click
        }

        view.findViewById<LinearLayout>(R.id.helpCenterItem).setOnClickListener {
            // Handle help center click
        }

        // Switch change listeners
        view.findViewById<Switch>(R.id.biometricsSwitch).setOnCheckedChangeListener { _, isChecked ->
            // Handle biometrics switch change
        }

        view.findViewById<Switch>(R.id.notificationsSwitch).setOnCheckedChangeListener { _, isChecked ->
            // Handle notifications switch change
        }
    }
}
