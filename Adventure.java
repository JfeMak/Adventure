import java.util.Random;
import javax.swing.JOptionPane;
import java.io.*;
import javax.sound.sampled.*;

public class Adventure {
    Random random = new Random();
    private String answer;
    private double rndm;
    private boolean isCorrect;

    public static void PlaySound (File Sound) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Sound));
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void PlayMusic () {
        File music = new File ("Suspense.wav");
        PlaySound(music);
    }

    public double getRandom() {
        rndm = random.nextDouble();
        return rndm;
    }

    public void setChoice(String c) {
        answer = c;
    }

    public String getChoice() {
        return answer;
    }

    public String getIntro() {
        return "Welcome to the maze!\nIf you finish it, you will get a glorious prize!"
        + "\nBut, do not get too confident, for it can end badly for \nyou along the way..."
        + "\n\nHere are 3 entrances to the maze\nChoose Wisely...\n";
    }

    public String getCase1Path1() {
        return "A stone door. You can't hear\n   anything behind it.";
    }

    public String getCase1Path2() {
        return "An iron door. You can see red\n   eyes staring right into you\n   through the slits of the door.";
    }

    public String getCase1Path3() {
        return "A wooden door. The door is\n   burning and you can see smoke\n   coming from the slits.";
    }

    public String getCase2Path1() {
        return "North\n   Nothing burning around that\n   entrance, you can't see where it\n   leads off to.";
    }

    public String getCase2Path2() {
        return "East\n   Seems pretty dangerous. Fires\n   are surrounding the entrance and"
        + "\n   you can hear roars in the\n   distance";
    }

    public String getCase2Path3() {
        return "West\n   Looks to be the most dangerous\n   direction. Fires and lava are"
        + "\n   everywhere. You see light at the\n   end of the path.";
    }

    public String getCase3Path1() {
        return "A pen! For the pen is mightier\n   than the sword!";
    }

    public String getCase3Path2() {
        return "Make it your friend! The best way\n   to defeat an enemy is to make it\n   your friend!";
    }

    public String getCase3Path3() {
        return "The almighty UNO reverse card!";
    }

    public boolean correct() {
        return isCorrect;
    }

    public String correctRiddle1() {
        if (answer.equals("1")) {
            isCorrect = false;
            return "It's pitch black inside. You take a\nstep, and you suddenly feel like"
            + "\nyou're falling. And then you\nrealize what's happening...\n:|";
        } else if (answer.equals("2")) {
            isCorrect = false;
            return "You knew what was going to\nhappen. Did you actually think\nthat this entrance was safe and"
            + "\nthe eyes were just a little trick?\n>:)";
        } else if (answer.equals("3")) {
            isCorrect = true;
            return "Entrance is safe for now, but not\n for long! Everything around you\n is burning. :O"
            + "\nQuick! Choose which way you\n want to escape!";
        } else {
            isCorrect = false;
            return "Invalid Input.";
        }
    }

    public String correctRiddle2() {
        if (answer.equals("1")) {
            isCorrect = false;
            return "You walk for a few minutes, and\nwhen you turn the corner, you"
            + "\nrealize it's a dead end. You are\nstuck and the fires have now\nsurrounded you.";
        } else if (answer.equals("2")) {
            isCorrect = true;
            return "You arrive in an arena. In front of\n you is a creature who has the"
            + "\npower to incinerate you. Pick\n something to help you in this\n duel! Choose wisely.";
        } else if (answer.equals("3")) {
            isCorrect = false;
            return "You made an attempt to walk in\nflames. You lasted 13 seconds.";
        } else {
            isCorrect = false;
            return "Invalid Input.";
        }
    }

    public String correctRiddle3() {
        if (answer.equals("1")) {
            isCorrect = false;
            return "Not in this situation.";
        } else if (answer.equals("2")) {
            isCorrect = false;
            return "You were rejected.";
        } else if (answer.equals("3")) {
            isCorrect = true;
            return "The \"No U\" that the card\n summoned was too much for the"
            + "\ncreature to handle. You defeated\n it.";
        } else {
            isCorrect = false;
            return "Invalid Input.";
        }
    }

    public String win() {
        return "Congrats! You won the feeling of\n something other than emptiness"
        + "\ninside! Great job! :)";
    }
}