package com.example.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.core.view.GestureDetectorCompat

private const val DEBUG_TAG = "Gestures"

class FlingColorView : View, GestureDetector.OnGestureListener {

    private lateinit var mDetector: GestureDetectorCompat;
    private val paint: Paint();
    private val currentColor = Color.LTGRAY;

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        this.mDetector = GestureDetectorCompat(this.context, this)
        this.paint = Paint()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (mDetector.onTouchEvent(event)) {
            invalidate()
            return true
        }

        return super.onTouchEvent(event)
    }

        override fun onDown(event: MotionEvent): Boolean {
            Log.d(DEBUG_TAG, "onDown: $event")
            return true
        }

    override fun onShowPress(e: MotionEvent?) {
        TODO("Not yet implemented")
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        TODO("Not yet implemented")
    }

    override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
        TODO("Not yet implemented")
    }

    override fun onLongPress(e: MotionEvent?) {
        TODO("Not yet implemented")
    }

    override fun onFling(
            event1: MotionEvent,
            event2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            Log.d(DEBUG_TAG, "onFling: $event1 $event2")
            return true
        }

}