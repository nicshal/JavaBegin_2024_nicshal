package nicshal.homework7;

public enum TerrainType {

    PLAIN("Равнина"),
    SWAMP("Болото"),
    DENSE_FOREST("Густой лес");

    private String title;

    TerrainType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return TerrainType.class.getSimpleName() + '{' +
                "title='" + title + '\'' +
                '}';
    }

}