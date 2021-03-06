package PT2020.polinom.PolinomProject;
import java.util.*;

public class Operatii {
   private Polinom Pol1;
   private Polinom Pol2;
   private Polinom rez;
 public Operatii (Polinom Pol1, Polinom Pol2, Polinom rez)
 {
	 this.Pol1=Pol1;
	 this.Pol2=Pol2;
	 this.rez=rez;
 }
public Polinom getPol2() {
	return Pol2;
}
public void setPol2(Polinom pol2) {
	Pol2 = pol2;
}
public Polinom getPol1() {
	return Pol1;
}
public void setPol1(Polinom pol1) {
	Pol1 = pol1;
}
public Polinom getRez() {
	return rez;
}
public void setRez(Polinom rez) {
	this.rez = rez;
}
  public void add(Polinom Pol1, Polinom Pol2, Polinom rez)
  {
    ArrayList<Monom> Laux = new ArrayList<Monom>(); 
       if  (Pol1.getPol().get(0).getPow()<=Pol2.getPol().get(0).getPow()) {
    	for (Monom item : Pol1.getPol())
    	{   int suma=Pol1.getPol().get(Pol1.getPol().get(0).getPow()-item.getPow()).getCoef()+Pol2.getPol().get(Pol2.getPol().get(0).getPow()-item.getPow()).getCoef();
    		Laux.add(new Monom (suma,Pol1.getPol().get(Pol1.getPol().get(0).getPow()-item.getPow()).getPow()));
    	}
    	for (int i=Pol2.getPol().get(0).getPow(); i>Pol1.getPol().get(0).getPow(); i--)
    	{
    		Laux.add(new Monom (Pol2.getPol().get(Pol2.getPol().get(0).getPow()-i).getCoef(),Pol2.getPol().get(Pol2.getPol().get(0).getPow()-i).getPow()));
    	}
       }
       else
       {
    	   for (Monom item : Pol2.getPol())
       	{   int suma=Pol2.getPol().get(Pol2.getPol().get(0).getPow()-item.getPow()).getCoef()+Pol1.getPol().get(Pol1.getPol().get(0).getPow()-item.getPow()).getCoef();
       		Laux.add(new Monom (suma,Pol2.getPol().get(Pol2.getPol().get(0).getPow()-item.getPow()).getPow()));
       	}
       	for (int i=Pol1.getPol().get(0).getPow(); i>Pol2.getPol().get(0).getPow(); i--)
       	{
       		Laux.add(new Monom (Pol1.getPol().get(Pol1.getPol().get(0).getPow()-i).getCoef(),Pol1.getPol().get(Pol1.getPol().get(0).getPow()-i).getPow()));
       	}
           }

	rez.setPol(Laux);
  }
  
  public void sub(Polinom Pol1, Polinom Pol2, Polinom rez)
  {
       for (Monom item:Pol2.getPol())
       {
    	   Pol2.getPol().get(item.getPow()).setCoef(-Pol2.getPol().get(item.getPow()).getCoef());
       }
       add(Pol1,Pol2,rez);
       
  }
  
  public void mult(Polinom Pol1, Polinom Pol2, Polinom rez)
  {
    ArrayList<Monom> Laux = new ArrayList<Monom>(); 
    ArrayList<Monom> Laux1 = new ArrayList<Monom>(); 
    for (Monom item:Pol1.getPol())
    {
    	for (Monom item1:Pol2.getPol())
    	{
    		Laux.add(new Monom (item.getCoef()*item1.getCoef(),item.getPow()+item1.getPow()));
    	}
    }
    int pow=Pol1.getPol().get(0).getPow()+Pol2.getPol().get(0).getPow();
    for (int i=pow;i>=0;i--)
    {int sumacoef=0;
    	for (Monom item:Laux)
    	{
    		if (item.getPow()==i)
    		{
    			sumacoef=sumacoef+item.getCoef();
    		}
    	}
    	Laux1.add(new Monom (sumacoef,i));
    }
	rez.setPol(Laux1);
  }
  
  
  public void deriv (Polinom Pol1, Polinom rez)
  {
	  ArrayList<Monom> Laux = new ArrayList<Monom>(); 
	  for (Monom item:Pol1.getPol())
      {
       if (  item.getPow()!=0)
       {
   	      Laux.add(new Monom (item.getCoef()*item.getPow(),item.getPow()-1));
      
  }
      }
		rez.setPol(Laux);
      
  }
  
  public void integrare (Polinom Pol1, Polinom rez)
  {
	  ArrayList<Monom> Laux = new ArrayList<Monom>(); 
	  for (Monom item:Pol1.getPol())
      {
   
   	      Laux.add(new Monom (item.getCoef(),item.getPow()+1));
      
      }
		rez.setPol(Laux);
      
  }
}
