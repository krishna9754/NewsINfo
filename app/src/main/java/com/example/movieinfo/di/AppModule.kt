package com.example.movieinfo.di

import com.example.movieinfo.datasource.NewDataSource
import com.example.movieinfo.datasource.NewDataSourceImp
import com.example.movieinfo.repository.NewsRepository
import com.example.movieinfo.interfaceservice.ApiService
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofit (): Retrofit{
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply{
            level = HttpLoggingInterceptor.Level.BASIC
        }

        val httpClient = OkHttpClient().newBuilder().apply {
            addInterceptor(httpLoggingInterceptor)
        }

        httpClient.apply {
            readTimeout(60, TimeUnit.SECONDS)
        }

        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        return Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .client(httpClient.build())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofits(retrofit: Retrofit) : ApiService{
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideNewDataSource(apiService: ApiService) : NewDataSource{
        return NewDataSourceImp(apiService)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(newDataSource: NewDataSource) : NewsRepository {
        return NewsRepository(newDataSource)
    }
}