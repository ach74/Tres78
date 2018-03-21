package pkg3enraya;

public class IA0 extends Jugador {
    
    //Atributes
    
    //Constructor
    
    public IA0(Session session, String name) {
        
        super(session, name);
        
    }
    
    //Public Methods

    public int[] move(Panel panel) {
        //Crear Array con coordenadas
        int coordinates[] = new int[2];
        coordinates[0] = 0;
        coordinates[1] = 0;
        //Buscar primera celda vacia
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) { 
                if (panel.checkMove(row, col)== true) {
                    //Igualar la Array a las coordenadas de la primera casilla libre
                    coordinates[0] = row;
                    coordinates[1] = col;
                    //Devolvemos la array con las cordenadas
                    return coordinates;
                }
            }
        }
        //En caso de que no encuentre ninguna devolvera la primera celda del tablero
        return coordinates;
    }
    
    //Private Methods
    
}