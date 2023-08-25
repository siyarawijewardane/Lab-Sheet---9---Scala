class Rational(numerator: Int, denominator: Int) {

      require(denominator != 0, "Denominator cannot be zero")
      
      private val gcdValue: Int = gcd(numerator.abs, denominator.abs)

      val numer: Int = numerator / gcdValue
      val denom: Int = denominator / gcdValue

      private def gcd(a: Int, b: Int): Int = {
        
        if (b == 0) a else gcd(b, a % b)

      }

      def neg: Rational = new Rational(-numer, denom)

      override def toString: String = s"$numer/$denom"
}

object RationalExample {

      def main(args: Array[String]): Unit = {

        val rational = new Rational(3, 4)     
        print(rational.neg) 

      }
}
