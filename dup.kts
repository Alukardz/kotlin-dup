fun removeDuplicates(num_duplicados: IntArray): IntArray {
  val n: Int
  var p2 = 0

  var num_sort = num_duplicados.sortedArray()
  n = num_sort.size

  if (n <= 1) {
    return num_sort
  }

  for (p1 in 1..n-1) {
    if (num_sort[p1] != num_sort[p2]) {
      p2++
      num_sort[p2] = num_sort[p1]
    }
  }
  
  return num_sort.slice(0..p2).toIntArray()
}

if (args.size >= 2 && args.contains("-a")) {
  try {
    var num_duplicados: IntArray = args[1 + args.indexOf("-a")].split(",").map { it.toInt() }.toIntArray()
    var numbers = removeDuplicates(num_duplicados)
    println(numbers.joinToString(", "))
  }
  catch (e: Exception) {
    println("Lista de numeros inválida. ej: '1,2,3'")
  }
} else {
  println("Debe especificar '-a' seguido de una lista de numeros.")
}

