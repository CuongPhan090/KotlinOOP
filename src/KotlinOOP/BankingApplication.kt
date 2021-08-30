package KotlinOOP

import java.lang.IllegalArgumentException
import java.time.LocalDateTime
import java.util.*
import kotlin.system.exitProcess

const val MINIMUM_BALANCE = 1000
const val INTEREST_RATE = 0.04
var transactionId: Long = 0

/*
"Banking Application:
Bank maintains customer accounts. Each account has details such as account number, name of account holder and Transactions.
Customer can either withdraw or deposit amount from its own account i.e. transaction.

For each transaction bank stores details as transaction id, transaction type (Withdraw/Deposit),
transaction amount, date and time of transaction.

Bank creates new account. Account number is auto assigned to account by increment last account number.
Bank also closes account of customer on request. Bank accountants search and display account details including transactions on customer request.

//Saving accounts receives interest at rate 4% per annual on their account balance periodically after every quarter.
//While withdrawing from saving account customer can withdraw all the amount.
//
//Current accounts does not receive any sort of interest on their account. Also, current account holders should also
//maintain a minimum balance and if the balance falls below this level,  a service charge of 100 is charged.

Write a menu-driven program for various operations such as
1) Open New Account 2) Deposit Amount 3) Withdraw Amount 4) Search by Name 5) Close Account 6) Deposit Interest
7) Search Account by A/C no 0) Exit the application.
Create appropriate classes, data members/properties, constructors, functions to write program for above-mentioned requirement."
 */
fun main() {
    val scanner = Scanner(System.`in`)
    val bankA = Bank()
    var choice: Int
    do {
        printMenu()
        print("Enter an option: ")
        choice = scanner.nextInt()
        bankA.query(choice)
    } while (choice != 0)


}

fun printMenu() {
    println(
        """
        1) Open New Account
        2) Deposit Amount
        3) Withdraw amount
        4) Search by Name
        5) Close Account
        6) Customer Detail
        7) Search Account by A/C no
        8) Transaction History
        0) Exit the application
    """.trimIndent()
    )
}

class Bank() {
    // HashMap<AccountNumber, CustomerObject>
    private val customers = HashMap<Long, Customer>()
    lateinit var customer: Customer
    private var accountNumber: Long = 999

    fun query(option: Int) {
        val scanner = Scanner(System.`in`)
        when (option) {
            1 -> openNewAccount()
            2 -> {
                print("Amount($): ")
                val amount = scanner.nextDouble()
                try {
                    customer.deposit(amount)
                } catch (e: Exception) {
                    println("No account exist!")
                }
            }
            3 -> {
                print("Amount($): ")
                val amount = scanner.nextDouble()
                try {
                    customer.withdraw(amount)
                } catch (e: Exception) {
                    println("No account exist!")
                }
            }
            4 -> {
                print("Account holder: ")
                val accountHolder = scanner.nextLine()
                val customerDuplicateName = searchByName(accountHolder)

                if (customerDuplicateName.size == 0)
                    println("Invalid account holder!")
                else if (customerDuplicateName.size > 1)
                    customerDuplicateName.forEach {
                        println(it)
                    }
                else
                    customer = customerDuplicateName[0]
            }

            5 -> try {
                closeAccount()
                println("Successfully close the account!")
            } catch (e: Exception) {
                println("Failed to close the account!")
            }
            6 -> println(customer)

            7 -> {
                print("Account number: ")
                val accountNumber = scanner.nextLong()
                if (searchByAccountNumber(accountNumber) == null)
                    println("Invalid account number!")
                else {
                    customer = searchByAccountNumber(accountNumber)!!
                }
            }
            8 -> customer.transactionHistory.forEach{println(it)}
            0 -> exitProcess(0)
            else -> println("Invalid option")
        }
    }

    private fun openNewAccount() {
        // Each account has details such as account number,
        // name of account holder, account type(Current/Saving) and Transactions.
        try {
            val scanner = Scanner(System.`in`)
            this.accountNumber++

            val accountNumber = this.accountNumber
            println("Account number: $accountNumber")
            print("Account holder: ")
            val accountHolder = scanner.nextLine()
            print("Account type (Current/Saving): ")
            val accountType = scanner.nextLine()
            // add the new customer to the customers database
            customers[accountNumber] = Customer(accountNumber, accountHolder, accountType)
            println("Account is created successfully!")
        } catch (e: IllegalArgumentException) {
            println("Invalid input.")
        } catch (e: Exception) {
            println("Unexpected error occur while creating account, please try again.")
        }
    }

