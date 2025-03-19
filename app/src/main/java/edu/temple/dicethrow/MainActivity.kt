package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dieFrag1 = DieFragment.newInstance(12)
        val dieFrag2 = DieFragment.newInstance(20)
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainerView, dieFrag1).add(R.id.fragmentContainerView2, dieFrag2).commit()

        findViewById<Button>(R.id.rollDiceButton).setOnClickListener {
            dieFrag1.throwDie()
            dieFrag2.throwDie()
        }


    }
}