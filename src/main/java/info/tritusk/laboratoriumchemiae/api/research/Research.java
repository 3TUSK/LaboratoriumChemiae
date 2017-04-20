package info.tritusk.laboratoriumchemiae.api.research;

public interface Research {
    
    /**
     * 
     * @return A unique name of this research.
     */
    String getResearchName();
    
    /**
     * It is recommended to implement a hash code for all 
     * {@code Research} instance.
     * @return The hash code of this research.
     */
    int hashCode();
    
    /**
     * The getter method of {@linkplain ResearchTag tags} of this research.<p>
     * Used for comparing similarity between two researches.
     * @return An array that consists with tags of this research.
     */
    ResearchTag[] getResearchTags();

}
