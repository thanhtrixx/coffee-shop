package trile.coffeeshop.order.internal

import jakarta.transaction.Transactional
import org.springframework.context.ApplicationEventPublisher
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import trile.coffeeshop.order.BrewingCommand
import trile.coffeeshop.common.Log
import trile.coffeeshop.common.exception.InvalidParamException
import trile.coffeeshop.order.CreateOrderRequest
import trile.coffeeshop.order.CreateOrderResponse
import trile.coffeeshop.order.OrderInfo
import trile.coffeeshop.order.OrderService
import trile.coffeeshop.order.OrderStatus

@Service
internal class OtherServiceImpl(
  private val repository: OrderRepository,
  private val publisher: ApplicationEventPublisher,
) : OrderService, Log {

  override fun getOrderInfo(orderId: Long): OrderInfo {
    val orderEntity = repository.findByIdOrNull(orderId)
      ?: throw InvalidParamException("Order with id $orderId not found")
    // TODO: get delivery information
    // TODO: get items information
    return OrderInfo(
      id = orderEntity.id!!,
      amount = orderEntity.amount,
      status = OrderStatus.valueOf(orderEntity.status),
      address = orderEntity.address,
      items = emptyList()
    )
  }

  @Transactional
  override fun createOther(orderReq: CreateOrderRequest): CreateOrderResponse {
    l.info("Starting create order")

    val orderEntity = repository.save(
      OrderEntity(
        amount = calculateOrderAmount(orderReq.items, orderReq.address),
        status = OrderStatus.INIT.name,
        address = orderReq.address
      )
    )

    publisher.publishEvent(BrewingCommand(orderEntity.id!!, orderReq.items))

    return CreateOrderResponse(
      id = orderEntity.id ?: 0L,
      amount = orderEntity.amount,
      status = OrderStatus.valueOf(orderEntity.status)
    )
  }

  private fun calculateOrderAmount(items: List<String>, address: String): Int {
    return 100
  }
}
