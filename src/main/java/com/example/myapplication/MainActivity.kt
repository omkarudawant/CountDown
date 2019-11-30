
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val timer = MyCounter(10000, 1000)
        start.setOnClickListener { timer.start() }
        stop.setOnClickListener { timer.cancel() }
    }

    inner class MyCounter(millisInFuture: Long, countDownInterval: Long) : CountDownTimer(millisInFuture, countDownInterval) {

        override fun onFinish() {
            println("Timer Completed.")
            tv.text = "Timer Completed."
        }

        override fun onTick(millisUntilFinished: Long) {
            tv.textSize = 50f

            tv.text = (millisUntilFinished / 1000).toString() + ""
            println("Timer  : " + millisUntilFinished / 1000)
        }
    }
}
