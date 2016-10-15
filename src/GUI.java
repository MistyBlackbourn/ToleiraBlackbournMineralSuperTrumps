import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class GUI {
    static Game game = new Game();
    public static void main(String[] args) {
        game.createCards();

        JFrame frame = new JFrame();
        JPanel panel1 = new JPanel();

        try {
            BufferedImage image = ImageIO.read(new File("images/Slide01.jpg"));
            Image image1 = image.getScaledInstance(149, 209, Image.SCALE_SMOOTH);
            Icon icon = new ImageIcon(image1);
            JButton rule_card = new JButton(icon);
            panel1.add(rule_card);
        } catch (IOException e){
            System.out.println("File not Found");
        }

        frame.add(panel1);

        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
