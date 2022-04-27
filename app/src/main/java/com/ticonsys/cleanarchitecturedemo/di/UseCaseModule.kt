package com.ticonsys.cleanarchitecturedemo.di


import com.ticonsys.cleanarchitecturedemo.domain.usecases.registration.ValidateEmail
import com.ticonsys.cleanarchitecturedemo.domain.usecases.registration.ValidatePassword
import com.ticonsys.cleanarchitecturedemo.domain.usecases.registration.ValidateRepeatedPassword
import com.ticonsys.cleanarchitecturedemo.domain.usecases.registration.ValidateTerms
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideValidateEmail(): ValidateEmail = ValidateEmail()

    @Provides
    @Singleton
    fun provideValidatePassword(): ValidatePassword = ValidatePassword()

    @Provides
    @Singleton
    fun provideValidateRepeatedPassword(): ValidateRepeatedPassword = ValidateRepeatedPassword()

    @Provides
    @Singleton
    fun provideValidateTerms(): ValidateTerms = ValidateTerms()


}