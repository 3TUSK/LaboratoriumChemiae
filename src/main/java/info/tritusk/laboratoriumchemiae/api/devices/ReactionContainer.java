package info.tritusk.laboratoriumchemiae.api.devices;

import info.tritusk.laboratoriumchemiae.api.agent.Agent;

import java.util.Collection;

public interface ReactionContainer {

    double getCurrentTemperature();

    double getCurrentPressure();

    double getCurrentConcentration(Agent agent);

    void setCurrentTemperature(double temperature);

    void setCurrentPressure(double pressure);

    Collection<ReactionAugment> getCurrentAugments();

    default void reactionPreparing() {
        getCurrentAugments().forEach(System.out::println);
    }

    default void reactionFinished() {
        getCurrentAugments().forEach(System.out::println);
    }

}
