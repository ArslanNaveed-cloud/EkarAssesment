package cx.example.ekartest

import android.app.Application
import cx.example.ekartest.utils.helper

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initialize()
    }
    private fun initialize(){
        helper.setApplicationContext(this)

    }
}