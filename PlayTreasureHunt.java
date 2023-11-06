/* PlayTreasureHunt class
*  Tu
*/

import javax.swing.JFrame;

public class PlayTreasureHunt 
{
 public static void main( String [] args )
 {
  TreasureHunt th = new TreasureHunt( 
                         TreasureHunt.DEFAULT_GAME_SIZE );
  TreasureHuntViewController huntGui 
    = new TreasureHuntViewController( th );
  huntGui.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
 }
}