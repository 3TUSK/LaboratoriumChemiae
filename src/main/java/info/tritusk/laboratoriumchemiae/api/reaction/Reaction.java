package info.tritusk.laboratoriumchemiae.api.reaction;

import info.tritusk.laboratoriumchemiae.api.agent.Agent;

public interface Reaction {

    ReactionType getIdentity();
    
    Agent[] reactants();
    
    Agent[] products();

}
