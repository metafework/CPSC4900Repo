package solitaire;

import java.awt.geom.RoundRectangle2D;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.awt.*;

import javax.swing.*;

import card.Card;
import card.StackOfCards;
import card.Tableau;
import card.PyramidOfCards;
import dataStructures.StackADT;
import solitaire.Pyramid;

/*This Class test certain components of the Aztec Pyramid game.
*Test cases are explained in more detail in the Project Document.
*/

public class pyramidTests{

  /*This method test the randomness of the stacks after randomDeck() method is called
  */
  public static void testRandomness(){
    System.out.print(" Testing randomness of stack...\n\n");
    double sameCard=0;
    double diffCard=0;
    for(int i=0; i<50;i++){
      //Initialized 2 decks (runs 50 times)
      StackOfCards testDeck0 = StackOfCards.randomDeck();
      StackOfCards testDeck1 = StackOfCards.randomDeck();

      for(int j=0; j<50;j++){

        if(testDeck0.pop().equals(testDeck1.pop())){ //Checks if any cards at the same position of the two decks have same value.
          sameCard++;
        }else diffCard++;
      }
    }
    double randomPercent=(sameCard/(sameCard+diffCard))*100; //Calculates a percentage of the occurance of two identical card in same position.

    System.out.print("Randomness of stacks: "+ Double.toString(randomPercent)+"%\n\n\n");

  }
 /*Starts a visible instance of a new game for validation of card positioning (Pyramid formation)
 * Not for testing other functionality.
 */
  public static Pyramid startTestGame(){
    // Create window components
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    Container contentPane = frame.getContentPane();
    Pyramid testPyramid=new Pyramid(contentPane); //Initialize new game instance.
    testPyramid.setCoord(contentPane);
    JPanel myPanel = new JPanel(){
      protected void paintComponent(Graphics pane){
      super.paintComponents(pane);
      testPyramid.paint(pane);

    };};
    contentPane.add(myPanel);
    frame.setBounds(0, 0, 687, 611);
    frame.setVisible(true);
    contentPane.repaint(); //Draws game instance.
    System.out.print("Game window launched for visual test of game components.\n\n\n");



    return testPyramid;
  }
  /*
  *This method tests the victory anouncemnt dialogue box.
  */
  public static void testWin(Pyramid testPyramid){
    testPyramid.onWin();
    System.out.print("Game window launched for visual test of victory declaration.\n");


  }


  public static void main(String[] args) {
    //Test Case 2: Correct Initialization of Pyramid
    Pyramid testPyramid=startTestGame();

    //Test Case 3: Test randomness of Card position initialization.
    testRandomness();

    //Test Case 10: Test Victory Announcement
    testWin(testPyramid);
}

}
