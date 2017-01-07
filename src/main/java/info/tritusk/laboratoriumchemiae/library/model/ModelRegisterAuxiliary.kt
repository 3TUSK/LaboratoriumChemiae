package info.tritusk.laboratoriumchemiae.library.model

import net.minecraft.block.Block
import net.minecraft.block.state.IBlockState
import net.minecraft.client.renderer.block.model.ModelBakery
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.client.renderer.block.statemap.StateMapperBase
import net.minecraft.item.Item
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.fluids.BlockFluidBase

fun registerModel(item: Item,
					meta: Int = 0,
					model: String = Item.REGISTRY.getNameForObject(item).toString()) = registerModel0(item, meta, model)
	
fun regsiterModel(block: Block,
				meta: Int = 0,
				model: String = Block.REGISTRY.getNameForObject(block).toString()) = registerModel0(Item.getItemFromBlock(block), meta, model)

fun registerModelFluid(fluidBlock: BlockFluidBase, name: String) {
	val modelLocation = ModelResourceLocation(":fluid", name)
	ModelLoader.setCustomStateMapper(fluidBlock, object: StateMapperBase() {
		override fun getModelResourceLocation(state: IBlockState) = modelLocation
	})
	ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(fluidBlock), {stack -> modelLocation})
	ModelBakery.registerItemVariants(Item.getItemFromBlock(fluidBlock), modelLocation)
}

private fun registerModel0(item: Item,
						meta: Int,
						model: String) = ModelLoader.setCustomModelResourceLocation(item, meta, ModelResourceLocation(model, "inventory"))
