package nicshal.homework10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class PhoneBook {

    private final HashMap<String, String> phoneMap = new HashMap<>();
    private static final String BAD_PARAMETER_ERROR =
            "В метод %s передано некорректное значение параметра %s --> %s";

    public void add(String fio, String phoneNumber) {
        if (fio == null || fio.isEmpty()) {
            throw new ParameterValueException(String.format(BAD_PARAMETER_ERROR, "add", "fio", fio));
        }
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            throw new ParameterValueException(String.format(BAD_PARAMETER_ERROR, "add", "phoneNumber", phoneNumber));
        }

        phoneMap.put(phoneNumber, fio);
    }

    public List<String> find(String fio) {
        if (fio == null || !phoneMap.containsValue(fio)) {
            return Collections.emptyList();
        }
        ArrayList<String> phoneList = new ArrayList<>();
        for (HashMap.Entry<String, String> entry : phoneMap.entrySet()) {
            if (entry.getValue().equals(fio)) {
                phoneList.add(entry.getKey());
            }
        }
        return phoneList;
    }

    public boolean containsPhoneNumber(String phoneNumber) {
        return phoneMap.containsKey(phoneNumber);
    }

}