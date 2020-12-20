package exception;

import java.util.Arrays;
import java.util.List;

public class MyException extends Exception {

    public static final int FILE_NOT_FOUND = 0;
    public static final int READ_ERROR = 1;
    public static final int WRONG_PARAMETER = 2;
    public static final int ROOM_WITHOUT_SERVICE = 3;

    private int value;

    public MyException(int value) {
        this.value = value;
    }

    private List<String> messege = Arrays.asList(
            " FILE NOT FOUND ",
            " READ ERROR ",
            " WRONG PARAMETER ",
            " ROOM WITHOUT SERVICE"
    );

    @Override
    public String getMessage() {
        return messege.get(value);
    }
}
