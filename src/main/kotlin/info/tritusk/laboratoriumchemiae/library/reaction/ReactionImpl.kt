package info.tritusk.laboratoriumchemiae.library.reaction

import info.tritusk.laboratoriumchemiae.api.reaction.*

abstract class ReactionLabChm(id: ReactionType): Reaction {
    private val identity: ReactionType = id
    override fun getIdentity() = identity
}
