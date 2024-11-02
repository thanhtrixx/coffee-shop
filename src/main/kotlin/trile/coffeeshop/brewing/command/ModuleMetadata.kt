package trile.coffeeshop.brewing.command

import org.springframework.modulith.ApplicationModule
import org.springframework.modulith.NamedInterface
import org.springframework.modulith.PackageInfo

@PackageInfo
@NamedInterface("command")
@ApplicationModule(type = ApplicationModule.Type.OPEN, allowedDependencies = ["order"])
class ModuleMetadata
