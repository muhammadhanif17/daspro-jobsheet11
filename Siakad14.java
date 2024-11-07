import java.util.Scanner;

public class Siakad14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah mahasiswa: ");
        int jmlMhs = sc.nextInt();
        System.out.print("Masukkan jumlah mata kuliah: ");
        int jmlMatkul = sc. nextInt();
        System.out.println();

        int [][] nilai = new int[jmlMhs][jmlMatkul];

        for (int i = 0; i < nilai.length; i++) {
            System.out.println("Input nilai mahasiswa ke-" + (i+1));
            double totalPerSiswa = 0;
            for (int j = 0; j < nilai[i].length; j++) {
                System.out.print("Nilai mata kuliah ke-" + (j+1) + ": ");
                nilai[i][j] = sc.nextInt();
                totalPerSiswa += nilai[i][j];
            }

            System.out.println("Rata - rata nilai = " + totalPerSiswa/jmlMatkul);
            System.out.println();
        }

        System.out.println("\n=============================");
        System.out.println("Rata-rata nilai setiap kuliah");

        for (int j = 0; j < jmlMatkul; j++) {
            double totalPerMatkul = 0;
            for (int i = 0; i < jmlMhs; i++) {
                totalPerMatkul += nilai[i][j];
            }
            System.out.println("Rata-rata mata kuliah ke-" + (j+1) + " = " + totalPerMatkul/jmlMhs);
        }
    }
}