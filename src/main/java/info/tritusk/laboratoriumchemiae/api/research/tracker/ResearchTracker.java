package info.tritusk.laboratoriumchemiae.api.research.tracker;

import info.tritusk.laboratoriumchemiae.api.research.Research;

/**
 * A ResearchTracker describes a form of entity (e.g.
 * {@linkplain net.minecraft.entity.player.EntityPlayer player},
 * {@linkplain net.minecraft.tileentity.TileEntity block entity}, even the
 * {@linkplain net.minecraft.world.World world} itself) that can "interpret" a
 * {@linkplain Research research} and thus store it for tracking.
 * 
 * @author 3TUSK
 */
public interface ResearchTracker {
    
    /**
     * 
     * @param research The research that is being looked up
     * @return {@code true} if and only if the tracker has the given research.
     */
    boolean hasResearch(Research research);
    
    /**
     * Let the tracker understand the given research
     * @param research The research to be given
     */
    void achieve(Research research);
    
    /**
     * Let the tracker forget the given research.
     * @param research The research to be forget
     */
    void regret(Research research);
    
}
