import java.util.Scanner;
/** Driver for a binary search tree that holds pokemon.
* @author Trey Yasunaga.
* @since 05/03/2021.
*/
public class Pokedex {
   /** Main method.
   * @param args not used*/
   public static void main(String[] args) {
      Scanner userIn = new Scanner(System.in);
      String choice = "";
      Pokemon pTemp;
      PokeTree tree = new PokeTree();
      boolean control = true;
      
      while (control) {
         System.out.println("Please select one of the following choices");
         System.out.println("1: Catch a Pokemon.");
         System.out.println("2: Release a Pokemon.");
         System.out.println("3: Print Pokedex.");
         System.out.println("0: Exit program.");
         
         //choice = userIn.nextLine();
         switch (userIn.nextLine().trim()) {
            case "1":
               pTemp = makePokemon();
               tree.add(pTemp);
               System.out.println("Added " + pTemp.getSpecies());
               break;
            case "2":
               pTemp = makePokemon();
               tree.remove(pTemp);
               System.out.println("Removed " + pTemp.getSpecies());
               break;
            case "3":
               tree.printPokeTree();
               break;
            case "0":
               System.out.println("Exiting");
               control = false;
               break;
            default:
               System.out.println("Invalid input. Please try again");
               break;
         }
      }
   
   
   }
   /** Makes a Pokemon based on user input. No name because the way 
   each pokemon are stored in the binary search tree the name information 
   and the stats and stuff only really matter for the first Pokemon of that species.
   * @return returns the created Pokemon.*/
   public static Pokemon makePokemon() {
      
      String input = "";
      Scanner userIn = new Scanner(System.in);
      boolean control = true;
      boolean control2 = true;
      String[] nameArray = {"Bulbasaur", "Ivysaur", "Venusaur",
         "Charmander", "Charmeleon", "Charizard",
         "Squirtle", "Wartortle", "Blastoise"};
      Pokemon pHolder = new Bulbasaur();
      Pokemon p = new Bulbasaur();
      
      while (control) {
         System.out.println("Enter the number to select the pokemon");
         for (int i = 0; i < nameArray.length; i++) {
            System.out.println((i + 1) + " for " + nameArray[i]);
         }
         input = userIn.nextLine().trim();
         switch(input) {
            case "1" : 
               pHolder = new Bulbasaur();
               control = false;
               break;
            case "2" :
               pHolder = new Ivysaur();
               control = false;
               break;
            case "3" :
               pHolder = new Venusaur();
               control = false;
               break;
            case "4" :
               pHolder = new Charmander();
               control = false;
               break;
            case "5" :
               pHolder = new Charmeleon();
               control = false;
               break;
            case "6" :
               pHolder = new Charizard();
               control = false;
               break;
            case "7" :
               pHolder = new Squirtle();
               control = false;
               break;
            case "8" :
               pHolder = new Wartortle();
               control = false;
               break;
            case "9" :
               pHolder = new Blastoise();
               control = false;
               break;
            default :
               System.out.println("Invalid input. Please enter 1-9 to select the pokemon.");
         } // switch
      } //while
      return pHolder;
   } //makePokemon
}