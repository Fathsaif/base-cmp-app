package com.saif.baseapp.history.presenter

import com.saif.baseapp.history.presenter.model.TransactionItem

sealed class TransactionHistoryUiState {
    object Loading : TransactionHistoryUiState()
    data class Success(val transactions: List<TransactionItem>) : TransactionHistoryUiState()
    data class Error(val message: String) : TransactionHistoryUiState()
}