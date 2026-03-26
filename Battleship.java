package Erg_1;

import java.util.Scanner;
import java.util.Random;

public class Battleship 
{
    public static void main(String[] args)
    {
        int flag = 0; // Diktis o opois kathorizei ton termatismo h tin sinexeia tou paixnidiou.
        
        mainMenu(); // Methodos h opoia emfanizei to kurio-arxiko menou tou paixnidioy.
        
        while(flag != 1)
        {
            // Arxikopoihsi tou basikoy pinaka array kai enos boithitikou sihps pou xrisimevei gia tin ylopoihsh tou paixnidiou.
            String[][] array = new String[10][10];
            String[][] ships = new String[10][10];
            
            for(int i=1; i<=9; i++)
            {
                for(int j=1; j<=9; j++)
                {
                    array[i][j] = "B";
                    ships[i][j] = "B";
                }
            }
            
            // Emfanisi tou basikoy pinaka pou apotelei kai to grafiko tou paixnidiou.
            board(array);
            
            // Methodos h opoia topothetei me tuxaia seira ta cruisers ston pinaka ships.
            deployRandomCruisers(ships);
            
            // Methodos h opoia topothetei me tuxaia seira ta patrols ston pinaka ships.
            deployRandomPatrols(ships); 
            
            // Methodos h opoia tsekarei tis eikasies tou paixti kai epistrefei to katallilo apotelesma h minima.
            PlayerGuess(ships, array);
            
            System.out.println("\n\nPlayer, do you want to continue the game Yes(0) or No(1)?");
            Scanner scan = new Scanner(System.in);
            flag = scan.nextInt(); 
            
            // Elegxos gia orthi paraxorisi timis apo ton xristi.
            while(flag < 0 || flag > 1)
            {
                System.out.println("Invalid number, try again:");
                flag = scan.nextInt();
            }
            
            // Tupwsi katallilou minimatos basi tis epilogis tou xristi.
            if(flag == 1)
            {
                System.out.println("\nExit...");
            }
            else
            {
                System.out.println("  \nRight now, sea is empty!!\n");
            }
            
        }
        
    }

    static void mainMenu() // Methodos i opoia emfanizei to arxxiko menou tou paixnidou.
    {    
        System.out.println("+--------------------------------------------+");
        System.out.println("|      !!! Welcome to BattleShips game !!!    |");
        System.out.println("+--------------------------------------------+");
        
        // Erwtisi pros ton xristi gia ton an gnorizei tous kanones tou paixnidiou.
        System.out.println("\nPlayer, do you know the rules Yes(0) or No(1)?"); 
        
        int op = 0;
        Scanner scan = new Scanner(System.in);
        
        // Epilogi timis-apantisis apo ton xristi.
        op = scan.nextInt(); 
        
        // Elegxos gia orthi paraxorisi timis apo ton xristi.
        while(op < 0 || op > 1)
        {
            System.out.println("Invalid number, try again:");
            op = scan.nextInt();
        }
        // Emfanisi kanonwn tou paixnidiou se periptwsi opou o xristis den tous gnorizei.
        if( op == 1) 
        {
            System.out.println("+--------------------------------------------+");
            System.out.println("| Rules:                                     |");
            System.out.println("| ~ There are two types of ships, Patrol and |");
            System.out.println("|   Cruiser. Patrol occupies only one cell,  |");
            System.out.println("|   the Cruiser occupies only two cells,     |");
            System.out.println("|   horizontal or vertically.                |");
            System.out.println("| ~ Three patrols and cruisers are randomly  |");
            System.out.println("|   placed on the grid. User calls 10        |");
            System.out.println("|   different cells, trying to guess if      |");
            System.out.println("|   there is a Patrol or Cruiser in it.      |");
            System.out.println("| ~ For each Patrol or Cruiser hit earns one |");
            System.out.println("|   point and if a Cruiser sinks, earn two   |");
            System.out.println("|   extra points are earned.                 |");
            System.out.println("+--------------------------------------------+");
            System.out.println(" \nLets start the game... Right now, sea is empty!!\n");
        }
        // Minima enarksis tou paixnidiou efoson o paixtis gnorizei tous kanones.
        else 
        {
            System.out.println("  \nLets start the game... Right now, sea is empty!!\n");
        }
    }
    
