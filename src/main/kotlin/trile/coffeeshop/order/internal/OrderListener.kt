package trile.coffeeshop.order.internal

import jakarta.transaction.Transactional
import org.springframework.context.ApplicationEventPublisher
import org.springframework.modulith.events.ApplicationModuleListener
import org.springframework.stereotype.Component
import trile.coffeeshop.brewing.BrewingResultCommand
import trile.coffeeshop.common.Log
import trile.coffeeshop.order.OrderStatus

@Component
internal class OrderListener(
  private val orderRepository: OrderRepository,
  private val publisher: ApplicationEventPublisher,
) : Log {

  @Transactional
  @ApplicationModuleListener
  fun handleBrewingResult(brewingResult: BrewingResultCommand) {
    orderRepository
      .findById(brewingResult.orderId)
      .map { order ->
        l.info("Changing order status to MADE")
        orderRepository.save(order.copy(status = OrderStatus.MADE.name))
      }
  }
}
