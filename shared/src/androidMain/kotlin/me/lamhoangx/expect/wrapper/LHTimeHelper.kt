package me.lamhoangx.expect.wrapper

actual class LHTimeHelper {
    actual fun currentTimeMillis(): Long {
        return System.currentTimeMillis()
    }
}