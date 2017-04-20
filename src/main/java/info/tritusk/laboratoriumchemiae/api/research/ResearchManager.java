package info.tritusk.laboratoriumchemiae.api.research;

import info.tritusk.laboratoriumchemiae.api.research.tracker.ResearchTracker;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

/**
 * The global research manager, used as a overall database. All
 * {@linkplain Research researches} that managed by {@linkplain ResearchTracker
 * research trackers} shall be recored in this global manager, otherwise it will be
 * recognized as "alien knowledge" and may subject to removal, which is
 * configurable.
 * 
 * @author 3TUSK
 */
@ParametersAreNonnullByDefault
public enum ResearchManager {
    
    INSTANCE;
    
    /**
     * An empty research, used to replace null value. <p>
     * It has name of "invalid_research" and hash code of 0.
     */
    public static final Research EMPTY_RESEARCH = new Research() {
        public String getResearchName() {
            return "invalid_research";
        }
        @Override
        public int hashCode() {
            return 0;
        }
        @Override
        public ResearchTag[] getResearchTags() {
            return new ResearchTag[0];
        }
        @Override
        public boolean equals(@Nullable Object o) {
            return o == null || o == this;
        }
    };
    
    private final Map<String, Research> knownResearches = new HashMap<>(50);
    
    /**
     * A flag that determines whether untracked research is allowed or not.
     */
    private boolean allowAlienKnowledge = false;
    
    public void registerResearch(final Research research) {
        if (knownResearches.containsKey(research.getResearchName())) {
            // TODO add warning log
            return;
        }
        knownResearches.put(research.getResearchName(), research);
    }
    
    /**
     * 
     * @param name Name of the research to be queried
     * @return A {@linkplain Optional wrapper} that contains either a matched
     * {@linkplain Research research instance
     * or an {@linkplain ResearchManager#EMPTY_RESEARCH empty one}.
     */
    @Nonnull
    public Optional<Research> findResearch(String name) {
        return name.isEmpty() ? Optional.of(EMPTY_RESEARCH) : knownResearches.containsKey(name) ? Optional.of(knownResearches.get(name)) : Optional.of(EMPTY_RESEARCH);
    }
    
    @Nonnull
    public Collection<Research> getAllResearches() {
        return Collections.unmodifiableCollection(knownResearches.values());
    }
    
    public boolean allowNonexistResearch() {
        return allowAlienKnowledge;
    }
}
