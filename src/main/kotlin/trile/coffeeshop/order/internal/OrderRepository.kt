package trile.coffeeshop.order.internal

import org.springframework.data.repository.CrudRepository

interface OrderRepository : CrudRepository<OrderEntity, Long>
