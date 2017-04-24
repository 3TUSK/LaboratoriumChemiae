package info.tritusk.laboratoriumchemiae.api.devices;

import info.tritusk.laboratoriumchemiae.api.agent.Agent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.vecmath.Point3i;

public interface AgentOutput<T> {

    /**
     * @return Class of its acceptable output type
     */
    @Nonnull
    Class<T> getType();

    void accpet(@Nonnull Agent... outputs);

    /**
     * Return a view-only Agent of which is stored in this AgentOutput instance.
     * @return Agent stored in this AgentOutput upon being retrieved.
     */
    @Nonnull
    T peek();

    /**
     * Output
     * @return Agent stored in
     */
    T poll();

    /**
     * @return true if this AgentOutput instance contains no agent.
     */
    boolean isEmpty();

    @Nonnull
    Point3i pos();

    //TODO we probably need a overview of stuff
}
