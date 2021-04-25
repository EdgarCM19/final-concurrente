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
            n=(int) (rnd.nextDouble() * 21 + 1);
            salida.send(n);
        }
        //se ve?
    }
}
