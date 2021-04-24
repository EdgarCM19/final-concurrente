import Jpmi.*;
import java.util.Random;

public class Jugador implements Proceso {

    int id;
    CanalSimple salida, entrada;
    MsgJugador msg;

    public Jugador(int id, CanalSimple salida,CanalSimple entrada){
        this.id = id;
        this.salida=salida;
        this.entrada = entrada;
    }
    public void run(){
        Random rnd = new Random();
        int n=0;
        while(true){
            n=(int) rnd.nextInt(20) + 1;
            msg=new MsgJugador(id,n);
            salida.send(msg);
            msg=(MsgJugador)entrada.receive();
            // String cad = ;
            System.out.println("[Jugador "+id+"]:>" + 
                    ((msg.ganador ) ? "Yeii Gane !!!" : "F.. Perdi !!!"));
        }
    }

}
