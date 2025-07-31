import java.util.Scanner;
public class StephanieXiaMurderMystery
{
    private static Scanner scan = new Scanner(System.in);

    private static void game () 
    {
        String user;
        String name;
        String birthday = "";
        int currentDate;
        int floorNum = (int)(Math.random() * 10+1);
        int compRemainder;
        int userRemainder;
        long startTime;
        String doorPassword = "";
        String userPassword = "";
        int solution;
        String operator, correctLaptopPassword = "";
        int randOp, num1, num2;
        
        //Introducion Line - letting the user know what the game is about
        outputSlowly("Welcome to the Murder Mystery Game. In order to win, you need to find out who the murderer is and overcome all the obstacles", 20); 
        outputSlowly("in the investigation process.", 20);   
        sopl("");
        //asking the user if they want to play (they have to play even if they say no)
        sopl("Are you ready to go on a thrilling adventure of mystery (y/n)?!");
        user = scan.nextLine();
        //turn lowercase to uppercase
        user = user.toUpperCase();
        //whatever the user types, they have to play
        if (user.equals("Y"))
        {
            outputSlowly("Alrighty, let’s get the fun started!", 20);
            sopl ("[Directive - type enter to proceed]");
            user = scan.nextLine();
        }
        else if (user.equals("N"))
        {
            sopl("Too bad, from the moment you enter the game, there was no turning back!");
            outputSlowly ("                                                      ", 30);
        }

        //clear screen
        sopl("\f");
        
        //getting some user info so it's more interactive
        outputSlowly ("First, we want to get to know a bit about you, the player.", 20);
        sopl("");
        //name
        sopl ("Your name (Ex. John Jefferson):");
        name = scan.nextLine();
        //birthday
        sopl ("Your birthday (MMDDYYYY):");
        birthday = scan.nextLine();
        //date
        sopl ("Current date (MMDDYYYY):");
        currentDate = scan.nextInt();

        outputSlowly ("I think we're ready...",40);
        
        //let the user have some time to read the line
        outputSlowly ("                                             ", 30);
        //clear screen
        sopl("\f");
        
        //Start of the game, the game date is set at the date the user put in
        //date of the game
        outputSlowly ("--- [" + currentDate + "] --- ", 30);
        sopl ("");
        //Beginning Back story
        outputSlowly ("You wake up in the middle of the night, sweating, panting. The memories of your best friend run through your mind. As if the ", 20);
        outputSlowly ("sun has come crashing down on earth, you feel as if your whole world has just collapsed. Your best friend was murdered the ", 20);
        outputSlowly ("night of " + (currentDate -10000) + ", yesterday. You walk into the bathroom and splash a handful of painfully cold water ", 20);
        outputSlowly ("on your face to wake yourself up. I need to do something, you think to yourself. I need to find out who the murderer is. The ", 20);
        outputSlowly ("realization hit you, guess the slap of the water worked… You change into your outdoor clothes, grab your bag and head out ", 20);
        outputSlowly ("the door. I’m going to get to the bottom of this you say to yourself, and you head to their house.",20);
        sopl ("[Directive -- Type enter to continue: ]");
        scan.nextLine();
        sopl("\f");
        
        //You are at the place of your friend's
        //Randomized floor number just for fun
        outputSlowly ("Their apartment is on floor " + floorNum + ". You walk up the stairs to their apartment and you pass by a person walking ", 20);
        outputSlowly ("down and accidentally overhears that they’re going to go to the convenience store and they’re going to be back in 7 ", 20);
        outputSlowly ("minutes. You thought it was just the owner of one of the apartments. It wasn’t until they left that you suddenly remember the ", 20);
        outputSlowly ("key chain that they were holding… It was the one you gave your best friend’s. It was the murderer, it has to be. I have to find", 20);
        outputSlowly ("evidence, you think to yourself. You only got 7 minutes or else you’re going to get caught by the murderer. You set a timer on your phone", 20); 
        outputSlowly ("for 7 minutes.",20);
        
        //Start timer for user to check how much time has past 
        startTime = System.nanoTime();

        sopl ("");
        //4 digit password for the user to figure out, can try infinite times if they fail
        outputSlowly ("You look at the 4 digit password lock of the apartment front door. You remember that they have sent you the password generator", 20);
        outputSlowly ("to their front door password once. You pull out your phone and find the message. It says…", 20);
        sopl ("");
        sopl ("[All digits of the password are from 1-10, you need to find out the remainder of two numbers four times to get the four digit password.]");
        sopl("");


        //for loop, looping 4 times, each time to get one digit of the password
        for (int i=0; i <4; i++)
        {
            //generates number randomly from 1-9
            int dividend = (int)(Math.random() * 9+1);
            int divisor = (int)(Math.random() * 9+1);
            //asks user the question
            sopl ("What is the remainder of " + dividend + "/" + divisor + "? (type in the number answer)");
            userRemainder = scan.nextInt(); 
            //the user's answer to the password
            userPassword += userRemainder;

            //the computer calculated answer to the password
            compRemainder = dividend%divisor;
            doorPassword += compRemainder;
        }

        outputSlowly ("You type in the password you got from the generator: " + userPassword, 25);
        sopl("");
        
        //if the user's password does not equal the correct answer, the user gets to try again until they succeed
        while (!userPassword.equals(doorPassword))
        {
            //reset the variables each time
            userPassword = "";
            doorPassword = "";

            sopl ("");
            sopl ("Wrong… You have to try again.");
 
            for (int i=0; i <4; i++)
            {
                int dividend = (int)(Math.random() * 9+1);
                int divisor = (int)(Math.random() * 9+1);
                sopl ("What is the remainder of " + dividend + "/" + divisor + "?");
                userRemainder = scan.nextInt(); 
                userPassword += userRemainder;

                compRemainder = dividend%divisor;
                doorPassword += compRemainder;
            }
            outputSlowly ("You type in the password you got from the generator: " + userPassword, 20);
            outputSlowly ("                                       ", 30);

        }
        //once userPassword equals door password the while loop will stop and enter this if statement (made an if statement just for technicallities, it doesn't have to be there)
        if (userPassword.equals(doorPassword))
        {
            outputSlowly ("The door clicks open. Yes! You got in!", 20);
            outputSlowly ("                                       ", 30);

        }

        scan.nextLine();
        //Shows user how much time has passed
        if (!checkTime(startTime)){
            return;
        }
        
        //make sure the user is ready
        sopl ("[Directive - Press enter to head inside]");
        user = scan.nextLine();
        
        sopl ("\f");
        
        //more story line/description of what's going on: they find their laptop and try to crack the password
        outputSlowly ("You see their laptop sitting on their desk and go to it immediately. You open it and realize it needs a password.", 20); 
        //"favour"
        outputSlowly ("You try your birthday: " + birthday + " because of course your best friend would have their best friend’s birthday as ", 20); 
        outputSlowly ("their password right?", 20);
        sopl ("");
        
        sopl ("[Directive -- type in your birthday: ]");
        scan.nextLine();
        sopl("\f");

        sopl ("The computer displays [Password Incorrect]");
        outputSlowly ("                  ", 40);
        outputSlowly ("You feel kind of hurt that it’s not your birthday but you can’t blame them… At the bottom you see a hint for the ", 20);
        outputSlowly ("password: ‘in the box’. Box? You look around for a box and you see a brown box glued to the counter. It has to be your ", 20);
        outputSlowly ("birthday this time right? You roll the numbers to your birthday.", 20);
        sopl ("");
        sopl ("[Directive -- type in your birthday: ]");
        user = scan.nextLine();

        outputSlowly ("                                       ", 20);
        sopl ("\f");     
        
        //opens box
        outputSlowly ("Yes! The box opens. You look inside of it, at the bottom there’s a screen that says ‘password to computer’ and a button that ", 20);
        outputSlowly ("says start (one attempt left). The answer to the questions put together is be the password to the computer! You only have one ", 20);
        outputSlowly ("chance to get all of these questions right and you must remember them after you finish the questions as the screen clears after ", 20);
        outputSlowly ("each question. You grab the nearest paper and pen to write down the answers and click start.", 20);
        //the user has to play the number game to find the password and they need to  write down or remember the answer to each question and 
        //then put it all together for the password, makes it more interactive and fun
        sopl ("");
        sopl ("Press enter to start.");
        user = scan.nextLine();

        sopl ("\f");

        for (int i = 0; i<5; i++)
        {
            //generates a number 0-2 and associates an operator with it (+, -, *)
            randOp = (int)(Math.random()* 3);
            //generates random numbers from 0 to 12
            num1 = (int)(Math.random() * 13); 
            num2 = (int)(Math.random() * 13); 

            if (randOp == 0){// addition
                solution = num1 + num2;
                operator = " + ";
            }
            else if (randOp == 1){ // subtraction
                solution = num1 - num2;
                operator = " - ";
            } 
            else { // multiplication
                solution = num1 * num2;
                operator = " x ";
            }
            //Tells user the question
            sopl ("What is " + num1 + operator + num2 + "? (Press enter for the next question)");
            user = scan.nextLine();
            //clears the screen after each question so the user has to write down or remember the answer themselves which makes it harder
            sopl ("\f");
            //calculates the correct answer to verify if the user's answer is correct
            correctLaptopPassword += solution;

        }
        //Finish problem and type in the computer password
        outputSlowly ("Finally, you finished all the problems. You go back to the computer to type in the password.", 20);
        sopl("");
        sopl ("Directive - Please type in the password for the computer (E.g. -2948-932).");
        //the user types in their answer

        user = scan.nextLine();

        sopl ("\f");
        
        //checks if the user typed in the correct password
        if (user.equals(correctLaptopPassword))
        {
            outputSlowly ("The computer unlockes! Yes! One step closer to finding the murderer.", 20);
            //checks if the user exceeded the 7 minute time limit
            //if they did, a story line is played and they lose the game
            if (!checkTime(startTime))
            {
            //ends the game
            return;
            //after there is option to play again
            }
            
            outputSlowly ("You look through their messages and see that the last message was a video sent from their phone to themself on" + currentDate, 20);
            outputSlowly ("You click on the video…", 20);
            //interactive
            sopl ("[Directive: Press enter to click on the video]");
            user = scan.nextLine();
            sopl ("\f");

            outputSlowly("It's a video of them and their sister, Tanya, in the woods hiking at the place they was murdered. Their sister’s alibi says she was ", 20);
            outputSlowly("at her friend's house during this time... so she's lying... No way. Could Tanya be the murderer?", 20);
            //makes sure the user finishes reading before going onto the next part
            sopl ("[Directive: Press enter]");
            user = scan.nextLine();
            sopl ("\f");
            
            //heads to the police station to hand in the evidence
            outputSlowly ("You pack up the computer and quickly head out the door before she comes back. You clutch your backpack in one hand and your other ", 20);
            outputSlowly ("is wiping the tears off your face. You run to the police station and hand in this new evidence safely. You head in a taxi ", 20);
            outputSlowly ("to get home on this restless night still thinking about if they would catch Tanya.", 20);
            sopl("");
            outputSlowly ("                 ", 50);
            user = scan.nextLine();
            sopl ("\f");
            
            //good ending -- finds the murderer
            outputSlowly ("--- Ringringring ---",30);
            outputSlowly ("Few hours later, you get a phone call. The police says they have successfully captured Tanya and she was comfirmed the ", 20);
            outputSlowly ("murderer. Your evidence provided a lot of help. You feel relieved that your best friend's murderer is now in jail and", 20);
            outputSlowly ("that you were helpful in cracking the case.", 20);
            outputSlowly ("CONGRATULATIONS-- MURDERER WAS FOUND - GAME SUCCESS: PLAYER WINS", 20);
            //ends the game
            return;
            //after,, there is option to play again
        }
        else
        {
            //if this code is run, the user has typed in the wrong password for the computer
            outputSlowly ("[Password Incorrect] You run back to the box to try the question again... but see the screen is black.", 20);
            //the user has already lost the game at this point, but if they spent 7 minutes or more up to this point, the game will execute the lose of the game due to time limit instead of the peaceful lose ending
            if (!checkTime(startTime))
            {
            return;
            }
            //peaceful lose ending
            outputSlowly ("You can't unlock their computer anymore. You search the house for any other clues but find nothing. You walk out of their ", 20);
            outputSlowly ("apartment and back to your house... not being able to find the murderer for your best friend.", 20);
            sopl ("[LOSE GAME] You weren't able to find out who the murderer was. ");
        }

    }

