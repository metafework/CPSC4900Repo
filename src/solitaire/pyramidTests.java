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


public class pyramidTests{
  //public static CardLayout cardLayout = new CardLayout();

  /*Test Pyramid initialization
  **
  */
  public static void testInit(){
    PyramidOfCards testStack=new PyramidOfCards(500,100,60,27,25,10);

    //testStack.shuffle();
    testStack.fillBySuit();

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container contentPane = frame.getContentPane();
    //contentPane.add(gamePanel);
    JPanel myPanel = new JPanel() {
      protected void paintComponent(Graphics pane) {
        super.paintComponents(pane);
        testStack.draw(pane);
        System.out.print("Painting");
      }
    };
    contentPane.add(myPanel);
    frame.setBounds(0, 0, 500, 400);
    frame.setVisible(true);
    contentPane.repaint();
  }

  /*Randomness test

  */
  public static void testRandomness(){
    int sameCard=0;
    int diffCard=0;
    for(int i=0; i<50;i++){
      StackOfCards testDeck0 = StackOfCards.randomDeck();
      StackOfCards testDeck1 = StackOfCards.randomDeck();
      //StackOfCards testTestDeck= new StackOfCards();
      //testTestDeck.fillBySuit();
      for(int j=0; j<50;j++){

        if(testDeck0.pop().equals(testDeck1.pop())){
          sameCard++;
        }else diffCard++;
      }
    }
    int randomPercent=(sameCard/(sameCard+diffCard))*100;

    System.out.print(Integer.toString(randomPercent)+"%\n");
  }


  /*First Card Selection*/
  
  /*Second Card Selection*/
  /*Arithmetic*/
  /*Successful pair*/
  /*Failed pair*/
  /*Dropdown menu options*/
  /*Scoring test*/
  /*Vicotry anouncement*/
  /*Re-initiallization*/
  /*High Score update test*/


  public static void main(String[] args) {
    testRandomness();
		//Calls initTableaux with the random deck and an anonymous array that
		//holds the initial tableau sizes.
		/*initTableaux(deck, new int[] {4, 4, 4, 4, 4, 4});
		initTableaux(deck, 7);
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container contentPane = frame.getContentPane();
    //contentPane.add(gamePanel);
    JPanel myPanel = new JPanel() {
      protected void paintComponent(Graphics pane) {
        super.paintComponents(pane);
        deck.draw(pane);
        System.out.print("Painting");
      }
    };
    contentPane.add(myPanel);
    frame.setBounds(0, 0, 500, 400);
    frame.setVisible(true);
    contentPane.repaint();
    System.out.print("Empty main\n");
*/



  }
}
