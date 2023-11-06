/** BorderLayoutView class
*   Reusable generic frame using a BorderLayout
*   Four buttons occupy the North, East, South, and West positions
*   A label with centered text occupies the center position
*   Accessors are provided so that a Controller can access 
*   the four  buttons and the label
*   Tu
*/

import javax.swing.*;
import java.awt.*;

public class BorderLayoutView extends JFrame
{
 private JButton north, east, south, west;
 private JLabel center;

 public BorderLayoutView( )
 {
  super( );
  Container contents = getContentPane( );
  contents.setLayout( new BorderLayout( ) ); // optional

  // instantiate button objects
  north = new JButton( );
  east = new JButton( );
  south = new JButton( );
  west = new JButton( );

  center = new JLabel( "", SwingConstants.CENTER );
  center.setOpaque( true );

  // order of adding components is not important
  contents.add( north, BorderLayout.NORTH );
  contents.add( east, BorderLayout.EAST );
  contents.add( south, BorderLayout.SOUTH );
  contents.add( west, BorderLayout.WEST );
  contents.add( center, BorderLayout.CENTER );

  setVisible( true );
 }

 public JButton getNorth( )
 {
  return north;
 }
 
 public JButton getEast( )
 {
  return east;
 }

 public JButton getSouth( )
 {
  return south;
 }

 public JButton getWest( )
 {
  return west;
 }
 
 public JLabel getCenter( )
 {
  return center;
 }
}