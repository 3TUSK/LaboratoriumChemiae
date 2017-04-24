package info.tritusk.laboratoriumchemiae.api.reaction;

import java.util.Collection;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import info.tritusk.laboratoriumchemiae.api.agent.Agent;
import info.tritusk.laboratoriumchemiae.api.devices.ReactionContainer;

@ParametersAreNonnullByDefault
public enum ReactionManager {

    INSTANCE;

    public static final Reaction EMPTY_REACTION = new Reaction() {
        @Override
        public ReactionType getIdentity() {
            return ReactionType.Defaults.UNCATEGORIZED;
        }

        @Override
        public Agent[] reactants() {
            return new Agent[0];
        }

        @Override
        public Agent[] getIdealProducts() {
            return new Agent[0];
        }

        @Override
        public Agent[] getActualProducts(ReactionContainer reactionContainer) {
            return new Agent[0];
        }
    };

    private final Multimap<ReactionType, Reaction> reactions = MultimapBuilder.hashKeys().hashSetValues().build();

    public boolean addReaction(ReactionType id, Reaction reaction) {
        return reactions.put(id, reaction);
    }

    public boolean clear() {
        reactions.clear();
        return true;
    }

    public boolean clear(ReactionType id) {
        return reactions.removeAll(id) != null;
    }

    @Nonnull
    public Collection<Reaction> getAll(ReactionType id) {
        return reactions.get(id);
    }
}
