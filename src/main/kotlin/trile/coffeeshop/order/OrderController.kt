package trile.coffeeshop.order

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("order")
internal class OrderController(
  private val orderService: OrderService
) {

  @GetMapping("/{orderId}")
  fun getOrderInfo(@PathVariable orderId: Long): OrderInfo {
    return orderService.getOrderInfo(orderId)
  }

  @PostMapping("/")
  fun createOrder(@RequestBody req: CreateOrderRequest): CreateOrderResponse {
    return orderService.createOther(req)
  }
}
