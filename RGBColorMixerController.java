/** RGBColorMixerController class
*   Tu
*/

import java.awt.event.*;
import javax.swing.*;

public class RGBColorMixerController implements ActionListener
{
 private RGBColorMixer model;
 private BorderLayoutView view;

 public RGBColorMixerController( RGBColorMixer newModel,
        BorderLayoutView newView )
 {
  model = newModel;
  view = newView;
  
  view.setTitle( model.getTitle( ) );

  JButton north = view.getNorth( ), west = view.getWest( ), 
          south = view.getSouth( ), east = view.getEast( );
  
  north.setText( model.getMethodLabel( RGBColorMixer.POSITION_CHANGE ) );
  west.setText( model.getMethodLabel( RGBColorMixer.POSITION_RED ) );
  south.setText( model.getMethodLabel( RGBColorMixer.POSITION_GREEN ) );
  east.setText( model.getMethodLabel( RGBColorMixer.POSITION_BLUE ) );
    
  north.addActionListener( this );
  west.addActionListener( this );
  south.addActionListener( this );
  east.addActionListener( this );
  
  updateView( );
 }

 public void actionPerformed( ActionEvent ae )
 {
  // update the model
  if ( ae.getSource( ) == view.getNorth( ) )
    model.invertDelta( );
  else if ( ae.getSource( ) == view.getWest( ) )
    model.addToRed( );
  else if ( ae.getSource( ) == view.getSouth( ) )
    model.addToGreen( );
  else if ( ae.getSource( ) == view.getEast( ) )
    model.addToBlue( );
  // update the view
  updateView( ); 
 }
 
 /** updateView method
 * updates the color and the text of the center label
 */
 public void updateView( )
 { 
  JLabel label = view.getCenter( );
  label.setBackground( model.getColor( ) );
  label.setText( model.toString( ) );
 } 
}