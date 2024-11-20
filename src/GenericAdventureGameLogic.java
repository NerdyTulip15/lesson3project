import java.util.Scanner;

public class GenericAdventureGameLogic {
    private Scanner scan;
    private GenericAdventureGame game;

    public GenericAdventureGameLogic(){
        scan = new Scanner(System.in);
    }

    public void start(){
        System.out.println("Welcome to Generic Adventure Game!");
        System.out.println("Enter your name");
        String name = scan.nextLine();
        System.out.println("Hello "+name+"!");
        System.out.println("Is there a specific amount of rounds you'd like on your adventure? (y/n)");
        String ans = scan.nextLine();
        int rounds=-1;
        if (ans.equals("y")){
            System.out.println("How many?");
            rounds = scan.nextInt();
            scan.nextLine();
        }

        if (rounds>0){
            game = new GenericAdventureGame(name, rounds);
        } else {
            game = new GenericAdventureGame(name);
        }
        System.out.println("It is time to set out on your quest for... something idk");
        boolean play = game.gameOver();
        while (play) {
            game.event();
            play = game.gameOver();
        }
        System.out.println();
        System.out.println("Welp looks like that's the end of your adventure");

    }
}
