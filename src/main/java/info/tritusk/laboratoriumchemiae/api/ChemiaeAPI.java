package info.tritusk.laboratoriumchemiae.api;

import info.tritusk.laboratoriumchemiae.api.reaction.ReactionManager;
import info.tritusk.laboratoriumchemiae.api.research.ResearchManager;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

/**
 * The ChemiaeAPI class is the place holder for major constants used by
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

    /**
     * Vanilla bucket has volume of 1000 millibucket (mB).
     */
    public static final int BUCKET_VOLUME = Fluid.BUCKET_VOLUME;

    /**
     * Vanilla iron bar will be melted into 9 mB molten iron.
     */
    public static final int IRON_BAR_VOLUME = 9;

    /**
     * Vanilla iron block will be melted into 1296 mB molten iron.
     */
    public static final int IRON_BLOCK_VOLUME = 1296;

    /**
     * Vanilla iron ingot will be melted into 144 mB molten iron.
     * This is also valid for iron dust.
     */
    public static final int IRON_INGOT_VOLUME = 144;

    /**
     * Vanilla iron nugget will be melted into 16 mB molten iron.
     */
    public static final int IRON_NUGGET_VOLUME = 16;

    /**
     * Vanilla glowstone block will be melted into 1000 mB molten glowstone,
     * which is exact one bucket volume.
     */
    public static final int GLOWSTONE_BLOCK_VOLUME = 1000;

    public static final int GLOWSTONE_DUST_VOLUME = 250;

    public static final int REDSTONE_DUST_VOLUME = 100;

    /**
     * Idea gas constant, in J K<sup>-1</sup> mol<sup>-1</sup>.
     */
    public static final double IDEAL_GAS_CONSTANT = 8.314;

    /**
     * One mole of any particles will consist with this number of particles.
     */
    public static final double AVOGADRO_CONSTANT = 6.02e23;

    /**
     * Standard temperature and pressure (STP).
     */
    public static final double STP_PRESSURE = 1e5;

    /**
     * Standard temperature and pressure (STP).
     */
    public static final double STP_TEMPERATURE = 273D;

}
