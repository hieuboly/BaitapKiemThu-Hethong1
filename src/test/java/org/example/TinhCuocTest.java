package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TinhCuocTest {

    @ParameterizedTest(name = "Case {0}: w={1}, d={2} -> cuoc={3}")
    @CsvSource({
            "01, 0.1,   100, 50600.0",
            "02, 0.11,  100, 50660.0",
            "03, 29.99, 100, 229940.0",
            "04, 30,    100, 230000.0",
            "05, 30.01, 100, 185045.0",
            "06, 49.99, 100, 274955.0",
            "07, 50,    100, 275000.0",
            "08, 25.05, 1,   150900.0",
            "09, 25.05, 2,   151500.0",
            "10, 25.05, 79,  197700.0",
            "11, 25.05, 80,  198300.0",
            "12, 25.05, 81,  190800.0",
            "13, 25.05, 159, 229800.0",
            "14, 25.05, 160, 230300.0",
            "15, 25.05, 161, 214700.0",
            "16, 25.05, 199, 229900.0",
            "17, 25.05, 200, 230300.0",
            "18, 25.05, 100, 200300.0"
    })
    @DisplayName("18 test case biên & cận biên hợp lệ")
    void testBienVaCanBienHopLe(String id, double w, int d, double expected) {
        assertEquals(expected, TinhCuoc.tinhCuocSo(w, d), 0.0001,
                "Sai ở case " + id + " (w=" + w + ", d=" + d + ")");
    }
}