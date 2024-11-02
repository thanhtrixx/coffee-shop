package trile.coffeeshop.order

interface OrderService {

  fun getOrderInfo(orderId: Long): OrderInfo

  fun createOther(orderReq: CreateOrderRequest): CreateOrderResponse
}
