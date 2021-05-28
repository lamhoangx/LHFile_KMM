package me.lamhoangx.expect.wrapper.file

expect class LHFileUtils {
    companion object {
        fun checksumDirectory(directory: String): String
        fun checksumFile(filePath: String): String
        fun move(filePathSrc: String, filePathDest: String): Boolean
    }
}