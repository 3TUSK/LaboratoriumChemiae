package info.tritusk.laboratoriumchemiae.api.research.tracker;

import java.util.HashSet;
import java.util.Set;

import info.tritusk.laboratoriumchemiae.api.research.Research;
import info.tritusk.laboratoriumchemiae.api.research.ResearchManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

/**
 * An example implementation of {@linkplain ResearchTracker}, used for
 * demonstration and {@linkplain 
 * net.minecraftforge.common.capabilities.Capability capability system}.
 * 
 * @author 3TUSK
 */
public class ResearchTrackerSampleImpl implements ResearchTracker {

    private Set<Research> knownResearches = new HashSet<>();

    @Override
    public boolean hasResearch(Research research) {
        return knownResearches.contains(research);
    }

    @Override
    public void achieve(Research research) {
        if (ResearchManager.EMPTY_RESEARCH.equals(research)) return;

        knownResearches.add(research);
    }

    @Override
    public void regret(Research research) {
        if (ResearchManager.EMPTY_RESEARCH.equals(research)) return;

        knownResearches.remove(research);
    }

    public void readFromNBT(NBTTagCompound nbt) {
        NBTTagList list = nbt.getTagList("researches", 9);
        final int tagCount = list.tagCount();
        for (int index = 0; index < tagCount; index++) {
            // TODO deserialization
        }
    }

    public void writeToNBT(NBTTagCompound nbt) {

    }

}
