package info.tritusk.laboratoriumchemiae.library

import info.tritusk.laboratoriumchemiae.api.devices.AgentInput
import info.tritusk.laboratoriumchemiae.api.devices.AgentOutput
import info.tritusk.laboratoriumchemiae.api.devices.ResearchDataInput
import info.tritusk.laboratoriumchemiae.api.reaction.Reaction
import info.tritusk.laboratoriumchemiae.api.reaction.ReactionType
import info.tritusk.laboratoriumchemiae.api.research.ResearchManager
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.nbt.NBTTagIntArray
import net.minecraft.nbt.NBTTagList
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.ITickable

abstract class Processible<out R : Reaction> : TileEntity(), ITickable { //TODO OpenComputer? Practical Logistics 2?

    protected val rType : ReactionType? = null //TODO You cannot invoke getIdentity() directly, then how to get ReactionType?
    protected val inputs : MutableSet<AgentInput<*>> = mutableSetOf()
    protected val outputs : MutableSet<AgentOutput<*>> = mutableSetOf()
    protected var data : ResearchDataInput<*>? = null

    override fun update() = if (!world.isRemote) updateServer() else updateClient()

    private fun updateServer() {
        val currData = data //Thread-safe, if I read it right.
        if (currData != null && currData.currentResearch() != ResearchManager.EMPTY_RESEARCH) {
            //TODO ONLY DO REACTION WHEN WE HAVE RECIPE DATA
        }
    }

    private fun updateClient() {
        // TODO do some client -> server synchronization stuff
    }



    override fun readFromNBT(compound: NBTTagCompound) = super.readFromNBT(compound.also {
        it.getTagList("inputs", 9).also {  }
    })

    override fun writeToNBT(compound: NBTTagCompound) = super.writeToNBT(compound).also {
        it.setTag("inputs", NBTTagList().also { inputs.forEachIndexed { index, agentInput -> it[index] = NBTTagIntArray(agentInput.pos()) } })
        it.setTag("outputs", NBTTagList().also { outputs.forEachIndexed { index, agentOutput -> it[index] = NBTTagIntArray(agentOutput.pos())} })
    }
}

