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
		        if(flag < 0 || flag > 1)
		        {
		        	System.out.println("Invalid number, try again:");
		        	flag = scan.nextInt();
		        }
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
		System.out.println("|     !!! Welcome to BattleShips game !!!    |");
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
	        if(op < 0 || op > 1)
	        {
	        	System.out.println("Invalid number, try again:");
	        	op = scan.nextInt();
	        }
	    }
		// Emfanisi kanonwn tou paixnidiou se periptwsi opou o xristis den tous gnorizei.
		if( op == 1) 
		{
			System.out.println("+--------------------------------------------+");
			System.out.println("| Rules:\t\t\t\t     |");
			System.out.println("| ~ There are two types of ships, Patrol and |");
			System.out.println("|   Cruiser. Patrol occupies only one cell,  |");
			System.out.println("|   the Cruiser occupies only two cells,     |");
			System.out.println("|   horizontal or vertically. \t\t     |");
			System.out.println("| ~ Three patrols and cruisers are randomly  |");
			System.out.println("|   placed on the grid. User calls 10        |");
			System.out.println("|   different cells, trying to guess if      |");
			System.out.println("|   there is a Patrol or Cruiser in it.      |");
			System.out.println("| ~ For each Patrol or Cruiser hit earns one |");
			System.out.println("|   point and if a Cruiser sinks, earn two   |");
			System.out.println("|   extra points are earned.\t\t     |");
			System.out.println("+--------------------------------------------+");
			System.out.println(" \nLets start the game... Right now, sea is empty!!\n");
		}
		// Minima enarksis tou paixnidiou efoson o paixtis gnorizei tous kanones.
		else 
		{
			System.out.println("  \nLets start the game... Right now, sea is empty!!\n");
		}
		scan.close();
	}
	
	static void board(String array[][]) // O pinakas pou apotelei kai to grafiko tou paixnidiou.
	{
		System.out.println("  c   1   2   3   4   5   6   7   8   9");
        System.out.println(" r  +---+---+---+---+---+---+---+---+---+");
        System.out.println("  1 | " + array[1][1]+ " | " + array[1][2]+ " | " + array[1][3]+ " | " + array[1][4]+ " | " + array[1][5]+ " | " + array[1][6]+ " | " + array[1][7]+ " | " + array[1][8]+ " | " + array[1][9]+ " |");
        System.out.println("    +---+---+---+---+---+---+---+---+---+");
        System.out.println("  2 | " + array[2][1]+ " | " + array[2][2]+ " | " + array[2][3]+ " | " + array[2][4]+ " | " + array[2][5]+ " | " + array[2][6]+ " | " + array[2][7]+ " | " + array[2][8]+ " | " + array[2][9]+ " |");
        System.out.println("    +---+---+---+---+---+---+---+---+---+");
        System.out.println("  3 | " + array[3][1]+ " | " + array[3][2]+ " | " + array[3][3]+ " | " + array[3][4]+ " | " + array[3][5]+ " | " + array[3][6]+ " | " + array[3][7]+ " | " + array[3][8]+ " | " + array[3][9]+ " |");
        System.out.println("    +---+---+---+---+---+---+---+---+---+");
        System.out.println("  4 | " + array[4][1]+ " | " + array[4][2]+ " | " + array[4][3]+ " | " + array[4][4]+ " | " + array[4][5]+ " | " + array[4][6]+ " | " + array[4][7]+ " | " + array[4][8]+ " | " + array[4][9]+ " |");
        System.out.println("    +---+---+---+---+---+---+---+---+---+");
        System.out.println("  5 | " + array[5][1]+ " | " + array[5][2]+ " | " + array[5][3]+ " | " + array[5][4]+ " | " + array[5][5]+ " | " + array[5][6]+ " | " + array[5][7]+ " | " + array[5][8]+ " | " + array[5][9]+ " |");
        System.out.println("    +---+---+---+---+---+---+---+---+---+");
        System.out.println("  6 | " + array[6][1]+ " | " + array[6][2]+ " | " + array[6][3]+ " | " + array[6][4]+ " | " + array[6][5]+ " | " + array[6][6]+ " | " + array[6][7]+ " | " + array[6][8]+ " | " + array[6][9]+ " |");
        System.out.println("    +---+---+---+---+---+---+---+---+---+");
        System.out.println("  7 | " + array[7][1]+ " | " + array[7][2]+ " | " + array[7][3]+ " | " + array[7][4]+ " | " + array[7][5]+ " | " + array[7][6]+ " | " + array[7][7]+ " | " + array[7][8]+ " | " + array[7][9]+ " |");
        System.out.println("    +---+---+---+---+---+---+---+---+---+");
        System.out.println("  8 | " + array[8][1]+ " | " + array[8][2]+ " | " + array[8][3]+ " | " + array[8][4]+ " | " + array[8][5]+ " | " + array[8][6]+ " | " + array[8][7]+ " | " + array[8][8]+ " | " + array[8][9]+ " |");
        System.out.println("    +---+---+---+---+---+---+---+---+---+");
        System.out.println("  9 | " + array[9][1]+ " | " + array[9][2]+ " | " + array[9][3]+ " | " + array[9][4]+ " | " + array[9][5]+ " | " + array[9][6]+ " | " + array[9][7]+ " | " + array[9][8]+ " | " + array[9][9]+ " |");
        System.out.println("    +---+---+---+---+---+---+---+---+---+");
        System.out.println("\n\n");
	}
	
	public static void deployRandomPatrols(String ships[][]) // H methodos i opoia pragmatopoiei tuxaia prosthiki patrols ston pinaka ships.
	{
		int r=0, c=0;
		
		for(int i=0; i<3; i++)
		{
			// Paragogi tuxaiwn timwn gia tin topothetisi twn patrols. 
				Random rows = new Random();
				r = rows.nextInt(8);
				if(r <= 1)
				{
					r = 2; 
				}
		
				Random columns = new Random();
				c = columns.nextInt(8);
				if(c <= 1)
				{
					c = 2; 
				}
				// Elegxos se periptwsi opou to patrol topothetite ston keno pinaka xwris na paraviazei tous kanones orthotitas.
				if(ships[r][c] == "B" && ships[r][c+1] != "S" && ships[r][c-1] != "S" && ships[r+1][c] != "S" && ships[r-1][c] != "S")
				{
					ships[r][c] = "S";
					
				}
				// elegxos opou to patrol paraviazei tous kanones orthotitas, topothetite se sigkekrimeno keli opou den enoxlei thn leitourgia tou paixnidiou.
				else if(ships[1][1] == "B")
				{
					ships[1][1] = "S";
				}
				else if(ships[9][1] == "B")
				{
					ships[9][1] = "S";
				}
				else if(ships[9][9] == "B")
				{
					ships[9][9] = "S";
				}
				else if(ships[1][9] == "B")
				{
					ships[1][9] = "S";
				}
		}
		
    }
	
	public static void deployRandomCruisers(String ships[][]) // H methodos i opoia pragmatopoiei tuxaia prosthiki cruisers ston pinaka ships.
	{
		int r=0, c=0;
		
		for(int i=0; i<3; i++)
		{
			// Paragogi tuxaiwn timwn gia tin topothetisi twn cruisers.
			Random rows = new Random();
			r = rows.nextInt(7);
			if(r <= 2)
			{
				r = 3; 
			}
			
			Random columns = new Random();
			c = columns.nextInt(7);
			if(c <= 2)
			{
				c = 3; 
			}
			
			// Elegxos se periptwsi opou to cruiser topothetite ston keno pinaka xwris na paraviazei tous kanones orthotitas.
			if(ships[r][c] == "B" && ships[r][c+2] != "S" && ships[r][c-1] != "S" && ships[r+2][c] != "S" && ships[r-1][c] != "S" && ships[r-1][c-1] != "S" && ships[r+1][c+1] != "S" && ships[r+1][c-1] != "S" && ships[r-1][c+1] != "S")
			{
				ships[r][c] = "S";
				ships[r+1][c] = "S";
			}
			// Elegxos opou to cruiser paraviazei tous kanones orthotitas, topothetite se sigkekrimeno keli opou den enoxlei thn leitourgia tou paixnidiou.
			else if(ships[1][1] == "B")
			{
				ships[1][1] = "S";
				ships[1][2] = "S";
			}
			else if(ships[9][1] == "B")
			{
				ships[9][1] = "S";
				ships[9][2] = "S";
			}
			else if(ships[1][8] == "B")
			{
				ships[1][8] = "S";
				ships[1][9] = "S";
			}
			else if(ships[9][8] == "B")
			{
				ships[9][8] = "S";
				ships[9][9] = "S";
			}
			
		}
		
	}
	
	public static void PlayerGuess(String ships[][], String array[][]) // Methodos h opoia tsekarei tis eikasies tou paixti kai epistrefei to katallilo apotelesma h minima.
	{
		
		int r=0, c=0; // Oi sintetagmenes
		int[] target = new int [10]; // Pinakas pou periexei tis eikasies tou paixti.
		int sm = 0; // Sum of misses.
		int spp = 0; // Sum points of patrols
		int spc = 0; // Sum points of cruisers
					  
		for(int i = 0; i < 10; i++)
		{	
			
				System.out.println("\nPlayer, give a possible guess below 11 - 99 :");
				Scanner scan = new Scanner(System.in);
				int guess = scan.nextInt();
				
				// Diaxorismos tos sintetagmenwn pou dinei o paixtis.
				r = guess / 10;
				c = guess % 10;
				// Elegxos gia orthi paraxorisi sintetagmenwn ston pinaka target.
				if(r != 0 && c != 0) 
				{
					target[i] = guess; 
				}
				
				// Elegxos gia orthi paraxorisi sintetagmenwn apo ton xristi, na min einai tis morfis x0 h 0y.
				while(r == 0 || c == 0)
			    {
			        if(r == 0 || c == 0)
			        {
			        	System.out.println("Invalid number x0 or 0y, try again:");
						guess = scan.nextInt();
					
						r = guess / 10;
						c = guess % 10;
						target[i] = guess; 
			        	
			        }
			    }
				// Elegxos gia orthi paraxorisi sintetagmenwn apo ton xristi, se periptosi pou dwsei tis idies sintetagmenes.
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
				
				// Elegxos opou h eikasia pou ekane o paixtis htan lanthasmeni(astoxia)
				if(ships[r][c] == "B" )
				{
					array[r][c] = "M";
					ships[r][c] = "M";
					System.out.println("You miss it!!");
					
					sm = sm + 1;
				}
				// Elegxos opou h eikasia pou ekane o paixtis htan swsti(eustoxia)
				if(ships[r][c] == "S" )
				{
						array[r][c] = "H";
						ships[r][c] = "H";
						System.out.println("You hit it!!");
						
				}
				
				// Emfanisi tou grafikou tou paixnidiou etsi oste o paixtis na gnorizei tis kiniseis pou ekane.
				board(array);		
			
		}
		// Anazitisi tou arithmo twn cruises pou vithistikan gia ton upologismo twn pontwn.  
		for(int i=3; i<7; i++ )
		{
		 for(int j=3; j<7; j++ )
		 {
			 // Elegxos gia to an vithistike kapio cruisers.
			 if(ships[i][j] == "H" && ships[i][j+1] == "H")
			 {
				spc = spc + 1;
			 }
			 else if(ships[i][j] == "H" && ships[i][j-1] == "H")
			 {
				spc = spc + 1;
			 }
			 if(ships[i][j] == "H" && ships[i+1][j] == "H")
			 {
				spc = spc + 1;
			 }
			 else if(ships[i][j] == "H" && ships[i-1][j] == "H")
			 {
				spc = spc + 1;
			 }
			 
		 }
		 
		}
		// Efoson kapoies theseis pou topothetounte ta cruisers einai fix, 
		// prepei na ginete elegxos gia to an exoun xtipithei apo ton xristi.
		if(ships[1][1] == "H" && ships[1][2] == "H"  )
		{
			 spc = spc + 2;
		}
		if(ships[9][1] == "H" && ships[9][2] == "H" )
		{
			 spc = spc + 2;
		}
		if(ships[9][9] == "H" && ships[9][8] == "H" )
	    {
			spc = spc + 2;
		}
		if(ships[1][9] == "H" && ships[1][8] == "H" )
		{
			spc = spc + 2;
		}
		
		
		
		// Anazitisi tou arithmo twn patrols pou vithistikan gia ton upologismo twn pontwn.
		 for(int i=1; i<9; i++ )
		 {
			 for(int j=1; j<9; j++ )
			 {
				// Elegxoi efoson to hit (H) apotelei ena patrol.
				if(ships[i][j] == "H")
				{
					// Elegxos opou to patrol vriskete kapou konta sto kentro tou pinka diladi entos (2,..,8x2,..,8)
					if((ships[i+1][j] == "M" || ships[i+1][j] == "B") && (ships[i][j+1] == "M" || ships[i][j+1] == "B") && (ships[i][j-1] == "M" || ships[i][j-1] == "B") && (ships[i-1][j] == "M" || ships[i-1][j] == "B"  ))
					{	
						
						spp = spp + 1;
								
					}
					
				}
				
			 }
		 }
		 // Efoson kapoies theseis pou topothetounte ta patrols einai fix, 
		 // prepei na ginete elegxos gia to an exoun xtipithei apo ton xristi.
		 if(ships[1][1] == "H" && (ships[1][2] == "M" || ships[1][2] == "B")  )
		 {
			 spp = spp +1;
		 }
		 if(ships[9][1] == "H" && (ships[9][2] == "M" || ships[9][2] == "B"))
		 {
			 spp = spp +1;
		 }
		 if(ships[9][9] == "H" && (ships[9][8] == "M" || ships[9][8] == "B"))
		 {
			 spp = spp +1;
		 }
		 if(ships[1][9] == "H" && (ships[1][8] == "M" || ships[1][8] == "B"))
		 {
			 spp = spp +1;
		 }
		 
		
		
		// Emfanisi tou telikou pinaka mazi me ta ploia pou den xtipithikan.
		System.out.println("The final board with ships is:\n");
		board(ships);
		
		
		opMenu(); // Methodos tou menu epilogwn gia to ti epithimei na dei o paixtis, sxetika me ta apotelesmata pou efere.
		
		int op = 0; // Arxikopoihsh tis metavlitis tis epilogis tou paixti.
		int flag = 1; // Deiktis pou kathorizei ton termatismo tou menu apotelesmatwn.
		
		while(flag != 0)
		{
			
			Scanner scan = new Scanner(System.in);
		
			// Epilogi apantisis apo ton xristi.
			op = scan.nextInt(); 
		
			// Elegxos egirotitas tis timis pou edwse o xristis.
			while(op < 0 || op > 4)
			{
				if(op < 0 || op > 4)
				{
					System.out.println("Invalid number, try again:");
					op = scan.nextInt();
				}
			}
			// Elegxos gia to an o paixtis epithimei na dei to sinoliko aritho epitixion pou ekane.
			if(op == 1)
			{
				System.out.println("\nThe sum of correct tries is: " + (10-sm));
				System.out.println("\nPlayer, give an other answer:");
			}
			// Elegxos gia to an o paixtis epithimei na dei tous pontous pou emase vithizontas ta patrols. 
			if(op == 2)
			{
				System.out.println("\nThe sum points of sunked patrols are: " + spp );
				System.out.println("You sunked " + spp  +" patrols.");
				System.out.println("\nGive an other answer:");
			}
			// Elegxos gia to an o paixtis epithimei na dei tous pontous pou emase vithizontas ta cruisers. 
			if(op == 3)
			{
					System.out.println("\nThe sum points of sunked cruisers are: " + spc  );
					System.out.println("You sunked " + spc/2 +" cruisers." );
					System.out.println("\nGive an other answer:");
			}
			// Elegxos gia to an o paixtis epithimei na dei tous sinolikous pontous pou emase vithizontas ta cruisers kai ta patrols.
			if(op == 4)
			{
				System.out.println("\nThe total points of sunked patrols and cruisers are: " + (spc+ spp ) );
				System.out.println("\nGive an other answer:");
			}
			// Elegxos gia to an o xristis den epithimei na dei ta apotelesmata tou.
			if(op == 0)
			{
				System.out.println("\nExit of results menu. ");
				flag = 0;
			}

		}
		
		
	}
	public static void opMenu() // Methodos tou menu epilogwn gia to ti epithimei na dei o paixtis, sxetika me ta apotelesmata pou efere.
	{
		// Emfanisi menu gia to ti epithimei na dei o paixtis, sxetika me ta apotelesmata pou efere.
				System.out.println("+--------------------------------------------+");
				System.out.println("| ~If you want see the sum of correct tries  |");
				System.out.println("|   press (1)\t\t\t\t     |");
				System.out.println("| ~If you want see the sum points of sunked  |");
				System.out.println("|   patroles press (2).\t\t\t     |");
				System.out.println("| ~If you want see the sum points of sunked  |");
				System.out.println("|   cruisers press (3).\t\t\t     |");
				System.out.println("| ~If you want see the total points of sunked|");
				System.out.println("|   cruisers and patroles press (4).\t     |");
				System.out.println("| ~If you do not want see the results        |");
				System.out.println("|   press (0)\t\t\t\t     |");
				System.out.println("+--------------------------------------------+");
				
				System.out.println("Player, give your answer:");
	}
	
 
}
