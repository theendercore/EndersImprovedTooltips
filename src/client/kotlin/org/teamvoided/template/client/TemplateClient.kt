package org.teamvoided.template.client

import me.fzzyhmstrs.fzzy_config.api.ConfigApi
import net.minecraft.client.gui.screens.Screen
import org.teamvoided.template.Template
import org.teamvoided.template.Template.MODID
import org.teamvoided.template.client.config.EITConfig

@Suppress("unused")
object TemplateClient {
    @JvmField
    var config = ConfigApi.registerAndLoadConfig(::EITConfig)
    fun init() {
        Template.log.info("Hello from $MODID")
    }

    fun hasShift() = Screen.hasShiftDown()
    fun hasCtrl() = Screen.hasControlDown()
    fun hasAlt() = Screen.hasAltDown()
}