@file:JvmName("ConfigChemiae")
@file:Config(modid = MOD_ID, name = MOD_NAME)
@file:Config.LangKey("config.labchem.config")
package info.tritusk.laboratoriumchemiae

import net.minecraftforge.common.config.Config

@Config.Comment("Test comment please ignore")
@Config.RangeInt(min = 0, max = 1)
@JvmField var thing : Int = 0