package se.hellsoft.contraintlayoutworkshop

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.constraint.ConstraintSet
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.OvershootInterpolator
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

      var selectedView: ImageView
      selectedView= ImageView(this)


    imageView2.setOnClickListener{

        if (selectedView != imageView2) {
            updateConstraints(R.layout.activity_main_click)
            textView2.setText("SOPRA")
            selectedView = imageView2
        }
        else {
            updateConstraints(R.layout.activity_main)
            textView2.setText("SOTTO")

            selectedView= ImageView(this)
        }

    }


  }

    fun updateConstraints(@LayoutRes id: Int) {
        val newConstraintSet = ConstraintSet()
        newConstraintSet.clone(this, id)
        newConstraintSet.applyTo(root)
        val transition = ChangeBounds()
        transition.interpolator = OvershootInterpolator()
        TransitionManager.beginDelayedTransition(root, transition)
    }


}
