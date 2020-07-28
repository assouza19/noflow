package noflow.modules

import noflow.logged.business.IBMBusiness
import noflow.logged.business.IBMBusinessImpl
import noflow.logged.provider.IBMProvider
import noflow.logged.provider.IBMProviderImpl
import noflow.logged.retrofit.IBMRetrofit
import noflow.notlogged.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val appModules = module {
    viewModel { MainViewModel(get()) }
    viewModel { noflow.logged.viewModel.MainViewModel()}

    factory { IBMBusinessImpl(get()) } bind IBMBusiness::class

    factory { IBMProviderImpl(get()) } bind IBMProvider::class

    factory { IBMRetrofit() }
}

