class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator must be non-zero")
  private val gcdVal = gcd(n.abs, d.abs)
  val numer: Int = n / gcdVal
  val denom: Int = d / gcdVal

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def sub(other: Rational): Rational = {
    new Rational(numer * other.denom - other.numer * denom, denom * other.denom)
  }

  override def toString: String = s"$numer/$denom"
}

object RationalTest extends App {
  val x = new Rational(3, 4)
  val y = new Rational(5, 8)
  val z = new Rational(2, 7)

  val result = x.sub(y).sub(z)
  println(s"Result of (xy - z) = $result")
}
