package info.tritusk.laboratoriumchemiae.agent

import info.tritusk.laboratoriumchemiae.api.agent.Agent

internal data class AgentImpl(val resource: String, val form: String, var qty: Int): Agent {

    override fun type() = resource

    override fun form() = form

    override fun getSize() = qty

    override fun setSize(newSize: Int) { qty = newSize }

    override fun equals(other: Any?) = when(other) {
        is Agent -> other.type() == this.resource && other.form() == this.form
        else -> false
    }

    override fun hashCode() = this.resource.hashCode() * 37 + this.form.hashCode()
}