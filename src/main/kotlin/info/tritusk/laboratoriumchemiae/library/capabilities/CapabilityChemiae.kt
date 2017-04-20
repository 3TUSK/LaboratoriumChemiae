package info.tritusk.laboratoriumchemiae.library.capabilities

import net.minecraftforge.common.capabilities.CapabilityManager

import info.tritusk.laboratoriumchemiae.api.research.tracker.ResearchTracker
import info.tritusk.laboratoriumchemiae.api.research.tracker.ResearchTrackerSampleImpl

fun initCapabilities() {
	CapabilityManager.INSTANCE.register(ResearchTracker::class.java,
			CapabilityStorageResearchTracker(),
			::ResearchTrackerSampleImpl)
}