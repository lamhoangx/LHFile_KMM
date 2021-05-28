package me.lamhoangx.expect.wrapper

import platform.Foundation.NSDate
import platform.Foundation.timeIntervalSince1970

actual class LHTimeHelper {
    actual fun currentTimeMillis(): Long {
        return (NSDate().timeIntervalSince1970() * 1000).toLong()
    }
}