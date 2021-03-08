package com.example.testetopi.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testetopi.ui.repositorieslist.RepositoriesListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(RepositoriesListViewModel::class)
    internal abstract fun repositoriesViewModel(broadcastViewModel: RepositoriesListViewModel): ViewModel
}