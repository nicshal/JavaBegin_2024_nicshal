package nicshal.homework4;

public class Box {

    private int length;
    private int width;
    private int height;
    private String color;
    private boolean status = false;
    private String content;

    public Box(int length, int width, int height, String color) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void addContent(String content) {
        if (isStatus()) {
            if (getContent() == null) {
                this.content = content;
            } else {
                System.out.println("Товар положить не удалось. В коробке уже лежит " + getContent());
            }
        } else {
            System.out.println("Товар положить не удалось. Коробка закрыта");
        }
    }

    public void removeContent() {
        if (isStatus()) {
            if (getContent() == null) {
                System.out.println("Товар выкинуть не удалось. Коробка пуста");
            } else {
                this.content = null;
            }
        } else {
            System.out.println("Товар выкинуть не удалось. Коробка закрыта");
        }
    }

    public void printBox() {
        System.out.println("Коробка:");
        System.out.println(" - цвет: " + getColor());
        System.out.println(" - размеры(длина/ширина/высота): " + getLength() + "/" + getWidth() + "/" + getHeight());
        System.out.println(isStatus() ? " - открыта" : " - закрыта");
        System.out.println(getContent() == null ? " - пустая" : (" - содержит " + getContent()));
    }
}