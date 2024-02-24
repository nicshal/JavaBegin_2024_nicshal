package nicshal.homework7;

public class Main {

    public static void main(String[] args) {
        Human human = new Human("Василий");
        human.travel(100, TerrainType.PLAIN);
        human.travel(200, TerrainType.SWAMP);

        Horse horse = new Horse(5000, 10);
        human.setCurrentTransport(horse);
        human.travel(300, TerrainType.PLAIN);
        human.travel(2000, TerrainType.SWAMP);

        human.leaveCurrentTransport();
        human.travel(100, TerrainType.PLAIN);
        human.leaveCurrentTransport();

        Car car = new Car(50000, 10);
        human.setCurrentTransport(car);
        human.travel(300, TerrainType.PLAIN);
        human.travel(2000, TerrainType.SWAMP);

        Bike bike = new Bike();
        human.setCurrentTransport(bike);
        human.travel(30000, TerrainType.PLAIN);
        human.travel(2000, TerrainType.SWAMP);

        AllTerrainVehicle allTerrainVehicle = new AllTerrainVehicle(4000, 20);
        human.setCurrentTransport(allTerrainVehicle);
        human.travel(300, TerrainType.PLAIN);
        human.travel(200, TerrainType.SWAMP);
    }

}