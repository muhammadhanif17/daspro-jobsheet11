import java.util.Scanner;

public class PengecekkanPrima {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int angka, faktor;
        boolean prima;
        String next = "y" ;

        while (next.equalsIgnoreCase("y")) {
            System.out.print("Masukkan sebuah angka: ");
            angka = sc.nextInt();
            sc.nextLine();

            System.out.println("Faktor dari " + angka + ": ");
            for (int i = 1; i <= angka; i++) {
                if (angka % i == 0) {
                    faktor = angka/i;
                    if (i == angka) {
                        System.out.print(faktor);
                    }else{
                        System.out.print(faktor + ", ");
                    }
                }
            }

            prima = true;
            if (angka <= 1) {
                prima = false;
            }else{
                for (int i = 2; i < (angka-1) ; i++) {
                    if (angka % i == 0) {
                        prima = false;
                        break;
                    }
                }
            }
            
            if (prima == true) {
                System.out.println("\n" + angka + " merupakan bilangan prima");
            }else{
                System.out.println("\n"  + angka + " bukan bilanga prima");
            }

            System.out.print("Apakah ingin lanjut? (y/n): ");
            next = sc.nextLine();

            if (next.equalsIgnoreCase("n")) {
                next = "n";
            }
        }
    }
}
