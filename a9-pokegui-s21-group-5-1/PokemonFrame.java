import javax.swing.JFrame;

/**
* Frame GUI for pokemon.
* @author Trey Yasunaga
* @since 05/04/2021
*/
public class PokemonFrame {

   /** main method.
   * @param args not used
   */
   public static void main(String[] args) {
      JFrame frame = new JFrame("Pokemon game");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new PokemonGUI());
      frame.pack();
      frame.setVisible(true);
   } //closes main
} //closes class