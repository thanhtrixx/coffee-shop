package trile.coffeeshop

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.modulith.core.ApplicationModule
import org.springframework.modulith.core.ApplicationModules
import org.springframework.modulith.docs.Documenter
import trile.coffeeshop.common.Log

@SpringBootTest
class CoffeeShopAppTests : Log {

  private val modules = ApplicationModules.of(CoffeeShopApp::class.java)

  @Test
  fun printModuleInformation() {
    modules.forEach { module: ApplicationModule ->
      l.info { "Module $module" }
    }
  }

  @Test
  fun createModuleDocumentation() {
    Documenter(modules)
      .writeDocumentation()
      .writeModuleCanvases()
      .writeAggregatingDocument()
      .writeModulesAsPlantUml()
      .writeIndividualModulesAsPlantUml()
  }

  @Test
  fun verifiesModularStructure() {
    modules.verify()
  }
}
