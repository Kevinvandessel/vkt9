public class Car{

    public Car(){
        Body body = new Body();
        Chassis chas = new Chassis();
        Engine eng = new Engine();
        Wheel w1 = new Wheel();
        Wheel w2 = new Wheel();
        Wheel w3 = new Wheel();
        Wheel w4 = new Wheel();
    }

    public void printParts(){
        System.out.println("Car parts:");
        System.out.println("	Body");
        System.out.println("	Chassis");
        System.out.println("	Engine");
        System.out.println("	4 Wheel");
    }
}

class Body{
    public Body(){
        System.out.println("Manufacturing: Body");
    }
}

class Chassis{
    public Chassis(){
        System.out.println("Manufacturing: Chassis");
    }
}

class Engine{
    public Engine(){
        System.out.println("Manufacturing: Engine");
    }
}

class Wheel{
    public Wheel(){
        System.out.println("Manufacturing: Wheel");
    }
}