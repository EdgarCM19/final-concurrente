import Jpmi.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Bingo {
    public static boolean lectura(String mg){
        Scanner sc = new Scanner(System.in);
            String valor="";
            boolean resultado=false;
            do{
                
                    System.out.println(mg);
                    valor=sc.nextLine();
                    valor=valor.toUpperCase();
            }while(!valor.equals("Y") && !valor.equals("N"));
            resultado=valor.equals("Y"); 
            return resultado;
    }

    public static void main(String[] args) {
        boolean ciclo=lectura("¿Desea que el programa se ejecute en un ciclo infinito? [Y/N]:");
        CanalSimple jugadorSalida [] = new CanalSimple[10];
        CanalSimple jugadorEntrada [] = new CanalSimple[10];
        Proceso [] procesos = new Proceso[13];
        
        for(int i=0;i<jugadorSalida.length;i++){
            jugadorEntrada[i]=new CanalSimple();
            jugadorSalida[i]=new CanalSimple();
            procesos[i]=new Jugador(i,jugadorSalida[i],jugadorEntrada[i],ciclo);
        }

        CanalSimple admInSorteo  = new CanalSimple();
        CanalSimple admInEscru   = new CanalSimple();
        CanalSimple admOutEscru  = new CanalSimple();
        CanalSimple sorteoOutAdm = new CanalSimple();

        procesos[10] = new Administracion(jugadorSalida, 
                                            sorteoOutAdm,
                                            admOutEscru,
                                            admInEscru,
                                            jugadorEntrada,ciclo);
        procesos[11] = new Sorteo(sorteoOutAdm,ciclo);
        procesos[12] = new Escrutinio(admOutEscru, admInEscru,ciclo);

        System.out.println("--------[INICIA RONDA DEL BINGO]--------");
        new Paralelo(procesos).run();
        
    }

}
