package org.teamvoided.template.client

import me.fzzyhmstrs.fzzy_config.api.ConfigApi
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.MutableComponent
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

    fun getIndent(): MutableComponent = Component.literal(" ".repeat(config.indentSpaces.get()))
    fun indented(lang: Component): MutableComponent = getIndent().append(lang)
}