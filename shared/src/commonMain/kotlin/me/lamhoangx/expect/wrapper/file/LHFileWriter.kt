package me.lamhoangx.expect.wrapper.file

expect class LHFileWriter (path: String) {
    constructor(directory: String, fileName: String)
    fun isReady(): Boolean
    fun close()

    fun write(data: String)
    fun writeBreakLine()
}