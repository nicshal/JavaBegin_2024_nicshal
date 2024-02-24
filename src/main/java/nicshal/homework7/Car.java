package nicshal.homework7;

import java.util.ArrayList;
import java.util.List;

public class Car extends Transport {

    public Car(int resource, int resourceConsumption) {
        super(resource, resourceConsumption);
        setInaccessibleTerrainTypeList(new ArrayList<>(List.of(TerrainType.SWAMP, TerrainType.DENSE_FOREST)));
    }

    @Override
    public String toString() {
        return Car.class.getSimpleName() + '{' +
                super.toString() +
                '}';
    }

}