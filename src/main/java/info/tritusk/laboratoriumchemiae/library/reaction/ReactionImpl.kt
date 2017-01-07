package info.tritusk.laboratoriumchemiae.library.reaction

import info.tritusk.laboratoriumchemiae.api.reaction.*

abstract class ReactionLabChm(id: ReactionIdentifier): Reaction {
	private val identity: ReactionIdentifier = id
	override fun getIdentity() = identity
}

class PhysicalReactionLabChm(id: ReactionIdentifier): ReactionLabChm(id) {
	
	
}

class ChemicalReactionLabChm(id: ReactionIdentifier): ReactionLabChm(id) {
	
}