package info.tritusk.laboratoriumchemiae.api.reaction;

import info.tritusk.laboratoriumchemiae.api.agent.Agent;
import info.tritusk.laboratoriumchemiae.api.devices.ReactionContainer;

import javax.annotation.Nonnull;

public interface Reaction {

    ReactionType getIdentity();

    @Nonnull
    Agent[] reactants();

    @Nonnull
    Agent[] getIdealProducts();

    @Nonnull
    Agent[] getActualProducts(ReactionContainer reactionContainer);

}
