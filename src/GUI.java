import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class GUI extends JFrame implements ActionListener{
    static Game game = new Game();
    //panel1
    JPanel panel1 = new JPanel();
    JPanel topCardPanel = new JPanel();
    JLabel topCard = new JLabel("Top Card of the Deck");
    JButton playedCard = new JButton();
    JPanel cardDetailsPanel = new JPanel();
    JLabel cardName = new JLabel("Card Name,");
    JLabel currentCategory = new JLabel("Category,");
    JLabel currentValue = new JLabel("Value");
    JPanel playerPanel = new JPanel();
    JLabel playersTurn = new JLabel("Players Turn:");
    JLabel nameLabel = new JLabel("Players Name");

    //panel2
    JPanel panel2 = new JPanel();
    JButton play = new JButton("Play");
    JButton rules = new JButton("Rules");
    JButton quit = new JButton("Quit");

    //panel3
    JPanel panel3 = new JPanel();
    JLabel statusLabel = new JLabel("Status/Errors");




    GUI(){
        super();
        panel1.setLayout(new GridLayout());
        topCardPanel.add(topCard);
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
        cardDetailsPanel.add(cardName);
        cardDetailsPanel.add(currentCategory);
        cardDetailsPanel.add(currentValue);
        panel1.add(cardDetailsPanel);
        playerPanel.add(playersTurn);
        playerPanel.add(nameLabel);
        panel1.add(playerPanel);


        panel2.setLayout(new GridLayout(2,8));
        panel2.add(play);
        panel2.add(rules);
        panel2.add(quit);

        panel3.add(statusLabel);


        super.add(panel1, BorderLayout.NORTH);
        super.add(panel2);
        super.add(panel3, BorderLayout.SOUTH);
        rules.addActionListener(this);
    }

    public static void main(String[] args) {


        game.createCards();

        GUI frame = new GUI();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(1350, 650);

        //Adds Card Temporarily
//        JButton card;
//        card = addCards();
//        panel2.add(card);

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

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if (source == rules){
            System.out.println(game.getRules());

        }
    }
}
