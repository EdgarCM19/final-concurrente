public class MsgJugador {

    public int id, dato;
    public boolean ganador;

    public MsgJugador(int id, int dato){
        this.id = id;
        this.dato = dato;
        this.ganador = false;
    }

    public void ganador(){
        this.ganador = true;
    }
}
