
package Entidades;
import Entidades.Catalogo;

public enum Especie {
    Brocchinia,
    Dionaea,
    Drosera,
    Nepenthes,
    Pinguicula,
    Sarracenia,
    Stylidium,
    Utricularia;
    
    public  int compareTo(Catalogo s1,Catalogo s2){
         return (s1.getEspecie()+s1.getNombre()+s1.getVar()).compareToIgnoreCase((s2.getEspecie()+s2.getNombre()+s2.getVar()));
    }

   
    
}
