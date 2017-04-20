package info.tritusk.laboratoriumchemiae.api.research.tracker;

import javax.annotation.Nonnull;

import info.tritusk.laboratoriumchemiae.api.research.tracker.ResearchTracker;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

/**
 * The holder of the instance of research tracker, in {@linkplain Capability
 * capability} form.
 * 
 * @author 3TUSK
 */
public enum CapabilityResearchTracker {
    
    ; // <- All the black magic is here

    /**
     * The {@linkplain Capability capability} instance. <br>
     * It will be available since
     * {@linkplain net.minecraftforge.fml.common.LoaderState#PREINITIALIZATION
     * PreInit stage}.
     */
    @Nonnull
    @CapabilityInject(ResearchTracker.class)
    public static final Capability<ResearchTracker> INSTANCE = null;

}
