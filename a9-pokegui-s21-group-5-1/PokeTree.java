import java.util.Scanner;

/** Binary search tree for pokemon.
* @author Trey Yasunaga from Lisa Miller
* @since 05/03/2021
*/
public class PokeTree {
   /** root node.*/
   private PokeNode root = null;
   /** Constructor just initializes tree.*/
   public PokeTree() {
   }
   /**Gets the root of tree. Only exists because 
   *  I can't figure out another way to test the tree constructor.
   * @return returns root of the tree.*/
   public PokeNode getRoot() {
      return this.root; 
   }
   /** public wrapper for recurrsive add method.
   * @param p is Pokemon to be added.*/
   public void add(Pokemon p) {
      root = add(root, p);
   }
   /** private recurrsive add method.
   * @param node is the root of the tree/subtree.
   * @param p Pokemon to be added.
   * @return returns the current node */
   private PokeNode add(PokeNode node, Pokemon p) {
      if (node == null) {
         return new PokeNode(p, 1, null, null);
      } else if (node.getKey() == p.getNumber()) {
         node.increaseNumCaught();
         return node;
      } else if (p.getNumber() < node.getKey()) {
         node.setLChild(add(node.getLChild(), p));
         return node;
      } else {
         node.setRChild(add(node.getRChild(), p));
         return node;
      }
   }
   /** public wrapper get for private recurrsive get.
   * @param searchKey is the Pokemon that it is trying to get.
   * @return returns the Pokemon if it exists.*/
   public Pokemon get(Pokemon searchKey) {
      return get(root, searchKey);
   }
   /** private recurrsive get.
   * @param node root of tree/subtree.
   * @param searchKey the thing it is looking for.
   * @return returns the Pokemon if found.
   * @throws PokeTreeException if Pokemon was not found.*/
   private Pokemon get(PokeNode node, Pokemon searchKey) {
      if (node == null) {
         throw new PokeTreeException("Pokemon Not Found");
      } else {
         if (searchKey.getNumber() == node.getKey()) {
            return node.getPokemon();
         } else if (searchKey.getNumber() < node.getKey()) {
            return this.get(node.getLChild(), searchKey);
         } else {
            return this.get(node.getRChild(), searchKey); 
         }
      }
   }
   /** public wrapper method for recurrsive printPokeTree.*/
   public String printPokeTree() {
      return printPokeTree(root);
   }
   /** private recurrsive print that prints the tree in order.
   * @param node is root of tree/subtree.*/
   private String printPokeTree(PokeNode node) {
      String s = "";
      if (node != null) {
         return printPokeTree(node.getLChild()) + node.getPokemon().toString() + "\nCaught: " 
             + node.getNumCaught() + "\n"
            + printPokeTree(node.getRChild());
      }
      //System.out.println(s);
      return s;
   }
   /** public wrapper for private recurrsive remove method.
   * @param p is the Pokemon to be removed.*/
   public void remove(Pokemon p) {
      root = this.remove(root, p);
   }
   /** private recurrsive remove method that finds the correct node.
   * @param node is the root of tree/subtree.
   * @param p is the Pokemon to be removed.
   * @throws PokeTreeException if it can't find p.
   * @return returns the node holding the Pokemon. */
   private PokeNode remove(PokeNode node, Pokemon p) {
      if (node == null) {
         throw new PokeTreeException("Item not found");
      } else if (p.getNumber() < node.getKey()) {
         node.setLChild(this.remove(node.getLChild(), p));
         return node;
      } else if (p.getNumber() > node.getKey()) {
         node.setRChild(this.remove(node.getRChild(), p));
         return node;
      } else {
         if (node.getNumCaught() == 1) {
            node = this.remove(node);
            return node;
         } else {
            node.decreaseNumCaught();
            return node;
         }
      }
   }
   /** helper remove method that deletes the node and handles the reordring of the child nodes.
   * @param node is the node to be removed.
   * @return returns the node that replaces the removed node or null*/
   private PokeNode remove(PokeNode node) {
      if (node.getLChild() == null && node.getRChild() == null) {
         return null;
      } else if (node.getLChild() == null) {
         return node.getRChild();
      } else if (node.getRChild() == null) {
         return node.getLChild();
      } else {
         Pokemon pTemp = this.getItemWithLargestSearchKey(node.getLChild());
         node.setPokemon(pTemp);
         node.setLChild(this.removeNodeWithLargestSearchKey(node.getLChild()));
         return node;
      }
   }
   /** Helper method for removing nodes. Finds larges item in subtree.
   * @param node root of the tree/subtree.
   * @return returns the Pokemon with largest key.*/
   private Pokemon getItemWithLargestSearchKey(PokeNode node) {
      if (node.getRChild() == null) {
         return node.getPokemon();
      } else {
         return this.getItemWithLargestSearchKey(node.getRChild());
      }
   }
   /** Helper method to remove nodes. Removes node iwth largest key.
   * @param node the root of tree/subtree.
   * @return PokeNode the root of the tree of the removed node.*/
   private PokeNode removeNodeWithLargestSearchKey(PokeNode node) {
      if (node.getRChild() == null) {
         return node.getLChild();
      } else {
         node.setRChild(this.removeNodeWithLargestSearchKey(node.getRChild()));
         return node;
      }
   }
   /**Driver to test the binary search tree.
   * @param args not used.*/
   public static void main(String[] args) {
      PokeTree tree = new PokeTree();
      //tree.add(new Bulbasaur());
      for (int i = 0; i < 18; i++) {
         tree.add(new Charmeleon());
         tree.add(new Charmander());
         tree.add(new Ivysaur());
         tree.add(new Wartortle());
         tree.add(new Squirtle());
         tree.add(new Venusaur());
         tree.add(new Bulbasaur());
         tree.add(new Charizard());
         tree.add(new Blastoise());
         System.out.println("wow");
      }
      Scanner userIn = new Scanner(System.in);
      tree.remove(new Squirtle());
      tree.printPokeTree();
   }
   
} //class