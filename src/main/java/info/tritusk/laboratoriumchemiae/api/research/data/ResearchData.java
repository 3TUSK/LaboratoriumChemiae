package info.tritusk.laboratoriumchemiae.api.research.data;

import info.tritusk.laboratoriumchemiae.api.reaction.Reaction;
import info.tritusk.laboratoriumchemiae.api.research.Research;

import javax.annotation.Nonnull;

public interface ResearchData {

    @Nonnull
    Reaction getReaction();

    @Nonnull
    Research getResearch();
}
