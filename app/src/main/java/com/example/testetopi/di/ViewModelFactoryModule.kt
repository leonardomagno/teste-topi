package com.example.testetopi.di

import androidx.lifecycle.ViewModelProvider
import com.example.testetopi.viewmodels.ViewModelsProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelsProviderFactory?): ViewModelProvider.Factory?
}