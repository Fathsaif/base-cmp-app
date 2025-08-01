package com.saif.baseapp.di

import com.saif.business.transactions.GetTransactionsUseCase
import com.saif.baseapp.history.presenter.TransactionsHistoryViewmodel
import org.koin.dsl.module

val historyModule = module {
    factory {
        TransactionsHistoryViewmodel(get())
    }

    factory {
        GetTransactionsUseCase(get())
    }
}
