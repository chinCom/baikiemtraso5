package voducchinh;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Chinh99562 {
    static String[][][] qlsvGo = { { { "10001", "10002", "10003", "10004" } },
            { { "Tuan", "Kiet", "Dat", "Diem" } },
            { { "0", "5", "3", "10" } } };

    public static void main(String[] args) throws Exception {
        System.out.println("-----THONG TIN SINH VIEN-----");
        System.out.println("Ma so sv" + "\t" + "ten" + "\t" + "diem");
        hienThi(qlsvGo);
        System.out.println("so luong sinh vien co diem >= 5: " + soLuongSVTren5(qlsvGo[2][0]));
        System.out.println("so luong sinh vien co diem < 5: " + soLuongSVDuoi5(qlsvGo[2][0]));
        System.out.println(timSVTheoMS(qlsvGo[0][0]));
        System.out.println("sinh vien co diem cao nhat: " + timSVDiemCaoNhat(qlsvGo[2][0]));
        System.out.println("sinh vien co diem thap nhat: " + timSVDiemThapNhat(qlsvGo[2][0]));
        System.out.print("sap xep tang theo ma so sinh vien: ");
        sapXepTangMS(qlsvGo[0][0]);
        sapXepGiamDiem(qlsvGo[2][0]);
        System.out.print("sap xep theo ten: ");
        sapXepTen(qlsvGo[1][0]);
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
            int diemTrongMang = Integer.parseInt(qlsv[i]);
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
            if (Integer.parseInt(qlsv[i]) < 5) {
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
                int maSo = Integer.parseInt(qlsv[i]);
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
        int diemCaoNhat = Integer.parseInt(qlsv[0]);
        int dem = 0;
        for (int i = 1; i < qlsv.length; i++) {
            if (Integer.parseInt(qlsv[i]) > diemCaoNhat) {
                diemCaoNhat = Integer.parseInt(qlsv[i]);
                dem = i;
            }
        }
        tenSVDiemCaoNhat = qlsvGo[1][0][dem];
        return tenSVDiemCaoNhat;
    }

    /* sinh vien co diem thap nhat, return type String */
    public static String timSVDiemThapNhat(String[] qlsv) {
        String tenSVDiemThapNhat = "";
        int DiemThapNhat = Integer.parseInt(qlsv[0]);
        int dem = 0;
        for (int i = 1; i < qlsv.length; i++) {
            int diemTrongMang = Integer.parseInt(qlsv[i]);

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
    public static void sapXepTangMS(String[] qlsv) {
        for (int i = 0; i < qlsv.length; i++) {
            for (int j = 0; j < qlsv.length - i - 1; j++) {
                if (Integer.parseInt(qlsv[j]) > Integer.parseInt(qlsv[j + 1])) {
                    String temp = qlsv[j];
                    qlsv[j] = qlsv[j + 1];
                    qlsv[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(qlsv));
    }

    /* sap xep diem giam dan */
    public static void sapXepGiamDiem(String[] qlsv) {

        for (int i = 0; i < qlsv.length; i++) {
            for (int j = 0; j < qlsv.length - i - 1; j++) {
                if (Integer.parseInt(qlsv[j]) < Integer.parseInt(qlsv[j + 1])) {
                    String temp = qlsv[j];
                    qlsv[j] = qlsv[j + 1];
                    qlsv[j + 1] = temp;
                }
            }
        }
        System.out.print("diem giam dan: ");
        System.out.println(Arrays.toString(qlsv));
        System.out.println();
    }

    /* sap xep ten theo bang chu cai */
    public static void sapXepTen(String[] qlsv) {
        for (int i = 0; i < qlsv.length; i++) {
            for (int j = 0; j < qlsv.length - i - 1; j++) {
                if (qlsv[j].charAt(0) > qlsv[j + 1].charAt(0)) {
                    String temp = qlsv[j];
                    qlsv[j] = qlsv[j + 1];
                    qlsv[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(qlsv));
    }

}
