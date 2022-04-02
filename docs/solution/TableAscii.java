interface Representation {
  String toString(int i);
}

class Decimal implements Representation {
  public String toString(int i) {  
      return String.valueOf(i);
  }
}

class Binaire implements Representation {
  public String toString(int i) {  
     return Integer.toBinaryString(i);
  }
}

class TableAsciiToHTML {
  private Representation repr;
 
  public TableAsciiToHTML(Representation repr) {
      this.repr = repr;
      printHTML();
  }
 
  private void printHTML() {
    int deb = 32;
    int fin = 256;
    int nbCol = 10;
    int cpt = 0;
    System.out.println("<html><head /><body><center><h1>TABLE DE CARACTERES<h1>");
    System.out.println("<table border=\"1\">");
    System.out.println("<tr>");
    for (int i = deb; i < fin; i++, cpt++) {
      if (cpt%nbCol == 0) {
         if (i>deb)  System.out.println("</tr>");
         System.out.println("<tr>");
      }
      System.out.println("<td align=\"center\"");
      System.out.println("<table border=\"1\"> <tr>");
      System.out.println("<td bgcolor=\"teal\" align=\"center\">");
      
      System.out.println(repr.toString(i));

      System.out.println("</td></tr><tr>");
      System.out.println("<td bgcolor=\"#CC3300\" align=\"center\">");
      System.out.println(" &#" + i + "; </td></tr></table></td>");
    }
    System.out.println("</table></center></body></html>");
  }
  
}

class AppTableAscii {
  public static void main(String[] args) {
     String arg = (args.length>0) ? args[0] : "Decimal";
     try {
         Class c = Class.forName(arg);
         Representation repr = (Representation) c.newInstance();
         TableAsciiToHTML app = new TableAsciiToHTML(repr);
     }
     catch (ClassNotFoundException e) {
       System.out.println("Erreur : " + arg + " n'est pas une classe implémentée.");
     }
     catch (InstantiationException e) {
       System.out.println("Erreur : " + arg + " n'est pas n'est pas du type attendu.");
     }
     catch (IllegalAccessException e) {
       System.out.println("Erreur : " + arg + " n'est pas accessible.");
     }
  }
}
