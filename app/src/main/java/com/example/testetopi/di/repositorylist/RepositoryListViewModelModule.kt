package com.example.testetopi.di.repositorylist

import androidx.lifecycle.ViewModel
import com.example.testetopi.di.ViewModelKey
import com.example.testetopi.ui.repositorieslist.RepositoriesListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class RepositoryListViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(RepositoriesListViewModel::class)
    abstract fun bindMainViewModel(mainActivityViewModel: RepositoriesListViewModel) : ViewModel
}