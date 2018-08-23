package com.example.erzhena.starwars.di.modules

import android.content.Context
import android.util.Log
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [
    StarWarModule::class
])
open class AppModule(private val context: Context, private val baseUrl: String) {

    @Singleton
    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideRxJava2CallAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor { msg ->
            Log.d("okhttp", msg)
        }
        interceptor.level = HttpLoggingInterceptor.Level.HEADERS
        return interceptor
    }


//    @Singleton
//    @Provides
//    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
//        return HttpLoggingInterceptor { msg ->
//            Log.d("okhttp", msg)
//        }.setLevel(HttpLoggingInterceptor.Level.HEADERS)
//        // interceptor.level = HttpLoggingInterceptor.Level.HEADERS
//    }

    @Singleton
    @Provides
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        provideGsonConverterFactory: GsonConverterFactory,
        provideRxJava2CallAdapterFactory: RxJava2CallAdapterFactory,
        provideOkHttpClient: OkHttpClient)
        : Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(provideGsonConverterFactory)
            .addCallAdapterFactory(provideRxJava2CallAdapterFactory)
            .client(provideOkHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideContext(): Context {
        return context
    }
}