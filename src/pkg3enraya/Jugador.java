package pkg3enraya;

import java.util.Scanner;

public class Jugador {
    
    private String name;
    private Session session;
    
    private Scanner teclado = new Scanner(System.in);
    
    private char ficha;

    public Jugador(Session session, String nombre) {
        this.session = session;
        this.name = nombre;  
    }
      
    public String getNombre() {
        return this.name;
    }
    
    public char getToken() {
        return this.ficha;
    }
    
    public int[] move() {   
        int posiciones[] = new int[2];
        //Preguntar fila
        System.out.println("Fila :");
        posiciones[0] = teclado.nextInt();
        System.out.println("");
        //Preguntar columna
        System.out.println("Columna :");
        posiciones[1] = teclado.nextInt();
        return posiciones;
    }
    
    public void setFicha(char ficha) {
        this.ficha = ficha;
    }
}