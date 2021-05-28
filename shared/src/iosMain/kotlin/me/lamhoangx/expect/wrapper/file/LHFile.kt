package me.lamhoangx.expect.wrapper.file

import platform.Foundation.NSFileHandle
import platform.Foundation.NSFileManager
import platform.Foundation.fileHandleForReadingAtPath

actual class LHFile actual constructor(private val path: String) {
    var file: NSFileHandle? = null
    init {
        file = NSFileHandle.fileHandleForReadingAtPath(path)
    }
    actual val isDirectory: Boolean
        get() = false

    actual fun exists(): Boolean {
        return NSFileManager.defaultManager.fileExistsAtPath(path)
    }

    actual fun delete(): Boolean {
        return NSFileManager.defaultManager.removeItemAtPath(path, null)
    }

    actual fun mkdirs() {
        NSFileManager.defaultManager.createFileAtPath(path, null, null)
    }

    actual constructor(directory: String, fileName: String) : this("$directory/$fileName") {

    }

    actual fun createNewFile() {
        NSFileManager.defaultManager.createFileAtPath(path, null, null)
    }

}