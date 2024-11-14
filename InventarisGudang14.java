import java.util.Scanner;

public class InventarisGudang14 {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        System.out.print("Masukkan jumlah jenis barang: ");
        int jmlJenis = sc1.nextInt();
        System.out.print("Masukkan jumlah lokasi penyimpanan: ");
        int jmlLokasi = sc1.nextInt();

        int  [][] stokBarang = new int[jmlJenis][jmlLokasi];
        String[] namaKota = new String[jmlLokasi];
        String[] namaBarang = new String[jmlJenis];
        String next = "y";
        
        System.out.println("Masukkan nama barang: ");
        for (int i = 0; i < jmlJenis; i++) {
            System.out.print("Barang " + (i+1) + ": ");
            namaBarang[i] = sc2.nextLine();
        }
        
        System.out.println("");
        System.out.println("Masukkan nama kota untuk setiap lokasi: ");
        for (int i = 0; i < namaKota.length; i++) {
            System.out.print("Kota untuk lokasi " + (i+1) + ": ");
            namaKota[i] = sc2.nextLine();
        }

        System.out.println();
        System.out.println("Mengisi stok barang...");
        while (next.equalsIgnoreCase("y")) {
            System.out.print("Jenis barang (1-" + jmlJenis + "): " );  
            int jenisBarang = sc1.nextInt();
            System.out.print("Lokasi (1-" + jmlLokasi + "): ");
            int lokasi = sc1.nextInt();
            System.out.print("Tambah stok: ");
            int stok = sc1.nextInt();

            stokBarang[jenisBarang-1][lokasi-1] += stok;
             System.out.print("Lanjut mengisi? (y/n): ");
             next = sc2.nextLine();

             if (next.equalsIgnoreCase("n")) {
                break;
             }
        }
        System.out.println();
        System.out.println("Tabel stok gudang: ");
        for (int i = 0; i < namaKota.length; i++) {
            if (i==0) {
                System.out.print("\t\t" + namaKota[i]);
            }else{
                System.out.print("\t" + namaKota[i]);
            }
        }
        for (int i = 0; i < stokBarang.length; i++) {
            System.out.print("\n" + namaBarang[i] + "\t:");
            for (int j = 0; j < stokBarang[i].length; j++) {
                System.out.print("\t" + stokBarang[i][j]);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Total Stok untuk setiap jenis barang: ");
        for (int i = 0; i < jmlJenis; i++) {
            int total = 0;
            for (int j = 0; j <jmlLokasi; j++) {
                total+= stokBarang[i][j];
            }
            System.out.println(namaBarang[i] + ": " + total);
        }

        System.out.println();
        System.out.println("Lokasi dengan stok terbanyak untuk setiap jenis barang: ");
        for (int i = 0; i < jmlJenis; i++) {
            int terbanyak = 0;
            for (int j = 0; j < jmlLokasi; j++) {
                if (stokBarang[i][j] > terbanyak) {
                    terbanyak = stokBarang[i][j];
                }
            }
            int indexTerbanyak = 0;
            for (int j = 0; j < jmlLokasi; j++) {
                if (stokBarang[i][j] == terbanyak) {
                    indexTerbanyak = j;
                }
            }
            if (terbanyak != 0) {
                System.out.println(namaBarang[i] + ": " + namaKota[indexTerbanyak]);
            }else{
                System.out.println(namaBarang[i] + ": Tidak ada stok");
            }
        }
    }
}