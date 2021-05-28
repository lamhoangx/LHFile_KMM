package me.lamhoangx.lhfile

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import me.lamhoangx.shared.LHFileTest
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pathFile = "${baseContext.filesDir.absolutePath}/kmm_file_io.test"
        File(pathFile).apply {
            if(exists()) {
                delete()
            }
        }
        val lhFile = LHFileTest(pathFile)
        val btn: Button = findViewById(R.id.btn_test)
        btn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                lhFile.apply {
                    write("Hello world!")
                    read()
                }
            }

        })
        PermissionUtils.rationalRequestStoragePermission(this)

        LHFileTest(pathFile).apply {
            write("Hello world!")
            read()
        }
    }
}
