package info.tritusk.laboratoriumchemiae.api.reaction;

public interface ReactionType {

    enum Defaults implements ReactionType {

        /**
         * Category for separation by different density, always in a centrifuge
         */
        CENTRIFUGE,

        /**
         * Category for general reaction under STP, usually in a reaction vessel
         */
        CHEM_REACTOR,

        /**
         * Category for condensation, aka separate substance by different boiling
         * point
         */
        CONDENSE_TOWER,

        /**
         * Category for electrolysis
         */
        ELECTROLYZER,

        /**
         * Category for pyrolysis (i.e. decomposition under high temperature)
         */
        PYROLYZER,

        /**
         * Category for reaction in refrigerator
         */
        REFRIGERATOR,

        /**
         * Identifier for any reaction that does not belongs to any category.
         */
        UNCATEGORIZED

    }
}
