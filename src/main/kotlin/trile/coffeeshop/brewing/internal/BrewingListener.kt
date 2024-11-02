package trile.coffeeshop.brewing.internal

import org.springframework.context.ApplicationEventPublisher
import org.springframework.modulith.events.ApplicationModuleListener
import org.springframework.stereotype.Component
import trile.coffeeshop.brewing.command.BrewingResultCommand
import trile.coffeeshop.common.Log
import trile.coffeeshop.order.command.BrewingCommand

@Component
internal class BrewingListener(
  private val publisher: ApplicationEventPublisher,

  ) : Log {

  @ApplicationModuleListener
  fun brewing(req: BrewingCommand) {
//    l.info { "Beginning to brewing orderId ${req.orderId} items ${req.items}" }

    // TODO: save items to DB

    publisher.publishEvent(BrewingResultCommand(req.orderId))
  }
}
