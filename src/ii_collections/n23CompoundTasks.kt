package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product) = customers
        .filter { it.orderedProducts.contains(product) }
        .toSet()

fun Customer.getMostExpensiveDeliveredProduct() = orders
        .filter { it.isDelivered }
        .map { it.products }
        .flatten()
        .maxBy { it.price }

fun Shop.getNumberOfTimesProductWasOrdered(product: Product) = customers
        .map { it.orders }
        .flatten()
        .map { it.products }
        .flatten()
        .count { it == product }
