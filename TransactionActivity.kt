package com.example.mycagnotte

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class TransactionActivity : AppCompatActivity() {

    private var ghislaineWallet = 500
    private val maxDeposit = 1000
    private val maxDebt = -300

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction)

        val totalBalanceTextView = findViewById<TextView>(R.id.wallet_balance)
        totalBalanceTextView.text = "Pot commun : $ghislaineWallet€"

        val ghislaineBalanceTextView = findViewById<TextView>(R.id.ghislaine_balance)
        ghislaineBalanceTextView.text = "Ghislaine ($ghislaineWallet€)"

        val depositButton = findViewById<Button>(R.id.deposit_button)
        depositButton.setOnClickListener {
            depositMoney(totalBalanceTextView, ghislaineBalanceTextView, 50)
        }

        val withdrawButton = findViewById<Button>(R.id.withdraw_button)
        withdrawButton.setOnClickListener {
            withdrawMoney(totalBalanceTextView, ghislaineBalanceTextView, 50)
        }
    }

    private fun depositMoney(totalBalanceTextView: TextView, ghislaineBalanceTextView: TextView, amount: Int) {
        if (ghislaineWallet + amount > maxDeposit) {
            // Dépassement de la limite de dépôt
            // Afficher un message d'erreur ou prendre une action appropriée
            return
        }

        ghislaineWallet += amount

        totalBalanceTextView.text = "Pot commun : $ghislaineWallet€"
        ghislaineBalanceTextView.text = "Ghislaine ($ghislaineWallet€)"
    }

    private fun withdrawMoney(totalBalanceTextView: TextView, ghislaineBalanceTextView: TextView, amount: Int) {
        if (ghislaineWallet - amount < maxDebt) {
            // Dépassement de la limite de dette
            // Afficher un message d'erreur ou prendre une action appropriée
            return
        }

        ghislaineWallet -= amount

        totalBalanceTextView.text = "Pot commun : $ghislaineWallet€"
        ghislaineBalanceTextView.text = "Ghislaine ($ghislaineWallet€)"
    }
}