    static void board(String array[][]) // O pinakas pou apotelei kai to grafiko tou paixnidiou.
    {
        System.out.println("   c   1   2   3   4   5   6   7   8   9");
        System.out.println(" r  +---+---+---+---+---+---+---+---+---+");
        for(int i=1; i<=9; i++) {
            System.out.print("  " + i + " | ");
            for(int j=1; j<=9; j++) {
                System.out.print(array[i][j] + " | ");
            }
            System.out.println("\n    +---+---+---+---+---+---+---+---+---+");
        }
        System.out.println("\n\n");
    }
    
    public static void deployRandomPatrols(String ships[][]) // H methodos i opoia pragmatopoiei tuxaia prosthiki patrols ston pinaka ships.
    {
        int r=0, c=0;
        Random rand = new Random();
        
        for(int i=0; i<3; i++)
        {
            r = rand.nextInt(8) + 2; // Διασφάλιση ορίου
            c = rand.nextInt(8) + 2; 

            // Χρήση .equals() αντί για ==
            if("B".equals(ships[r][c]) && !"S".equals(ships[r][c+1]) && !"S".equals(ships[r][c-1]) && !"S".equals(ships[r+1][c]) && !"S".equals(ships[r-1][c]))
            {
                ships[r][c] = "S";
            }
            else if("B".equals(ships[1][1]))
            {
                ships[1][1] = "S";
            }
            else if("B".equals(ships[9][1]))
            {
                ships[9][1] = "S";
            }
            else if("B".equals(ships[9][9]))
            {
                ships[9][9] = "S";
            }
            else if("B".equals(ships[1][9]))
            {
                ships[1][9] = "S";
            }
        }
    }
    
    public static void deployRandomCruisers(String ships[][]) // H methodos i opoia pragmatopoiei tuxaia prosthiki cruisers ston pinaka ships.
    {
        int r=0, c=0;
        Random rand = new Random();
        
        for(int i=0; i<3; i++)
        {
            r = rand.nextInt(7) + 3;
            c = rand.nextInt(7) + 3;
            
            // Χρήση .equals() για ασφαλή σύγκριση Strings
            if("B".equals(ships[r][c]) && !"S".equals(ships[r][c+2]) && !"S".equals(ships[r][c-1]) && !"S".equals(ships[r+2][c]) && !"S".equals(ships[r-1][c]) && !"S".equals(ships[r-1][c-1]) && !"S".equals(ships[r+1][c+1]) && !"S".equals(ships[r+1][c-1]) && !"S".equals(ships[r-1][c+1]))
            {
                ships[r][c] = "S";
                ships[r+1][c] = "S";
            }
            else if("B".equals(ships[1][1]))
            {
                ships[1][1] = "S";
                ships[1][2] = "S";
            }
            else if("B".equals(ships[9][1]))
            {
                ships[9][1] = "S";
                ships[9][2] = "S";
            }
            else if("B".equals(ships[1][8]))
            {
                ships[1][8] = "S";
                ships[1][9] = "S";
            }
            else if("B".equals(ships[9][8]))
            {
                ships[9][8] = "S";
                ships[9][9] = "S";
            }
        }
    }
    
