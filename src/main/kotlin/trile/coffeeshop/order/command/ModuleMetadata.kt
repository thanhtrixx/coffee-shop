package trile.coffeeshop.order.command

import org.springframework.modulith.ApplicationModule
import org.springframework.modulith.NamedInterface
import org.springframework.modulith.PackageInfo

@PackageInfo
@NamedInterface("command")
@ApplicationModule(type = ApplicationModule.Type.OPEN, allowedDependencies = ["brewing"])
class ModuleMetadata
