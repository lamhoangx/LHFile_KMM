package me.lamhoangx.expect.wrapper.file

import android.os.Build
import android.os.FileUtils
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.nio.channels.FileChannel

actual class LHFileUtils {
    actual companion object {
        actual fun checksumDirectory(directory: String): String {
            return ""
        }

        actual fun checksumFile(filePath: String): String {
            return ""
        }

        actual fun move(filePathSrc: String, filePathDest: String): Boolean {
            try {
                val src = File(filePathSrc)
                if (!src.exists()) return false

                val dest = File(filePathDest)
                if (dest.exists()) {
                    dest.delete()
                }
                var result = false
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    var inputStream: FileInputStream? = null
                    var outputStream: FileOutputStream? = null
                    try {
                        inputStream = FileInputStream(src)
                        outputStream = FileOutputStream(dest)
                        FileUtils.copy(inputStream, outputStream)
                        src.delete()
                        result = true
                    } catch (e: Throwable) {
                        e.printStackTrace()
                    } finally {
                        try {
                            inputStream?.close()
                            outputStream?.close()
                        } catch (e: Throwable) {
                        }
                    }
                }
                if (!result) {
                    result = moveManual(src, dest)
                }
                if (!result) {
                    src.renameTo(dest)
                    src.delete()
                }
                return result
            } catch (e: Throwable) {
                e.printStackTrace()
            }
            return false
        }

        private fun moveManual(src: File, dest: File): Boolean {
            var result = false
            var outputChannel: FileChannel? = null
            var inputChannel: FileChannel? = null
            try {
                outputChannel = FileOutputStream(dest).channel
                inputChannel = FileInputStream(src).channel
                inputChannel.transferTo(0, inputChannel.size(), outputChannel)
                inputChannel.close()
                src.delete()
                result = true
            } catch (e: Throwable) {
                e.printStackTrace()
            } finally {
                try {
                    inputChannel?.close()
                    outputChannel?.close()
                } catch (e: Throwable) {
                }
            }
            return result
        }
    }
}