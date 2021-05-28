package me.lamhoangx.expect.wrapper

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual class LHCoroutine {
    actual companion object {
        internal actual val Main: CoroutineDispatcher = Dispatchers.Main
        internal actual val Background: CoroutineDispatcher = Dispatchers.Default
    }
}