    private fun searchByAccountNumber(accountNumber: Long): Customer? {
        return customers[accountNumber]
    }

    private fun searchByName(accountHolder: String): ArrayList<Customer> {
        val customersDuplicateName = ArrayList<Customer>()
        customers.values.forEach {
            if (it.accountHolder == accountHolder) {
                customersDuplicateName.add(it)
            }
        }
        return customersDuplicateName
    }

    private fun closeAccount() {
        customers.remove(customer.accountNumber)
    }
}

data class Transaction(
    val transactionId: Long,
    val transactionType: String,
    val transactionAmount: Double,
    val dateTimeTransaction: LocalDateTime
) {
    override fun toString(): String {
        return """
            Transaction ID     : $transactionId
            Transaction Type   : $transactionType
            Transaction Amount : $transactionAmount
            Date               : $dateTimeTransaction
            +++++++++++++++++++++++++++++++++++++++++
        """.trimIndent()
    }
}

open class Account(
    protected val accountNumber: Long,
    protected val accountHolder: String,
    var balance: Double = 0.0
) {

    open fun deposit(amount: Double) {
        balance += amount
        println("Successfully deposit $$amount to the bank account")
    }

    open fun withdraw(amount: Double) {
        if (balance < amount) {
            println("Insufficient fund!")
        } else {
            balance -= amount
        }
    }
}

// Saving accounts receives interest at rate 4% per annual on their account balance periodically after every quarter.
// While withdrawing from saving account customer can withdraw all the amount.
class SavingAccount(accountNumber: Long, accountHolder: String) : Account(accountNumber, accountHolder) {

    fun interestRateCompensation() {
        balance += (balance * INTEREST_RATE)
    }
}

// Current accounts does not receive any sort of interest on their account. Also, current account holders should also
// maintain a minimum balance and if the balance falls below this level,  a service charge of 100 is charged.
class CurrentAccount(accountNumber: Long, accountHolder: String) : Account(accountNumber, accountHolder) {

    fun minBalancePenalty() {
        println("Your account balance is below $$MINIMUM_BALANCE, a service charge of $100 will be placed on your account.")
        withdraw(100.0)
    }
}

// Each account has details such as account number, name of account holder and Transactions.
class Customer(val accountNumber: Long, val accountHolder: String, var accountType: String) {
    val transactionHistory = ArrayList<Transaction>()
    lateinit var currentAccount: CurrentAccount
    lateinit var savingAccount: SavingAccount

    init {
        val scanner = Scanner(System.`in`)
        while (true) {
            if (accountType == "Current") {
                currentAccount = CurrentAccount(accountNumber, accountHolder)
                break
            } else if (accountType == "Saving") {
                savingAccount = SavingAccount(accountNumber, accountHolder)
                break
            } else {
                println("Invalid account type!")
                print("Account type (Current/Saving): ")
                accountType = scanner.nextLine()
            }
        }
    }

    fun deposit(amount: Double) {
        if (accountType == "Current") {
            currentAccount.deposit(amount)
        } else {
            savingAccount.deposit(amount)
        }
        transactionHistory.add(Transaction(transactionId, "Deposit", amount, LocalDateTime.now()))
        transactionId++
    }

    fun withdraw(amount: Double) {
        if (accountType == "Current") {
            currentAccount.withdraw(amount)
        } else {
            savingAccount.withdraw(amount)
        }
        transactionHistory.add(Transaction(transactionId, "Withdraw", amount, LocalDateTime.now()))
        transactionId++
    }

    override fun toString(): String {
        return """
            Account Holder: $accountHolder
            Account Number: $accountNumber
            Account Type  : $accountType
            Balance       : ${
                try {
                    currentAccount.balance
                } catch (e: UninitializedPropertyAccessException) {
                    savingAccount.balance
                }
                }
            ----------------------------------------------------------
        """.trimIndent()
    }
}