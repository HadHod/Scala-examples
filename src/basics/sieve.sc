package basics

object sieve {
    def getPrimes(n: Int): List[Int] = {
        def from(n: Int): Stream[Int] = n #:: from(n + 1)
        def sieve(s: Stream[Int]): Stream[Int] = s.head #:: sieve(s.tail filter (_ % s.head != 0))
        val primes = sieve(from(2))

        primes.take(n).toList
    }                                             //> getPrimes: (n: Int)List[Int]
    
    getPrimes(5)                                  //> res0: List[Int] = List(2, 3, 5, 7, 11)
}