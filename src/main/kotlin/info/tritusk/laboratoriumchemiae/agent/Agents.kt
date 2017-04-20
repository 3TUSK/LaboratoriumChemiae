@file:JvmName("Agents")
package info.tritusk.laboratoriumchemiae.agent

import info.tritusk.laboratoriumchemiae.api.agent.Agent
import net.minecraft.item.ItemStack
import oreregistry.api.OreRegistryApi

fun Agent.getItemStack(): ItemStack =
        OreRegistryApi.registry.registeredResources[this.type()]?.takeIf {
            it.hasProduct(this.form())
        }?.registeredProducts?.get(this.form()) ?: ItemStack.EMPTY

fun create(resource: String, type: String, size: Int = 1): Agent = AgentImpl(resource, type, size)
