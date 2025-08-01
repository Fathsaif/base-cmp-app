package com.saif.shared.fake

import com.saif.shared.repository.TransactionRepository
import com.saif.shared.repository.models.PaymentRequest
import com.saif.shared.repository.models.PaymentResponseDTO

class TransactionFakeRepository : TransactionRepository {

    private val transactions = mutableListOf<PaymentResponseDTO>()

    override suspend fun sendPayment(payment: PaymentRequest): com.saif.shared.utils.Result<String> {
        val dto = PaymentResponseDTO(
            id = "fake-id-${transactions.size + 1}",
            recipientEmail = payment.email,
            amount = payment.amount,
            currency = payment.currency,
            timestamp = "now"
        )
        transactions.add(dto)
        return com.saif.shared.utils.Result.Success("OK")
    }

    override suspend fun getTransactions(): com.saif.shared.utils.Result<List<PaymentResponseDTO>> {
        return com.saif.shared.utils.Result.Success(transactions)
    }
}
