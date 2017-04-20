package info.tritusk.laboratoriumchemiae.api.devices;

import info.tritusk.laboratoriumchemiae.api.agent.Agent;

import javax.annotation.Nonnull;

public interface AgentOutput<T> {

    /**
     * @return Class of its acceptable output type
     */
    @Nonnull
    Class<T> getType();

    void accpet(@Nonnull Agent... outputs);

    T output(@Nonnull Agent agent);

    boolean isEmpty();

    @Nonnull
    int[] pos();

    //TODO we probably need a overview of stuff
}
