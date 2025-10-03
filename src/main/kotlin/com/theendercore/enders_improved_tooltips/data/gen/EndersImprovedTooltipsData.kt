package com.theendercore.enders_improved_tooltips.data.gen

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.minecraft.core.RegistrySetBuilder
import com.theendercore.enders_improved_tooltips.EndersImprovedTooltips.log

@Suppress("unused")
object EndersImprovedTooltipsData : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(gen: FabricDataGenerator) {
        log.info("Hello from DataGen")
//        val pack = gen.createPack()

//        pack.addProvider(::TemplateWorldGenerator)
    }

    override fun buildRegistry(gen: RegistrySetBuilder) {
//        gen.add(RegistryKeys.BIOME, TemplateBiomes::boostrap)
    }
}
