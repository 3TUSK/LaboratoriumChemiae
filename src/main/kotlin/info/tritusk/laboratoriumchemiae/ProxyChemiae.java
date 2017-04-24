package info.tritusk.laboratoriumchemiae;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public interface ProxyChemiae {

    void pre(FMLPreInitializationEvent event);

    void pro(FMLInitializationEvent event);

    void post(FMLPostInitializationEvent event);

}
