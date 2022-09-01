import java.awt.Color;
import java.awt.Font;
import java.awt.Choice;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
/**
* Panel for PokemonFrame.
* @author Trey Yasunaga, Ken Seekins
* @since 5/1/2021
*/

public class PokemonGUI extends JPanel {

   /**Storing for Pokedex.*/
   private PokeTree tree = new PokeTree();
   
   /**Storing for Name Sort.*/
   private PokeTreeName treeName = new PokeTreeName();
   
   /**Storing for HP Sort.*/
   private PokeTreeHP treeHP = new PokeTreeHP();
   
   /**Storing for CP Sort.*/
   private PokeTreeCP treeCP = new PokeTreeCP();
   
   /**Storing for Recent Sort.*/
   private Deque<Pokemon> stack = new LinkedList<>();
   
   /**Holds Pokemons as they are Polled.*/
   private Deque<Pokemon> stack2 = new LinkedList<>();
   
   /**Storing for Sort by Number.*/
   private PriorityQueue<Pokemon> pq = new PriorityQueue<>();
   
   /**Holds Pokemon as they are polled.*/
   private PriorityQueue<Pokemon> pq2 = new PriorityQueue<>();
   
   /**Pokemon object to be created, stored.*/
   private Pokemon p;
   /**light blue color.*/
   private Color color = new Color(214, 235, 254);
   /**Big font.*/
   private Font bigF = new Font("", Font.PLAIN, 30);
   /**Medium Font.*/
   private Font medF = new Font("", Font.PLAIN, 20);
   /**Label.*/
   private JLabel title = new JLabel("Pokemon GUI");
   /**Label for pictures.*/
   private JLabel image = new JLabel(new ImageIcon("blank.png"));
   /**Label used as padding.*/
   private JLabel filler = new JLabel("");
   
