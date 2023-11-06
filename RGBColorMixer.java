/** RGBColorMixer class
*   Tu
*/

import java.awt.Color;

public class RGBColorMixer 
{
 public static int POSITION_CHANGE = 0;
 public static int POSITION_RED = 1;
 public static int POSITION_GREEN = 2;
 public static int POSITION_BLUE = 3;
 
 private int delta; // color increment           
 private Color color; // mixed color             

 /** Constructor
 * @param newDelta delta
 */
 public RGBColorMixer( int newDelta )
 {
  if ( newDelta < -255 || newDelta > 255 || newDelta == 0 )
    delta = 1;
  else 
    delta = newDelta;
  if ( delta > 0 )  
    color = Color.BLACK;
  else
    color = Color.WHITE;
 }

 /** getColor method
 * @return color
 */
 public Color getColor( )
 {
  return color;
 }
 
 /** invertDelta method
 * sets delta to its opposite
 */
 public void invertDelta( )
 {
  delta = -delta;
 }

 /** addToRed method
 * add delta to red component of color
 */
 public void addToRed( )
 {
  if ( color.getRed( ) + delta > 255 )
    color = new Color( 255, color.getGreen( ), color.getBlue( ) );
  else if ( color.getRed( ) + delta < 0 )
    color = new Color( 0, color.getGreen( ), color.getBlue( ) );
  else
    color = new Color( color.getRed( ) + delta, color.getGreen( ), 
                       color.getBlue( ) );
 }

 /** addToGreen method
 * add delta to green component of color
 */
 public void addToGreen( )
 {
  if ( color.getGreen( ) + delta > 255 )
    color = new Color( color.getRed( ), 255, color.getBlue( ) );
  else if ( color.getGreen( ) + delta < 0 )
    color = new Color( color.getRed( ), 0, color.getBlue( ) );
  else
    color = new Color( color.getRed( ), color.getGreen( ) + delta, 
                       color.getBlue( ) );
 }
 
 /** addToBlue method
 * add delta to blue component of color
 */
 public void addToBlue( )
 {
  if ( color.getBlue( ) + delta > 255 )
    color = new Color( color.getRed( ), color.getGreen( ), 255 );
  else if ( color.getBlue( ) + delta < 0 )
    color = new Color( color.getRed( ), color.getGreen( ), 0 );
  else
    color = new Color( color.getRed( ), color.getGreen( ), 
                       color.getBlue( ) + delta );
 }
 
  /** getMethodLabel method
 * @param position 0: Change, 1: Red, 2: Green, 3: Blue
 * @return a String to use as the text to label
 *         the calling of one of the methods
 *         invertDelta, addToRed, addToGreen, and addToBlue
 */ 
 public String getMethodLabel( int position )
 {
  if ( position == POSITION_CHANGE )
    return "CHANGE DIRECTION";
  else if ( position == POSITION_RED )
    return "RED";
  else if ( position == POSITION_GREEN )
    return "GREEN";
  else if ( position == POSITION_BLUE )
    return "BLUE";
  else
    return "";
 }
  
 /** getTitle method
  * @return a String to use as title for this object
 */ 
 public String getTitle( )
 {
   return "Start Mixing Colors";
 }
 
 /** toString method
 * @return a String representation of color
 */
 public String toString( )
 {
  String colorText = color.toString( );
  int bracketIndex = colorText.indexOf( "[" );
  if ( bracketIndex >= 0 )
    colorText = colorText.substring( bracketIndex, colorText.length( ) );
  return colorText;
 }  
}