package me.lamhoangx.expect.wrapper.file

import me.lamhoangx.expect.wrapper.LHTimber
import java.io.File
import java.io.FileOutputStream

actual class LHFileWriter actual constructor(path: String) {

    private var fileOutputStream: FileOutputStream? = null
    private var ready: Boolean = false

    init {
        val file = File(path)
        val parent = file.parentFile
        if(parent?.exists() == false) {
            parent.mkdirs()
        }

        fileOutputStream = FileOutputStream(file)
        ready = true
        LHTimber.d("FileWriter: $path")
    }

    actual fun isReady(): Boolean {
        return ready
    }

    actual fun close() {
        fileOutputStream?.close()
    }

    actual fun write(data: String) {
        fileOutputStream?.apply {
            LHTimber.d("WRITE: $data")
            write(data.toByteArray())
        }
    }

    actual fun writeBreakLine() {
        fileOutputStream?.write('\n'.toInt())
    }

    actual constructor(directory: String, fileName: String) : this("$directory/$fileName")
}