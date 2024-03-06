//Функция uniq: List[Int] => (List[Int], Boolean), удаляющая дублирующиеся числа из списка отсортированных по возрастанию целых чисел. 
//Функция возвращает пару, первым элементом которой является результирующий список, а вторым — признак успешного выполнения.
//Выполнение может быть неуспешным, если исходный список не отсортирован по возрастанию.

val uniq_helper: (List[Int], List[Int]) => (List[Int], Boolean) = {
  case (xs, Nil) => (reverse(xs), true)
  case (Nil, y::ys) => uniq_helper(List[Int](y), ys)
  case (x::xs, y::ys) if x > y => (reverse(x::xs):::(y::ys), false)
  case (x::xs, y::ys) if x == y => uniq_helper(x::xs, ys)
  case (xs, y::ys) => uniq_helper(y::xs, ys)
}

// uniq_helper(List[Int](), List[Int](1, 1, 2, 2, 5))
// uniq_helper(List[Int](1), List[Int](1, 2, 2, 5))
// uniq_helper(List[Int](1), List[Int](2, 2, 5))
// uniq_helper(List[Int](2, 1), List[Int](2, 5))
// uniq_helper(List[Int](2, 1), List[Int](5))
// uniq_helper(List[Int](5, 2, 1), List[Int]())
// return (reverse(List[Int](5, 2, 1), true))

val reverse_helper: (List[Int], List[Int]) => List[Int] = {   // 3 6 1 8
  case (xs, Nil) => xs
  case (xs, y::ys) => reverse_helper(y::xs, ys)
}

val reverse: List[Int] => List[Int] = {
  case xs => reverse_helper(List[Int](), xs)
}
// Function reverse
// reverse(List[int](), List[int](3, 6, 1, 8))
// reverse(List[int](3), List[int](6, 1, 8))
// reverse(List[int](6, 3), List[int](1, 8))
// reverse(List[int](1, 6, 3), List[int](8))
// reverse(List[int](8, 1, 6, 3), List[int]())
// return List[int](8, 1, 6, 3)



val uniq: List[Int] => (List[Int], Boolean) = {
  case xs => uniq_helper(List[Int](), xs)
}

println(uniq(List[Int](1, 1, 1, 2, 2, 2, 5, 5)))
println(uniq(List[Int](1, 1, 3, 2, 2, 2, 5, 5)))


 



