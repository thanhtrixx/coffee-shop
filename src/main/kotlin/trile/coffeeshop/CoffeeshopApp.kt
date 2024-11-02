package trile.coffeeshop

import org.springframework.boot.runApplication
import org.springframework.modulith.Modulith
import org.springframework.scheduling.annotation.EnableAsync

@Modulith
@EnableAsync
class CoffeeShopApp

fun main(args: Array<String>) {
  runApplication<CoffeeShopApp>(*args)
}
