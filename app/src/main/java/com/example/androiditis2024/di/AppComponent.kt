package com.example.androiditis2024.di

import android.app.Application
import com.example.androiditis2024.App
import com.example.androiditis2024.di.modules.ActivityBindsModule
import com.example.androiditis2024.di.modules.AppModule
import com.example.androiditis2024.di.modules.NetModule
import com.example.androiditis2024.di.modules.RepositoryModule
import com.example.androiditis2024.di.modules.ViewModelModule
import com.example.androiditis2024.presentation.weather.WeatherActivity
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule


@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    NetModule::class,
    RepositoryModule::class,
    ViewModelModule::class,
    ActivityBindsModule::class
])
interface AppComponent {


    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder
        fun build(): AppComponent
    }

    fun inject(application: App)
}