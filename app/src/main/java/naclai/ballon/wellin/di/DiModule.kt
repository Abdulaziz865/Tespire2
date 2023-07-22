package naclai.ballon.wellin.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import naclai.ballon.wellin.MyApp
import naclai.ballon.wellin.other.FacebookInitialization
import naclai.ballon.wellin.other.FirebaseInitialization
import naclai.ballon.wellin.other.OneSignalInitialization
import naclai.ballon.wellin.other.SettingWebView
import naclai.ballon.wellin.other.SharedPrefs
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DiModule {

    @Provides
    @Singleton
    fun provideApplication(): MyApp {
        return MyApp()
    }

    @Provides
    @Singleton
    fun provideSharedPrefs(@ApplicationContext context: Context): SharedPrefs {
        return SharedPrefs(context)
    }

    @Provides
    @Singleton
    fun provideFacebookInitialization(@ApplicationContext context: Context): FacebookInitialization {
        return FacebookInitialization(context)
    }

    @Provides
    @Singleton
    fun provideFirebaseInitialization(application: MyApp, facebookInitialization: FacebookInitialization): FirebaseInitialization {
        return FirebaseInitialization(application, facebookInitialization)
    }

    @Provides
    @Singleton
    fun provideSettingsWebView(firebaseInitialization: FirebaseInitialization): SettingWebView {
        return SettingWebView(firebaseInitialization)
    }

    @Provides
    @Singleton
    fun provideOneSignalInitialization(@ApplicationContext context: Context, sharedPrefs: SharedPrefs): OneSignalInitialization {
        return OneSignalInitialization(context, sharedPrefs)
    }
}