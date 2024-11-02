package trile.coffeeshop.order

data class CreateOrderRequest(
  val address: String,
  val items: List<String>
)

data class CreateOrderResponse(
  val id: Long,
  val amount: Int,
  val status: OrderStatus,
)
