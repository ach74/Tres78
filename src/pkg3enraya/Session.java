package pkg3enraya;

import java.util.Scanner;

public class Session {

    //Atributes
    private Partida partida;    //Relacion con partida
    private Jugador jugadorHumano; //Relacion con jugador
    private Jugador jugadorIA; //Relacion con IA
    private Ranking ranking;    //Relacion con ranking
    private final Scanner teclado = new Scanner(System.in);

    public Session() {

    }

    private void crearJugadores() {
        //Crear Jugador
        System.out.println("Escribe tu nombre :");
        String name = teclado.nextLine();
        this.nuevoJugador(name);
        //Crear IA
        this.nuevaIA("IA");
        System.out.println(this.jugadorIA.getNombre() + " VS " + this.jugadorHumano.getNombre() + "\n");
    }
    
    private void menu() {

        //Mostrar Menu
        System.out.println("1. Iniciar una nueva partida.");
        System.out.println("2. Mostrar ranking.");
        System.out.println("3. Salir. \n");
        System.out.println("Elije una opcion: ");
        
        int op;
        
        op = teclado.nextInt();
        
        System.out.println();
        
        switch (op) {
            case 1:
                nuevaPartida(this.jugadorHumano, this.jugadorIA, this.ranking);
                menu();
                break;
            case 2:
                ranking.showRanking(jugadorHumano);
                menu();
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("No ha elegido una opcion posible.");
                menu();
                break;
        }
        
    }
   
    private void nuevaPartida(Jugador jugadorHumano, Jugador jugadorIA, Ranking ranking) {
        this.partida = new Partida(jugadorHumano, jugadorIA, ranking);
    }
    
    private void nuevaIA(String name) {
        this.jugadorIA = new IA0(this, name);
    }
    
    private void nuevoJugador(String name) {
        this.jugadorHumano = new Jugador(this, name);
    }

    private void nuevoRanking() {
        this.ranking = new Ranking(this.jugadorHumano);
    }


    public static void main(String[] args) {
        
        Session S = new Session();

        S.crearJugadores();

        S.nuevoRanking();

        S.menu();
    }
 
}
