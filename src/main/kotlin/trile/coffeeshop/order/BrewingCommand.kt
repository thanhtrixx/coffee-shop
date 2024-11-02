package trile.coffeeshop.order

data class BrewingCommand(val orderId: Long, val items: List<String>)
