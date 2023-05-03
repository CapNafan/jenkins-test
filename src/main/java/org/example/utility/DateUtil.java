package org.example.utility;

import java.time.Year;

public class DateUtil {
    public static Integer getCurrentYear() {
        return Year.now().getValue();
    }

}
