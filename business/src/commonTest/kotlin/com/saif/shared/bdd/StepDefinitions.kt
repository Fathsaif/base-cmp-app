package com.saif.shared.bdd

import com.saif.business.BusinessResult
import com.saif.business.transactions.GetTransactionsUseCase
import com.saif.business.transactions.PaymentSuccessResponse
import com.saif.business.transactions.SendPaymentUseCase
import com.saif.shared.fake.TransactionFakeRepository
import kotlinx.coroutines.runBlocking
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import io.cucumber.java.en.Given
import io.cucumber.java.en.When
import io.cucumber.java.en.Then

class StepDefinitions {

    private val repository = TransactionFakeRepository()
    private val sendPaymentUseCase = SendPaymentUseCase(repository)
    private val getTransactionsUseCase = GetTransactionsUseCase(repository)

    private lateinit var result: PaymentSuccessResponse
    private lateinit var transactions: List<PaymentSuccessResponse>

    private var email: String = ""
    private var amount: Double = 0.0
    private var currency: String = ""

    @Given("a valid recipient email {string}")
    fun a_valid_recipient_email(email: String) {
        this.email = email
    }

    @Given("a valid amount {double}")
    fun a_valid_amount(amount: Double) {
        this.amount = amount
    }

    @Given("a supported currency {string}")
    fun a_supported_currency(currency: String) {
        this.currency = currency
    }

    @When("I send the payment")
    fun i_send_the_payment() {
        runBlocking {
            val res = sendPaymentUseCase(email, amount, currency)
            assertTrue(res is BusinessResult.Success)
            result = (res as BusinessResult.Success).data
        }
    }

    @Then("the payment should be successful")
    fun the_payment_should_be_successful() {
        assertEquals(email, result.recipientEmail)
        assertEquals(amount, result.amount)
        assertEquals(currency, result.currency)
    }

    @When("I fetch all transactions")
    fun i_fetch_all_transactions() {
        runBlocking {
            val res = getTransactionsUseCase()
            assertTrue(res is BusinessResult.Success)
            transactions = (res as BusinessResult.Success).data
        }
    }

    @Then("I should get a non-empty list")
    fun i_should_get_a_non_empty_list() {
        assertTrue(transactions.isNotEmpty())
    }
}
