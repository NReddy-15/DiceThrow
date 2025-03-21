package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.random.Random

class DieFragment : Fragment() {

    val DIESIDE = "sidenumber"

    lateinit var dieTextView: TextView

    var dieSides: Int = 6
    private val CURRENT_ROLL_KEY = "current roll"
    private var current_roll = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getInt(DIESIDE).run {
                dieSides = this
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //throwDie()
        savedInstanceState?.run {
            current_roll = getInt(CURRENT_ROLL_KEY, 0)
        }
        if (current_roll == 0) {
            throwDie()
        }
        else {
            throwDie(current_roll)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(CURRENT_ROLL_KEY, current_roll)
    }

    fun throwDie() {
        current_roll = (Random.nextInt(dieSides)+1)
        dieTextView.text = current_roll.toString()
    }

    fun throwDie(num: Int) {
        dieTextView.text = num.toString()
    }
}