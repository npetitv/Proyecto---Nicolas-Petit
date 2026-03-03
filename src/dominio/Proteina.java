package dominio;

import estructuras.Lista; 

public class Proteina {
    
    private String nombre;
    private Lista<Interaccion> interacciones;

    public Proteina(String nombre) {
        this.nombre = nombre;
        // Inicializamos nuestra lista personalizada vacía
        this.interacciones = new Lista<>(); 
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Lista<Interaccion> getInteracciones() {
        return interacciones;
    }
    
    public void agregarInteraccion(Interaccion interaccion) {
        this.interacciones.agregar(interaccion);
    }
}