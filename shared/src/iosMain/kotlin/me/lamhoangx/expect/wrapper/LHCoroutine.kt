package me.lamhoangx.expect.wrapper

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Runnable
import platform.Foundation.NSRunLoop
import platform.Foundation.performBlock
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue
import platform.darwin.dispatch_queue_t
import kotlin.coroutines.CoroutineContext

actual class LHCoroutine {
    actual companion object {
        internal actual val Main: CoroutineDispatcher = NsQueueDispatcher(dispatch_get_main_queue())

        internal actual val Background: CoroutineDispatcher = Main

        internal class NsQueueDispatcher(
            private val dispatchQueue: dispatch_queue_t
        ) : CoroutineDispatcher() {
            override fun dispatch(context: CoroutineContext, block: Runnable) {
                dispatch_async(dispatchQueue) {
                    block.run()
                }
            }
        }

        object MainLoopDispatcher: CoroutineDispatcher() {
            override fun dispatch(context: CoroutineContext, block: Runnable) {
                NSRunLoop.mainRunLoop().performBlock {
                    block.run()
                }
            }
        }

        object BackgroundLoopDispatcher: CoroutineDispatcher() {
            override fun dispatch(context: CoroutineContext, block: Runnable) {
                NSRunLoop.mainRunLoop().performBlock {
                    block.run()
                }
            }
        }
    }
}
