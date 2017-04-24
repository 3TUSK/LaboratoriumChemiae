package info.tritusk.laboratoriumchemiae.agent

import gnu.trove.map.TObjectIntMap
import gnu.trove.map.hash.TObjectIntHashMap
import net.minecraft.item.ItemStack
import oreregistry.api.OreRegistryApi

object AgentRegistry {
	private val mapping: TObjectIntMap<String> = TObjectIntHashMap()
	
	fun getProductMol(stack: ItemStack) = getProductMol(OreRegistryApi.info.getProductInfo(stack)?.productType)
	
	fun getProductMol(type: String?) = mapping[type]
	
	fun setProductMolNum(type: String, mB: Int) = mapping.put(type, mB)
}
