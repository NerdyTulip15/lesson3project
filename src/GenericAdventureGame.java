import java.util.Scanner;
public class GenericAdventureGame {
    private String playerName;
    private int playerHealth;
    private Scanner scan;
    private int rounds;
    private int roundCount;
    private boolean hasSpellbook;
    private boolean secret;
    private int healingPotions;
    private boolean understandSpellbook;

    public GenericAdventureGame(String n){
        playerName = n;
        playerHealth = 100;
        scan = new Scanner(System.in);
        rounds = -1;
        roundCount=1;
        hasSpellbook = false;
        secret = false;
        healingPotions = 0;
        understandSpellbook = false;
    }

    public GenericAdventureGame(String n, int r){
        playerName = n;
        playerHealth = 100;
        scan = new Scanner(System.in);
        rounds = r;
        roundCount=1;
        hasSpellbook = false;
        secret = false;
        healingPotions = 0;
        understandSpellbook = false;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public void event(){
        int num = (int)(Math.random()*5)+1;
        if (num==1){
            triviaEvent();
        } else if (num==2){
            luckEvent();
        } else if (num==3){
            mathEvent();
        } else if (num==4){
            choiceEvent();
        } else if (num==5){
            battleEvent();
        }
        roundCount++;
    }

    public void event(int num){ //STRICTLY FOR TESTING PURPOSES
        if (num==1){
            triviaEvent();
        } else if (num==2){
            luckEvent();
        } else if (num==3){
            mathEvent();
        } else if (num==4){
            choiceEvent();
        } else if (num==5){
            battleEvent();
        }
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
    //use a nested loop here
    private void battleEvent(){
        int enemyHP = 50;
        String action;
        System.out.println("Oh no! It's a wild goblin!");
        while (enemyHP>0&&playerHealth>0){
            goblinAttack();
            System.out.println("Choose an action");
            System.out.println("A) Sword");
            System.out.print("B) Heal");
            System.out.println(" (healing potions: "+healingPotions+")");
            if (hasSpellbook){
                System.out.println("C) Spellbook");
            }
            action = scan.nextLine().toLowerCase();
            if (hasSpellbook) {
                while (!action.equals("a") && !action.equals("b") && !action.equals("c")) {
                    System.out.println("You can't do that! Remember to respond with the corresponding letter");
                    action = scan.nextLine().toLowerCase();
                }
            } else {
                while (!action.equals("a") && !action.equals("b")) {
                    System.out.println("You can't do that! Remember to respond with the corresponding letter");
                    action = scan.nextLine().toLowerCase();
                }
            }

            if (action.equals("a")){
                System.out.println("You pull out your sword and slash the goblin");
                enemyHP-=10;
            } else if (action.equals("b")){
                if (healingPotions==0){
                    System.out.println("bro you literally have no healing potions");
                } else {
                    System.out.println("You drank a healing potion");
                    healingPotions--;
                    playerHealth+=8;
                    if (playerHealth>100){
                        playerHealth=100;
                    }
                }
            } else if (action.equals("c")){
                if (understandSpellbook){
                    System.out.println("Enter a spell name. It can be any name you like.");
                    action = scan.nextLine().toLowerCase();
                    if (action.equals("wake up")&&secret){
                        System.out.println("You open your eyes. You seem to be in a hospital laying on a bed.");
                        System.out.println("There's a nurse right next to you.");
                        System.out.println("\"Oh! You're awake!\"");
                        System.out.println("A) ...");
                        action = scan.nextLine();
                        System.out.println("\"I was starting to worry that you wouldn't make it...\"");
                        System.out.println("\"You've been in a coma for 7 years\"");
                        System.out.println("A) ...");
                        action = scan.nextLine();
                        System.out.println("\"Don't worry, it's going to be okay now.\"");
                        playerHealth = 0;
                        break;
                    } else {
                        int damage = spell(action);
                        enemyHP -= damage;
                    }
                } else {
                    System.out.println("You used the spellbook. Or at least tried to");
                    enemyHP-=3;
                }
            }
            System.out.println("Goblin HP: "+enemyHP);

        }

    }

    private void goblinAttack(){
        int act = (int)(Math.random()*3)+1;
        if (act==1){
            System.out.println("The goblin slashed you with its claws!");
            playerHealth-=5;
        } else if (act==2){
            System.out.println("The goblin stabbed you with a very sharp stick!");
            playerHealth-=10;
        } else {
            System.out.println("The goblin punched you!");
            playerHealth-=3;
        }
    }

    private int spell(String s){
        int len = s.length();
        int damage = len/2;
        for (int i=0; i<len; i++){
            String sub = s.substring(i,i+1);
            sub = sub.toLowerCase();
            if (sub.equals("e")){
                damage+=2;
            } else if (sub.equals("x")){
                damage+=5;
            }
        }
        return damage;
    }

    private void choiceEvent(){
        int num = (int)(Math.random()*4)+1;
        String ans = "";
        if (num==1){
            System.out.println("A merchant offers you a free cookie. Will you take it?");
            System.out.println("A) Yes");
            System.out.println("B) No");
            ans = scan.nextLine().toLowerCase();
            while (!ans.equals("a")&&!ans.equals("b")) {
                System.out.println("I don't think the merchant understands you. Remember to respond with the corresponding letter");
                ans = scan.nextLine().toLowerCase();
            }
            if (ans.equals("a")){
                System.out.println("You take the cookie. You realize it's an oatmeal raisin cookie. You're allergic to raisins, so you take some damage.");
                playerHealth-=damage();
            } else {
                System.out.println("You decline and move along.");
            }
        } else if (num==2&&hasSpellbook==false){
            System.out.println("A man walks up to you.");
            System.out.println("\"SHERN SIDR RMWSLSIGJ! E LSMN RJWJ EPEJEX WP MSHFU TIEO LWJE JFH K SDK'R KDNF MG. JSK VBBJ MCBG K NSKFK KSDHNF. KSH POW SJFJ SHF SDKRL DN GJHF J DKE SJEKG JIEKSITU SNFGK?\"");
            System.out.println("He hands you a spellbook. I think he wants you to say one of the words in there so that people can understand him again. Not sure which one it is tho. Try your best I guess");
            System.out.println("A) チキン"); //chicken
            System.out.println("B) 呪いを解く"); //remove curse
            System.out.println("C) 爆発"); //explosion
            System.out.println("D) リックロール");//rickroll lmao
            ans = scan.nextLine().toLowerCase();
            while (!ans.equals("a")&&!ans.equals("b")&&!ans.equals("c")&&!ans.equals("d")){
                System.out.println("Yeah that's not one of the spells. Remember to respond with the corresponding letter.");
                ans = scan.nextLine().toLowerCase();
            }
            if (ans.equals("a")){
                System.out.println("You recite the words. The man then turns into a chicken. You shrug and walk away");
                hasSpellbook=true;
                System.out.println("OBTAINED SPELLBOOK");
            } else if (ans.equals("b")){
                System.out.println("You recite the words. The man looks at you with gratitude. \"Thank you so much, dear traveler! Here. Keep the spellbook as thanks\"");
                hasSpellbook=true;
                System.out.println("OBTAINED SPELLBOOK");
                System.out.println("OBTAINED SPELLBOOK TRANSLATOR");
                understandSpellbook = true;
            } else if (ans.equals("c")){
                System.out.println("The spellbook explodes. You were holding it, so your hands get burns.");
                playerHealth-=damage();
            } else {
                System.out.println("NEVER GONNA GIVE YOU UP");
                System.out.println("NEVER GONNA LET YOU DOWN");
                System.out.println("NEVER GONNA RUN AROUND AND HURT YOU");
                System.out.println("NEVER GONNA MAKE U CRY");
                System.out.println("NEVER GONNA SAY GOODBYE");
                System.out.println("NEVER GONNA TELL A LIE AND HURT YOU");
                playerHealth-=damage();
            }
        } else if (num==2){
            System.out.println("\"Hello! "+playerName+" ,right? I've heard about you. Heard you've been looking for something.\"");
            if (hasSpellbook){ //helps with secret ending
                System.out.println("She notices the spellbook in your bag.");
                System.out.println("\"Oh you have the spellbook! That's nice.\"");
                System.out.println("\"...say, do you know what it is you're looking for?\"");
                System.out.println("A) ...");
                ans = scan.nextLine();
                System.out.println("\"You don't know, huh?\"");
                System.out.println("\"Let me tell you something.\"");
                System.out.println("\"You know how to end this adventure, right?\"");
                System.out.println("\"You either die or you run out of rounds.\"");
                System.out.println("\"But what if I told you that there's a third way?\"");
                System.out.println("\"A secret way.\"");
                System.out.println("\"You just need to WAKE UP\"");
                System.out.println("A) ...");
                ans = scan.nextLine();
                secret = true;
            }
            System.out.println("\"Anyway, my bag's stuck up in that tree. Can you get it for me?\"");
            System.out.println("You agree to do so and attempt to get it.");
            System.out.println("A) Climb the tree");
            System.out.println("B) Chop down the tree");
            ans = scan.nextLine().toLowerCase();
            while (!ans.equals("a")&&!ans.equals("b")){
                System.out.println("Yeah you can't do that buddy. Remember to respond with the corresponding letter");
                ans = scan.nextLine().toLowerCase();
            }

            if (ans.equals("a")){
                System.out.println("You climb the tree successfully and get the bag. You jump down from the tree and give it to the woman.");
                System.out.println("\"Thank you, dear traveler!\"");
            } else {
                System.out.println("You spot an axe nearby. You grab it and chop the tree down. Unfortunately, you have no idea what you're doing so the tree falls down on you. You eventually get out, but you did take some damage from that.");
                playerHealth-=damage();
            }
        } else if (num==3){
            System.out.println("You're walking down the path when you hear singing. You check it out and see a choir singing. They seem really into it.");
            System.out.println("A) Ignore them");
            System.out.println("B) Disturb them");
            System.out.println("C) Secret 3rd option");
            ans = scan.nextLine().toLowerCase();
            while (!ans.equals("a")&&!ans.equals("b")&&!ans.equals("c")){
                System.out.println("You can't do that! Remember to respond with the corresponding letter");
                ans = scan.nextLine().toLowerCase();
            }
            if (ans.equals("a")){
                System.out.println("You continue to walk down the path");
            } else if (ans.equals("b")){
                System.out.println("You take out a bell and ring it. The choir stops singing and notices you. They then throw a bunch of rocks at you. What were you thinking, man?");
                playerHealth-=damage();
            } else {
                System.out.println("You listen to the choir for a while. Their singing is very beautiful. It's so beautiful that it heals you.");
                if (100-playerHealth<=9){
                    playerHealth=100;
                } else {
                    playerHealth+=10;
                }
            }
        } else {
            System.out.println("A wizard approaches you.");
            System.out.println("\"Hey, you look pretty strong. You see, I made this pretty cool spell and I need to test it on someone. Would you like to test it out?\"");
            System.out.println("A) Sure");
            System.out.println("B) No");
            ans = scan.nextLine().toLowerCase();
            if (!ans.equals("a")&&!ans.equals("b")){
                System.out.println("The wizard looks confused. Remember to correspond with the corresponding letter");
                ans = scan.nextLine().toLowerCase();
            }
            if (ans.equals("a")){
                System.out.println("The wizard tests out his spell on you. Thankfully, you're left unharmed.");
                System.out.println("\"Thank you, kind traveller. Here, take this as a gift.\"");
                System.out.println("The wizard gave you a healing potion");
                healingPotions++;
            } else if (ans.equals("b")){
                System.out.println("The wizard walks away disappointed. You continue to walk down the path");
            }
        }
    }

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
