package com.theendercore.enders_improved_tooltips.client

import me.fzzyhmstrs.fzzy_config.api.ConfigApi
import net.minecraft.client.gui.screens.Screen
import com.theendercore.enders_improved_tooltips.EndersImprovedTooltips
import com.theendercore.enders_improved_tooltips.EndersImprovedTooltips.MODID
import com.theendercore.enders_improved_tooltips.client.config.EITConfig

@Suppress("unused")
object EndersImprovedTooltipsClient {
    @JvmField
    var config = ConfigApi.registerAndLoadConfig(::EITConfig)
    fun init() {
        EndersImprovedTooltips.log.info("Hello from $MODID")
    }

    fun hasShift() = Screen.hasShiftDown()
    fun hasCtrl() = Screen.hasControlDown()
    fun hasAlt() = Screen.hasAltDown()
}