/* PlaySubHunt class
*  Tu
*/

import javax.swing.JFrame;

public class PlaySubHunt 
{
 public static void main( String [] args )
 {
  SubHunt sub = new SubHunt( SubHunt.DEFAULT_GAME_SIZE );
  SubHuntViewController subGui = new SubHuntViewController( sub );
  subGui.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
 }
}