import Jpmi.*;

public class Jugador implements Proceso {

    int id;
    CanalSimple entrada;
//hello Edgar
    public Jugador(int id, CanalSimple entrada){
        this.id = id;
        this.entrada = entrada;
    }

}
