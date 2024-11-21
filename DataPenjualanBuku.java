import java.util.Scanner;

public class DataPenjualanBuku {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        System.out.println("=== Selamat datang di Sistem Pengelolaan Data Penjualan Buku ===");
        System.out.print("Masukkan jumlah Tipe buku: ");
        int jmlTipe = sc1.nextInt();

        String maxTipe = " ";
        String maxHari = " ";
        int max = 0;
        int totalPenjualan = 0;
        int totalPendapatan = 0;
        int dataPenjualan[][] = new int[jmlTipe][7];
        int[][] hargaBuku =new int[2][jmlTipe];
        int[] totalPerBuku = new int[jmlTipe];
        int[] totalPerHari = new int[7];
        String[] tipeBuku = new String[jmlTipe];
        String[] namaHari = {"Senin", "Selasa", "Rabu", "Kamis", "Jum'at", "Sabtu", "Minggu"};
        String[] jenisHari ={"Weekday", "Weekend"};

        System.out.println("Masukkan tipe buku: ");
        for (int i = 0; i < jmlTipe; i++) {
            System.out.print("Tipe buku ke-" + (i+1) + ": ");
            tipeBuku[i] = sc2.nextLine();
        }

        System.out.println();
        System.out.println("Masukkan harga buku: ");
        for (int i = 0; i < hargaBuku.length; i++) {
            System.out.println("Harga buku saat " + jenisHari[i] + ": ");
            for (int j = 0; j < jmlTipe; j++) {
                System.out.print(tipeBuku[j] + ": ");
                hargaBuku[i][j] = sc1.nextInt();
            }
        }

        System.out.println();
        System.out.println("Masukkan data penjualan buku selama seminggu");
        for (int i = 0; i < dataPenjualan.length; i++) {
            System.out.println("Data penjualan " + tipeBuku[i] + ": ");
            for (int j = 0; j < dataPenjualan[i].length; j++) {
                System.out.print("Jumlah penjualan pada hari " + namaHari[j] + ": ");
                dataPenjualan[i][j] = sc1.nextInt();
                totalPerBuku[i] += dataPenjualan[i][j];
                totalPenjualan += dataPenjualan[i][j];
                if (j < 5) {
                    totalPendapatan += dataPenjualan[i][j] * hargaBuku[0][i];
                }else{
                    totalPendapatan += dataPenjualan[i][j] * hargaBuku[1][i];
                }
                if (dataPenjualan[i][j] > max) {
                    max = dataPenjualan[i][j];
                    maxTipe = tipeBuku[i];
                    maxHari = namaHari[j];
                }
            }
        }
    
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < jmlTipe; i++) {
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
            System.out.print("\n" + tipeBuku[i] + "\t:");
            for (int j = 0; j < 8; j++) {
                if (j<7) {
                    System.out.print(" " + dataPenjualan[i][j] + "\t");
                }else{
                    System.out.print(" " + totalPerBuku[i]);
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

        System.out.println();
        System.out.println("Total Penjualan selama seminggu: " + totalPenjualan);
        System.out.println("Total Pendapatan selama seminggu: " + totalPendapatan);
        System.out.println("Penjualan tertinggi yaitu penjualan " + maxTipe + " pada hari " + maxHari + " sejumlah " + max);
        
    }
}