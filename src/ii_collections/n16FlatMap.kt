package ii_collections

fun example() {

    val result = listOf("abc", "12").flatMap { it.toList() }

    result == listOf('a', 'b', 'c', '1', '2')
}

val Customer.orderedProducts get() = orders.map { it.products }.flatten().toSet()
val Shop.allOrderedProducts get() = customers.map { it.orderedProducts }.flatten().toSet()
