package me.lamhoangx.expect.wrapper.file

import me.lamhoangx.expect.wrapper.LHTimber
import me.lamhoangx.toNSData
import platform.Foundation.*

actual class LHFileWriter actual constructor(path: String) {
    var file: NSFileHandle? = null
    init {
        if(!NSFileManager.defaultManager.fileExistsAtPath(path)) {
            NSFileManager.defaultManager.createFileAtPath(path, null, null)
        }
        file = NSFileHandle.fileHandleForWritingAtPath(path)
        LHTimber.d("FileWriter: $path")
    }
    actual fun isReady(): Boolean {
        return file != null
    }

    actual fun close() {
        file?.closeFile()
    }

    actual fun write(data: String) {
        data.toNSData()?.apply {
            LHTimber.d("WRITE: $data")
            file?.writeData(this)
        }
    }

    actual fun writeBreakLine() {
        "\n".toNSData()?.apply {
            file?.writeData(this)
        }
    }

    actual constructor(directory: String, fileName: String) : this("$directory/$fileName") {
    }
}