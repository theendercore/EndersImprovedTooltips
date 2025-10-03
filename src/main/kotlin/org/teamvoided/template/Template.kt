package org.teamvoided.template

import net.minecraft.resources.ResourceLocation
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Suppress("unused")
object Template {
    const val MODID = "enders_improved_tooltips"

    @JvmField
    val log: Logger = LoggerFactory.getLogger(Template::class.simpleName)
    fun init() {
        log.info("Hello from Common")
    }

    fun id(path: String) = ResourceLocation.fromNamespaceAndPath(MODID, path)
}
