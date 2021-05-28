package me.lamhoangx.expect.wrapper

class LHTime {
    companion object {
        private val timeHelper = LHTimeHelper()
        fun currentTimeMillis(): Long {
            return timeHelper.currentTimeMillis()
        }
    }
}

expect class LHTimeHelper() {
    fun currentTimeMillis(): Long
}