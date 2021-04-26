import Jpmi.*;
import java.util.Random;
public class Sorteo implements Proceso {
    CanalSimple salida;
    boolean ciclo;

    public Sorteo(CanalSimple salida,boolean ciclo){
        this.salida = salida;
        this.ciclo=ciclo;
    }

    public void run(){
        do{
            Integer ganador = (Integer)(new Random().nextInt(20)) + 1;
            System.out.println("-------[SORTEO]------\n[Sorteo]>El numero ganador es: " + ganador);
            salida.send(ganador);
        }while(ciclo);
    }
}
