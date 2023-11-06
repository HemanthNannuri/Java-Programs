/* TreasureHuntViewController class
*  Tu
*/

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

public class TreasureHuntViewController extends JFrame 
             implements MouseMotionListener
{
  private int x;
  private int y;
  private TreasureHunt hunt;
  private Insets insets; 
  
  public TreasureHuntViewController( TreasureHunt newHunt )
  {
   super( "Play!" );
	 
   hunt = newHunt;	 
   // application registers on itself
   // since it is a MouseMotionListener itself
   addMouseMotionListener( this );
   setSize( hunt.getGameSize( ), hunt.getGameSize( ) );
   setVisible( true );
   
   // resize window to include insets
   insets = getInsets( );
   setSize( getWidth( ) + insets.left + insets.right, 
            getHeight( ) + insets.top + insets.bottom );
  }
  
  public void mouseMoved( MouseEvent me )
  {
   // get location of mouse
   x = me.getX( ) - insets.left;
   y = me.getY( ) - insets.top;	 
   hunt.play( x, y );
   repaint( );
   if ( hunt.isGameOver( ) )
	  removeMouseMotionListener( this );
  }
  
  public void mouseDragged( MouseEvent me )
  { } // we do not want to process mouse drag events

  public void paint( Graphics g )
  {
   super.paint( g );
   g.translate( insets.left, insets.top );
   hunt.draw( g, x , y );
  }
}