package info.tritusk.laboratoriumchemiae.api.devices;

import info.tritusk.laboratoriumchemiae.api.research.Research;

import javax.annotation.Nonnull;

public interface ResearchDataInput<T> {

    /**
     * Read data from given data bearer.
     * @param dataBearer The object that has research data.
     */
    void readData(@Nonnull T dataBearer);

    /**
     * Get a instance
     * @return
     */
    @Nonnull
    Research currentResearch();

}
