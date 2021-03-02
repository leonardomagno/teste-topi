package com.example.testetopi.ui.di

import androidx.lifecycle.ViewModel
import com.example.testetopi.di.ViewModelKey
import com.example.testetopi.ui.repositorieslist.RepositoriesListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface MainModule {

    @Binds
    @IntoMap//Multibinds
    @ViewModelKey(RepositoriesListViewModel::class)
    fun bindRepositoriesListViewModel(viewModel: RepositoriesListViewModel): ViewModel
}