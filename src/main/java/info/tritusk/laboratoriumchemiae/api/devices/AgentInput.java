package info.tritusk.laboratoriumchemiae.api.devices;

import info.tritusk.laboratoriumchemiae.api.agent.Agent;
import kotlin.Triple;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

public interface AgentInput<T> {

    /**
     * @return Class of its acceptable input type
     */
    @Nonnull
    Class<T> getType();

    /**
     * Consume the given collection of agents.
     * @param agents Array of agents to be consumed.
     */
    void consume(@Nonnull Agent... agents);

    /**
     * Accept the given type of input and store in {@linkplain Agent agent} form.
     * The remainder shall be returned, or null shall be returned if the input type
     * can be null.
     * @param input The input to be stored in this AgentInput instance.
     * @return The remainder, may be null.
     */
    @Nullable
    T accept(@Nonnull T input);

    /**
     * @return An integer array with size of 3, consisted of x, y, z coordinates;
     * or empty array for unimplemented.
     */
    @Nonnull
    int[] pos();

}
