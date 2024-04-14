package nicshal.homework19;

public class ApplicationConstants {

    public static final double PRECISION = 0.0001;

    public static final String BOX_MOVE_ERROR =
            "В целевой коробке недостаточно места для размещения все пересыпаемых фруктов (осталось места - %s, требуется места - %s";
    public static final String BOX_RESIDUAL_CAPACITY_ERROR =
            "Фрукт с весом %s уже не заходит в коробку. Осталось места - %s";

    private ApplicationConstants() {
    }

}