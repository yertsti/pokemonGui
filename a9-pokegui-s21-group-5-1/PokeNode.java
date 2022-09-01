/**
* Pokemon node class.
* @author Trey Yasunaga
* @since 04/22/2021
*/

public class PokeNode {
   /**The Pokemon inside the node.*/
   private Pokemon data;
   /**The nodes left child.*/
   private PokeNode lChild;
   /** The nodes right child.*/
   private PokeNode rChild;
   /** The number caught inside node.
    Gets incremented when duplicate Pokemon is added in the tree.*/
   private int numberCaught;
   
   /**Constructor.
   * @param p is the Pokemon to be stored in the node.
   * @param numCaught is the counter for how many duplicates of this pokemon are in the tree.
   * @param newLChild is the nodes left child.
   * @param newRChild is the nodes right child.
   * @throws PokeNodeException if pokemon is null or if numCaught is < 1.
   */
   public PokeNode(Pokemon p, int numCaught, PokeNode newLChild, PokeNode newRChild) {
      if (p == null) {
         throw new PokeNodeException("Pokemon cannot be null");
      }
      if (numCaught < 1) {
         throw new PokeNodeException("Number caught cannot be < 1");
      }
      data = p;
      lChild = newLChild;
      rChild = newRChild;
      numberCaught = numCaught;
   }
   /**Gets the Pokemon in node.
   * @return returns the pokemon.*/
   public Pokemon getPokemon() {
      return this.data;
   }
   /**Gets the key to sort the node.
   * @return returns the sort key.*/
   public int getKey() {
      return this.data.getNumber();
   }
   /**Gets the amount caught.
   * @return returns the number caught.*/
   public int getNumCaught() {
      return this.numberCaught;
   }
   /**Gets the nodes left child.
   * @return returns the left child.*/
   public PokeNode getLChild() {
      return this.lChild;
   }
   /**Gets the nodes right child.
   * @return returns the right child.*/
   public PokeNode getRChild() {
      return this.rChild;
   }
   /** Increments number caught by 1.*/
   public void increaseNumCaught() {
      numberCaught++;
   }
   /** Decrements number caught by 1.
   * @throws PokeNodeException if numberCaught goes below 1.*/
   public void decreaseNumCaught() throws PokeNodeException {
      numberCaught--;
      if (numberCaught < 1) {
         throw new PokeNodeException("Number Caught cannot be reduced to 0");
      }
      
   }
   /** Sets nodes left child.
   * @param newLChild is the new left child.*/
   public void setLChild(PokeNode newLChild) {
      this.lChild = newLChild;
   }
   /** Sets nodes right child.
   * @param newRChild is the new right child.*/
   public void setRChild(PokeNode newRChild) {
      this.rChild = newRChild;
   }
   /** Sets the nodes Pokemon.
   * @param newPokemon is the new Pokemon*/
   public void setPokemon(Pokemon newPokemon) {
      this.data = newPokemon;
   }
   /** toString method for the node.
   * @return returns the data's toString method.*/
   public String toString() {
      return this.data.toString();
   }
   /** driver for PokeNode.
   * @param args not used.*/
   public static void main(String[] args) {
      Pokemon p = new Bulbasaur();
      PokeNode node3 = new PokeNode(new Squirtle(), 1, null, null);
      PokeNode node2 = new PokeNode(new Charizard(), 5, null, null);
      PokeNode node1 = new PokeNode(p, 2, node2, node3);
      System.out.println(node1.getPokemon());
      System.out.println(node1.getKey());
      System.out.println(node1.getLChild());
      System.out.println(node1.getLChild().getNumCaught());
   }
}