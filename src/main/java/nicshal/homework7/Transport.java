package nicshal.homework7;

import static java.lang.Math.max;

import java.util.List;

public abstract class Transport implements Mobility {

    private int resource;
    private int resourceConsumption;
    private List<TerrainType> inaccessibleTerrainTypeList;

    public Transport(int resource, int resourceConsumption) {
        this.resource = max(resource, 1);
        this.resourceConsumption = max(resourceConsumption, 1);
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = max(resource, 1);
    }

    public int getResourceConsumption() {
        return resourceConsumption;
    }

    public void setResourceConsumption(int resourceConsumption) {
        this.resourceConsumption = max(resourceConsumption, 1);
    }

    public int getMaxAvailableDistance() {
        return resource / resourceConsumption;
    }

    public List<TerrainType> getInaccessibleTerrainTypeList() {
        return inaccessibleTerrainTypeList;
    }

    protected void setInaccessibleTerrainTypeList(List<TerrainType> inaccessibleTerrainTypeList) {
        this.inaccessibleTerrainTypeList = inaccessibleTerrainTypeList;
    }

    @Override
    public boolean move(int distance, TerrainType typeArea) {
        if (inaccessibleTerrainTypeList.contains(typeArea)) {
            System.out.println("Перемещение на " + getClass().getSimpleName() + " невозможно. " + getClass().getSimpleName() + " не может передвигаться по " + typeArea.getTitle());
            return false;
        }
        if (getMaxAvailableDistance() < distance) {
            System.out.println("Перемещение на " + getClass().getSimpleName() + " невозможно. " + getClass().getSimpleName() + " не хватит ресурсов на расстояние " + distance);
            return false;
        }
        System.out.println("Осуществлено передвижение на " + getClass().getSimpleName() + " по " + typeArea.getTitle() + " на расстояние " + distance);
        return true;
    }

    @Override
    public String toString() {
        return Transport.class.getSimpleName() + '{' +
                "resource=" + resource +
                ", resourceConsumption=" + resourceConsumption +
                ", inaccessibleTerrainTypeList=" + inaccessibleTerrainTypeList +
                '}';
    }

}