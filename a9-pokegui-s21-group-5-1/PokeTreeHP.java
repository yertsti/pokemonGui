/**
 * Binary search tree for Pokemon.
 * 
 * @author Ken Seekins, Lisa Miller from William McDaniel Albritton
 * @since 4/23/2021
 */
public class PokeTreeHP {

  /** Root node instance variable. */
   private PokeNode root = null;

  /** No parameter constructor. */
   public PokeTreeHP() {
      // root already initialized
   }

  /**
   * Adds an item to the tree.
   * Non-recursive wrapper method
   * 
   * @param poke Pokemon to be added
   */
   public void add(Pokemon poke) {
   
   // calls a recursive, private method
   // cannot get direct access to the root outside the class
      root = add(root, poke);
   }
  
  /**
   * Recusively adds an item to the tree.
   * 
   * @param node The root of the tree/subtree
   * @param poke1 The Pokemon to be added
   * @return Pokenode The current node
   */
   private PokeNode add(PokeNode node, Pokemon poke1) {
   // base case: empty tree or end of a leaf
      if (node == null) {
      
         return new PokeNode(poke1, 1, null, null);
         
         
      }
      // same species. Just increase the counter on the node by 1. No new node. 
      else if (0 == poke1.getCP() - node.getPokemon().getCP()) {
         node.increaseNumCaught();
         return node;
      
      }
      // recursive case: if item is less than current node
      // then move to left child node
      else if (0 < poke1.getCP() - node.getPokemon().getCP()) {
      // set the node's left child to the
      // left subtree with item added
         node.setLChild(this.add(node.getLChild(), poke1));
         return node;
      }
      // recursive case: if item is greater than current node
      // then traverse to right child node
      else {
      // set the node's right child to the
      // right subtree with item added
         node.setRChild(this.add(node.getRChild(), poke1));
         return node;
      }
   }

  /**
   * called automatically by println/print method.
   * 
   * @return an inorder String of the tree
   */
   public String toString() {
      return this.inOrder(root);
   }

  /**
   * inOrder display of nodes, with newline between each node.
   * 
   * @param node The root of the tree/subtree
   * @return an inorder String of the tree
   */
   private String inOrder(PokeNode node) {
      String displayNodes = "";
      if (node != null) {
         displayNodes = displayNodes 
            + this.inOrder(node.getLChild());
         displayNodes = displayNodes + node.toString() + "\n";
         displayNodes = displayNodes 
            + this.inOrder(node.getRChild());
      }
      return displayNodes;
   }

} // end of class
 