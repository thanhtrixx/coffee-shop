package trile.coffeeshop.order

data class OrderInfo(
  val id: Long,
  val amount: Int,
  val status: OrderStatus,
  val address: String,
  val items: List<String>
)

enum class OrderStatus {
  INIT,
  MAKING,
  MADE,
  DELIVERING,
  DELIVERED

}
