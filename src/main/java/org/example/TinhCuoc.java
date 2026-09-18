package org.example;


public class TinhCuoc {
    private static final double GIA_CAN_NANG_BAC_1 = 6000;
    private static final double GIA_CAN_NANG_BAC_2 = 4500;
    private static final double GIA_KHOANG_CACH_BAC_1 = 600;
    private static final double GIA_KHOANG_CACH_BAC_2 = 500;
    private static final double GIA_KHOANG_CACH_BAC_3 = 400;

    private static final double CAN_NANG_MIN = 0.1;
    private static final double CAN_NANG_MAX = 50.0;
    private static final int KHOANG_CACH_MIN = 1;
    private static final int KHOANG_CACH_MAX = 200;

    public static boolean isValidCanNang(double w) {
        return w >= CAN_NANG_MIN && w <= CAN_NANG_MAX;
    }

    public static boolean isValidKhoangCach(int d) {
        return d >= KHOANG_CACH_MIN && d <= KHOANG_CACH_MAX;
    }

    public static double getDonGiaCanNang(double w) {
        return (w <= 30.0) ? GIA_CAN_NANG_BAC_1 : GIA_CAN_NANG_BAC_2;
    }

    public static double getDonGiaKhoangCach(int d) {
        if (d <= 80) return GIA_KHOANG_CACH_BAC_1;
        if (d <= 160) return GIA_KHOANG_CACH_BAC_2;
        return GIA_KHOANG_CACH_BAC_3;
    }

    public static String tinhCuoc(double w, int d) {
        if (!isValidCanNang(w) && !isValidKhoangCach(d))
            return "Cân nặng và khoảng cách không hợp lệ";
        if (!isValidCanNang(w)) return "Cân nặng không hợp lệ";
        if (!isValidKhoangCach(d)) return "Khoảng cách không hợp lệ";

        double cuoc = w * getDonGiaCanNang(w) + d * getDonGiaKhoangCach(d);
        return String.valueOf(cuoc);
    }

    public static double tinhCuocSo(double w, int d) {
        return Double.parseDouble(tinhCuoc(w, d));
    }
}