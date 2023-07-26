package naclai.ballon.wellin

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import naclai.ballon.wellin.other.OneSignalInitialization
import naclai.ballon.wellin.white.utils.PreferenceHelper
import javax.inject.Inject


@HiltAndroidApp
class MyApp : Application() {

    @Inject
    lateinit var oneSignalInitialization: OneSignalInitialization

    override fun onCreate() {
        super.onCreate()
        PreferenceHelper.units(this)
        oneSignalInitialization.init()
    }
}