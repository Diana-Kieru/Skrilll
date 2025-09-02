package com.example.skrill

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Initialize views and set up click listeners here
        setupClickListeners()
    }

    private fun setupClickListeners() {
        // Add button click listener
        view?.findViewById<View>(R.id.addButton)?.setOnClickListener {
            // Handle add button click
        }

        // Transfer button click listener
        view?.findViewById<View>(R.id.transferButton)?.setOnClickListener {
            // Handle transfer button click
        }

        // Exchange button click listener
        view?.findViewById<View>(R.id.exchangeButton)?.setOnClickListener {
            // Handle exchange button click
        }

        // Profile icon click listener
        view?.findViewById<View>(R.id.profileIcon)?.setOnClickListener {
            // Navigate to ProfileFragment
            (activity as? MainActivity)?.navigateToProfile()
        }

        // Notification icon click listener
        view?.findViewById<View>(R.id.notificationContainer)?.setOnClickListener {
            // Handle notification click
        }

        // Partner cards click listeners
        view?.findViewById<View>(R.id.syndicateCard)?.setOnClickListener {
            // Handle Syndicate card click
        }

        view?.findViewById<View>(R.id.onexbetCard)?.setOnClickListener {
            // Handle 1xBet card click
        }

        // See all transactions click listener
        view?.findViewById<View>(R.id.seeAllTransactions)?.setOnClickListener {
            // Handle see all transactions click
        }

        // Bottom navigation click listeners
        view?.findViewById<View>(R.id.navHome)?.setOnClickListener {
            // Already on home, refresh if needed
            (activity as? MainActivity)?.navigateToHome()
        }

        view?.findViewById<View>(R.id.navCrypto)?.setOnClickListener {
            // Navigate to crypto section (for now, just show a message)
            // You can implement a CryptoFragment later
        }

        view?.findViewById<View>(R.id.navSports)?.setOnClickListener {
            // Navigate to sports section (for now, just show a message)
            // You can implement a SportsFragment later
        }

        view?.findViewById<View>(R.id.navRewards)?.setOnClickListener {
            // Navigate to rewards section (for now, just show a message)
            // You can implement a RewardsFragment later
        }
    }
}
