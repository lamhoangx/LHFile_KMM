package me.lamhoangx.expect.wrapper.file

expect class LHFileReader (path: String) {
    constructor(directory: String, fileName: String)
    fun isReady(): Boolean
    fun close()
    fun readLine(): String?
    fun getFilePointer(): Long
    fun seek(offset: Long)
}