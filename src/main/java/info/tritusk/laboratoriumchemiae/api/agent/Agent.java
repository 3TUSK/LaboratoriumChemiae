package info.tritusk.laboratoriumchemiae.api.agent;

import info.tritusk.laboratoriumchemiae.api.reaction.Reaction;
import oreregistry.api.registry.ProductTypes;
import oreregistry.api.registry.ResourceTypes;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

/**
 * An {@code Agent} refers to a certain amount of substance that involved in a
 * {@linkplain Reaction}.
 * 
 * @author 3TUSK
 */
public interface Agent {

    /**
     * Return the type of this agent.
     * Definition of the type must follow {@link ResourceTypes}
     * @return The {@linkplain ResourceTypes resource type} of this agent. Return empty string as invalid type.
     * @see    ResourceTypes
     */
    @Nonnull
    String type();

    /**
     * Return the actual form of this agent. Definition
     * of the form must follow {@link ProductTypes}.
     * @return The product type of this agent. Return empty string as invalid form.
     * @see    ProductTypes
     */
    @Nonnull
    String form();

    /**
     * @return The size of this agent. Cannot be less than zero.
     */
    @Nonnegative
    int size();

}
