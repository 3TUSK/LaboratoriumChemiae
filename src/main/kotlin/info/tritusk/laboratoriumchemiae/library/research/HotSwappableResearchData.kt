package info.tritusk.laboratoriumchemiae.library.research

import info.tritusk.laboratoriumchemiae.api.reaction.Reaction
import info.tritusk.laboratoriumchemiae.api.reaction.ReactionManager
import info.tritusk.laboratoriumchemiae.api.reaction.ReactionType
import info.tritusk.laboratoriumchemiae.api.research.Research
import info.tritusk.laboratoriumchemiae.api.research.ResearchManager
import info.tritusk.laboratoriumchemiae.api.research.data.ResearchData
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.io.Serializable
import javax.annotation.concurrent.NotThreadSafe

/**
 * Mutable implementation of {@linkplain ResearchData}.
 */
@NotThreadSafe
data class HotSwappableResearchData(
        var wrappedResearch : Research?,
        var wrappedReaction : Reaction?) : ResearchData, Serializable {
    constructor() : this(null, null)

    override fun getReaction() : Reaction = wrappedReaction ?: ReactionManager.EMPTY_REACTION

    override fun getResearch() : Research = wrappedResearch ?: ResearchManager.EMPTY_RESEARCH

    private fun writeObject(out: ObjectOutputStream) {
        out.writeUTF(wrappedResearch?.researchName ?: "")
    }

    private fun readObject(`in`: ObjectInputStream) {
        wrappedResearch = ResearchManager.INSTANCE.findResearch(`in`.readUTF()).get()
        //val reactionID = `in`.readUTF()
        wrappedReaction = ReactionManager.INSTANCE.getAll(ReactionType.values()[`in`.readInt()]).findLast { true } //TODO
    }

    private fun readObjectNoData() = Unit // Nothing happened, keep wrapped research and reaction as null

}