package info.tritusk.laboratoriumchemiae.api.devices;

import info.tritusk.laboratoriumchemiae.api.agent.Agent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.vecmath.Point3i;

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
    @Deprecated
    void consume(@Nonnull Agent... agents);

    @Nonnull
    Agent getContainedAgent();

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
     * @return true if this AgentInput instance contains no agent.
     */
    boolean isEmpty();

    /**
     * @return Its position vector (i.e. the point, with the (0,0,0) as origin)
     * Return (0,0,0) for unimplemented.
     */
    @Nonnull
    Point3i pos();

}
