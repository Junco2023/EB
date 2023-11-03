
package Entidades;


public class Cliente {
    int idCliente;
    String nombre,apellido,localidad,provincia,direccion,cp;int dni,telefono;

    public Cliente() {
    }

    public Cliente(int idCliente, String nombre, String apellido, String localidad, String provincia, String direccion, String cp, int dni, int telefono) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.localidad = localidad;
        this.provincia = provincia;
        this.direccion = direccion;
        this.cp = cp;
        this.dni = dni;
        this.telefono = telefono;
    }

    public Cliente(String nombre, String apellido, String localidad, String provincia, String direccion, String cp, int dni, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.localidad = localidad;
        this.provincia = provincia;
        this.direccion = direccion;
        this.cp = cp;
        this.dni = dni;
        this.telefono = telefono;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", localidad=" + localidad + ", provincia=" + provincia + ", direccion=" + direccion + ", cp=" + cp + ", dni=" + dni + ", telefono=" + telefono + '}';
    }
    
}
