import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class GUI extends JFrame implements ActionListener {
    static Game game = new Game();
    //panel1
    JPanel panel1 = new JPanel();
    JPanel topCardPanel = new JPanel();
    JLabel topCard = new JLabel("Top Card of the Deck");
    JButton playedCard = new JButton();
    JPanel cardDetailsPanel = new JPanel();
    JLabel cardDetailsLabel = new JLabel("Card Name, Category, Value");
    JPanel playerPanel = new JPanel();
    JLabel playersTurn = new JLabel("Players Turn:");
    JLabel nameLabel = new JLabel("Players Name");

    //panel2
    JPanel panel2 = new JPanel();
    JButton play = new JButton("Play");
    JButton rules = new JButton("Rules");
    JButton quit = new JButton("Quit");
    JButton threePlayers = new JButton("Three Players");
    JButton fourPlayers = new JButton("Four Players");
    JButton fivePlayers = new JButton("Five Players");
    JTextField playersName1 = new JTextField("Player 1");
    JTextField playersName2 = new JTextField("Player 2");
    JTextField playersName3 = new JTextField("Player 3");
    JTextField playersName4 = new JTextField("Player 4");
    JTextField playersName5 = new JTextField("Player 5");
    JButton returnButton = new JButton("Return");
    JButton confirmPlayersNames = new JButton("Confirm Names");
    JButton ruleCardButton;
    JButton playerCardButton = new JButton("Player Card");
    JButton beginButton = new JButton("Begin");
    JButton passButton = new JButton("Pass");
    JButton hardness = new JButton("Hardness");
    JButton specificGravity = new JButton("Specific Gravity");
    JButton cleavage = new JButton("Cleavage");
    JButton crustalAbundance = new JButton("Crustal Abundance");
    JButton economicValue = new JButton("Economic Value");
    JButton nextPlayerButton = new JButton("Next Player");
    int numberPlayers = 0;

    //panel3
    JPanel panel3 = new JPanel();
    JLabel statusLabel = new JLabel("Status/Errors");

    GUI() {
        super();
        panel1.setLayout(new GridLayout());
        topCardPanel.add(topCard);
        try {
            BufferedImage image = ImageIO.read(new File("images/Slide65.jpg"));
            Image image1 = image.getScaledInstance(111, 156, Image.SCALE_SMOOTH);
            Icon icon = new ImageIcon(image1);
            playedCard = new JButton(icon);

        } catch (IOException e) {
            System.out.println("File not Found");
        }
        topCardPanel.add(playedCard);
        panel1.add(topCardPanel);
        cardDetailsPanel.add(cardDetailsLabel);
        panel1.add(cardDetailsPanel);
        playerPanel.add(playersTurn);
        playerPanel.add(nameLabel);
        panel1.add(playerPanel);


        panel2.setLayout(new GridLayout(2, 8));
        panel2.add(play);
        panel2.add(rules);
        panel2.add(quit);

        panel3.add(statusLabel);

        super.add(panel1, BorderLayout.NORTH);
        super.add(panel2);
        super.add(panel3, BorderLayout.SOUTH);

        quit.addActionListener(this);
        rules.addActionListener(this);
        play.addActionListener(this);
        threePlayers.addActionListener(this);
        fourPlayers.addActionListener(this);
        fivePlayers.addActionListener(this);
        confirmPlayersNames.addActionListener(this);
        beginButton.addActionListener(this);
        passButton.addActionListener(this);
        hardness.addActionListener(this);
        specificGravity.addActionListener(this);
        crustalAbundance.addActionListener(this);
        cleavage.addActionListener(this);
        economicValue.addActionListener(this);
        nextPlayerButton.addActionListener(this);
    }

    public static void main(String[] args) {
        game.createCards();
        GUI frame = new GUI();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(1350, 650);

        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static JButton createCardButton(String filePath, int width, int height) {
        try {
            BufferedImage image = ImageIO.read(new File(filePath));
            Image image1 = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
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


        if (source == rules) {
            panel2.removeAll();
            for (Card ruleCard : game.ruleDeck.deck) {
                ruleCardButton = createCardButton("images/" + ruleCard.getFileName(), 330, 465);
                panel2.add(ruleCardButton);

            }

            panel2.add(returnButton);
            returnButton.addActionListener(this);
            panel2.setLayout(new GridLayout(1, 4));
            statusLabel.setText("Please press the return button to return to the main menu");
            validate();
            repaint();
        } else if (source == returnButton) {
            panel2.removeAll();
            panel2.add(play);
            panel2.add(rules);
            panel2.add(quit);
            panel2.setLayout(new GridLayout(2, 8));
            statusLabel.setText("Please make a selection");
            validate();
            repaint();
        } else if (source == quit) {
            System.exit(0);
        } else if (source == confirmPlayersNames) {
            if (numberPlayers == 3) {
                game.createPlayers(playersName1.getText());
                game.createPlayers(playersName2.getText());
                game.createPlayers(playersName3.getText());
            } else if (numberPlayers == 4) {
                game.createPlayers(playersName1.getText());
                game.createPlayers(playersName2.getText());
                game.createPlayers(playersName3.getText());
                game.createPlayers(playersName4.getText());
            } else if (numberPlayers == 5) {
                game.createPlayers(playersName1.getText());
                game.createPlayers(playersName2.getText());
                game.createPlayers(playersName3.getText());
                game.createPlayers(playersName4.getText());
                game.createPlayers(playersName5.getText());
            }
            game.shuffleDeck();
            game.dealCards();
            panel2.removeAll();
            panel2.add(beginButton);
            statusLabel.setText("All Cards have been shuffled and dealt. Please press button to begin");
            validate();
            repaint();

        } else if (source == threePlayers) {
            numberPlayers = 3;
            panel2.removeAll();
            panel2.add(playersName1);
            panel2.add(playersName2);
            panel2.add(playersName3);
            panel2.add(confirmPlayersNames);
            statusLabel.setText("Please enter the names of the players and press confirm");
            validate();
            repaint();
        } else if (source == fourPlayers) {
            numberPlayers = 4;
            panel2.removeAll();
            panel2.add(playersName1);
            panel2.add(playersName2);
            panel2.add(playersName3);
            panel2.add(playersName4);
            panel2.add(confirmPlayersNames);
            statusLabel.setText("Please enter the names of the players and press confirm");
            validate();
            repaint();
        } else if (source == fivePlayers) {
            numberPlayers = 5;
            panel2.removeAll();
            panel2.add(playersName1);
            panel2.add(playersName2);
            panel2.add(playersName3);
            panel2.add(playersName4);
            panel2.add(playersName5);
            panel2.add(confirmPlayersNames);
            statusLabel.setText("Please enter the names of the players and press confirm");
            validate();
            repaint();
        } else if (source == play) {
            panel2.removeAll();
            panel2.add(threePlayers);
            panel2.add(fourPlayers);
            panel2.add(fivePlayers);
            statusLabel.setText("Please select the number of players");
            validate();
            repaint();

        } else if (source == beginButton) {
            panel2.removeAll();
            game.validPlayer();
            if (game.players.get(game.playersTurn).getPassed()) {

                statusLabel.setText("You've passed. Please press next player");
                game.nextPlayer();
                panel2.removeAll();
                beginButton.setText("Next Player");
                panel2.add(beginButton);
                validate();
                repaint();


            } else if (!game.players.get(game.playersTurn).getPassed()) {
                nameLabel.setText(game.players.get(game.playersTurn).getName());
                for (Card playersCard : game.players.get(game.playersTurn).getPlayersHand()) {
                    playerCardButton = createCardButton("images/" + playersCard.getFileName(), 134, 189);
                    panel2.add(playerCardButton);
                    playerCardButton.setName(playersCard.getTitle());
                    playerCardButton.setActionCommand("cardSelected");
                    playerCardButton.addActionListener(this);

                }
                panel2.add(passButton);
                if (!game.categoryIsSelected) {
                    statusLabel.setText("Please select any card, you will then also need to select a category");
                } else {
                    statusLabel.setText("Please select a card to play");
                }

                validate();
                repaint();

            }


        } else if (source == passButton) {
            statusLabel.setText("You chose to pass and drew a card");
            game.drawCard();
            if (game.playersPassed()) {
                game.categoryIsSelected = false;
            }
            game.nextPlayer();
            panel2.removeAll();
            beginButton.setText("Next Player");
            panel2.add(beginButton);
            statusLabel.setText("Press 'Next Player' to begin the next players turn");
            validate();
            repaint();
        } else if (event.getActionCommand().equals("cardSelected")) {
            for (int i = 0; i < game.players.get(game.playersTurn).getPlayersHand().size(); ++i) {
                System.out.println(((JComponent) event.getSource()).getName());
                if (game.players.get(game.playersTurn).getPlayersHand().get(i).getTitle().equals(((JComponent) event.getSource()).getName())) {
                    Card selectedCard = game.players.get(game.playersTurn).getPlayersHand().get(i);
                    boolean validCard = game.checkCard(selectedCard);
                    System.out.println(validCard);
                    if (selectedCard.getCardType().equals("trump")) {
                        if (selectedCard.getTitle().equals("The Geologist")){
                            game.categoryIsSelected = false;
                        } else {
                            game.cardCategory = selectedCard.getSubtitle().toLowerCase();
                            statusLabel.setText("Category selected was " + game.cardCategory + ".");
                            game.categoryIsSelected = true;
                            game.newCategorySelected = true;
                            game.resetPlayersPassed();
                        }
                    }
                    if (!game.categoryIsSelected) {
                        panel2.removeAll();
                        panel2.add(hardness);
                        panel2.add(specificGravity);
                        panel2.add(cleavage);
                        panel2.add(crustalAbundance);
                        panel2.add(economicValue);
                        statusLabel.setText("Please select a category");
                        validate();
                        repaint();


                        game.playCard(selectedCard, i);
                        game.categoryIsSelected = true;
                        game.newCategorySelected = true;
                        game.resetPlayersPassed();
                    }
                    else if (game.categoryIsSelected && validCard){
                        game.playCard(selectedCard, i);
                        cardDetailsLabel.setText(game.playerSelection().toString());
                        game.nextPlayer();
                        panel2.removeAll();
                        beginButton.setText("Next Player");
                        panel2.add(beginButton);
                        statusLabel.setText("Press 'Next Player' to begin the next players turn");
                        validate();
                        repaint();
                    }
                    if (!validCard) {
                        statusLabel.setText("You can't play that card, please select another");
                        repaint();
                    } else {
                        topCardPanel.remove(playedCard);
                        playedCard = createCardButton("images/" + selectedCard.getFileName(), 111, 156);
                        topCardPanel.add(playedCard);
                        statusLabel.setText("Card played!");
                        validate();
                        repaint();
                        game.newCategorySelected = false;

                    }
                    game.newCategorySelected = false;
                    if (game.players.get(game.playersTurn).getHandSize() == 0) {
                        game.winningPlayer();

                    }
                }
            }

        } else if (source == hardness) {
            game.cardCategory = "hardness";
            cardDetailsLabel.setText(game.playerSelection().toString());
            game.nextPlayer();
            panel2.removeAll();
            beginButton.setText("Next Player");
            panel2.add(beginButton);
            statusLabel.setText("Press 'Next Player' to begin the next players turn");
            validate();
            repaint();
        } else if (source == specificGravity) {
            game.cardCategory = "specific gravity";
            cardDetailsLabel.setText(game.playerSelection().toString());
            game.nextPlayer();
            panel2.removeAll();
            beginButton.setText("Next Player");
            panel2.add(beginButton);
            statusLabel.setText("Press 'Next Player' to begin the next players turn");
            validate();
            repaint();
        } else if (source == crustalAbundance) {
            game.cardCategory = "crustal abundance";
            cardDetailsLabel.setText(game.playerSelection().toString());
            game.nextPlayer();
            panel2.removeAll();
            beginButton.setText("Next Player");
            panel2.add(beginButton);
            statusLabel.setText("Press 'Next Player' to begin the next players turn");
            validate();
            repaint();
        } else if (source == cleavage) {
            game.cardCategory = "cleavage";
            cardDetailsLabel.setText(game.playerSelection().toString());
            game.nextPlayer();
            panel2.removeAll();
            beginButton.setText("Next Player");
            panel2.add(beginButton);
            statusLabel.setText("Press 'Next Player' to begin the next players turn");
            validate();
            repaint();
        } else if (source == economicValue) {
            game.cardCategory = "economic value";
            cardDetailsLabel.setText(game.playerSelection().toString());
            game.nextPlayer();
            panel2.removeAll();
            beginButton.setText("Next Player");
            panel2.add(beginButton);
            statusLabel.setText("Press 'Next Player' to begin the next players turn");
            validate();
            repaint();
        }
    }
}
