package oop

object linearization {
    class C1 {
        def m = List("C1")
    }

    trait T1 extends C1 {
        override def m = { "T1" :: super.m }
    }

    trait T2 extends C1 {
        override def m = { "T2" :: super.m }
    }

    trait T3 extends C1 {
        override def m = { "T3" :: super.m }
    }

    class C2 extends T1 with T2 with T3 {
        override def m = { "C2" :: super.m }
    }

    val c2 = new C2                               //> c2  : oop.linearization.C2 = oop.linearization$C2@61e4705b
    println(c2.m)                                 //> List(C2, T3, T2, T1, C1)
}