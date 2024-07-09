package Java.Day2.DesignPatterns.Factory;

public interface Superhero {
    void activateSuperpower();
    void sayName(); 
}

class CaptainAmerica implements Superhero {

    @Override
    public void activateSuperpower() {
        System.out.println("I can throw my shield really far!");
    }

    @Override
    public void sayName(){
        System.out.println("I'm Steve Rogers!");
    }
}

class SuperMan implements Superhero {

    @Override
    public void activateSuperpower() {
        System.out.println("I can fly really high!");
    }

    @Override
    public void sayName(){
        System.out.println("I'm Clark Kent!");
    } 
}

class BlackPanther implements Superhero {

    @Override
    public void activateSuperpower() {
        System.out.println("Wakanda forever!");
    }

    @Override
    public void sayName(){
        System.out.println("I'm T'Challa!");
    }
}

class Batman implements Superhero {

    @Override
    public void activateSuperpower() {
        System.out.println("I drive the batmobile!");
    }

    @Override
    public void sayName(){
        System.out.println("I'm Bruce Wayne!");
    }
}

