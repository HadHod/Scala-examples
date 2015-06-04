# Scala examples

* sieve algorithm on streams
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
