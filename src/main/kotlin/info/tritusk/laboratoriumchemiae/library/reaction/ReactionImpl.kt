package info.tritusk.laboratoriumchemiae.library.reaction

import info.tritusk.laboratoriumchemiae.api.agent.Agent
import info.tritusk.laboratoriumchemiae.api.reaction.*

abstract class ReactionLabChm(id: ReactionType): Reaction {
    private val identity: ReactionType = id
    override fun getIdentity() = identity
}

abstract class PhysicalReactionLabChm(id: ReactionType): ReactionLabChm(id), PhysicalReaction

abstract class ChemicalReactionLabChm(id: ReactionType): ReactionLabChm(id), ChemicalReaction

class PhaseChange(original: Agent, product: Agent): PhysicalReactionLabChm(ReactionType.UNCATEGORIZED) {
    private val reactant: Array<Agent> = arrayOf(original)
    private val product: Array<Agent> = arrayOf(product)
    override fun reactants() = reactant
    override fun products() = product
}

class SimpleChemReaction(val agents: Array<Agent>, val products: Array<Agent>): ChemicalReactionLabChm(ReactionType.CHEM_REACTOR) {
    override fun reactants() = agents
    override fun products() = products
}