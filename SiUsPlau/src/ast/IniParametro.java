package ast;
import java.util.List;
import asem.TablaAmbitos;

public class IniParametro extends E {
   private E d, sig;
   public IniParametro(E dato, E parametro) {
    	d=dato;  
	   sig=parametro;
   }     

   public TipoE tipo() {return TipoE.PARAMETRO;}
   public String toString() {return "parametros("+d.toString()+sig.toString()+")";}
   
   public void vincula(TablaAmbitos T) {
	   d.vincula(T);
	   sig.vincula(T); 
   }
   
   public void chequea() throws Exception{
      d.chequea();
      sig.chequea();
      this.tipo = d.tipo;
   }
   public E getSig(){
		return sig;
	}
   
   public String codigo(List<String> lista) {
	   return d.codigo(lista) + sig.codigo(lista);
   }
}
