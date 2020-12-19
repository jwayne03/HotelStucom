package exception;

import java.util.Arrays;
import java.util.List;

public class MyException extends Exception {

    public static final int READ_ERROR = 0;
    public static final int ROOM_WITHOUT_SERVICE = 1;

    private int value;

    public MyException(int value) {
        this.value = value;
    }

    private List<String> messege = Arrays.asList(
            " READ ERROR ",
            " ROOM WITHOUT SERVICE"
    );

    @Override
    public String getMessage() {
        return messege.get(value);
    }
}
