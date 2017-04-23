package info.tritusk.laboratoriumchemiae.library

import info.tritusk.laboratoriumchemiae.api.agent.Agent
import info.tritusk.laboratoriumchemiae.api.devices.AgentInput
import info.tritusk.laboratoriumchemiae.api.devices.AgentOutput
import info.tritusk.laboratoriumchemiae.api.devices.ResearchDataInput
import info.tritusk.laboratoriumchemiae.api.reaction.ReactionType
import info.tritusk.laboratoriumchemiae.api.research.Research
import info.tritusk.laboratoriumchemiae.api.research.ResearchManager
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.ITickable

abstract class Processible<out R : ReactionType> : TileEntity(), ITickable {

    protected val inputs : MutableSet<AgentInput<*>> = mutableSetOf()
    protected val outputs : MutableSet<AgentOutput<*>> = mutableSetOf()
    protected var data : ResearchDataInput<*>? = null

    protected var status = WorkStatus.IDLE
    private var tickCounter = 0
    protected var reactionStartSignal = false

    override fun update() = if (tickCounter++ == 20 && !world.isRemote) updateServer() else updateClient()

    private fun updateServer() {
        val currData = data //Thread-safe, if I read it right.
        if (currData != null && currData.currentResearch() != ResearchManager.EMPTY_RESEARCH) {
            //TODO ONLY DO REACTION WHEN WE HAVE RECIPE DATA
            if (reactionStartSignal) {
                val reactionProcess = launch(CommonPool) {
                    reactionStart(
                            data?.currentResearch() ?: ResearchManager.EMPTY_RESEARCH,
                            inputs.map { it.containedAgent }.toTypedArray()
                    )
                }.invokeOnCompletion {
                    status = WorkStatus.IDLE
                }
            }
        }
    }

    private fun updateClient() {
        // TODO do some client -> server synchronization stuff
    }

    suspend fun reactionStart(data : Research, inputs : Array<Agent>) {
        status = WorkStatus.WORKING
    }

}

