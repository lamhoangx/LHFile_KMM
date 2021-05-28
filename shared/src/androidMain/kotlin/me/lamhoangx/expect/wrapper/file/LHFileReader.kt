package me.lamhoangx.expect.wrapper.file

import java.io.File
import java.io.RandomAccessFile

actual class LHFileReader actual constructor(path: String) {
    var file: File? = null
    var reader: RandomAccessFile? = null
    init {
        file = File(path)
        file?.let {
            if(it.exists()) {
                reader = RandomAccessFile(it, "r")
            }
        }
    }
    actual fun isReady(): Boolean {
        return reader != null
    }

    actual fun close() {
        reader?.close()
    }

    actual fun readLine(): String? {
        return reader?.readLine()
    }

    actual fun getFilePointer(): Long {
        return reader?.filePointer ?: -1
    }

    actual fun seek(offset: Long) {
        reader?.seek(offset)
    }

    actual constructor(directory: String, fileName: String) : this("$directory/$fileName") {

    }

}