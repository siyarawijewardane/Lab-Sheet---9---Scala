class Account(val accountNumber: Int, var balance: Double) {
  override def toString: String = s"Account($accountNumber, $balance)"
}

class Bank(val accounts: List[Account]) {
  def accountsWithNegativeBalances: List[Account] = accounts.filter(_.balance < 0)

  def calculateTotalBalance: Double = accounts.map(_.balance).sum

  def applyInterest(): Unit = {
    for (account <- accounts) {
      if (account.balance > 0) {
        account.balance *= 1.05 // Deposit interest of 5%
      } else {
        account.balance *= 1.1 // Overdraft interest of 10%
      }
    }
  }
}

object Main extends App {
  val account1 = new Account(1, 100.0)
  val account2 = new Account(2, -50.0)
  val account3 = new Account(3, 200.0)

  val bank = new Bank(List(account1, account2, account3))

  println("Accounts with negative balances:")
  val negativeBalances = bank.accountsWithNegativeBalances
  negativeBalances.foreach(println)

  val totalBalance = bank.calculateTotalBalance
  println(s"Total balance of all accounts: $totalBalance")

  bank.applyInterest()
  println("Balances after applying interest:")
  bank.accounts.foreach(println)
}
