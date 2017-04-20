package info.tritusk.laboratoriumchemiae.library.research

import info.tritusk.laboratoriumchemiae.api.research.data.ResearchData
import net.minecraft.nbt.NBTTagCompound

object ResearchUtil {

    fun ResearchData.deserializeNBT(tag: NBTTagCompound) {

    }

    fun ResearchData.serializeNBT() : NBTTagCompound = NBTTagCompound()
}
