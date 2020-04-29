package mm.apk.opensourcelibrary

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast

/**
 * Descriptions：
 * StartVersion：
 * <p>
 * Author：ChenME
 * Date：2020-04-29
 * Email：ibelieve1210@163.com
 */
private var mToast: Toast? = null // Toast对象
private val mHandler = Handler(Looper.getMainLooper())

/**
 * 短 Toast
 */
fun Context.stt(messageRes: Int) {
    this.mtt(this.getString(messageRes).toString())
}

fun Context.stt(message: String) {
    this.mtt(message)
}

/**
 * 长 Toast
 */
fun Context.ltt(messageRes: Int) {
    this.mtt(this.getString(messageRes).toString(), true)
}

fun Context.ltt(message: String) {
    this.mtt(message, true)
}

fun Context.mtt(msg: String, isLongToast: Boolean = false) {
    Thread(Runnable {
        run {
            mHandler.post {
                synchronized(this) {
                    if (mToast != null) {
                        mToast!!.cancel()
                        mToast = null
                    }
                    mToast = Toast.makeText(this, "测试开源lib --->> $msg", if (isLongToast) Toast.LENGTH_LONG else Toast.LENGTH_SHORT)
                    mToast!!.show()
                }
            }
        }
    }).start()
}