   /**Top sub panel.*/
   private JPanel topSubPanel = new JPanel();
   /**Center sub panel.*/
   private JPanel centerSubPanel = new JPanel();
   /**Bottom sub panel.*/
   private JPanel bottomSubPanel = new JPanel();
   /**Left sub panel.*/
   private JPanel westSubPanel = new JPanel();
   /**Right sub panel.*/
   private JPanel eastSubPanel = new JPanel();
   /**displays the created pokemon.*/
   private JTextArea textArea = new JTextArea(8, 20);
   /**Displays all created pokemon in a list.*/
   private JTextArea listArea = new JTextArea(8, 20);
   /**Scroll bar stuff.*/
   private JScrollPane scroll = new JScrollPane(listArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
       JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
   
   /**Event listner.*/
   private GUIListener listener = new GUIListener();
   /**Drop down list to pick pokemon species.*/
   private Choice pokemonChoice = new Choice();
   
   /**Catch new pokemon.*/
   private JButton catchButton = new JButton("Catch");
   /**Hunt a new pokemon.*/
   private JButton huntButton = new JButton("Hunt");
   /**Button to display all pokemon.*/
   private JButton pokedexButton = new JButton("Pokedex");
   /**Resets everything i think.*/
   private JButton backpack = new JButton("Backpack");
   
   /**Random number generator.*/
   private Random rand = new Random();
   /** drop down list sorting options. */
   private Choice cList = new Choice();
    

       
   /**
   * Holds everything.
   */
   public PokemonGUI() {
      this.setLayout(new BorderLayout());
      this.setPreferredSize(new Dimension(554, 800));
      this.setBackground(Color.pink);
      
      //button setup
      catchButton.addActionListener(listener);
      huntButton.addActionListener(listener);
      backpack.addActionListener(listener);
      pokedexButton.addActionListener(listener);
      //cList.addActionListener(listener);
      //cList.setSelectedIndex(0);
      this.add("North", topSubPanel);
      this.add("South", bottomSubPanel);
      this.add("Center", centerSubPanel);
      this.add("West", westSubPanel);
      this.add("East", eastSubPanel);
      
      topSubPanel.add(title);
      
      centerSubPanel.setBackground(color);
      westSubPanel.setBackground(color);
      eastSubPanel.setBackground(color);
      centerSubPanel.add(textArea).setFont(medF);
      //centerSubPanel.add(new JLabel(new ImageIcon("bulbasaur.png")));
      centerSubPanel.add(image);
      centerSubPanel.add(huntButton);
      centerSubPanel.add(catchButton);
      eastSubPanel.add(filler);
      //centerSubPanel.add(listArea).setFont(medF);
      centerSubPanel.add(scroll);
      listArea.setFont(medF);
      
      
      textArea.setEditable(false);
      listArea.setEditable(false);
      
      cList.add("Sort by Number");
      cList.add("Sort by Recent");
      cList.add("Sort by Name");
      cList.add("Sort by HP");
      cList.add("Sort by CP");
   
      
      bottomSubPanel.setBackground(color);
      bottomSubPanel.add(pokedexButton).setFont(medF);
      bottomSubPanel.add(backpack).setFont(medF);
      bottomSubPanel.add(cList).setFont(medF);
      scroll.setBorder(null);
      scroll.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
      
      
      title.setFont(bigF);
      catchButton.setFont(medF);
      catchButton.setPreferredSize(new Dimension(100, 50));
      catchButton.setVisible(true);
      catchButton.setEnabled(false);
      huntButton.setFont(medF);
      huntButton.setPreferredSize(new Dimension(100, 50));
      
           
   
      
   } //closes panel constructor.
   /**Event listener stuff.*/
   private class GUIListener implements ActionListener {
      /**Action performed method.
      * @param event what button was pressed.
      */
      public void actionPerformed(ActionEvent event) {
         if (event.getSource() == huntButton) {
         
            String[] spriteArray = new String[]{
               "bulbasaur.png", "ivysaur.png", "venusaur.png", "charmander.png",
               "charmeleon.png", "charizard.png", "squirtle.png", "wartortle.png", "blastoise.png"};
            int pokedexButtonNum;
            ImageIcon sprite = new ImageIcon();
            String name = "";
            p = new Bulbasaur();
            
            pokedexButtonNum = rand.nextInt(9);
            switch(pokedexButtonNum) {
               case 0: p = new Bulbasaur();
                  image.setIcon(new ImageIcon(spriteArray[pokedexButtonNum]));
                  //sprite.setImage("bulbasaur.png");
                  break;
               case 1: p = new Ivysaur();
                  image.setIcon(new ImageIcon(spriteArray[pokedexButtonNum]));
                  break;
               case 2: p = new Venusaur();
                  image.setIcon(new ImageIcon(spriteArray[pokedexButtonNum]));
                  break;
               case 3: p = new Charmander();
                  image.setIcon(new ImageIcon(spriteArray[pokedexButtonNum]));
                  break;
               case 4: p = new Charmeleon();
                  image.setIcon(new ImageIcon(spriteArray[pokedexButtonNum]));
                  break;
               case 5: p = new Charizard();
                  image.setIcon(new ImageIcon(spriteArray[pokedexButtonNum]));
                  break;
               case 6: p = new Squirtle();
                  image.setIcon(new ImageIcon(spriteArray[pokedexButtonNum]));
                  break;
               case 7: p = new Wartortle();
                  image.setIcon(new ImageIcon(spriteArray[pokedexButtonNum]));
                  break;
               case 8: p = new Blastoise();
                  image.setIcon(new ImageIcon(spriteArray[pokedexButtonNum]));
                  break;
               default:
                  System.out.println("If this prints, something weird happened");
            } //closes switch
            textArea.setText("A wild " + p.getSpecies() + " has appeared!");
            catchButton.setVisible(true);
            catchButton.setEnabled(true);
         } //closes hunt button
         
         if (event.getSource() == catchButton) {
            int chance = rand.nextInt(100);
            if (chance >= 49) {
              
            
               textArea.setText("You caught " + p.toString() + "!");
               tree.add(p);
               treeName.add(p);
               treeHP.add(p);
               treeCP.add(p);
               pq.add(p);
               stack.push(p);
               
               catchButton.setEnabled(false);
            } else {
               textArea.setText(p.getSpecies() + " has escaped.");
               image.setIcon(new ImageIcon("blank.png"));
               catchButton.setEnabled(false);
            }
         } //catchButton
         if (event.getSource() == pokedexButton) {
            String s = tree.printPokeTree();
            //System.out.println(s);
            listArea.setText(s);
         } //pokedex button 
         if (event.getSource() == backpack) {
            String s = ""; 
            String sp = "";
            s = cList.getSelectedItem();
            switch(s) {
               
               case "Sort by Number":  
                  while (pq.size() > 0) {
                     Pokemon curr = pq.poll();
                     pq2.add(curr);
                     sp = sp + "\n" + (curr.toString());
                     
                  }
                  listArea.setText(sp);
                  while (pq2.size() > 0) {
                     Pokemon curr2 = pq2.poll();
                     pq.add(curr2);
                  }
                  
                     
                  break;
               
               case "Sort by Recent": 
                  
                  while (stack.size() > 0) {
                     Pokemon curr = stack.poll();
                     sp = sp + "\n" + (curr.toString());
                     stack2.push(curr);
                  }
                  listArea.setText(sp);
                  while (stack2.size() > 0) {
                     Pokemon curr2 = stack2.poll();
                     stack.push(curr2);
                  }
                        
                  
                                      
                  break;
               case "Sort by Name":
                  String pName = treeName.toString();
               //System.out.println(s);
                  listArea.setText(pName);
               
                  
                   
                  break;
               case "Sort by HP": 
                  String hp1 = treeHP.toString();
               //System.out.println(s);
                  listArea.setText(hp1);
                     
                  break;  
               
               default : 
               
                  String cp1 = treeCP.toString();
               //System.out.println(s);
                  listArea.setText(cp1);
                      
                  break;        
            } // close switch
            
            //} //close if
         } // backpack button
      } 
      
   }
  
} //closes panel class