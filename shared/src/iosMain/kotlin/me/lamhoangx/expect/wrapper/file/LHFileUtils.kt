package me.lamhoangx.expect.wrapper.file

import platform.Foundation.NSFileManager

actual class LHFileUtils {
    actual companion object {
        actual fun checksumDirectory(directory: String): String {
            return ""
        }
        actual fun checksumFile(filePath: String): String {
            return ""
        }
        actual fun move(filePathSrc: String, filePathDest: String): Boolean {
            return NSFileManager.defaultManager.moveItemAtPath(filePathSrc, filePathDest, null)
        }
    }
}