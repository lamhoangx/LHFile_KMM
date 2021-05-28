package me.lamhoangx.shared

import me.lamhoangx.expect.wrapper.LHTimber
import me.lamhoangx.expect.wrapper.file.LHFileReader
import me.lamhoangx.expect.wrapper.file.LHFileWriter

class LHFileTest(
    val pathFile: String
) {
    private var reader: LHFileReader? = null
    private var writer: LHFileWriter? = null

    init {
    }

    fun write(data: String) {
        writer = LHFileWriter(path = pathFile)
        writer?.apply {
            if(isReady()) {
                LHTimber.d("WRITING...")
                for (i in 1..5) {
                    writer?.write("$i: $data")
                    writeBreakLine()
                }
            }
        }
        writer?.close()
    }

    fun read() {
        reader = LHFileReader(pathFile)
        reader?.apply {
            if(isReady()) {
                var line: String? = null
                LHTimber.d("READING...")
                while (readLine()?.also { line = it } != null) {
                    line?.let {
                        LHTimber.d("LINE READ: $line")
                    }
                }
            }
        }
    }
}