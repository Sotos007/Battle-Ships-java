package Erg_1;

import java.util.Scanner;
import java.util.Random;

public class Battleship 
{
    public static void main(String[] args)
    {
        int flag = 0; // Index that determines whether to terminate or continue the game.
        
        mainMenu(); // Method that displays the main/initial game menu.
        
        while(flag != 1)
        {
            // Initialization of the main grid array and an auxiliary ships array used for game logic.
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
            
            // Display the main board which constitutes the game's graphics.
            board(array);
            
            // Method that places cruisers in random positions on the ships grid.
            deployRandomCruisers(ships);
            
            // Method that places patrols in random positions on the ships grid.
            deployRandomPatrols(ships); 
            
            // Method that checks player guesses and returns the appropriate result or message.
            PlayerGuess(ships, array);
            
            System.out.println("\n\nPlayer, do you want to continue the game Yes(0) or No(1)?");
            Scanner scan = new Scanner(System.in);
            flag = scan.nextInt(); 
            
            // Check for valid user input.
            while(flag < 0 || flag > 1)
            {
                System.out.println("Invalid number, try again:");
                flag = scan.nextInt();
            }
            
            // Print appropriate message based on user selection.
            if(flag == 1)
            {
                System.out.println("\nExit...");
            }
            else
            {
                System.out.println("  \nRight now, the sea is empty!!\n");
            }
            
        }
        
    }

    static void mainMenu() // Method that displays the initial game menu.
    {    
        System.out.println("+--------------------------------------------+");
        System.out.println("|      !!! Welcome to BattleShips game !!!    |");
        System.out.println("+--------------------------------------------+");
        
        // Ask the user if they know the game rules.
        System.out.println("\nPlayer, do you know the rules Yes(0) or No(1)?"); 
        
        int op = 0;
        Scanner scan = new Scanner(System.in);
        
        // User selection for answer.
        op = scan.nextInt(); 
        
        // Check for valid user input.
        while(op < 0 || op > 1)
        {
            System.out.println("Invalid number, try again:");
            op = scan.nextInt();
        }
        // Display game rules if the user does not know them.
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
            System.out.println(" \nLets start the game... Right now, the sea is empty!!\n");
        }
        // Start message if the player already knows the rules.
        else 
        {
            System.out.println("  \nLets start the game... Right now, the sea is empty!!\n");
        }
    }
    
    static void board(String array[][]) // The grid representing the game board graphics.
    {
        System.out.println("    c   1   2   3   4   5   6   7   8   9");
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
    
    public static void deployRandomPatrols(String ships[][]) // Method that randomly adds patrols to the ships grid.
    {
        int r=0, c=0;
        Random rand = new Random();
        
        for(int i=0; i<3; i++)
        {
            r = rand.nextInt(8) + 2; // Ensuring boundary safety
            c = rand.nextInt(8) + 2; 

            // Using .equals() for String comparison
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
    
    public static void deployRandomCruisers(String ships[][]) // Method that randomly adds cruisers to the ships grid.
    {
        int r=0, c=0;
        Random rand = new Random();
        
        for(int i=0; i<3; i++)
        {
            r = rand.nextInt(7) + 3;
            c = rand.nextInt(7) + 3;
            
            // Using .equals() for safe String comparison
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
    
    public static void PlayerGuess(String ships[][], String array[][]) // Method that checks player guesses and returns results.
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
                    System.out.println("These coordinates are already used, try again:");
                    guess = scan.nextInt();
                    r = guess / 10;
                    c = guess % 10;
                    target[i] = guess;
                }
            }
            
            // Check Hit or Miss using .equals()
            if("B".equals(ships[r][c]))
            {
                array[r][c] = "M";
                ships[r][c] = "M";
                System.out.println("You missed it!!");
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

        // Calculate Cruiser points
        for(int i=1; i<9; i++ )
        {
            for(int j=1; j<9; j++ )
            {
                if("H".equals(ships[i][j]) && "H".equals(ships[i][j+1])) { spc++; }
                if("H".equals(ships[i][j]) && "H".equals(ships[i+1][j])) { spc++; }
            }
        }
        
        // Fixed positions boundary check
        if("H".equals(ships[1][1]) && "H".equals(ships[1][2])) { spc += 2; }
        if("H".equals(ships[9][1]) && "H".equals(ships[9][2])) { spc += 2; }
        if("H".equals(ships[9][9]) && "H".equals(ships[9][8])) { spc += 2; }
        if("H".equals(ships[1][9]) && "H".equals(ships[1][8])) { spc += 2; }
        
        // Calculate Patrol points
        for(int i=1; i<9; i++ )
        {
            for(int j=1; j<9; j++ )
            {
                if("H".equals(ships[i][j]))
                {
                    // Check if hit is isolated (Patrol)
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
                System.out.println("\nPlayer, give another answer:");
            }
            if(op == 2)
            {
                System.out.println("\nThe total points from sunken patrols: " + spp );
                System.out.println("You sank " + spp  +" patrols.");
                System.out.println("\nGive another answer:");
            }
            if(op == 3)
            {
                System.out.println("\nThe total points from sunken cruisers: " + spc  );
                System.out.println("You sank " + spc/2 +" cruisers." );
                System.out.println("\nGive another answer:");
            }
            if(op == 4)
            {
                System.out.println("\nThe total points from sunken patrols and cruisers: " + (spc+ spp ) );
                System.out.println("\nGive another answer:");
            }
            if(op == 0)
            {
                System.out.println("\nExiting the results menu. ");
                resFlag = 0;
            }
        }
    }

    public static void opMenu() 
    {
        System.out.println("+--------------------------------------------+");
        System.out.println("| ~If you want to see the sum of correct     |");
        System.out.println("|   tries press (1)                          |");
        System.out.println("| ~If you want to see the points for sunken  |");
        System.out.println("|   patrols press (2).                       |");
        System.out.println("| ~If you want to see the points for sunken  |");
        System.out.println("|   cruisers press (3).                      |");
        System.out.println("| ~If you want to see the total points for   |");
        System.out.println("|   all ships press (4).                     |");
        System.out.println("| ~If you do not want to see results         |");
        System.out.println("|   press (0)                                |");
        System.out.println("+--------------------------------------------+");
        System.out.println("Player, give your choice:");
    }
}
