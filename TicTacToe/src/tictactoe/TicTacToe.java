/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
/**
 *
 * @author AK 47
 */
public class TicTacToe extends JFrame{
    
    private int userTurn = 0; //if the number is even, then its player one's turn and we place an X. Else we place an O.
    private int winCounter1 = 0;
    private int winCounter2 = 0;
    private int lossCounter1 = 0;
    private int lossCounter2 = 0;
    
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 500;
    private boolean inProgress = false;
    private String enteredNamePlayerOne;
    private String enteredNamePlayerTwo;
    
    private JPanel error;
    private JPanel playerOneInfoPanel;
    private JTextField playerOneName;
    private JLabel name1;
    private JLabel wins1;
    private JLabel losses1;
    private JLabel winsCount1;
    private JLabel lossCount1;
    
    private JPanel playerTwoInfoPanel;
    private JTextField playerTwoName;
    private JLabel name2;
    private JLabel wins2;
    private JLabel losses2;
    private JLabel winsCount2;
    private JLabel lossCount2;
    
    private JPanel bothPlayerPanels;
    
    private JPanel gameGrid; //creates the grid and the 9 buttons used in tic tac toe game
    private JButton topLeft;
    private JButton topMid;
    private JButton topRight;
    private JButton midLeft;
    private JButton midMid;
    private JButton midRight;
    private JButton botLeft;
    private JButton botMid;
    private JButton botRight;
    
    private JPanel lowerPanel;  
    private JPanel upperLowerPanel;
    private JButton newGameButton;
    private JButton resetButton;
    private JButton exitButton;
    private JLabel bottomMessage;
    
    public TicTacToe()
    {
        setTitle("Tic Tac Toe");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        

        
        buildPlayerInfo();
        buildTicTacToeGrid();
        buildLowerArea();
        
        add(bothPlayerPanels, BorderLayout.NORTH);
        add(gameGrid, BorderLayout.CENTER);
        add(lowerPanel, BorderLayout.SOUTH);
        
        setVisible(true);
    }
    
    
    
    private void buildPlayerInfo()
    {
        bothPlayerPanels = new JPanel();
        bothPlayerPanels.setLayout(new GridLayout(1, 2)); //creates grid layout for player panels
        
        playerOneInfoPanel = new JPanel();
        playerOneName = new JTextField(8);
        name1 = new JLabel("Name: ");
        wins1 = new JLabel("Wins: ");
        losses1 = new JLabel("Losses: ");
        winsCount1 = new JLabel(Integer.toString(winCounter1)); //sets the win/loss JLabels to the integer value of variable that counts wins
        lossCount1 = new JLabel(Integer.toString(lossCounter1));
        
        
        playerTwoInfoPanel = new JPanel();
        playerTwoName = new JTextField(8);
        name2 = new JLabel("Name: ");
        wins2 = new JLabel("Wins: ");
        losses2 = new JLabel("Losses: ");
        winsCount2 = new JLabel(Integer.toString(winCounter2)); 
        lossCount2 = new JLabel(Integer.toString(lossCounter2));
        
        playerOneInfoPanel.setLayout(new GridLayout(3, 3)); 
        playerTwoInfoPanel.setLayout(new GridLayout(3, 3));
        
        playerOneInfoPanel.setBorder(BorderFactory.createTitledBorder("Player 1 (X)"));
        playerOneInfoPanel.add(name1);
        playerOneInfoPanel.add(playerOneName);
        playerOneInfoPanel.add(wins1);
        playerOneInfoPanel.add(winsCount1);
        playerOneInfoPanel.add(losses1);
        playerOneInfoPanel.add(lossCount1);
        
        playerTwoInfoPanel.setBorder(BorderFactory.createTitledBorder("Player 2 (0)"));
        playerTwoInfoPanel.add(name2);
        playerTwoInfoPanel.add(playerTwoName);
        playerTwoInfoPanel.add(wins2);
        playerTwoInfoPanel.add(winsCount2);
        playerTwoInfoPanel.add(losses2);
        playerTwoInfoPanel.add(lossCount2);
        
        
        bothPlayerPanels.add(playerOneInfoPanel); //adds panel to left grid
        bothPlayerPanels.add(playerTwoInfoPanel); //adds panel to right grid
        
        
    }

    
    private void buildTicTacToeGrid()
    {
        Font font = new Font("Arial", Font.BOLD, 24);
        gameGrid = new JPanel();
        gameGrid.setLayout(new GridLayout(3, 3)); //creates grid layout
        
        
        
        topLeft = new JButton("");
        topMid = new JButton(" ");
        topRight = new JButton("  ");
        midLeft = new JButton("   ");
        midMid = new JButton("    ");
        midRight = new JButton("     ");
        botLeft = new JButton("      ");
        botMid = new JButton("        ");
        botRight = new JButton("       ");
        
        topLeft.setEnabled(false);
        topMid.setEnabled(false);
        topRight.setEnabled(false);
        midLeft.setEnabled(false);
        midMid.setEnabled(false);
        midRight.setEnabled(false);
        botLeft.setEnabled(false);
        botMid.setEnabled(false);
        botRight.setEnabled(false);
        
        topLeft.setFont(font);
        topMid.setFont(font);
        topRight.setFont(font);
        midLeft.setFont(font);
        midMid.setFont(font);
        midRight.setFont(font);
        botLeft.setFont(font);
        botMid.setFont(font);
        botRight.setFont(font);
        
        
        
        topLeft.addActionListener(new TicTacToeButtonListener()); //add action listener
        topMid.addActionListener(new TicTacToeButtonListener());
        topRight.addActionListener(new TicTacToeButtonListener());
        midLeft.addActionListener(new TicTacToeButtonListener());
        midMid.addActionListener(new TicTacToeButtonListener());
        midRight.addActionListener(new TicTacToeButtonListener());
        botLeft.addActionListener(new TicTacToeButtonListener());
        botMid.addActionListener(new TicTacToeButtonListener());
        botRight.addActionListener(new TicTacToeButtonListener());
        
        gameGrid.add(topLeft);
        gameGrid.add(topMid);
        gameGrid.add(topRight);
        gameGrid.add(midLeft);
        gameGrid.add(midMid);
        gameGrid.add(midRight);
        gameGrid.add(botLeft);
        gameGrid.add(botMid);
        gameGrid.add(botRight);
        
        
    }
    
    
    private void buildLowerArea()
    {
       lowerPanel = new JPanel();
       upperLowerPanel = new JPanel();
       upperLowerPanel.setLayout(new GridLayout(1, 3));
       lowerPanel.setLayout(new GridLayout(2, 1));
       newGameButton = new JButton("New Game");
       resetButton = new JButton("Reset Game");
       exitButton = new JButton("Exit Game");
       bottomMessage = new JLabel("Welcome to Tic-Tac-Toe!");
       bottomMessage.setBorder(BorderFactory.createEtchedBorder());
       
       
       newGameButton.addActionListener(new gameStartExitResetListener()); //adds buttons to gameStarExitReset
       resetButton.addActionListener(new gameStartExitResetListener());
       exitButton.addActionListener(new gameStartExitResetListener());
       
       
       
       upperLowerPanel.add(newGameButton); //ads the buttons to the upper lower pannel in grid form
       upperLowerPanel.add(resetButton);
       upperLowerPanel.add(exitButton);
       
       lowerPanel.add(upperLowerPanel);//ads the upperLowerPanel to the grid (so its on top of message)
       lowerPanel.add(bottomMessage);
    }
    
    
    
