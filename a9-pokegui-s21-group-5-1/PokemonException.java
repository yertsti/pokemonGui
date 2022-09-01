/**
* Pokemon exception class.
* @author Kenneth Seekins
* @since 3/30/2021
*/
public class PokemonException extends RuntimeException {
   /** Invoking superclass.
   *
   */
   public PokemonException() {
   
      super();
   
   } // closes exception  
   
   /**constructor with message.
   * @param message error message
   */
   public PokemonException(String message) {
   
      super(message);
      
   }
   
   
} //closes class