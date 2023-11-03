
package Entidades;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {
    private int idPedido;
    private LocalDate fecha;
    private Cliente cliente;
    private ArrayList <Catalogo> cat ;
    private Catalogo catalogo;
    private String MetodoDePago,entrega,empresa,opcion;
    String seguimiento;
    private LocalDate despacho;
    private LocalDate recibido;
    String tel;
    boolean pago;
    String anotaciones;

    public Pedido() {
    }

    public Pedido(LocalDate fecha, Cliente cliente, ArrayList<Catalogo> cat, String MetodoDePago, String entrega, String empresa, String opcion, String seguimiento, LocalDate despacho, LocalDate recibido, String tel, boolean pago, String anotaciones) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.cat = cat;
        this.MetodoDePago = MetodoDePago;
        this.entrega = entrega;
        this.empresa = empresa;
        this.opcion = opcion;
        this.seguimiento = seguimiento;
        this.despacho = despacho;
        this.recibido = recibido;
        this.tel = tel;
        this.pago = pago;
        this.anotaciones = anotaciones;
    }

    public Pedido(int idPedido,LocalDate fecha,Cliente cliente, Catalogo catalogo, String MetodoDePago, String entrega, String empresa,String opcion, String seguimiento, LocalDate despacho, LocalDate recibido,String tel ,boolean pago, String anotaciones) {
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.cliente = cliente;
        this.catalogo = catalogo;
        this.MetodoDePago = MetodoDePago;
        this.entrega = entrega;
        this.empresa = empresa;
        this.opcion=opcion;
        this.seguimiento = seguimiento;
        this.despacho = despacho;
        this.recibido = recibido;
        this.tel=tel;
        this.pago=pago;
        this.anotaciones = anotaciones;
    }

    public Pedido(LocalDate fecha,Cliente cliente, Catalogo catalogo, String MetodoDePago, String entrega, String empresa,String opcion, String seguimiento, LocalDate despacho, LocalDate recibido,String tel ,boolean pago, String anotaciones) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.catalogo = catalogo;
        this.MetodoDePago = MetodoDePago;
        this.entrega = entrega;
        this.empresa = empresa;
        this.opcion=opcion;
        this.seguimiento = seguimiento;
        this.despacho = despacho;
        this.recibido = recibido;
        this.tel=tel;
        this.pago=pago;
        this.anotaciones = anotaciones;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Catalogo> getCat() {
        return cat;
    }

    public void setCat(ArrayList<Catalogo> cat) {
        this.cat = cat;
    }
    
    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }
    public String getMetodoDePago() {
        return MetodoDePago;
    }

    public void setMetodoDePago(String MetodoDePago) {
        this.MetodoDePago = MetodoDePago;
    }

    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public String getSeguimiento() {
        return seguimiento;
    }

    public void setSeguimiento(String seguimiento) {
        this.seguimiento = seguimiento;
    }

    public LocalDate getDespacho() {
        return despacho;
    }

    public void setDespacho(LocalDate despacho) {
        this.despacho = despacho;
    }

    public LocalDate getRecibido() {
        return recibido;
    }

    public void setRecibido(LocalDate recibido) {
        this.recibido = recibido;
    }
    public String getTel(){
        return tel;
    }
    public void setTel(String tel){
        this.tel=tel;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public String getAnotaciones() {
        return anotaciones;
    }

    public void setAnotaciones(String anotaciones) {
        this.anotaciones = anotaciones;
    }
 
    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", fecha=" + fecha + ", catalogo=" + catalogo + ", cliente=" + cliente + ", MetodoDePago=" + MetodoDePago + ", entrega=" + entrega + ", empresa=" + empresa + ", seguimiento=" + seguimiento + ", despacho=" + despacho + ", recibido=" + recibido + ", anotaciones=" + anotaciones + '}';
    }
    
    
    
}
