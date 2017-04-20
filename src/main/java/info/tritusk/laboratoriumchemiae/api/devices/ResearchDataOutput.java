package info.tritusk.laboratoriumchemiae.api.devices;

import javax.annotation.Nonnull;

public interface ResearchDataOutput<T> {

    /**
     * Write data to given object.
     * @param dataBearer The object that will record the data
     * @return The result. Ideally, it should be the <code>dataBearer</code>.
     */
    @Nonnull
    T recordData(@Nonnull T dataBearer);

}
