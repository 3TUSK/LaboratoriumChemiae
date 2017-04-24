package info.tritusk.laboratoriumchemiae.apparatus

import info.tritusk.laboratoriumchemiae.api.agent.Agent
import info.tritusk.laboratoriumchemiae.api.devices.ReactionContainer
import info.tritusk.laboratoriumchemiae.api.reaction.Reaction
import info.tritusk.laboratoriumchemiae.api.reaction.ReactionType
import info.tritusk.laboratoriumchemiae.library.BlockChemiae
import info.tritusk.laboratoriumchemiae.library.BlockEntityChemiae
import info.tritusk.laboratoriumchemiae.library.Processable
import net.minecraft.block.material.Material

class BlockCentrifuge: BlockChemiae(Material.IRON) {
	
}

class BlockEntityCentrifuge: Processable()

class ReactionCentrifuge : Reaction {
    override fun getIdentity(): ReactionType = ReactionType.Defaults.CENTRIFUGE

    override fun reactants(): Array<Agent> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getIdealProducts(): Array<Agent> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getActualProducts(reactionContainer: ReactionContainer?): Array<Agent> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}