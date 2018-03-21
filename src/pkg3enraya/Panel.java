package pkg3enraya;

public class Panel {

    //Atributes
    private char cell[][] = new char[3][3];

    //Constructor
    public Panel() {
        //Dar valores a las celdas
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                cell[row][col] = ' ';
            }
        }
    }

    //Public Methods
    public boolean checkMove(int row, int col) {
        //Comprobar que la casilla existe
        if (row > 2 || row < 0 || col > 2 || col < 0) {
            //Devolvemos False para denegar el movimiento
            return false; //End  
        }
        //Comprobar que la casilla deseada este vacia
        if (this.cell[row][col] != ' ') {
            //Devolvemos False para denegar el movimiento
            return false; //End  
        }
        //Devolver True para permitir el movimiento.
        return true;
    }
    
    public boolean checkTie() {
        //Comprueba si todas las casillas estan llenas
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (cell[row][col] == ' ') {
                    //Devuelve False si no hay empate
                    return false; // End
                }
            }
        }
        //Devuelve True si hay empate
        return true;
    }
    
    public boolean checkWin() {
        //Comprueba si hay una victoria horizontal
        for (int row = 0; row < cell.length; row++) {
            if (cell[row][0] == cell[row][1] && cell[row][1] == cell[row][2] && cell[row][0] != ' ') {
                //Devuelve verdadero por que hay una victoria
                return true;
            }
        }
        //Comprueba si hay una victoria vertical
        for (int col = 0; col < cell.length; col++) {
            if (cell[0][col] == cell[1][col] && cell[1][col] == cell[2][col] && cell[0][col] != ' ') {
                //Devuelve verdadero por que hay una victoria
                return true;
            }
        }
        //Comprueba si hay una vistoria diagonal (de izquierda arriba a derecha abajo)
        if (cell[0][0] == cell[1][1] && cell[1][1] == cell[2][2] && cell[0][0] != ' ') {
            //Devuelve verdadero por que hay una victoria
            return true;
        }
        //Comprueba si hay una victoria diagonal (de derecha arriba a izquierda abajo)
        if (cell[0][2] == cell[1][1] && cell[1][1] == cell[2][0] && cell[0][2] != ' ') {
            //Devuelve verdadero por que hay una victoria
            return true;
        }
        //Devuelve Falso por que no hay ninguna victoria
        return false;
    }
    
    public void setCell(int row, int col, char value) {
        //Ejecutar el movimiento
        this.cell[row][col] = value;
    }
    
    public void showPanel() {
        //Imprimir encabezado
        System.out.print("      [0]  [1]  [2] ");
        System.out.println("");
        //Imprimir contenido de las celdas y guia lateral
        for (int row = 0; row < 3; row++) {
            System.out.print(" [" + row + "] ");
            for (int col = 0; col < 3; col++) {
                System.out.print(" [" + this.cell[row][col] + "] ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    //Private Methods
}
