/* Using JComboBox to show a sampling of international foods
 * Tu
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FoodSamplings extends JFrame
{
 private Container contents;
 private JComboBox<String> countries;
 private JLabel foodImage;

 private String [] countryList =
            { "France", "Greece", "Italy", "Japan", "USA" };
 private ImageIcon [] foods =
            {  new ImageIcon( "cheese.jpg" ),
               new ImageIcon( "fetaSalad.jpg" ),
               new ImageIcon( "pizza.jpg" ),
               new ImageIcon( "sushi.jpg" ),
               new ImageIcon( "hamburger.jpg" ) };

 public FoodSamplings( )
 {
  super( "Food samplings of various countries" );
  contents = getContentPane( );
  contents.setLayout( new FlowLayout( ) );

  // instantiate the components
  countries = new JComboBox<String>( countryList );
  countries.setMaximumRowCount( 4 );
  countries.setSelectedIndex( 2 );
  foodImage = new JLabel( foods[2] );

  // add components to the content pane
  contents.add( countries );
  contents.add( foodImage );

  // set up event handler
  ItemListenerHandler ilh = new ItemListenerHandler ( );
  countries.addItemListener( ilh );

  setSize( 350, 150 );
  setVisible( true );
 }

 private class ItemListenerHandler implements ItemListener
 {
  public void itemStateChanged( ItemEvent ie )
  {
   int index = countries.getSelectedIndex( );
   foodImage.setIcon( foods[index] );
  }
 }

 public static void main( String [] args )
 {
  FoodSamplings fs = new FoodSamplings( );
  fs.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
 }
}
