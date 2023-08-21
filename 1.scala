class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be zero")

  private val gcdVal = gcd(n.abs, d.abs)
  val numerator: Int = n / gcdVal
  val denominator: Int = d / gcdVal

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def neg: Rational = new Rational(-numerator, denominator)

  override def toString: String = {
    if (denominator == 1) s"$numerator"
    else s"$numerator/$denominator"
  }
}

object Rational {
  def apply(n: Int, d: Int): Rational = new Rational(n, d)
}

// Example usage
val x = Rational(3, 4)
val neg_x = x.neg

println(s"x: $x")         // Output: x: 3/4
println(s"-x: $neg_x")    // Output: -x: -3/4
