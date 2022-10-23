package unj.cs.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            val rollFirstDice = rollDice()
            val diceImage: ImageView = findViewById(R.id.imageView)
            diceImage.setImageResource(drawableDice(rollFirstDice))
            diceImage.contentDescription = rollFirstDice.toString()

            val rollSecondDice = rollDice()
            val diceImage2: ImageView = findViewById(R.id.imageView2)
            diceImage2.setImageResource(drawableDice(rollSecondDice))
            diceImage2.contentDescription = rollSecondDice.toString()

            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    private fun rollDice(): Int {
        val dice = Dice(6)
        return dice.roll()
    }

    private fun drawableDice(diceSide: Int): Int {
        val drawableResource = when (diceSide) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        return drawableResource
    }
}

class Dice (private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}