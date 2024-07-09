package Java.Day2.DesignPatterns.Factory;

public class Factory {

    /**
     * FACTORY
     *      -> you don't instantiate - the factory does 
     *      -> you have one general class or interface with a bunch of child objects 
     *         and rather than your main class depending on ALL the child objects, it only depends on the factory
     *      -> this is a direct correlation to the idea of coupling and cohesion
     * 
     * 
     * COUPLING vs COHESION
     *      -> cohesion refers to relationships within your classes
     *          - low cohesion means that a class performs many different things
     *          - high cohesion means that your class is focused on a specific set of tasks
     * 
     *      -> coupling refers to relationshps between different classes
     *          - low coupling means youre dependent on few classes
     *          - high coupling means youre very dependent on many classes
     * 
     *      In code: we want HIGH COHESION and LOW COUPLING 
     * 
     */

    public static void main(String[] args) {

        Superhero hero = SuperheroFactory.createSuperhero("Captain America");
        hero.activateSuperpower();
        hero.sayName();


        Superhero hero2 = SuperheroFactory.createSuperhero("Batman");
        hero2.activateSuperpower();
        hero2.sayName();
    } 

}

class SuperheroFactory {
    public static Superhero createSuperhero(String type) {
        if(type.equals("Captain America")) {
            return new CaptainAmerica();
        } else if(type.equals("SuperMan")) {
            return new SuperMan();
        } else if(type.equals("Black Panther")) {
            return new BlackPanther();
        } else if(type.equals("Batman")) {
            return new Batman();
        } else {
            throw new IllegalArgumentException("Invalid Superhero " + type);
        }
    }
}
