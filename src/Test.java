
/**
 * Test
 */
public class Test {

  public static void main(String[] args) {

    String[][][] qlsvGo = { { { "10001", "10002", "10003", "10004" } },
        { { "Tuan", "Kiet", "Dat", "Diem" } },
        { { "0", "5", "3", "10" } } };
    hienThi(qlsvGo);
    System.out.println();
    sapXepGiamDiem(qlsvGo);
    hienThi(qlsvGo);
  }

  // [1 - 3][0][1 - 4] => not include 3 and 4
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

  public static void hienThi(String[][][] qlsv) {
    for (int i = 0; i < qlsv[0][0].length; i++) {
      System.out.print(qlsv[0][0][i] + "   \t" + qlsv[1][0][i] + "  \t" + qlsv[2][0][i] + "\n");
    }
  }
}