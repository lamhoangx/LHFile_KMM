package me.lamhoangx.expect.wrapper

import platform.Foundation.NSLog

actual class LHTimber {
    actual companion object {
        actual fun d(e: Throwable) {
            NSLog("iOS_LOG: %s", e.stackTraceToString())
        }

        actual fun e(s: String) {
            NSLog("iOS_LOG: %s", s)
        }

        actual fun d(s: String) {
            NSLog("iOS_LOG: %s", s)
        }
    }
}