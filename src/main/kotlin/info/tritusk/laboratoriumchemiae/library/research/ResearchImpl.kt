package info.tritusk.laboratoriumchemiae.library.research

import info.tritusk.laboratoriumchemiae.api.research.Research
import info.tritusk.laboratoriumchemiae.api.research.ResearchTag

data class ResearchImpl(val name : String, val tags : Array<ResearchTag>) : Research {
    override fun getResearchName(): String = name

    override fun getResearchTags(): Array<ResearchTag> = tags

    override fun equals(other: Any?) = other is Research && other.researchName == this.name

    override fun hashCode() = name.hashCode()
}