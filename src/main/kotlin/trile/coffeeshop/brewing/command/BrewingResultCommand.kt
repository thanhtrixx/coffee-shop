package trile.coffeeshop.brewing.command

import java.time.LocalDateTime

data class BrewingResultCommand(
  val orderId: Long,
  val completedDateTime: LocalDateTime = LocalDateTime.now()
)
