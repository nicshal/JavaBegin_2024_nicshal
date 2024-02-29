package nicshal.homework7;

import java.util.ArrayList;
import java.util.List;

public class Bike implements Mobility {

    private List<TerrainType> inaccessibleTerrainTypeList;

    public Bike() {
        this.inaccessibleTerrainTypeList = new ArrayList<>(List.of(TerrainType.SWAMP));
    }

    public List<TerrainType> getInaccessibleTerrainTypeList() {
        return inaccessibleTerrainTypeList;
    }

    @Override
    public boolean move(int distance, TerrainType typeArea) {
        if (inaccessibleTerrainTypeList.contains(typeArea)) {
            System.out.println("Перемещение на " + getClass().getSimpleName() + " невозможно. " + getClass().getSimpleName() + " не может передвигаться по " + typeArea.getTitle());
            return false;
        }
        System.out.println("Осуществлено передвижение на " + getClass().getSimpleName() + " по " + typeArea.getTitle() + " на расстояние " + distance);
        return true;
    }

    @Override
    public String toString() {
        return Bike.class.getSimpleName() + '{' +
                "inaccessibleTerrainTypeList=" + inaccessibleTerrainTypeList +
                '}';
    }

}