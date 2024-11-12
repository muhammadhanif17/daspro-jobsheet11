import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String ticTacToe [][] = new String[3][3];
        String simbol;
        int baris, kolom;
        boolean next = true;

        System.out.println("===========================");
        System.out.println("||    Tic-Tac-Toe Game    ||");
        System.out.println("===========================");
        while (next) {
            for (int i = 0; i < ticTacToe.length; i++) {
                for (int j = 0; j < ticTacToe[i].length; j++) {
                    if (ticTacToe[i][j] == null) {
                        System.out.print("_ ");
                    }else{
                        System.out.print(ticTacToe[i][j]+ " ");
                    }
                }
                System.out.println();
            }
            System.out.println();
            System.out.println("Pilih x atau o");
            System.out.print("Masukkan simbol: ");
            simbol = sc.nextLine();
            
            if (simbol.equalsIgnoreCase("x") || simbol.equalsIgnoreCase("o")) {
                System.out.print("Masukkan baris: ");
                baris = sc.nextInt();
                System.out.print("Masukkan kolom: ");
                kolom = sc.nextInt();
                sc.nextLine();
    
                if (ticTacToe[baris-1][kolom-1] != null) {
                    System.out.println("Baris dan kolom sudah terisi!");
                    continue;
                }else if (baris < 1 || baris > 3 || kolom < 1 || kolom > 3) {
                    System.out.println("Baris dan kolom tidak tersedia!");
                    continue;
                }
                ticTacToe[baris-1][kolom-1] = simbol;
                
                boolean menang = false;
                for (int i = 0; i < ticTacToe.length; i++) {
                    if (ticTacToe[i][0] != null && ticTacToe[i][1] != null && ticTacToe[i][2] != null &&
                    ticTacToe[i][0].equalsIgnoreCase(simbol) && ticTacToe[i][1].equalsIgnoreCase(simbol) && ticTacToe[i][2].equalsIgnoreCase(simbol) ) {
                        menang = true;
                    }
                    if (ticTacToe[0][i] != null && ticTacToe[1][i] != null && ticTacToe[2][i] != null &&
                    ticTacToe[0][i].equalsIgnoreCase(simbol) && ticTacToe[1][i].equalsIgnoreCase(simbol) && ticTacToe[2][i].equalsIgnoreCase(simbol) ) {
                        menang = true;
                    }
                }
                if (ticTacToe[0][0] != null && ticTacToe[1][1] != null && ticTacToe[2][2] != null &&
                ticTacToe[0][0].equalsIgnoreCase(simbol) && ticTacToe[1][1].equalsIgnoreCase(simbol) && ticTacToe[2][2].equalsIgnoreCase(simbol) ) {
                    menang = true;
                }
                if (ticTacToe[0][2] != null && ticTacToe[1][1] != null && ticTacToe[2][0] != null &&
                ticTacToe[0][2].equalsIgnoreCase(simbol) && ticTacToe[1][1].equalsIgnoreCase(simbol) && ticTacToe[2][0].equalsIgnoreCase(simbol) ) {
                    menang = true;
                }
                if (menang) {
                    for (int i = 0; i < ticTacToe.length; i++) {
                        for (int j = 0; j < ticTacToe[i].length; j++) {
                            if (ticTacToe[i][j] == null) {
                                System.out.print("_ ");
                            }else{
                                System.out.print(ticTacToe[i][j]+ " ");
                            }
                        }
                        System.out.println();
                    }
                    System.out.println("Pemain " + simbol + " menang");
                    next = false;
                }else{
                    boolean seri = true;
                    for (int i = 0; i < ticTacToe.length; i++) {
                        for (int j = 0; j < ticTacToe[i].length; j++) {
                            if (ticTacToe[i][j] == null ) {
                                seri = false;
                            } 
                        }
                        if (!seri) { break; }
                    }
                    if (seri) {
                        for (int i = 0; i < ticTacToe.length; i++) {
                            for (int j = 0; j < ticTacToe[i].length; j++) {
                                if (ticTacToe[i][j] == null) {
                                    System.out.print("_ ");
                                }else{
                                    System.out.print(ticTacToe[i][j]+ " ");
                                }
                            }
                            System.out.println();
                        }
                        System.out.println("Permainan seri!");
                        next = false;
                    }
                }

            }else{
                System.out.println("simbol yang dimasukkan tidak sesuai!");
                continue;
            }
        }
        System.out.println("Game Over!");
        
    }
}