package Hackerrank.CovariantReturnTypes;

//Complete the classes below
class Flower {
    public String whatsYourName() {
        return "I have many names and types.";
    }
}

class Jasmine extends Flower{
    @Override
    public String whatsYourName() {
        final String name = "Jasmine";
        return name;
    }
}

class Lily extends Flower {
    @Override
    public String whatsYourName() {
        final String name = "Lily";
        return name;
    }
}

class Region {
    public Flower yourNationalFlower() {
        Flower flower = new Flower();
        return flower;
    }
}

class WestBengal extends Region{
    @Override
    public Flower yourNationalFlower() {
        Jasmine jasmine = new Jasmine();
        return jasmine;
    }
}

class AndhraPradesh extends Region{
    @Override
    public Flower yourNationalFlower() {
        Lily lily  = new Lily();
        return lily;
    }
}