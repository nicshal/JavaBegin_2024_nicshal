package nicshal.homework7;

import java.util.ArrayList;
import java.util.List;

public class Human implements Mobility {

    private String name;
    private Mobility currentTransport = this;
    private List<TerrainType> inaccessibleTerrainTypeList = new ArrayList<>(List.of(TerrainType.SWAMP));

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Mobility getCurrentTransport() {
        return currentTransport;
    }

    public void setCurrentTransport(Mobility currentTransport) {
        this.currentTransport = currentTransport;
    }

    public List<TerrainType> getInaccessibleTerrainTypeList() {
        return inaccessibleTerrainTypeList;
    }

    public void leaveCurrentTransport() {
        if (getCurrentTransport() == this) {
            System.out.println(getName() + " не имеет транспорта. Ходит пешком.");
        } else {
            System.out.println(getName() + " покинул " + getCurrentTransport().getClass().getSimpleName());
        }
        System.out.println("----------------------");
        this.currentTransport = this;
    }

    public void travel(int distance, TerrainType typeArea) {
        if (currentTransport.move(distance, typeArea)) {
            System.out.println("Путешествие " + getName() +
                    (getCurrentTransport() == this ? " пешком" : (" на " + getCurrentTransport().getClass().getSimpleName())) +
                    " прошло успешно");
        } else {
            System.out.println("Путешествие " + getName() +
                    (getCurrentTransport() == this ? " пешком" : (" на " + getCurrentTransport().getClass().getSimpleName())) +
                    " не удалось");
        }
        System.out.println("----------------------");
    }

    @Override
    public boolean move(int distance, TerrainType typeArea) {
        if (inaccessibleTerrainTypeList.contains(typeArea)) {
            System.out.println("Перемещение " + getClass().getSimpleName() + " невозможно. " +
                    getClass().getSimpleName() + " не может передвигаться по " + typeArea.getTitle());
            return false;
        }
        System.out.println("Осуществлено передвижение " + getClass().getSimpleName() + " по " +
                typeArea.getTitle() + " на расстояние " + distance);
        return true;
    }

    @Override
    public String toString() {
        return Human.class.getSimpleName() + '{' +
                "name='" + name + '\'' +
                ", currentTransport=" + currentTransport +
                ", inaccessibleTerrainTypeList=" + inaccessibleTerrainTypeList +
                '}';
    }

}