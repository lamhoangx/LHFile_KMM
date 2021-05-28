package me.lamhoangx.expect.wrapper.file

import java.io.File

actual class LHFile actual constructor(path: String) {
    private var file: File? = null
    init {
        file = File(path)
    }
    actual val isDirectory: Boolean
        get() = file?.isDirectory == true

    actual fun exists(): Boolean {
        return file?.exists() == true
    }

    actual fun delete(): Boolean {
        return file?.delete() == true
    }

    actual fun mkdirs() {
        file?.mkdirs()
    }

    actual constructor(directory: String, fileName: String) : this("$directory/$fileName")

    actual fun createNewFile() {
        file?.createNewFile()
    }
}