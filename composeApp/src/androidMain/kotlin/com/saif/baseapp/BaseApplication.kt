package com.saif.baseapp
import android.app.Application
import com.saif.baseapp.di.KoinInitializerAndroid
import com.saif.shared.AppContext

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setInstance(this)
        AppContext.setContext(this)
        KoinInitializerAndroid(this).init()
    }

    companion object Companion {
        lateinit var instance: BaseApplication
            private set

        fun setInstance(application: BaseApplication) {
            instance = application
        }
    }

}