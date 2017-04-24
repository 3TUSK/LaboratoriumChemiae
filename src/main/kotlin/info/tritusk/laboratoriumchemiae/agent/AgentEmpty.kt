package info.tritusk.laboratoriumchemiae.agent

import info.tritusk.laboratoriumchemiae.api.agent.Agent

internal object AgentEmpty : Agent {
    override fun type() = ""
    override fun form() = ""
    override fun getSize() = 0
    override fun setSize(newSize : Int) = Unit
}