package info.tritusk.laboratoriumchemiae.api;

import info.tritusk.laboratoriumchemiae.api.reaction.ReactionManager;
import info.tritusk.laboratoriumchemiae.api.research.ResearchManager;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

/**
 * ChemiaeAPI is the place holder for major constants used by
 * Laboratorium Chemiae.
 * <p>d
 * This class cannot be initialized.
 * </p>
 */
public final class ChemiaeAPI {

    /**
     * Cannot be initialized. Any attempt of getting instance will cause an
     * exception being thrown.
     * 
     * @throws UnsupportedOperationException
     *             This class cannot be initialized.
     */
    private ChemiaeAPI() {
        throw new UnsupportedOperationException();
    }
    
    // Short-cut. I know the package name is very long...
    public static final ReactionManager REACTION_MANAGER = ReactionManager.INSTANCE;
    
    public static final ResearchManager RESEARCH_MANAGER = ResearchManager.INSTANCE;

    public static final int BUCKET_VOLUME = Fluid.BUCKET_VOLUME;

    public static final int IRON_BAR_VOLUME = 9;

    public static final int IRON_BLOCK_VOLUME = 1296;

    public static final int IRON_INGOT_VOLUME = 144;

    public static final int IRON_NUGGET_VOLUME = 16;

    public static final int GLOWSTONE_BLOCK_VOLUME = 1000;

    public static final int GLOWSTONE_DUST_VOLUME = 250;

    public static final int REDSTONE_DUST_VOLUME = 100;

}
