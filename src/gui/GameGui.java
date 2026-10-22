package gui;

import cards.DefaultCards;
import cards.DefaultCardsEnum;
import gamelogic.Dealer;
import gamelogic.GameLogic;
import gamelogic.Player;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.*;
import java.awt.*;
import main.Main;

public class GameGui implements Igui{
    JFrame frame;
    PlayerPanel playerSide;
    PlayerPanel dealerSide;
    Container container;
    private final DefaultCards cards = new DefaultCards();
    private final Stack<JLabel> playerCardLabels = new Stack<>();
    private final Stack<JLabel> dealerCardLabels = new Stack<>();
    HitButton hitButton = new HitButton();
    JButton standButton = new JButton("stand");
    JButton restartButton = new JButton("restart");
    private JLabel _t = new JLabel("");
    private Player player = new Player("Player", cards);
    private Dealer dealer = new Dealer("Dealer", cards);
    private boolean gameEnd = false;
    public GameGui(JFrame frame){
        this.frame = frame;
        container = frame.getContentPane();
        playerSide = new PlayerPanel();
        playerSide.setBounds(1, frame.getHeight() / 2, frame.getWidth(), frame.getHeight() / 2);
        playerSide.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        dealerSide = new PlayerPanel();
        dealerSide.setBounds(1, 1, frame.getWidth(), frame.getHeight() / 2);
        dealerSide.setBorder(BorderFactory.createLineBorder(Color.RED));
        container.add(playerSide);
        container.add(dealerSide);
        renderDealerHands();
        System.out.println("initiated gamegui");
        System.out.println("player hand: " + player.cards.size());
        System.out.println("cards panel: " + playerSide.getCardsPanel().getBounds());//i know the actionlisteners could go i na different class and itd also make alot more sense cuz it has nothing to do with the gui but like i was in too deep in the rabbit hole
        restartButton.addActionListener(e -> {
            resetContainer();
            cards.shuffle();
            player = new Player("Player", cards);
            dealer = new Dealer("Dealer", cards);
            renderDealerHands();

        });
        standButton.addActionListener(e -> {
            if(gameEnd == false){
                dealer.dealTill17(cards);
                renderHands();
                if(GameLogic.checkBust(player, dealer) != null){

                        Main.getThreadInstance().scheduleSwingTasks(() ->{
                            winnerText("Player won!");
                        });


                }
                else if(GameLogic.checkBust(player, dealer) == null){
                    if(GameLogic.checkWon(player, dealer) == null){
                        Main.getThreadInstance().scheduleSwingTasks(() -> {
                            System.out.println("got here");
                            winnerText("tie");
                        });
                    }
                    else{
                        Main.getThreadInstance().scheduleSwingTasks(() ->{
                            winnerText(GameLogic.checkWon(player, dealer).toString() + " won!");
                        });
                    }

                }
            }

        });
        int btnW = 100, btnH = 50, gap = 15;
        int totalW = 3 * btnW + 2 * gap;
        int startX = (playerSide.getWidth() - totalW) / 2;
        int y = 20;

        hitButton.setBounds(startX, y, btnW, btnH);
        standButton.setBounds(startX + btnW + gap, y, btnW, btnH);
        restartButton.setBounds(startX + 2 * (btnW + gap), y, btnW, btnH);
        playerSide.add(hitButton);
        playerSide.add(standButton);
        playerSide.add(restartButton);
    }
    public void open() {
        container.setVisible(true);
    }

    public void close() {
        container.setVisible(false);
    }

    public void winnerText(String text){
        _t = new JLabel(text);
        gameEnd = true;
        _t.setFont(new Font("Arial", Font.BOLD, 48));
        _t.setBounds(container.getWidth() / 2 - _t.getWidth() / 2 , 200, 300, 300);
        dealerSide.add(_t);
        renderHands();
    }
    public void renderHands() {
        playerSide.setCardsPanel(rebuildLabels(playerCardLabels, player.cards, playerSide));
        dealerSide.setCardsPanel(rebuildLabels(dealerCardLabels, dealer.cards, dealerSide));
        render();
    }
    public void renderDealerHands() {
        playerSide.setCardsPanel(rebuildLabels(playerCardLabels, player.cards, playerSide));
        dealerSide.setCardsPanel(rebuildLabels(dealerCardLabels, dealer.actualCards, dealerSide));
        render();
    }
    public void resetContainer(){
        _t.setText("");
        render();
        gameEnd = false;
    }
    public JLayeredPane rebuildLabels(Stack<JLabel> labels, ArrayList<Integer> hand, PlayerPanel panel) {
        for (JLabel l : labels) {
            panel.getCardsPanel().remove(l);
        }
        labels.clear();
        JLayeredPane l = new JLayeredPane(); //Mr mench this wouldve been so much more efficient and cost alot less if i could just reset the labels inside the pane and have one layered pane pleaseee make the rubric more broad next time
        l.setLayout(null);
        l.setBounds(100, 100, 600, 75);
        for (int i = 0; i < hand.size(); i++) {
            String path = DefaultCardsEnum.getSprite(hand.get(i)).getPath();
            ImageIcon icon = new ImageIcon(path);
            if (icon.getIconWidth() <= 0) {
                System.out.println("Could not load card image: " + path);
            }
            JLabel label = new JLabel(icon);
            label.setBounds(i * 40, 0, icon.getIconWidth(), icon.getIconHeight());
            labels.add(label);
            l.add(label, Integer.valueOf(i));
        }
        return l;
    }
    public void render(){
        try{
            playerSide.setBounds(1, frame.getHeight() / 2, frame.getWidth(), frame.getHeight() / 2);
            dealerSide.setBounds(1, 1, frame.getWidth(), frame.getHeight() / 2);
            int btnW = 100, btnH = 50, gap = 15;
            int totalW = 3 * btnW + 2 * gap;
            int startX = (playerSide.getWidth() - totalW) / 2;
            int y = 20;

            hitButton.setBounds(startX, y, btnW, btnH);
            standButton.setBounds(startX + btnW + gap, y, btnW, btnH);
            restartButton.setBounds(startX + 2 * (btnW + gap), y, btnW, btnH); //lowk made ai make these for me cuz i couldnt bother spacing the buttons and making the mlook pretty and noam was NOT gonna do freontend
            frame.revalidate();
            frame.repaint();
        }
        catch(NullPointerException e){
            System.out.println("Frame hasnt been initiated");
        }


    }
    public Dealer getDealer(){
        return dealer;
    }
    public Player getPlayer(){
        return player;
    }
    public boolean getGameEnd(){
        return gameEnd;
    }
    public DefaultCards getCards(){
        return cards;
    }
}
