package info.tritusk.laboratoriumchemiae

import javax.annotation.Nonnull

import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.SidedProxy
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent as FMLPreInitEvent
import net.minecraftforge.fml.common.event.FMLInitializationEvent as FMLInitEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent as FMLPostInitEvent

const val MOD_ID = "laboratoriumchemiae"
const val MOD_NAME = "Laboratorium Chemiae"
const val SERVER_PROXY = "info.tritusk.laboratoriumchemiae.ProxyChemiaeServer"
const val CLIENT_PROXY = "info.tritusk.laboratoriumchemiae.ProxyChemiaeClient"

@Mod(modid = MOD_ID, name = MOD_NAME, version = "@VERSION", useMetadata = true, modLanguage = "kotlin", modLanguageAdapter = "net.shadowfacts.forgelin.KotlinAdapter")
object LaboratoriumChemiae {
	
	@SidedProxy(serverSide = SERVER_PROXY, clientSide = CLIENT_PROXY)
	lateinit var proxy: ProxyChemiae
	
	@Mod.EventHandler fun pre(event: FMLPreInitEvent) = proxy.pre(event)
	
	@Mod.EventHandler fun pro(event: FMLInitEvent) = proxy.pro(event)
	
	@Mod.EventHandler fun post(event: FMLPostInitEvent) = proxy.post(event)
	
}
