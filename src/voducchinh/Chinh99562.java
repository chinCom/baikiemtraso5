package voducchinh;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Chinh99562 {
    static String[][][] qlsvGo = { { { "10001", "10002", "10003", "10004" } },
            { { "Tuan", "Kiet", "Dat", "Diem" } },
            { { "0.0", "5.5", "3.8", "10" } } };

    public static void main(String[] args) throws Exception {
        System.out.println("-----THONG TIN SINH VIEN-----");
        System.out.println("Ma so sv" + "\t" + "ten" + "\t" + "diem");
        hienThi(qlsvGo);

        System.out.println("so luong sinh vien co diem >= 5: " + soLuongSVTren5(qlsvGo[2][0]));
        System.out.println("so luong sinh vien co diem < 5: " + soLuongSVDuoi5(qlsvGo[2][0]));
        System.out.println(timSVTheoMS(qlsvGo[0][0]));
        System.out.println("sinh vien co diem cao nhat: " + timSVDiemCaoNhat(qlsvGo[2][0]));
        System.out.println("sinh vien co diem thap nhat: " + timSVDiemThapNhat(qlsvGo[2][0]));

        /* sap xep tang theo ma so sinh vien */
        System.out.println();
        System.out.println("sap xep tang theo ma so sinh vien: ");
        System.out.println("Ma so sv" + "\t" + "ten" + "\t" + "diem");
        sapXepTangMS(qlsvGo);
        hienThi(qlsvGo);

        /* sap xep giam theo diem */
        System.out.println();
        sapXepGiamDiem(qlsvGo);
        System.out.println("sap xep giam theo diem");
        System.out.println("Ma so sv" + "\t" + "ten" + "\t" + "diem");
        hienThi(qlsvGo);

        /* sap xep theo ten (theo bang chu cai) */
        System.out.println();
        System.out.println("sap xep theo ten: ");
        System.out.println("Ma so sv" + "\t" + "ten" + "\t" + "diem");
        sapXepTen(qlsvGo);
        hienThi(qlsvGo);
    }

    public static void hienThi(String[][][] qlsv) {
        for (int i = 0; i < qlsv[0][0].length; i++) {
            System.out.print(qlsv[0][0][i] + "   \t" + qlsv[1][0][i] + "  \t" + qlsv[2][0][i] + "\n");
        }
    }

    /* quan ly sinh vien */
    // so sinh vien co diem >= 5
    public static int soLuongSVTren5(String[] qlsv) {
        int dem = 0;
        for (int i = 0; i < qlsv.length; i++) {
            float diemTrongMang = Float.parseFloat(qlsv[i]);
            if (diemTrongMang >= 5) {
                dem++;
            }
        }
        return dem;
    }

    /* so sinh vien co diem < 5 */
    public static int soLuongSVDuoi5(String[] qlsv) {
        int dem = 0;
        for (int i = 0; i < qlsv.length; i++) {
            if (Float.parseFloat(qlsv[i]) < 5) {
                dem++;
            }
        }
        return dem;
    }

    public static String timSVTheoMS(String[] qlsv) {
        boolean bool = false;
        int maSoSV = 0;
        String tenSV = "";
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Nhap ma so sinh vien");
            maSoSV = sc.nextInt();
            int dem = 0;

            for (int i = 0; i < qlsv.length; i++) {
                float maSo = Float.parseFloat(qlsv[i]);
                if (maSo == maSoSV) {
                    dem = i;
                    bool = true;
                    tenSV = qlsvGo[1][0][dem];
                    break;
                }
            }

        } catch (InputMismatchException e) {
            e.printStackTrace(); // print error
        }
        return bool ? "sinh vien co ma so la: " + maSoSV + " la: " + tenSV
                : "khong tim thay sinh vien co ma so " + maSoSV;
    }

    /* sinh vien co diem cao nhat, return type String */
    public static String timSVDiemCaoNhat(String[] qlsv) {
        String tenSVDiemCaoNhat = "";
        float diemCaoNhat = Float.parseFloat(qlsv[0]);
        int dem = 0;
        for (int i = 1; i < qlsv.length; i++) {
            if (Float.parseFloat(qlsv[i]) > diemCaoNhat) {
                diemCaoNhat = Float.parseFloat(qlsv[i]);
                dem = i;
            }
        }
        tenSVDiemCaoNhat = qlsvGo[1][0][dem];
        return tenSVDiemCaoNhat;
    }

    /* sinh vien co diem thap nhat, return type String */
    public static String timSVDiemThapNhat(String[] qlsv) {
        String tenSVDiemThapNhat = "";
        float DiemThapNhat = Float.parseFloat(qlsv[0]);
        int dem = 0;
        for (int i = 1; i < qlsv.length; i++) {
            float diemTrongMang = Float.parseFloat(qlsv[i]);

            if (diemTrongMang < DiemThapNhat) {
                DiemThapNhat = diemTrongMang;
                dem = i;
            }

        }
        tenSVDiemThapNhat = qlsvGo[1][0][dem];
        return tenSVDiemThapNhat;
    }

    /* tim sinh vien theo ten */
    public static String timSVTheoTen(String[] qlsv) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Nhap ten sinh vien");
            String ten = sc.nextLine();
            for (int i = 0; i < qlsv.length; i++) {
                if (ten.equals(qlsv[i])) {
                    ten = qlsv[i];
                    return ten;
                }
            }
            return "khong tim thay";
        }
    }

    /* sap xep tang theo ma so sinh vien */
    public static void sapXepTangMS(String[][][] qlsv) {
        for (int i = 0; i < qlsv[1][0].length; i++) {
            for (int j = 0; j < qlsv[1][0].length - i - 1; j++) {
                if (Float.parseFloat(qlsv[0][0][j]) > Float.parseFloat(qlsv[0][0][j + 1])) {
                    String tam1, tam2, tam3;
                    tam1 = qlsv[0][0][j];
                    qlsv[0][0][j] = qlsv[0][0][j + 1];
                    qlsv[0][0][j + 1] = tam1;

                    tam2 = qlsv[1][0][j];
                    qlsv[1][0][j] = qlsv[1][0][j + 1];
                    qlsv[1][0][j + 1] = tam2;

                    tam3 = qlsv[2][0][j];
                    qlsv[2][0][j] = qlsv[2][0][j + 1];
                    qlsv[2][0][j + 1] = tam3;
                }
            }
        }
    }

    /* sap xep diem giam dan */
    public static void sapXepGiamDiem(String[][][] qlsv) {

        for (int i = 0; i < qlsv[2][0].length; i++) {
            for (int j = 0; j < qlsv[2][0].length - i - 1; j++) {
                if (Float.parseFloat(qlsv[2][0][j]) < Float.parseFloat(qlsv[2][0][j + 1])) {
                    String tam1, tam2, tam3;
                    tam1 = qlsv[0][0][j];
                    qlsv[0][0][j] = qlsv[0][0][j + 1];
                    qlsv[0][0][j + 1] = tam1;

                    tam2 = qlsv[1][0][j];
                    qlsv[1][0][j] = qlsv[1][0][j + 1];
                    qlsv[1][0][j + 1] = tam2;

                    tam3 = qlsv[2][0][j];
                    qlsv[2][0][j] = qlsv[2][0][j + 1];
                    qlsv[2][0][j + 1] = tam3;
                }
            }
        }
    }

    /* sap xep ten theo bang chu cai */
    public static void sapXepTen(String[][][] qlsv) {
        for (int i = 0; i < qlsv[1][0].length; i++) {
            for (int j = 0; j < qlsv[1][0].length - i - 1; j++) {
                if (qlsv[1][0][j].charAt(0) > qlsv[1][0][j + 1].charAt(0)) {
                    // swap three field
                    String tam1, tam2, tam3;
                    tam1 = qlsv[0][0][j];
                    qlsv[0][0][j] = qlsv[0][0][j + 1];
                    qlsv[0][0][j + 1] = tam1;

                    tam2 = qlsv[1][0][j];
                    qlsv[1][0][j] = qlsv[1][0][j + 1];
                    qlsv[1][0][j + 1] = tam2;

                    tam3 = qlsv[2][0][j];
                    qlsv[2][0][j] = qlsv[2][0][j + 1];
                    qlsv[2][0][j + 1] = tam3;
                }
            }
        }
    }

}
