import java.util.Scanner;
public class GenericAdventureGame {
    private String playerName;
    private int playerHealth;
    private Scanner scan;
    private int rounds;
    private int roundCount;

    public GenericAdventureGame(String n){
        playerName = n;
        playerHealth = 100;
        scan = new Scanner(System.in);
        rounds = -1;
        roundCount=1;
    }

    public GenericAdventureGame(String n, int r){
        playerName = n;
        playerHealth = 100;
        scan = new Scanner(System.in);
        rounds = r;
        roundCount=1;
    }

    public int getRounds() {
        return rounds;
    }

    public void event(){
        int num = (int)(Math.random()*3)+1; //change the 3 to 5 once done
        if (num==1){
            triviaEvent();
        } else if (num==2){
            luckEvent();
        } else if (num==3){
            mathEvent();
        }
        System.out.println("You have "+playerHealth+" HP left");
        roundCount++;
    }

    private void triviaEvent(){
        int num = (int)(Math.random()*5)+1;
        String answer = "";
        System.out.println("The path splits into multiple paths. Between them is a sign. Here's what it says.");
        System.out.println("\"One of these paths leads to something bad! Choose the path with the right answer to this question\"");
        if (num==1){
            System.out.println("According to the Guinness World Records, what's the best-selling book of all time? (respond with the letter corresponding to the choice)");
            System.out.println("A) Harry Potter and the Sorcerer's Stone");
            System.out.println("B) The Bible");
            System.out.println("C) The Lord of the Rings");
            System.out.println("D) To Kill A Mockingbird");
            answer = scan.nextLine().toLowerCase();
            if (answer.equals("b")){
                System.out.println("You walk down the path.");
            } else {
                System.out.println("You walk down the path. You then fell into a hole and took some damage");
                playerHealth-=damage();
            }
        } else if (num==2){
            System.out.println("Which of these countries is the largest?");
            System.out.println("A) Russia");
            System.out.println("B) USA");
            System.out.println("C) Canada");
            System.out.println("D) Italy");
            answer = scan.nextLine().toLowerCase();
            if (answer.equals("a")){
                System.out.println("You walk down the path.");
            } else {
                System.out.println("You walk down the path. A gorilla then ran up to you and beat you up. It is a very angry gorilla.");
                playerHealth-=damage();
            }
        } else if (num==3){
            System.out.println("What's the fear of long words called?");
            System.out.println("A) Arachnophobia");
            System.out.println("B) Mysophobia");
            System.out.println("C) Amaxophobia");
            System.out.println("D) Hippopotomonstrosesquippedaliophobia");
            answer = scan.nextLine().toLowerCase();
            if (answer.equals("d")){
                System.out.println("You walk down the path.");
            } else {
                System.out.println("You walk down the path. A giant letter monster then punches you in the face.");
                playerHealth=-damage();
            }
        } else if (num==4){
            System.out.println("How many legs does a spider have?");
            System.out.println("A) 8");
            System.out.println("B) 6");
            System.out.println("C) 4");
            System.out.println("D) 2");
            answer = scan.nextLine().toLowerCase();
            if (answer.equals("a")){
                System.out.println("You walk down the path.");
            } else {
                System.out.println("You walk down the path. You then gain emotional damage because of how hard that question was");
                playerHealth=-damage();
            }
        } else {
            System.out.println("If there's something strange in your neighborhood, who you gonna call?");
            System.out.println("A) Police");
            System.out.println("B) Firefighters");
            System.out.println("C) Ghostbusters");
            System.out.println("D) Nobody");
            answer = scan.nextLine().toLowerCase();
            if (answer.equals("c")){
                System.out.println("You walk down the path.");
            } else {
                System.out.println("You walk down the path. You then get ran over by a car. Wonder where it's going.");
                playerHealth-=damage();
            }
        }
    }

    private void battleEvent(){}

    private void choiceEvent(){}

    private void luckEvent(){
        int luckyNum = (int)(Math.random()*10)+1;
        int chosenNum;
        System.out.println("Oh no! You've been cursed! Quick! Pick a number from 1-10!");
        chosenNum = scan.nextInt();
        scan.nextLine();
        if (chosenNum==luckyNum){
            System.out.println("The curse wore off.");
        } else {
            System.out.println("You chose the wrong number so you took some damage");
            playerHealth-=damage();
        }
    }

    private void mathEvent(){
        int firstNum = (int)(Math.random()*100)+1;
        int secondNum = (int)(Math.random()*100)+1;
        System.out.println("Math jumpscare! What's "+firstNum+"+"+secondNum+"?");
        int answer = scan.nextInt();
        scan.nextLine();
        if (answer==firstNum+secondNum){
            System.out.println("Correct! Keep going!");
        } else {
            System.out.println("You got the question wrong. The math gods got angry at you so they struck you with lightning");
            playerHealth-=damage();
        }
    }

    private int damage(){
        return (int)(Math.random()*21)+10;
    }

    public boolean gameOver(){
        boolean notDead;
        boolean moreRounds = true;
        if (playerHealth>0){
            notDead=true;
        } else {
            notDead = false;
        }

        if (rounds>0){
            if (roundCount>rounds){
                moreRounds = false;
            }
        }

        if (notDead&&moreRounds){
            return true;
        }
        return false;
    }
}
