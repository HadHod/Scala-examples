# Scala examples

* sieve algorithm on streams
```scala
def from(n: Int): Stream[Int] = n #:: from(n + 1)

def sieve(s: Stream[Int]): Stream[Int] =
    s.head #:: sieve(s.tail filter (_ % s.head != 0))

val primes = sieve(from(2))
```
* List[Future[T]] to Future[List[T]]
```scala
def sequence[T](fts: List[Future[T]]): Future[List[T]] = {
    fts match {
        case Nil         => Future(Nil)
        case (ft :: fts) => ft.flatMap(t => sequence(fts).flatMap(ts => Future(t :: ts)))
    }
}
```
