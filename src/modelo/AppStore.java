package modelo;

public class AppStore {
    private static final int MAX=4;
    private Juego juegos[];
    private int indice;

    public AppStore(){
        juegos = new Juego[MAX];
        indice = -1;
        //inicializarDatos(); -> Para precargar datos al arrancar el programa
    }

    public void inicializarDatos(){
        agregarJuego(new Juego("FIFA2026", "Deportes", 10, 70, 50));
        agregarJuego(new Juego("Roblox", "Acción", 60, 75, 60));
    }
    public boolean estaLlena() {
        return indice >= MAX - 1;
    }

    public Juego[] getJuegos() {
        return juegos;
    }

    public boolean agregarJuego(Juego j){
        if(j != null && indice < MAX-1){
            juegos[++indice]= j;
            return true;
        }
        return false;
    }

    public Juego buscarJuego(String nombre){
        if(nombre != null && !nombre.trim().isEmpty()){
            for(int i =0; i <= indice; i++){
                if(juegos[i].getNombre().equalsIgnoreCase(nombre)){
                    return juegos[i];
                }
            }
            return null;
        }
        return null;

    }

    public boolean comprar(String nombre, int cantidad){
        Juego j = buscarJuego(nombre);
        if(j != null){
            return j.comprar(cantidad);
        }
        return false;
    }
    public double vender(String nombre, int cantidad){
        Juego j = buscarJuego(nombre);
        if(j != null){
            if(j.vender(cantidad)){
                return j.getPrecio()*cantidad;

            }
            return 0;
        }
        return 0;

    }

    public String juegoMasVendido() {
        String nombre = "";
        int mayor = 0;
        for (int i = 0; i <= indice; i++) {
            if (juegos[i].getLicenciasVendidas() > mayor) {
                mayor = juegos[i].getLicenciasVendidas();
                nombre = juegos[i].getNombre();
            }
        }
        return nombre;
    }

}