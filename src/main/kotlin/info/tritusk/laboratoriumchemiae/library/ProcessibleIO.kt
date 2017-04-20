package info.tritusk.laboratoriumchemiae.library

import info.tritusk.laboratoriumchemiae.api.agent.Agent
import info.tritusk.laboratoriumchemiae.api.devices.AgentInput
import info.tritusk.laboratoriumchemiae.api.devices.AgentOutput
import net.minecraft.item.ItemStack
import net.minecraft.tileentity.TileEntity
import net.minecraftforge.fluids.FluidStack
import net.minecraftforge.fluids.FluidTankInfo
import net.minecraftforge.fluids.IFluidTank
import net.minecraftforge.items.IItemHandler

abstract class AbstractTileInputItem : TileEntity(), AgentInput<ItemStack> {
    override fun getType() = ItemStack::class.java

    override abstract fun consume(agents: Array<Agent>)

    override abstract fun accept(input: ItemStack): ItemStack?

    override fun pos() = intArrayOf(getPos().x, getPos().y, getPos().z)
}

class AbstractTileOutputItem {}

class AbstractTileInputFluid {}

class AbstractTileOutputFluid {}

class InputOnlyItemHandler(val master: AgentInput<ItemStack>) : IItemHandler {
    override fun insertItem(slot: Int, stack: ItemStack, simulate: Boolean): ItemStack = if (simulate) {
        stack.copy().also { master.accept(it) }
    } else {
        stack.also { master.accept(it) }
    }

    override fun getStackInSlot(slot: Int) : ItemStack = ItemStack.EMPTY

    override fun getSlotLimit(slot: Int) = 0

    override fun getSlots() = 0

    override fun extractItem(slot: Int, amount: Int, simulate: Boolean) : ItemStack = ItemStack.EMPTY
}

class OutputOnlyItemHander(val master: AgentOutput<ItemStack>) : IItemHandler {
    override fun insertItem(slot: Int, stack: ItemStack, simulate: Boolean) = stack

    override fun getStackInSlot(slot: Int): ItemStack {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSlotLimit(slot: Int) = 0

    override fun getSlots() = 1

    override fun extractItem(slot: Int, amount: Int, simulate: Boolean): ItemStack {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class InputOnlyFluidTank(val master: AgentInput<FluidStack>) : IFluidTank {
    override fun drain(maxDrain: Int, doDrain: Boolean): FluidStack? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getFluidAmount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getFluid(): FluidStack? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun fill(resource: FluidStack?, doFill: Boolean): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getInfo(): FluidTankInfo {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCapacity(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}