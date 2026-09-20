package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TinhCuocTest {

    // ============================================================
    // PHẦN 1: 18 CA GỐC (biên & cận biên hợp lệ)
    // ============================================================
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

    // ============================================================
    // PHẦN 2: 5 CA BỔ SUNG – HỢP LỆ (giữa miền + biên kết hợp)
    // ============================================================
    @ParameterizedTest(name = "Case {0}: w={1}, d={2} -> cuoc={3}")
    @CsvSource({
            "19, 25.05, 120, 210300.0",   // giữa miền KC bậc 2 – phát hiện M12
            "26, 0.1,   1,   1200.0",     // biên dưới cả 2
            "27, 50,    200, 305000.0",   // biên trên cả 2
            "28, 30,    80,  228000.0"    // biên bậc cả 2
    })
    @DisplayName("4 test case bổ sung – hợp lệ (giữa miền & biên kết hợp)")
    void testBoSungHopLe(String id, double w, int d, double expected) {
        assertEquals(expected, TinhCuoc.tinhCuocSo(w, d), 0.0001,
                "Sai ở case " + id + " (w=" + w + ", d=" + d + ")");
    }

    // ============================================================
    // PHẦN 3: 6 CA BỔ SUNG – KHÔNG HỢP LỆ
    // ============================================================
    @ParameterizedTest(name = "Case {0}: w={1}, d={2} -> ngoai le: {3}")
    @CsvSource({
            "20, 0.09,  100, Cân nặng không hợp lệ",
            "21, 50.01, 100, Cân nặng không hợp lệ",
            "22, 25.05, 0,   Khoảng cách không hợp lệ",
            "23, 25.05, 201, Khoảng cách không hợp lệ",
            "24, 0.09,  0,   Cân nặng và khoảng cách không hợp lệ",
            "25, 50.01, 201, Cân nặng và khoảng cách không hợp lệ"
    })
    @DisplayName("6 test case bổ sung – không hợp lệ (sát biên & cả 2)")
    void testBoSungKhongHopLe(String id, double w, int d, String expectedMessage) {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> TinhCuoc.tinhCuocSo(w, d),
                "Case " + id + " phải ném ngoại lệ"
        );
        assertEquals(expectedMessage, ex.getMessage(),
                "Sai thông báo lỗi ở case " + id);
    }
}