    private class TicTacToeButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            JButton buttonClicked;
            buttonClicked = (JButton)e.getSource(); //get the button that was clicked and have buttonClicked point to it
            if((userTurn % 2 == 0) && (buttonClicked.getText() != "X") && (buttonClicked.getText() != "O"))
            {
                bottomMessage.setText(enteredNamePlayerTwo + "'s turn"); //signifying player 1's turn is over
                buttonClicked.setText("X"); //button is changed to an X
                userTurn++;
            }
            else if((userTurn % 2 != 0) && (buttonClicked.getText() != "X") && (buttonClicked.getText() != "O"))
            {
                
                bottomMessage.setText(enteredNamePlayerOne + "'s turn"); //signifying player 2's turn is over
                buttonClicked.setText("O"); //button is changed to an O
                userTurn++;
            }
            
            
            
            if(isWon())
            {
                newGameButton.setEnabled(true);
                if(userTurn % 2 != 0) //this means player 1 has won
                {
                    winCounter1++; //counts a win for player 1
                    lossCounter2++; //counts a loss for player 2
                    winsCount1.setText(Integer.toString(winCounter1)); //sets win count to JLabel 
                    lossCount2.setText(Integer.toString(lossCounter2));
                    
                }
                else if(userTurn % 2 == 0) //this means player 2 has won
                {
                    winCounter2++;
                    lossCounter1++;
                    winsCount2.setText(Integer.toString(winCounter2));
                    lossCount1.setText(Integer.toString(lossCounter1));
                }
                
                resetButtons();
                userTurn = 0;
            }
            
