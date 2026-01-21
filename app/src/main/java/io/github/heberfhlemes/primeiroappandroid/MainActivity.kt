package io.github.heberfhlemes.primeiroappandroid

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtWelcome = findViewById<TextView>(R.id.txtWelcome)
        txtWelcome.setOnClickListener {
            showNameDialog(txtWelcome)
        }

        val githubIcon = findViewById<ImageView>(R.id.imgGithub)
        githubIcon.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_VIEW,
                "https://github.com/HeberFHLemes/primeiro-app-android".toUri()
            )
            startActivity(intent)
        }

        showNameDialog(txtWelcome)
    }

    private fun showNameDialog(txtWelcome: TextView) {
        val editText = EditText(this)

        AlertDialog.Builder(this)
            .setTitle(getString(R.string.welcome_question))
            .setView(editText)
            .setCancelable(false)
            .setPositiveButton(android.R.string.ok) { _, _ ->
                val nome = editText.text.toString().trim()
                    .ifEmpty { getString(R.string.default_user_name) }

                txtWelcome.text = getString(R.string.welcome_user, nome)
            }
            .show()
    }
}