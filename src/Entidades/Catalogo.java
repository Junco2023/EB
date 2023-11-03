
package Entidades;

public class Catalogo {
    int idCatalogo;
    Especie especie;
    String  nombre,var;
    double mac;int stock;
    double precio;
    double peso = 0 ;
    
    public Catalogo(){
    }

    public Catalogo(int idCatalogo, Especie especie, String nombre, String var, double mac, int stock, double precio,double peso) {
        this.idCatalogo = idCatalogo;
        this.especie = especie;
        this.nombre = nombre;
        this.var = var;
        this.mac = mac;
        this.stock = stock;
        this.precio = precio;
        this.peso=peso;
    }

    public Catalogo(Especie especie, String nombre, String var, double mac, int stock, double precio,double peso) {
        this.especie = especie;
        this.nombre = nombre;
        this.var = var;
        this.mac = mac;
        this.stock = stock;
        this.precio = precio;
        this.peso=peso;
    }
    

    public int getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(int idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public double getMac() {
        return mac;
    }

    public void setMac(double mac) {
        this.mac = mac;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    

    @Override
    public String toString() {
        return "Catalogo{" + "idCatalogo=" + idCatalogo + ", especie=" + especie + ", nombre=" + nombre + ", var=" + var + ", mac=" + mac + ", stock=" + stock + ", precio=" + precio + ", peso=" + peso + '}';
    }
    
    //@Override
    public int compareTo(Catalogo t) {
        //cuando use el metodo se va a daterminar el oden de los componenetes
        //SI = drosera primero >0, si = srracenia segundo =0 y si = utriulri 3erlugar <0 
        //Comparamos y filtramos segun la ESPECIE ,dentro del especie ordenmos alf. por nombre,var y n de mac 
        String n =especie+nombre+var+mac;
        String n2=t.especie+t.nombre+t.var+t.mac;
        switch(especie){
            case Brocchinia: if(especie.compareTo(Especie.Brocchinia)>0){ return 1;}//return 1;
            if(n.compareToIgnoreCase(n2)>0){return 1;
               }else if (n.compareTo(n2)==0){return 0;
                  }else return -1;
            
            case Dionaea : if(especie.compareTo(Especie.Dionaea)>0){ return 1;}//return 1;
            if(n.compareToIgnoreCase(n2)>0){return 1;
               }else if (n.compareTo(n2)==0){return 0;
                  }else return -1;
            
            case Drosera : if(especie.compareTo(Especie.Drosera)>0){ return 1;}//return 1;
            if(n.compareToIgnoreCase(n2)>0){return 1;
               }else if (n.compareTo(n2)==0){return 0;
                  }else return -1;
            
            case Nepenthes:if(especie.compareTo(Especie.Nepenthes)>0){ return 1;}//return 1;
            if(n.compareToIgnoreCase(n2)>0){return 1;
               }else if (n.compareTo(n2)==0){return 0;
                  }else return -1;
            
            case Pinguicula:if(especie.compareTo(Especie.Pinguicula)>0){ return 1;}//return 1;
            if(n.compareToIgnoreCase(n2)>0){return 1;
               }else if (n.compareTo(n2)==0){return 0;
                  }else return -1;
            
            case Sarracenia :if(especie.compareTo(Especie.Sarracenia)>0){ return 0;}//return 1;
            if(n.compareToIgnoreCase(n2)>0){return 1;
               }else if (n.compareTo(n2)==0){return 0;
                  }else return -1;
            case Stylidium:if(especie.compareTo(Especie.Stylidium)>0){ return 1;}//return 1;
            if(n.compareToIgnoreCase(n2)>0){return 1;
               }else if (n.compareTo(n2)==0){return 0;
                  }else return -1;
                
            case Utricularia :if(especie.compareTo(Especie.Utricularia)<0){ return -1;}//return 1;
            if(n.compareToIgnoreCase(n2)>0){return 1;
               }else if (n.compareTo(n2)==0){return 0;
                  }else return -1;
                  
        }
    return 0;
    }
    
    

   
}

