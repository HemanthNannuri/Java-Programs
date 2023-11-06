/** MixColors class
*   Tu
*/

import javax.swing.JFrame;

public class MixColors 
{ 
 public static void main( String [] args )
 {
  // Instantiate the Model
  RGBColorMixer colorMixer = new RGBColorMixer( -10 );
  // Instantiate the View
  BorderLayoutView colorMixerGui = new BorderLayoutView( );
  colorMixerGui.setSize( 350, 250 );
  colorMixerGui.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  // Instantiate the Controller
  RGBColorMixerController controller 
    = new RGBColorMixerController( colorMixer, colorMixerGui );
 }
}