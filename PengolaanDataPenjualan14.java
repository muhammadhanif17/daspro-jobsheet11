import java.util.Scanner;

public class PengolaanDataPenjualan14 {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        System.out.println("=== Selamat datang di Sistem Pengelolaan Data Penjualan ===");
        System.out.print("Masukkan jumlah produk: ");
        int jmlProduk = sc1.nextInt();

        int dataPenjualan[][] = new int[jmlProduk][7];
        int[] totalPerProduk = new int[jmlProduk];
        int[] totalPerHari = new int[7];
        String[] namaProduk = new String[jmlProduk];
        String[] namaHari = {"Senin", "Selasa", "Rabu", "Kamis", "Jum'at", "Sabtu", "Minggu"};

        System.out.println("Masukkan nama produk: ");
        for (int i = 0; i < jmlProduk; i++) {
            System.out.print("Nama produk ke-" + (i+1) + ": ");
            namaProduk[i] = sc2.nextLine();
        }

        System.out.println();
        System.out.println("Masukkan data penjualan produk selama seminggu");
        for (int i = 0; i < dataPenjualan.length; i++) {
            System.out.println("Data penjualan " + namaProduk[i] + ": ");
            for (int j = 0; j < dataPenjualan[i].length; j++) {
                System.out.print("Jumlah penjualan pada hari " + namaHari[j] + ": ");
                dataPenjualan[i][j] = sc1.nextInt();
                totalPerProduk[i] += dataPenjualan[i][j];
            }
        }
        
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < jmlProduk; i++) {
                totalPerHari[j] += dataPenjualan[i][j];
            }
        }

        System.out.println();
        System.out.println("Tabel data penjualan: ");
        for (int i = 0; i < 8; i++) {
            if (i<7) {
                System.out.print("\t " + namaHari[i]);
            }else{
                System.out.print("\t Total");
            }
        }
        for (int i = 0; i < dataPenjualan.length; i++) {
            System.out.print("\n" + namaProduk[i] + "\t:");
            for (int j = 0; j < 8; j++) {
                if (j<7) {
                    System.out.print(" " + dataPenjualan[i][j] + "\t");
                }else{
                    System.out.print(" " + totalPerProduk[i]);
                }
            }
        }
        System.out.println("\n______________________________________________________________________");
        for (int i = 0; i < 8; i++) {
            if (i==0) {
                System.out.print("Total\t:");
            }else{
                System.out.print(" " + totalPerHari[i-1] + "\t");
            }
        }  
    }
}