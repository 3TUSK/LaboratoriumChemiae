package info.tritusk.laboratoriumchemiae.agent

import info.tritusk.laboratoriumchemiae.api.agent.Agent

object AgentEmpty : Agent {
    override fun type() = ""
    override fun form() = ""
    override fun size() = 0
}