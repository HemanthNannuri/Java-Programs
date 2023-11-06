/* SubHuntViewController class
*  Tu
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SubHuntViewController extends JFrame
{
 private int x; // current x mouse position
 private int y; // current y mouse position
 private SubHunt sub; // submarine
 private boolean gameStarted = false;
 private Insets insets; 
 private MouseHandler mh; // mouse event handler

 public SubHuntViewController( SubHunt newSub )
 {
  super( "Play!" );

  sub = newSub;
  // instantiate event handler and register listener on window
  mh = new MouseHandler( );
  addMouseListener( mh );

  // size window to include insets
  setVisible( true );
  insets = getInsets( );
  setSize( sub.getGameSize( ) + insets.left + insets.right, 
           sub.getGameSize( ) + insets.top + insets.bottom );
 }

 private class MouseHandler extends MouseAdapter
 {
  public void mouseClicked( MouseEvent me )
  {
   x = me.getX( ) - insets.left;
   y = me.getY( ) - insets.top;
   sub.play( x, y );
   setTitle( sub.getStatus( ) );
   repaint( );
  }
 }

 public void paint( Graphics g )
 {
  if ( !gameStarted )
  {
   super.paint( g );
   gameStarted = true;
  }
  g.translate( insets.left, insets.top );
  sub.draw( g, x, y );
  if ( sub.isHit( ) )
    removeMouseListener( mh );
 }
}