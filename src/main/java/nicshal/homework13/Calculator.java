package nicshal.homework13;

import java.util.Map;

public class Calculator {

    public static final String OPERATION_STRING_FORMAT_ERROR =
            "ERROR - некорректный формат операционной строки. Требуемый формат: operand operand operator";
    public static final String OPERAND_TYPE_ERROR =
            "ERROR - операнды должны иметь тип int. Передано на обработку: operand1 = %s, operand2 = %s";
    public static final String OPERATOR_TYPE_ERROR =
            "ERROR - передан некорректный код оператора. Передано на обработку: operator = %s";
    public static final String CALCULATION_ERROR =
            "ERROR - ошибка при расчете: %s";

    public static Map<String, Operator<String, Integer>> operatorMap = Map.of(
            "+", new Operator<>("Сложение", (a, b) -> a + b),
            "-", new Operator<>("Вычитание", (a, b) -> a - b),
            "*", new Operator<>("Умножение", (a, b) -> a * b),
            "/", new Operator<>("Деление", (a, b) -> a / b)
    );

    public static String getOperators() {
        StringBuilder buffer = new StringBuilder("Доступные операции:\n");
        for (Map.Entry<String, Operator<String, Integer>> entry : operatorMap.entrySet()) {
            buffer.append(entry.getKey()).append(" --> ").append(entry.getValue().getName()).append("\n");
        }
        return buffer.toString();
    }

    public static String calculate(String operation) {
        String[] parameterList = operation.split(" ");
        if (parameterList.length != 3) {
            throw new BadOperationStringException(OPERATION_STRING_FORMAT_ERROR);
        }
        if (operatorMap.get(parameterList[2]) == null) {
            throw new BadOperationStringException(String.format(OPERATOR_TYPE_ERROR, parameterList[2]));
        }
        try {
            Integer operand1 = Integer.parseInt(parameterList[0]);
            Integer operand2 = Integer.parseInt(parameterList[1]);
            return operatorMap.get(parameterList[2]).getInterfase().apply(operand1, operand2).toString();
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            throw new BadOperationStringException(String.format(OPERAND_TYPE_ERROR, parameterList[0], parameterList[1]));
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new BadOperationStringException(String.format(CALCULATION_ERROR, ex.getMessage()));
        }

    }

}