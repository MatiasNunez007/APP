package modelo;

public class Juego {
    private String nombre;
    private String categoria;
    private int tamanio;
    private double precio;
    private int licenciasDisponibles;
    private int licenciasVendidas;

    public Juego(String nombre, String categoria, int tamanio, double precio, int licenciasDisponibles) {
        setNombre(nombre);
        setCategoria(categoria);
        setTamanio(tamanio);
        setPrecio(precio);
        this.licenciasDisponibles = licenciasDisponibles;
        licenciasVendidas = 0;
    }

    //GETTERS

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getTamanio() {
        return tamanio;
    }

    public double getPrecio() {
        return precio;
    }

    public int getLicenciasDisponibles() {
        return licenciasDisponibles;
    }

    public int getLicenciasVendidas() {
        return licenciasVendidas;
    }

    //SETTERS

    public void setNombre(String nombre) {
        if(nombre != null && !nombre.trim().isEmpty()){
            this.nombre = nombre;
        }
    }

    public void setCategoria(String categoria) {
        if(categoria != null && !categoria.trim().isEmpty()){
            this.categoria = categoria;
        }
    }

    public void setTamanio(int tamanio) {
        if(tamanio > 0){
            this.tamanio = tamanio;
        }

    }

    public void setPrecio(double precio) {
        if(precio > 0){
            this.precio = precio;
        }
    }

    public boolean comprar(int cantidad){
        if(cantidad > 0){
            licenciasDisponibles += cantidad;
            return true;
        }
        return false;
    }

    public boolean vender(int cantidad){
        if(cantidad > 0 && cantidad <= licenciasDisponibles){
            licenciasVendidas += cantidad;
            licenciasDisponibles -= cantidad;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return  "---------------------------------------------------" + '\n' +
                "- Título del juego: " + nombre + '\n' +
                "- Género / Categoría: " + categoria + '\n' +
                "- Peso / Tamaño: " + tamanio + " KB" +'\n' +
                "- Valor unitario: $" + precio + '\n' +
                "- Stock disponible: " + licenciasDisponibles + '\n' +
                "- Unidades vendidas: " + licenciasVendidas + '\n' +
                "---------------------------------------------------";
    }
}