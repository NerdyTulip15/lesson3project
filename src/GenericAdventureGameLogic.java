import java.sql.SQLOutput;
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
        game = new GenericAdventureGame(name);
        System.out.println("It is time to set out on your quest for... something idk");
        boolean play = game.alive();
        while (play) {
            game.event();
        }
    }
}
