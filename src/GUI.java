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
        FlowLayout flow = new FlowLayout();
        BorderLayout borderLayout = new BorderLayout();
        frame.setLayout(flow);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(1350, 650);


        //panel1
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout());

        JPanel topCardPanel = new JPanel();
        JLabel topCard = new JLabel("Top Card of the Deck");
        topCardPanel.add(topCard);
        JButton playedCard = new JButton();
        try {
            BufferedImage image = ImageIO.read(new File("images/Slide01.jpg"));
            Image image1 = image.getScaledInstance(111, 156, Image.SCALE_SMOOTH);
            Icon icon = new ImageIcon(image1);
            playedCard = new JButton(icon);

        } catch (IOException e) {
            System.out.println("File not Found");
        }
        topCardPanel.add(playedCard);
        panel1.add(topCardPanel);

        JPanel cardDetailsPanel = new JPanel();
        JLabel cardName = new JLabel("Quartz,");
        cardDetailsPanel.add(cardName);

        JLabel currentCategory = new JLabel("Specific Gravity,");
        cardDetailsPanel.add(currentCategory);

        JLabel currentValue = new JLabel("6.5");
        cardDetailsPanel.add(currentValue);

        panel1.add(cardDetailsPanel);


        JPanel playerPanel = new JPanel();
        JLabel playersTurn = new JLabel("Players Turn:");
        playerPanel.add(playersTurn);
        JLabel nameLabel = new JLabel("Toleira");
        playerPanel.add(nameLabel);
        panel1.add(playerPanel);

        //panel2
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(2, 8));

        //panel3
        JPanel panel3 = new JPanel();
        panel3.setLayout(borderLayout);
        JLabel statusLabel = new JLabel("Status/Errors");
        panel3.add(statusLabel, BorderLayout.SOUTH);


        //Adds Card Temporarily
        JButton card;
        card = addCards();
        panel2.add(card);
        JButton card2;
        card2 = addCards();
        panel2.add(card2);
        JButton card3;
        card3 = addCards();
        panel2.add(card3);
        JButton card4;
        card4 = addCards();
        panel2.add(card4);
        JButton card5;
        card5 = addCards();
        panel2.add(card5);
        JButton card6;
        card6 = addCards();
        panel2.add(card6);
        JButton card7;
        card7 = addCards();
        panel2.add(card7);
        JButton card8;
        card8 = addCards();
        panel2.add(card8);
        JButton card9;
        card9 = addCards();
        panel2.add(card9);

        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);

        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static JButton addCards() {
        try {
            BufferedImage image = ImageIO.read(new File("images/Slide01.jpg"));
            Image image1 = image.getScaledInstance(122, 171, Image.SCALE_SMOOTH);
            Icon icon = new ImageIcon(image1);
            JButton card = new JButton(icon);
            return card;
        } catch (IOException e) {
            System.out.println("File not Found");
        }
        return null;
    }
}
