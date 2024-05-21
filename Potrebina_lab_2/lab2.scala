class MultSet private (p: Int => Boolean) {
    protected val predicate = p

    def this(k: Int) = this(
        (number: Int) => number % k == 0
    )

    def this() = this(1)

    def in(number: Int): Boolean = predicate(number)

    def +(otherSet: MultSet): MultSet = new MultSet(
        (number: Int) => predicate(number) || otherSet.predicate(number)
    )

    def *(otherSet: MultSet) : MultSet = new MultSet(
        (number: Int) => predicate(number) && otherSet.predicate(number)
    )
}



val s1 = MultSet(3) // множество чисел : на 3
val s2 = MultSet(5)

println("Множество 5: " + s1.in(5))
println("Множество 3: " + s1.in(3))
println("--s1 + s2--")
val a = s1 + s2
println("---------------")
println("Множество 3: " + a.in(3))
println("Множество 4: " + a.in(4))
println("Множество 5: " + a.in(5))
println("--s1 * s2--")
val m = s1 * s2
println("Множество 3: " + m.in(3))
println("Множество 5: " + m.in(5))
println("Множество 15: " + m.in(15))



