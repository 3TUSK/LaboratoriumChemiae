package info.tritusk.laboratoriumchemiae

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent as FMLPreInitEvent
import net.minecraftforge.fml.common.event.FMLInitializationEvent as FMLInitEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent as FMLPostInitEvent

open class ProxyChemiaeCommon: ProxyChemiae {
	override fun pre(event: FMLPreInitEvent) = Unit
	
	override fun pro(event: FMLInitEvent) = Unit
	
	override fun post(event: FMLPostInitEvent) = Unit
}

class ProxyChemiaeServer: ProxyChemiaeCommon()

class ProxyChemiaeClient: ProxyChemiaeCommon()