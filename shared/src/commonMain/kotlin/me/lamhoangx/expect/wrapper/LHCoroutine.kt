package me.lamhoangx.expect.wrapper

import kotlinx.coroutines.CoroutineDispatcher

expect class LHCoroutine {
    companion object {
        internal val Main: CoroutineDispatcher
        internal val Background: CoroutineDispatcher
    }
}