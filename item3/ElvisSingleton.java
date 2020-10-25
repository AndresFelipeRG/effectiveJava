
public class ElvisSingleton {


   private String s;

   private ElvisSingleton (String s){
      this.s = s;
   }
   
   public static class ElvisSingletonHolder {
       
       private static final INSTANCE = new ElvisSingleton("name");

   }
   
     public static ElvisSingleton getInstance(){
       
         return ElvisSingletonHolder.INSTANCE;
       
       }
}
