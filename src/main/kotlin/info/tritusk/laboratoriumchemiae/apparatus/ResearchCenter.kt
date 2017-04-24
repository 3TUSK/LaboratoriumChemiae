package info.tritusk.laboratoriumchemiae.apparatus

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Items
import net.minecraft.util.EnumFacing
import net.minecraft.util.EnumHand
import net.minecraft.util.math.BlockPos
import net.minecraft.util.text.TextComponentString
import net.minecraft.world.World

class BlockResearchCenter : Block(Material.IRON) {

    override fun onBlockActivated(worldIn: World, pos: BlockPos, state: IBlockState, playerIn: EntityPlayer?, hand: EnumHand, facing: EnumFacing, hitX: Float, hitY: Float, hitZ: Float) = when(worldIn.isRemote) {
        false -> {
            playerIn?.sendStatusMessage(TextComponentString("Welcome back, commander"), true)
            hand.takeIf { it == EnumHand.MAIN_HAND }?.also {
                playerIn?.getHeldItem(it)?.takeIf {
                    it.item == Items.PAPER && it.count == 1
                }?.setTranslatableName("labchem.info.has_research")
            }
            true
        }
        true -> false
    }

}