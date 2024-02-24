package nicshal.homework7;

import java.util.ArrayList;
import java.util.List;

public class AllTerrainVehicle extends Transport {

    public AllTerrainVehicle(int resource, int resourceConsumption) {
        super(resource, resourceConsumption);
        setInaccessibleTerrainTypeList(new ArrayList<>(List.of()));
    }

    @Override
    public String toString() {
        return AllTerrainVehicle.class.getSimpleName() + '{' +
                super.toString() +
                '}';
    }

}