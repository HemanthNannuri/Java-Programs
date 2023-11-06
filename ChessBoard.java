/* Using GridLayout to organize our window
   Tu
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChessBoard extends JFrame
{
 private Container contents;
 private JButton [][] squares;
 private String [] letters = 
    { "a", "b", "c", "d", "e", "f", "g", "h" };
 private int [] digits = { 1, 2, 3, 4, 5, 6, 7, 8 };

 public ChessBoard( )
 {
  super( "Click a square to reveal its position" );
  contents = getContentPane( );

  // set layout to an 8-by-8 Grid
  contents.setLayout( new GridLayout( letters.length, digits.length ) );

  squares = new JButton[letters.length][digits.length];

  ButtonHandler bh = new ButtonHandler( );

  for ( int i = 0; i < letters.length; i++ )
  {
   for ( int j = 0; j < digits.length; j++ )
   {
    // instantiate JButton array
    squares[i][j] = new JButton( );

    // make every other square red
    if ( ( i + j ) % 2 == 0 )
      squares[i][j].setBackground( Color.RED );

    // add the JButton
    contents.add( squares[i][j] );

    // register listener on button
    squares[i][j].addActionListener( bh );
   }
  }

  setSize( 400, 400 );
  setVisible( true );
 }

 private class ButtonHandler implements ActionListener
 {
  public void actionPerformed( ActionEvent ae )
  {
    for ( int i = 0; i < letters.length; i++ )
    {
      for ( int j = 0; j < digits.length; j++ )
      {
        if ( ae.getSource( ) == squares[i][j] )
        {
          squares[i][j].setText( letters[i] + digits[j] );
          return;
        }
      }
    }
  }
 }

 public static void main( String [] args )
 {
   ChessBoard myGame = new ChessBoard( );
   myGame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
 }
}