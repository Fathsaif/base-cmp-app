package com.saif.baseapp.di

import com.saif.baseapp.transactions.presenter.SendPaymentViewModel
import org.koin.dsl.module

val transactionsModule = module {
    factory {
        SendPaymentViewModel(get())
    }
}