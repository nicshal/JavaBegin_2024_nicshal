package nicshal.homework7;

import java.util.ArrayList;
import java.util.List;

public class Horse extends Transport {

    public Horse(int resource, int resourceConsumption) {
        super(resource, resourceConsumption);
        setInaccessibleTerrainTypeList(new ArrayList<>(List.of(TerrainType.SWAMP)));
    }

    @Override
    public String toString() {
        return Horse.class.getSimpleName() + '{' +
                super.toString() +
                '}';
    }

}