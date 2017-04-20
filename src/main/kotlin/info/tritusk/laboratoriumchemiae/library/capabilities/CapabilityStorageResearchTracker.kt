package info.tritusk.laboratoriumchemiae.library.capabilities

import net.minecraft.nbt.NBTBase
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.EnumFacing
import net.minecraftforge.common.capabilities.Capability as Cap

import info.tritusk.laboratoriumchemiae.api.research.tracker.ResearchTracker

class CapabilityStorageResearchTracker: Cap.IStorage<ResearchTracker> {
	
	override fun readNBT(capability: Cap<ResearchTracker>, ins: ResearchTracker, facing: EnumFacing?, nbt: NBTBase) {
		if (nbt is NBTTagCompound) {
			
		}
	}
	
	override fun writeNBT(capability: Cap<ResearchTracker>, ins: ResearchTracker, facing: EnumFacing?): NBTTagCompound {
		val tag = NBTTagCompound()
		return tag
	}
}