package trile.coffeeshop.order.internal

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class OrderEntity(
  val amount: Int,
  val status: String,
  val address: String,

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long? = null,
)
