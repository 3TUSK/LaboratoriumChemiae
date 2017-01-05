package info.tritusk.laboratoriumchemiae.api.reaction;

import java.util.Collection;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;

@ParametersAreNonnullByDefault
public enum ReactionManager {

	INSTANCE;
	
	private final Multimap<ReactionIdentifier, Reaction> reactions = 
			MultimapBuilder.enumKeys(ReactionIdentifier.class).hashSetValues().build();
	
	public boolean addReaction(ReactionIdentifier id, Reaction reaction) {
		return reactions.put(id, reaction);
	}
	
	public boolean clear() {
		reactions.clear();
		return true;
	}
	
	public boolean clear(ReactionIdentifier id) {
		return reactions.removeAll(id) != null;
	}
	
	@Nonnull
	public Collection<Reaction> getAll(ReactionIdentifier id) {
		return reactions.get(id);
	}
}
