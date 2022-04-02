public class App{

static public void main(String[] args){
 try {
   Compte c = new Compte(args[0]);
   c.deposer(300);
 }
 catch(Exception e) {
   System.out.println("Problème : " + e.getMessage());
 }
}

}
