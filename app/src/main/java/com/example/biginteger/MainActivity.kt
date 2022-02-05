package com.example.biginteger
// https://www.youtube.com/playlist?list=PL7NYbSE8uaBDcLkbXsQADdvBnVbavonGn
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val constraintLayout: ConstraintLayout = findViewById(R.id.constLayout)
        assignRandomNumbers()
        val buttonL : Button = findViewById(R.id.btnLeft)
        val buttonR : Button = findViewById(R.id.btnRight)
        buttonL.setOnClickListener {
            val leftNum = buttonL.text.toString().toInt()
            val rightNum = buttonR.text.toString().toInt()
            conditionCheck(leftNum,rightNum,constraintLayout)
            assignRandomNumbers()
        }
        buttonR.setOnClickListener {
            val leftNum = buttonL.text.toString().toInt()
            val rightNum = buttonR.text.toString().toInt()
            conditionCheck(rightNum,leftNum,constraintLayout)
            assignRandomNumbers()
        }
    }

    private fun conditionCheck(big:Int, small:Int, constraintLayout: ConstraintLayout) {
        if(big>small){
            constraintLayout.setBackgroundColor(Color.CYAN)
            Toast.makeText(this,"Correct!! ",Toast.LENGTH_SHORT).show()
        }
        else{
            constraintLayout.setBackgroundColor(Color.YELLOW)
            Toast.makeText(this,"Wrong :)",Toast.LENGTH_SHORT).show()
        }
    }

    private fun assignRandomNumbers() {
        val buttonLeft : Button = findViewById(R.id.btnLeft)
        val buttonRight : Button = findViewById(R.id.btnRight)
        val r= Random()
        buttonLeft.text = r.nextInt(10).toString()
        buttonRight.text = buttonLeft.text
        while(buttonLeft.text == buttonRight.text){
            buttonRight.text = r.nextInt(10).toString()
        }
    }
}