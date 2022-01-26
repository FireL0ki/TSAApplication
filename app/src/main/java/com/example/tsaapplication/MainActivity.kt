package com.example.tsaapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    // create global variables for each of our views we need to to reference for event listeners
    // private -- only accessible within activity class, not any other classes in the project
    // late init (late initialize?) allows us to specify there's a Button without yet initializing it
    // (--> we are promising to initialize the Button later)
    // --we can therefore not declare now as val (we need to change it later/ initialize)

    // cannot initialize this button here yet, because the content view isn't set, so there's nothing to initialize it in/from?
    private lateinit var tapHereButton: Button
    private lateinit var leftArrow: ImageButton
    private lateinit var rightArrow: ImageButton



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // the above needs to happen before working with layout

        // add event listener to a view --
        // (a view is any component you see on the screen, text view, button, etc.)
        // To add an event listener to a view--
        // 1. get a reference to the view
        // 2. add the correct type of event listener to the view (click, long press, multi-touch, etc.)


        tapHereButton = findViewById(R.id.tap_here_button)
        leftArrow = findViewById(R.id.left_arrow)
        rightArrow = findViewById(R.id.right_arrow)

        tapHereButton.setOnClickListener {
            showRandomArrow()
        }

        leftArrow.setOnClickListener {
            reset()
        }

        rightArrow.setOnClickListener {
            reset()
        }
    }

        // if nothing else needs access to a function, good idea to make private
        // so nothing else can call it by mistake and cause errors/ change app behavior
        private fun showRandomArrow() {
            tapHereButton.visibility = View.INVISIBLE
            // create a list of choices - left & right, and use random() function to pick a random one
            val direction = listOf("left", "right").random()
            // check which is chosen, and use that to call the correct button
            if (direction == "left") {
                leftArrow.visibility = View.VISIBLE
            } else {
                rightArrow.visibility = View.VISIBLE
            }

        }

        private fun reset() {
            tapHereButton.visibility = View.VISIBLE
            rightArrow.visibility = View.INVISIBLE
            leftArrow.visibility = View.INVISIBLE
        }

}