package pkg3enraya;

public class Partida {

    //Atributes
    private Jugador jugador;
    private Panel panel;
    private Jugador jugadores[] = new Jugador[2];

    //Constructor
    public Partida(Jugador jugadorHumano, Jugador jugadorIA, Ranking ranking) {
        System.out.println("Partida creada\n");

        añadirJugador(jugadorHumano);

        añadirJugador(jugadorIA);

        ranking.partidasJugadas();

        nuevoTablero();
        //Se sortea quien empieza la partida       
        setJugador(sorteo(jugadores[0], jugadores[1]));

        //Se inicia la partida
        this.gameManagement(ranking);
    }

    private boolean añadirJugador(Jugador jugador) {

        for (int pos = 0; pos < 2; pos++) {

            if (this.jugadores[pos] == null) {

                this.jugadores[pos] = jugador;

                System.out.println(jugadores[pos].getNombre() + " se ha unido a la partida.");

                return true;
            }
        }
        return false;
    }

    private Jugador sorteo(Jugador jugadorHumano, Jugador jugadorIA) {
        int sorteo = (int) (Math.random() * 2);
        if (sorteo == 0) {
            jugadorHumano.setFicha('X');
            jugadorIA.setFicha('O');
            System.out.println("Va a empezar : " + jugadorHumano.getNombre());
            return jugadorHumano;
        } else if (sorteo == 1) {
            jugadorHumano.setFicha('O');
            jugadorIA.setFicha('X');
            System.out.println("Va a empezar : " + jugadorIA.getNombre());
            return jugadorIA;
        }
        return null;
    }

    private void gameManagement(Ranking ranking) {
        //Array con corrdenadas del movimiento a ejecutar
        int coordinates[] = new int[2];
        //Manejar Turnos
        boolean endGame = false;
        for (int turn = 0; endGame == false; turn++) {
            //Anunciar Turno
            System.out.println("Se iniciara el turno " + (turn + 1) + ".");
            System.out.println("");
            //Mostrar Tablero        
            this.panel.showPanel();
            //Pedir Movimiento a Jugador
            if (jugador instanceof IA0) {
                coordinates = ((IA0) this.jugador).move(this.panel);
            } else {
                coordinates = this.jugador.move();
            }
            //Anunciar Movimiento del jugador
            System.out.println(this.jugador.getNombre() + " mueve a: " + coordinates[0] + " " + coordinates[1]);
            System.out.println("");
            //Si el movimiento es valido
            if (this.panel.checkMove(coordinates[0], coordinates[1]) == true) {
                //Ejecutarlo
                this.panel.setCell(coordinates[0], coordinates[1], this.jugador.getToken());
                //Comprobar victoria
                if (this.panel.checkWin() == true) {
                    System.out.println(this.jugador.getNombre() + " ha ganado la partida.");
                    System.out.println("");
                    endGame = true;
                    break;
                }
                if (this.panel.checkTie() == true) {
                    System.out.println("Se ha producido un empate.");
                    System.out.println("");
                    endGame = true;
                    break;
                }
            } //Si el movimiento no es valido
            else {
                System.out.println(this.jugador.getNombre() + " ha perdido la partida.");
                endGame = true;
                break;
            }
            //Cambiar jugador
            switchPlayer();
            //Mostrar Tablero        
            this.panel.showPanel();
        }
    }

    private void nuevoTablero() {
        this.panel = new Panel();
    }

    private void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    private void switchPlayer() {
        if (this.jugador == jugadores[0]) {
            this.jugador = jugadores[1];
        } else {
            this.jugador = jugadores[0];
        }
    }

    private void updateRanking(Ranking ranking, Boolean tie) {
        //Sumar Victoria
        if (!(jugador instanceof IA0) && tie == false) {
            ranking.addWin();
        }
        //Sumar Empate 
        if (tie == true) {
            ranking.addTie();
        }
    }
}
