package info.tritusk.laboratoriumchemiae

import info.tritusk.laboratoriumchemiae.apparatus.BlockResearchCenter
import info.tritusk.laboratoriumchemiae.apparatus.ResearchArchive
import info.tritusk.laboratoriumchemiae.library.capabilities.*
import info.tritusk.laboratoriumchemiae.research.TileResearchArchive
import net.minecraft.creativetab.CreativeTabs
import net.minecraftforge.fml.common.registry.GameRegistry
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent as FMLPreInitEvent
import net.minecraftforge.fml.common.event.FMLInitializationEvent as FMLInitEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent as FMLPostInitEvent
import org.apache.logging.log4j.Logger

open class ProxyChemiaeCommon: ProxyChemiae {
    lateinit var logger: Logger

    override fun pre(event: FMLPreInitEvent) {
        logger = event.modLog
        initCapabilities()
        GameRegistry.register(BlockResearchCenter().setCreativeTab(CreativeTabs.MISC).setRegistryName("research_center"))
	    GameRegistry.register(ResearchArchive().setRegistryName("research_archive"))
        GameRegistry.registerTileEntity(TileResearchArchive::class.java, "labchem_research_archive")
    }

    override fun pro(event: FMLInitEvent) = Unit

    override fun post(event: FMLPostInitEvent) = Unit
}

class ProxyChemiaeServer: ProxyChemiaeCommon()

class ProxyChemiaeClient: ProxyChemiaeCommon()