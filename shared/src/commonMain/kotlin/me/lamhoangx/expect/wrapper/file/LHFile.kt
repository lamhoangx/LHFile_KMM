package me.lamhoangx.expect.wrapper.file

expect class LHFile(path: String) {
    constructor(directory: String, fileName: String)

    val isDirectory: Boolean

    fun exists(): Boolean
    fun delete(): Boolean
    fun mkdirs()
    fun createNewFile()
}