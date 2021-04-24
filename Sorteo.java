import Jpim.*;
import java.util.Random;
public class Sorteo implements Proceso {
    Integer ganador;
    CanalSimple salida;

    public Sorteo(CanalSimple salida){
        this.salida=salida;
    }

    public void run(){
        while(true){
            Random rnd = new Random();
            ganador = (int) rnd.nextInt(20) + 1;
            salida.send(ganador);
        }
    }
}
