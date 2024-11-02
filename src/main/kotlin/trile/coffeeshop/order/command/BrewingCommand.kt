package trile.coffeeshop.order.command

data class BrewingCommand(val orderId: Long, val items: List<String>)