            else if(userTurn == 9 && !isWon()) //checks to see if board is filled and nobody is won
            {
                newGameButton.setEnabled(true);
                resetButtons(); //resets button if nobody wins as well, doesnt add win or loss.
                userTurn = 0; //resets userTurn
            }
            
            
        }
    }
    
    private class gameStartExitResetListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            enteredNamePlayerOne = playerOneName.getText(); //whatver has been entered into TextField is saved as name.
            enteredNamePlayerTwo = playerTwoName.getText();
             boolean wasError = false;
            wasError = ErrorMessage(enteredNamePlayerOne, enteredNamePlayerTwo);
            if (wasError && e.getSource() == newGameButton)
            {
                JOptionPane.showMessageDialog(error, "The name or names for this game are ILLEGAL. Please change them so that they are not empty and do not exclusively contain spaces.", "ERROR",  JOptionPane.ERROR_MESSAGE);
            }
            if(e.getSource() == newGameButton && !wasError)
            {
               
                inProgress = true;
                topLeft.setEnabled(true);
                topMid.setEnabled(true);
                topRight.setEnabled(true);
                midLeft.setEnabled(true);
                midMid.setEnabled(true);
                midRight.setEnabled(true);
                botLeft.setEnabled(true);
                botMid.setEnabled(true);
                botRight.setEnabled(true);
                
                
                
                playerOneName.setEditable(false); //makes the names uneditable
                playerTwoName.setEditable(false); //makes the names uneditable once game has started
                
                bottomMessage.setText(enteredNamePlayerOne + "'s Turn");
                newGameButton.setEnabled(false);
            }
            
            else if(e.getSource() == resetButton && !wasError)
            {
                JFrame resetDialog = new JFrame();
                String message = "This will end the game and set the win/loss stats to 0. Are you sure?";
                int answer = JOptionPane.showConfirmDialog(resetDialog, message, "option", JOptionPane.YES_NO_OPTION);
                if(answer == JOptionPane.YES_OPTION) //user clicks yes
                {
                    resetButtons(); //resets board to original state
                    resetStats(); //resets stats to original state
                    newGameButton.setEnabled(true);
                }
                
            }
            
            else if(e.getSource() == resetButton && wasError)
            {
                JOptionPane.showMessageDialog(error, "Reset pressed on incorrect names, please try to initialize the game again.", "ERROR",  JOptionPane.ERROR_MESSAGE);  
            }
            
            else if(e.getSource() == exitButton)
            {
                System.exit(0);
            }
        }
    }
    
    
    public boolean isWon() //checks to see whether there is a victory, returns true if so, false if not
    {
        if(topLeft.getText() == topMid.getText() && topLeft.getText() == topRight.getText())
        {
            return true;
        }
        else if(midLeft.getText() == midMid.getText() && midLeft.getText() == midRight.getText())
        {
            return true;
        }
        else if(botLeft.getText() == botMid.getText() && botLeft.getText() == botRight.getText())
        {
            return true;
        }
        else if(topLeft.getText() == midLeft.getText() && topLeft.getText() == botLeft.getText())
        {
            return true;
        }
        else if(topMid.getText() == midMid.getText() && topMid.getText() == botMid.getText())
        {
            return true;
        }
        else if(topRight.getText() == midRight.getText() && topRight.getText() == botRight.getText())
        {
            return true;
        }
        else if(topLeft.getText() == midMid.getText() && topLeft.getText() == botRight.getText())
        {
            return true;
        }
        else if(botLeft.getText() == midMid.getText() && botLeft.getText() == topRight.getText())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void resetButtons() //resets the board to a clean one, also resets game board
    {
        topLeft.setText(""); //resets what they hold
        topMid.setText(" ");
        topRight.setText("  ");
        midLeft.setText("   ");
        midMid.setText("    ");
        midRight.setText("     ");
        botLeft.setText("      ");
        botMid.setText("       ");
        botRight.setText("        ");
        
        topLeft.setEnabled(false); //resets if they are enabled or not
        topMid.setEnabled(false);
        topRight.setEnabled(false);
        midLeft.setEnabled(false);
        midMid.setEnabled(false);
        midRight.setEnabled(false);
        botLeft.setEnabled(false);
        botMid.setEnabled(false);
        botRight.setEnabled(false);
        
        playerOneName.setEditable(true);
        playerTwoName.setEditable(true);
        
        bottomMessage.setText("Welcome to Tic-Tac-Toe");
    }
    
    public void resetStats()
    {
        winCounter1 = 0; //sets integer win/loss values back to zero
        winCounter2 = 0;
        lossCounter1 = 0;
        lossCounter2 = 0;
        
        winsCount1.setText(Integer.toString(winCounter1)); //actually sets the labels to 0 wins/loss
        winsCount2.setText(Integer.toString(winCounter2));
        lossCount1.setText(Integer.toString(lossCounter1));
        lossCount2.setText(Integer.toString(lossCounter2));
        
        playerOneName.setText("");
        playerTwoName.setText("");
    }
    
       public boolean ErrorMessage(String p1Name, String p2Name)
    {
        boolean setError = false;
        if(p1Name == null || p1Name.isEmpty() || p1Name.trim().isEmpty()) // trim causes all whitespace to be "trimmed" out of the string. The isEmpty then checks for the case of an all space-case being empty.
        {
            setError = true;
        }
        
        if(p2Name == null || p2Name.isEmpty() || p2Name.trim().isEmpty())
        {
            setError = true;
        }
        
//        if(setError == true)
//        {
//            JOptionPane.showMessageDialog(error, "The name or names for this game are ILLEGAL. Please change them so that they are not empty and do not exclusively contain spaces.", "ERROR",  JOptionPane.ERROR_MESSAGE);    
//        }
        
        return setError;
        
    }
    
    
    
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        
        
        
        new TicTacToe();
        
        
        
        
        
    }
    
}