    public static void PlayerGuess(String ships[][], String array[][]) // Methodos h opoia tsekarei tis eikasies tou paixti kai epistrefei to katallilo apotelesma h minima.
    {
        int r=0, c=0; 
        int[] target = new int [10]; 
        int sm = 0; 
        int spp = 0; 
        int spc = 0; 
                   
        Scanner scan = new Scanner(System.in);

        for(int i = 0; i < 10; i++)
        {    
            System.out.println("\nPlayer, give a possible guess below 11 - 99 :");
            int guess = scan.nextInt();
            
            r = guess / 10;
            c = guess % 10;

            if(r != 0 && c != 0) 
            {
                target[i] = guess; 
            }
            
            while(r == 0 || c == 0 || r > 9 || c > 9)
            {
                System.out.println("Invalid number, try again (11-99, no zeros):");
                guess = scan.nextInt();
                r = guess / 10;
                c = guess % 10;
                target[i] = guess; 
            }

            for(int j = 0; j < 10; j++)
            {
                if(target[i] == target[j] && i != j)
                {
                    System.out.println("These cord already used, try again:");
                    guess = scan.nextInt();
                    r = guess / 10;
                    c = guess % 10;
                    target[i] = guess;
                }
            }
            
            // Σύγκριση με .equals()
            if("B".equals(ships[r][c]))
            {
                array[r][c] = "M";
                ships[r][c] = "M";
                System.out.println("You miss it!!");
                sm = sm + 1;
            }
            else if("S".equals(ships[r][c]))
            {
                array[r][c] = "H";
                ships[r][c] = "H";
                System.out.println("You hit it!!");
            }
            
            board(array);        
        }

        // Υπολογισμός Cruiser points με .equals()
        for(int i=1; i<9; i++ )
        {
            for(int j=1; j<9; j++ )
            {
                if("H".equals(ships[i][j]) && "H".equals(ships[i][j+1])) { spc++; }
                if("H".equals(ships[i][j]) && "H".equals(ships[i+1][j])) { spc++; }
            }
        }
        
        // Fixed positions check με .equals()
        if("H".equals(ships[1][1]) && "H".equals(ships[1][2])) { spc += 2; }
        if("H".equals(ships[9][1]) && "H".equals(ships[9][2])) { spc += 2; }
        if("H".equals(ships[9][9]) && "H".equals(ships[9][8])) { spc += 2; }
        if("H".equals(ships[1][9]) && "H".equals(ships[1][8])) { spc += 2; }
        
        // Υπολογισμός Patrol points με .equals()
        for(int i=1; i<9; i++ )
        {
            for(int j=1; j<9; j++ )
            {
                if("H".equals(ships[i][j]))
                {
                    // Έλεγχος αν είναι μεμονωμένο hit (Patrol)
                    if(!("H".equals(ships[i+1][j])) && !("H".equals(ships[i][j+1])) && !("H".equals(ships[i][j-1])) && !("H".equals(ships[i-1][j])))
                    {    
                        spp = spp + 1;
                    }
                }
            }
        }
        
        System.out.println("The final board with ships is:\n");
        board(ships);
        
        opMenu(); 
        
        int op = 0; 
        int resFlag = 1; 
        
        while(resFlag != 0)
        {
            op = scan.nextInt(); 
            while(op < 0 || op > 4)
            {
                System.out.println("Invalid number, try again:");
                op = scan.nextInt();
            }
            if(op == 1)
            {
                System.out.println("\nThe sum of correct tries is: " + (10-sm));
                System.out.println("\nPlayer, give an other answer:");
            }
            if(op == 2)
            {
                System.out.println("\nThe sum points of sunked patrols are: " + spp );
                System.out.println("You sunked " + spp  +" patrols.");
                System.out.println("\nGive an other answer:");
            }
            if(op == 3)
            {
                System.out.println("\nThe sum points of sunked cruisers are: " + spc  );
                System.out.println("You sunked " + spc/2 +" cruisers." );
                System.out.println("\nGive an other answer:");
            }
            if(op == 4)
            {
                System.out.println("\nThe total points of sunked patrols and cruisers are: " + (spc+ spp ) );
                System.out.println("\nGive an other answer:");
            }
            if(op == 0)
            {
                System.out.println("\nExit of results menu. ");
                resFlag = 0;
            }
        }
    }

    public static void opMenu() 
    {
        System.out.println("+--------------------------------------------+");
        System.out.println("| ~If you want see the sum of correct tries  |");
        System.out.println("|   press (1)                                |");
        System.out.println("| ~If you want see the sum points of sunked  |");
        System.out.println("|   patroles press (2).                      |");
        System.out.println("| ~If you want see the sum points of sunked  |");
        System.out.println("|   cruisers press (3).                      |");
        System.out.println("| ~If you want see the total points of sunked|");
        System.out.println("|   cruisers and patroles press (4).         |");
        System.out.println("| ~If you do not want see the results        |");
        System.out.println("|   press (0)                                |");
        System.out.println("+--------------------------------------------+");
        System.out.println("Player, give your answer:");
    }
}
