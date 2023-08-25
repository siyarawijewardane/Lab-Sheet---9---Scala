class Rational(numerator: Int, denominator: Int) {

      require(denominator != 0, "Denominator must not be zero")
      
      private val gcdValue = gcd(numerator.abs, denominator.abs)

      val numer: Int = numerator / gcdValue
      val denom: Int = denominator / gcdValue
      
      private def gcd(a: Int, b: Int): Int = {
        
        if (b == 0) a else gcd(b, a % b)
      }
      
      def sub(other: Rational): Rational = {
        new Rational(numer * other.denom - other.numer * denom, denom * other.denom)
      }
      
      override def toString: String = s"$numer/$denom"
}

object RationalExample {

  def main(args: Array[String]): Unit = {
    
        val x = new Rational(3, 4)
        val y = new Rational(5, 8)
        val z = new Rational(2, 7)
        
        val result = x.sub(y).sub(z)
        print(result)
    
  }
  
}

