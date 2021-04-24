import Jpmi.*;

public class Escrutinio implements Proceso {
    
    public CanalSimple entrada, salida;

    public Escrutinio(CanalSimple entrada, CanalSimple salida){
        MsgAdm msg = (MsgAdm)entrada.receive();
        for(int i = 0; i < msg.jugadores.lenght; i++){
            
        }
    }

}
