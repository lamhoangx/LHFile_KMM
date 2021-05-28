package me.lamhoangx.expect.wrapper

import me.lamhoangx.string
import platform.Foundation.*
import platform.darwin.NSUInteger

class NSStreamReader(path: String, delimeter: Char = '\n', chunkSize: Int = 1024) {
    var encoding: String = ""
    var chunkSize: NSUInteger = 0u
    var fileHandle: NSFileHandle? = null
    var buffer: NSData? = null
    var delimPattern = delimeter
    var isAtEOF: Boolean = false
    var offset: Long = 0
    var currentOffset: ULong = 0u

    init {
        if(NSFileManager.defaultManager.fileExistsAtPath(path)) {
            fileHandle = NSFileHandle.fileHandleForReadingAtPath(path)
        }
        this.chunkSize = chunkSize.toULong()
    }

    fun rewind() {
        fileHandle?.seekToOffset(0, null)
        currentOffset = 0u
        isAtEOF = false
    }

    fun readLine(): String? {
        if (isAtEOF) return null
        var data = StringBuilder()
        while (true) {
            fileHandle?.seekToOffset(currentOffset, null)
            val buffer = fileHandle?.readDataUpToLength(chunkSize, null)
            val strData: String? = buffer?.string()
//            LHTimber.d("READ: $strData - $buffer")
            strData?.let {
                if (strData.contains(delimPattern)) {
                    val fields = strData.split(delimPattern)
                    val line = fields[0]
                    data.append(line)
                    currentOffset += line.length.toUInt() + 1u
                    return data.toString()
                } else {
                    currentOffset += it.length.toUInt()
                    data.append(it)
                }
            }
            if(strData == null) {
                isAtEOF = true
                return if(data.isEmpty()) null else data.toString()
            }
        }
    }

    fun closeFile() {
        currentOffset = 0u
        isAtEOF = true
        fileHandle?.closeFile()
    }

    fun getFilePointer(): Long {
        return currentOffset.toLong()
    }

    fun seekToOffset(offset: Long) {
        fileHandle?.seekToOffset(offset = offset.toULong(), null)
    }

    fun isReady(): Boolean {
        return fileHandle != null
    }
}