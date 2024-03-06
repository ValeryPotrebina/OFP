### Лабораторная работа № 1
### «Введение в функциональное программирование на языке Scala»


# Цель работы
Целью данной работы является ознакомление с программированием на языке Scala на основе чистых функций.

# Индивидуальный вариант
Функция uniq: List[Int] => (List[Int], Boolean), удаляющая дублирующиеся числа из списка 
отсортированных по возрастанию целых чисел. Функция возвращает пару, первым элементом которой
является результирующий список, а вторым — признак успешного выполнения. Выполнение может быть 
неуспешным, если исходный список не отсортирован по возрастанию.

# Реализация и тестирование

Работа в REPL-интерпретаторе Scala:

```scala
val uniq_helper: (List[Int], List[Int]) => (List[Int], Boolean) = {
  case (xs, Nil) => (reverse(xs), true)
  case (Nil, y::ys) => uniq_helper(List[Int](y), ys)
  case (x::xs, y::ys) if x > y => (reverse(x::xs):::(y::ys), false)
  case (x::xs, y::ys) if x == y => uniq_helper(x::xs, ys)
  case (xs, y::ys) => uniq_helper(y::xs, ys)
}

val reverse_helper: (List[Int], List[Int]) => List[Int] = {   // 3 6 1 8
  case (xs, Nil) => xs
  case (xs, y::ys) => reverse_helper(y::xs, ys)
}

val reverse: List[Int] => List[Int] = {
  case xs => reverse_helper(List[Int](), xs)
}

val uniq: List[Int] => (List[Int], Boolean) = {
  case xs => uniq_helper(List[Int](), xs)
}

println(uniq(List[Int](1, 1, 1, 2, 2, 2, 5, 5)))
println(uniq(List[Int](1, 1, 3, 2, 2, 2, 5, 5)))
```

# Вывод программы

```
scala> :load lab1.scala
(List(1, 2, 5),true)
(List(1, 3, 2, 2, 2, 5, 5),false)
val uniq_helper: (List[Int], List[Int]) => (List[Int], Boolean) = Lambda$1767/0x0000000800946840@643a73fa
val reverse_helper: (List[Int], List[Int]) => List[Int] = Lambda$1768/0x0000000800947040@2686a801
val reverse: List[Int] => List[Int] = Lambda$1769/0x0000000800948040@39acf187
val uniq: List[Int] => (List[Int], Boolean) = Lambda$1770/0x0000000800948840@7878459f
```