class Compte {
  private IFCompte compte;
  
  public Compte(String typeCompte) throws Exception {
     Class c = Class.forName(typeCompte);
     this.compte = (IFCompte) c.newInstance();
  }
  
  public void deposer (float montant){
     this.compte.deposer(montant);
  }
}

interface IFCompte {
  void deposer(float montant);
}

class CompteEpargne implements IFCompte {
  public void deposer(float montant){
    System.out.println();
    System.out.println("Montant déposé sur le compte épargne : " + montant);
    System.out.println();
    System.out.println();
  }
}  
 
class CompteCheque implements IFCompte {
  public void deposer(float montant){
    System.out.println();
    System.out.println("Montant déposé sur le compte chèque : " + montant);
    System.out.println();
    System.out.println();
  }
}


