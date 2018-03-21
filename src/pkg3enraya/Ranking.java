package pkg3enraya;

class Ranking {
    
    //Atributes
    
    private int partidasJugadas = 0;
    private String nombre;
    private Session session;
    private int empates = 0;
    private int victorias = 0;

    //Constructor
    
    public Ranking(Jugador player) {
        this.nombre = player.getNombre();
    }
    
    //Public Methods
    
    public void partidasJugadas() {
        this.partidasJugadas++;
    }
    
    public void addTie() {
        this.empates++;
    }
    
    public void addWin() {
        this.victorias++;
    }

    public void showRanking(Jugador player) {
    
        System.out.println(this.nombre + " ha jugado " + this.partidasJugadas + " partidas.");
        System.out.println(this.nombre + " ha ganado " + this.victorias + " partidas.");
        System.out.println(this.nombre + " ha perdido " + (this.partidasJugadas - (this.victorias + this.empates)) + " partidas.");
        System.out.println(this.nombre + " ha empatado " + this.empates + " partidas.");
        System.out.println("");
        
    }
    
    //Private Methods
    
}