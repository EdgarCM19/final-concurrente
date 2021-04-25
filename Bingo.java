import Jpmi.*;

public class Bingo {

    public static void main(String[] args) {
        CanalSimple jugadorSalida [] = new CanalSimple[10];
        CanalSimple jugadorEntrada [] = new CanalSimple[10];
        Proceso [] procesos = new Proceso[13];
        
        for(int i=0;i<jugadorSalida.length;i++){
            jugadorEntrada[i]=new CanalSimple();
            jugadorSalida[i]=new CanalSimple();
            procesos[i]=new Jugador(i,jugadorSalida[i],jugadorEntrada[i]);
        }

        CanalSimple admInSorteo  = new CanalSimple();
        CanalSimple admInEscru   = new CanalSimple();
        CanalSimple admOutEscru  = new CanalSimple();
        CanalSimple sorteoOutAdm = new CanalSimple();

        procesos[10] = new Administracion(jugadorSalida, 
                                            sorteoOutAdm,
                                            admOutEscru,
                                            admInEscru,
                                            jugadorEntrada);
        procesos[11] = new Sorteo(sorteoOutAdm);
        procesos[12] = new Escrutinio(admOutEscru, admInEscru);

        System.out.println("--------[INICIA RONDA DEL BINGO]--------");
        new Paralelo(procesos).run();
        
    }

}
