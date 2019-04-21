package es.rchampa.mapearimagen

import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent.ACTION_UP
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.bottom_sheet.*
import kotlinx.android.synthetic.main.mycontent.*


const val HEIGHT = 100
const val WIDTH = 100

class MainActivity : AppCompatActivity(), TouchImageView.OnTouchPositionListener {

    lateinit var newView: ImageView
    private lateinit var sheetBehavior: BottomSheetBehavior<LinearLayout>

    override fun onPosition(x: Float, y: Float) {
//        Toast.makeText(this,"Posicion: x=$x  y=$y",Toast.LENGTH_LONG).show()
//        addImageButton(x,y)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sheetBehavior = BottomSheetBehavior.from<LinearLayout>(bottom_sheet)


        supportActionBar?.hide()


        bt_expand.setOnClickListener {
            sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }

        bt_half_expand.setOnClickListener{
            sheetBehavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
        }


        iv_cementerio.setOnTouchListener{ view, event ->
            val x = event.x.toInt()
            val y = event.y.toInt()


            try {
                if(event.action==ACTION_UP)
                    findColor(view,x,y)

            }
            catch (e: Exception) {
                e.printStackTrace()
            }

//            imgbmp.recycle()
            true

        }


    }

    /**
     * Find components of color of the bitmap at x, y.
     * @param x Distance from left border of the View
     * @param y Distance from top of the View
     * @param view Touched surface on screen
     */
    @Throws(NullPointerException::class)
    fun findColor(view: View, x: Int, y: Int): Int {

        var red = 0
        var green = 0
        var blue = 0
        var color = 0

        val offset = 1 // 3x3 Matrix
        var pixelsNumber = 0

        var xImage = 0
        var yImage = 0

        // Get the bitmap from the view.
        val imageView = view as ImageView
        val bitmapDrawable = imageView.drawable as BitmapDrawable
        val imageBitmap = bitmapDrawable.bitmap

        // Calculate the target in the bitmap.
        xImage = (x * (imageBitmap.width.toDouble() / imageView.width.toDouble())).toInt()
        yImage = (y * (imageBitmap.height.toDouble() / imageView.height.toDouble())).toInt()

        // Average of pixels color around the center of the touch.
//        for (i in xImage-offset .. xImage+offset) {
//            for (j in yImage-offset .. yImage+offset) {
//                try {
//                    color = imageBitmap.getPixel(i, j)
//                    red += Color.red(color)
//                    green += Color.green(color)
//                    blue += Color.blue(color)
//                    pixelsNumber += 1
//                } catch (e: Exception) {
//                    //Log.w(TAG, "Error picking color!");
//                }
//
//            }
//        }
//        red = red / pixelsNumber
//        green = green / pixelsNumber
//        blue = blue / pixelsNumber

        color = imageBitmap.getPixel(xImage, yImage)
        red += Color.red(color)
        green += Color.green(color)
        blue += Color.blue(color)
        showData(arrayOf(red,green,blue),x.toFloat(),y.toFloat())

//        showToast("$red $green $blue")

        return Color.rgb(red, green, blue)
    }

    private fun showData(data:Array<Int>,x: Float,y: Float){
        showToast(CodigoLetra.toString(data),x,y)
    }

    private fun showToast(message: String,x: Float,y: Float){
        addIV(message, x,y)
    }

    fun addIV(message: String, x:Float, y:Float){

        if (::newView.isInitialized){

            if(message=="NADA"){
                newView.visibility = View.GONE
            }
            else{
                newView.visibility = View.VISIBLE
                newView.x = x - (WIDTH/2)
                newView.y = y - (HEIGHT/2)
            }

            return
        }

        if(message=="NADA"){
            return
        }
        newView = ImageView(this)
        cl.addView(newView)
        newView.layoutParams.height = HEIGHT
        newView.layoutParams.width = WIDTH
        newView.x = x - (WIDTH/2)
        newView.y = y - (HEIGHT/2)
        newView.setImageResource(R.drawable.globo)
    }
}
