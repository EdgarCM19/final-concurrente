import Jpmi.*;
import java.util.Random;
public class Sorteo implements Proceso {
    CanalSimple salida;

    public Sorteo(CanalSimple salida){
        this.salida = salida;
    }

    public void run(){
        // while(true)
            Integer ganador = (Integer)(new Random().nextInt(20)) + 1;
            System.out.println("-------[SORTEO]------\n[Sorteo]>El numero ganador es: " + ganador);
            salida.send(ganador);
    }
}
