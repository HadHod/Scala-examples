def pascal(n: Int): List[Int] = {

    if (n < 1) return List()

    def generatePascal(l: List[Int]): List[Int] = l match {
        case Nil      => Nil
        case h :: Nil => Nil
        case h :: t   => h + t.head :: generatePascal(t)
    }

    def run(level: Int, result: List[Int]): List[Int] = level match {
        case 1 => result
        case n => run(n - 1, 1 :: generatePascal(result) ::: List(1))
    }

    run(n, List(1))
}