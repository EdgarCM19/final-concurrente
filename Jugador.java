import Jpmi.*;

public class Jugador implements Proceso {

    int id;
    CanalSimple entrada;

    public Jugador(int id, CanalSimple entrada){
        this.id = id;
        this.entrada = entrada;
    }

}