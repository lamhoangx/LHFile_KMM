package me.lamhoangx.expect.wrapper

import android.util.Log

actual class LHTimber {
    actual companion object {
        actual fun d(e: Throwable) {
            Log.d("AND_LOG", e.toString())
        }

        actual fun e(s: String) {
            Log.e("AND_LOG", s)
        }

        actual fun d(s: String) {
            Log.d("AND_LOG", s)
        }
    }
}