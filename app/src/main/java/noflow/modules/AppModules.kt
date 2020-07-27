package noflow.modules

import noflow.notlogged.MainViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val appModules = module {
    viewModel { MainViewModel(get()) }
}