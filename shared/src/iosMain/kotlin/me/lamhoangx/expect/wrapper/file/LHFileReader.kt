package me.lamhoangx.expect.wrapper.file

import me.lamhoangx.expect.wrapper.NSStreamReader

actual class LHFileReader actual constructor(path: String) {
    private var reader: NSStreamReader? = null
    init {
        try {
            reader = NSStreamReader(path)
        } catch (e: Throwable) {
        }
    }
    actual fun isReady(): Boolean {
        return reader?.isReady() == true
    }

    actual fun close() {
        reader?.closeFile()
    }

    actual fun readLine(): String? {
        return reader?.readLine()
    }

    actual fun getFilePointer(): Long {
        reader?.let {
            return it.getFilePointer()
        }
        return 0
    }

    actual fun seek(offset: Long) {
        reader?.seekToOffset(offset)
    }

    actual constructor(directory: String, fileName: String) : this("$directory/$fileName")

}