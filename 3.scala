class Account(val accountNumber: String, var balance: Double) {
  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
      println(s"Deposited $amount. New balance: $balance")
    } else {
      println("Invalid deposit amount.")
    }
  }
  
  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      println(s"Withdrew $amount. New balance: $balance")
    } else {
      println("Invalid withdrawal amount.")
    }
  }
  
  def transfer(targetAccount: Account, amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      targetAccount.balance += amount
      println(s"Transferred $amount to ${targetAccount.accountNumber}. Your new balance: $balance")
    } else {
      println("Invalid transfer amount.")
    }
  }
  
  override def toString: String = s"Account($accountNumber, Balance: $balance)"
}

// Example usage
val account1 = new Account("12345", 1000.0)
val account2 = new Account("67890", 500.0)

println("Initial Account States:")
println(account1)
println(account2)

account1.deposit(200.0)
account1.withdraw(50.0)
account1.transfer(account2, 300.0)

println("\nUpdated Account States:")
println(account1)
println(account2)