    //The losing ending the user will get if they don't finish within 7 minutes
    public static void losingEnding()
    {
        outputSlowly ("Just then sounds of key rustling appear outside the front door. The murderer is back!! ", 20);
        outputSlowly ("You take the laptop and climb into the nearest closet. Through a crack you see their sister walk into the room… She sits down ", 20);
        outputSlowly ("at the table in front of where the computer was… you glup. She looks around anxiously and then like nothing happened she walks ", 20);
        outputSlowly ("out of your sight.", 20);
        sopl ("");
        outputSlowly ("After what felt like eternity a weird choking smell begins appearing, the sound of the front door slam rings in your ears and ", 20);
        outputSlowly ("footsteps fade away from outside. You open the closet to see that she has lit the entire apartment on fire. ", 20);
        sopl ("");
        outputSlowly ("---There’s no way out. ---", 25);
        sopl ("");
        outputSlowly ("You clutch onto the laptop in your hands and collapse to the floor. A rolling drop of tear begins to fall from the corner of ", 20);
        outputSlowly ("your eyes. You look up, beyond the ceiling, as if you already see them…", 25);
        sopl ("");
        sopl ("You died and failed to find the murderer. [LOSE GAME]");

    }
    
    //method that will check how much time has passed
    public static boolean checkTime(long startTime)
    {
        //time that has passed in nano seconds
        long elapsed;
        //time that has passed in minutes
        double minutesElapsed;
        
        elapsed = System.nanoTime() - startTime;
        minutesElapsed = (elapsed / 1000000000.0)/60 ;
        //let the user know how much time has passed
        sopl ("You check your phone for your time. " + minutesElapsed + " minutes has past."); 
        //if the player takes more than 7 minutes to complete the game, they lose (the murderer comes back)
        if (minutesElapsed > 7)
        {
            losingEnding();
            return false;
        }
        return true;
    }
    
    //lets the play again method keep on running
    public static void main (String[] args)
    {
        do {
            game();
        }while (playAgain());
    }
    
    //shortcut method for system.out.println
    private static void sopl(String s){
        System.out.println(s);
    }
    //play again method
    private static boolean playAgain (){
        sopl ("");
        System.out.println("Would you like to play again? (y/n)");
        String answer;
        answer = scan.nextLine();
        sopl ("");
        char result = answer.toUpperCase().charAt(0);

        return (result == 'Y'); // did the user type a y or Y in the first letter? If so, this
        // will return true, otherwise it will return false.
    }

    //let's strings be outputed letter by letter in a set speed 
    public static void outputSlowly (String output, int delay){
        for (int i = 0; i < output.length(); i++){
            System.out.print(output.charAt(i));
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {}
        }
        sopl("");
    }
}
