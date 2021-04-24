import Jpim.*;
import java.util.Random;
public class Sorteo implements Proceso {
    CanalSimple salida;

    public Sorteo(CanalSimple salida){
        this.salida = salida;
    }

    public void run(){
        while(true)
            salida.send((Integer)(new Random().nextInt(20)) + 1);
    }
}
