import java.util.Scanner;

public class BioskopWithScanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nama, next = "y";
        int baris = 0, kolom = 0, pilihan;
        String[][] penonton = new String[4][2];

        while (true) {
            System.out.println("");
            System.out.println("Menu 1 : Input data penonton");
            System.out.println("Menu 2 : Tampilkan daftar penonton");
            System.out.println("Menu 3 : Exit");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();
            
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama: ");
                    nama = sc.nextLine();
                    
                    for (int i = 0; i < penonton.length; i++) {
                        
                        System.out.print("Masukkan baris: ");
                        baris = sc.nextInt();
                        System.out.print("Masukkan kolom: ");
                        kolom = sc.nextInt();
                        sc.nextLine();

                        if (baris > 4 || kolom > 2 || baris < 1 || kolom < 1) {
                            System.out.println("Kursi tidak tersedia, ulangi lagi!");
                            continue;
                        }else if ( penonton[baris-1][kolom-1] != null) {
                            System.out.println("Kursi sudah terisi, ulangi lagi!");
                            continue;
                        }else{
                            break;
                        } 
                    }
                    
                    penonton[baris-1][kolom-1] = nama;
                    break;
                case 2:
                    for (int i = 0; i < penonton.length; i++) {
                        System.out.print("Penonton pada baris ke-" + (i+1) + ": ");
                        for (int j = 0; j < penonton[i].length; j++) {
                            if (penonton[i][j] == null) {
                                System.out.print("***\t");
                            }else{
                                System.out.print(penonton[i][j] + "\t");
                            }
                        }System.out.println();
                    }
                    break;
                case 3:
                    next = "n";
                    break;
                default:
                    System.out.println("Input menu tidak valid");
                    break;
            }
            if (next.equalsIgnoreCase("n")) {
                break;
            }
        }
    }
}