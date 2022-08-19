import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.text.DecimalFormat;

public class AdventureDB {
    public static void main (String[] args) {
        Adventure adventure = new Adventure();
        DecimalFormat df = new DecimalFormat("0.000");

        ImageIcon maze = new ImageIcon("Maze.jpg");
        ImageIcon threeDoors = new ImageIcon("3Doors.png");
        ImageIcon reCaptcha = new ImageIcon("ReCaptcha.png");
        ImageIcon check = new ImageIcon("Checkmark.png");
        ImageIcon x = new ImageIcon("Xmark.png");
        ImageIcon fall = new ImageIcon("Falling.png");
        ImageIcon skull = new ImageIcon("Skull.png");
        ImageIcon cardinalDirections = new ImageIcon("CardinalDirections.png");
        ImageIcon deadEnd = new ImageIcon("DeadEnd.jpg");
        ImageIcon fire = new ImageIcon("Fire.png");
        ImageIcon fireMonster = new ImageIcon("FireMonster.jpg");
        ImageIcon noU = new ImageIcon("NoU.png");
        ImageIcon pen = new ImageIcon("Pen.jpg");
        ImageIcon rejected = new ImageIcon("Rejected.jpg");
        ImageIcon trophy = new ImageIcon("Trophy.png");

        String input, rand;
        boolean isRightNum = false;

        adventure.PlayMusic();
        
        JOptionPane.showMessageDialog(null,
            "Maze",
            "Maze",
            1,
            maze);

        while (!isRightNum) {
            rand = df.format(adventure.getRandom());
            input = (String) JOptionPane.showInputDialog(null,
                "To gain access to the maze, you must enter this number:\n"
                + rand,
                "Maze",
                3,
                reCaptcha,
                null,
                null);

            if (input.equals(rand)) {
                isRightNum = true;
                JOptionPane.showMessageDialog(null,
                    "You may pass!",
                    "Maze",
                    1,
                    check);
            } else {
                isRightNum = false;
                JOptionPane.showMessageDialog(null,
                    "Incorrect. Please try again.",
                    "Maze",
                    2,
                    x);
            } 
        }

        input = (String) JOptionPane.showInputDialog(null,
            adventure.getIntro()
            + "\n1) " + adventure.getCase1Path1()
            + "\n2) " + adventure.getCase1Path2()
            + "\n3) " + adventure.getCase1Path3(),
            "Maze",
            3,
            threeDoors,
            null,
            null);

        adventure.setChoice(input);

        if (adventure.getChoice().equals("1")) {
            JOptionPane.showMessageDialog(null,
                adventure.correctRiddle1(),
                "Maze",
                1,
                fall);
        } else if (adventure.getChoice().equals("2")) {
            JOptionPane.showMessageDialog(null,
                adventure.correctRiddle1(),
                "Maze",
                1,
                skull);
        } else if (adventure.getChoice().equals("3")) {
            input = (String) JOptionPane.showInputDialog(null,
                adventure.correctRiddle1() + "\n"
                + "\n1) " + adventure.getCase2Path1()
                + "\n2) " + adventure.getCase2Path2()
                + "\n3) " + adventure.getCase2Path3(),
                "Maze",
                3,
                cardinalDirections,
                null,
                null);
        } else {
            JOptionPane.showMessageDialog(null,
                adventure.correctRiddle1(),
                "Maze",
                0,
                x);
        }

        if (adventure.correct()) {
            adventure.setChoice(input);

            if (adventure.getChoice().equals("1")) {
                JOptionPane.showMessageDialog(null,
                    adventure.correctRiddle2(),
                    "Maze",
                    1,
                    deadEnd);
            } else if (adventure.getChoice().equals("2")) {
                input = (String)JOptionPane.showInputDialog(null,
                    adventure.correctRiddle2() + "\n"
                    + "\n1) " + adventure.getCase3Path1()
                    + "\n2) " + adventure.getCase3Path2()
                    + "\n3) " + adventure.getCase3Path3(),
                    "Maze",
                    3,
                    fireMonster,
                    null,
                    null);
            } else if (adventure.getChoice().equals("3")) {
                JOptionPane.showMessageDialog(null,
                    adventure.correctRiddle2(),
                    "Maze",
                    1,
                    fire);
            } else {
                JOptionPane.showMessageDialog(null,
                    adventure.correctRiddle2(),
                    "Maze",
                    0,
                    x);
            }

            if (adventure.correct()) {
                adventure.setChoice(input);

                switch (adventure.getChoice()) {
                    case "1":
                        JOptionPane.showMessageDialog(null,
                            adventure.correctRiddle3(),
                            "Maze",
                            1,
                            pen);
                        break;
                    case "2":
                        JOptionPane.showMessageDialog(null,
                            adventure.correctRiddle3(),
                            "Maze",
                            1,
                            rejected);
                        break;
                    case "3":
                        JOptionPane.showMessageDialog(null,
                            adventure.correctRiddle3(),
                            "Maze",
                            1,
                            noU);
                        JOptionPane.showMessageDialog(null,
                            adventure.win(),
                            "Maze",
                            1,
                            trophy);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,
                            adventure.correctRiddle2(),
                            "Maze",
                            0,
                            x);
                        break;
                }
            }
        }
    }
}