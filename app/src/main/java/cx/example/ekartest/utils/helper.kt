package cx.example.ekartest.utils

import android.app.Application
import cx.example.ekartest.MyApplication

/**
 * This class is used for creating the static reference that will be used inside of the application
 */
class helper {

    companion object{
        lateinit var application: Application
        fun setApplicationContext(application: MyApplication): MyApplication{
            this.application = application
            return application
        }
    }


}