package info.tritusk.laboratoriumchemiae.apparatus

import info.tritusk.laboratoriumchemiae.research.TileResearchArchive
import net.minecraft.block.Block
import net.minecraft.block.ITileEntityProvider
import net.minecraft.block.material.Material
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World

class ResearchArchive : Block(Material.IRON), ITileEntityProvider {
    override fun createNewTileEntity(worldIn: World?, meta: Int): TileEntity? = TileResearchArchive()
}