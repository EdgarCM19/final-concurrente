import Jpmi.*;

public class Administracion implements Proceso{
    public CanalSimple  canal_in[];
    public CanalSimple  in_sorteo;
    public CanalSimple  out_escru;
    public CanalSimple  in_escru;
    public CanalSimple  canal_out[];
    public MsgJugador [] jugadores;
    public Integer num;
    public boolean ciclo;
    
    public Administracion(CanalSimple  canal_in[],
                            CanalSimple  in_sorteo,
                            CanalSimple  out_escru,
                            CanalSimple  in_escru,
                            CanalSimple  canal_out[],
                            boolean ciclo){

        this.canal_in   = canal_in;
        this.in_sorteo  = in_sorteo;
        this.out_escru  = out_escru;
        this.in_escru   = in_escru;
        this.canal_out  = canal_out;
        this.ciclo=ciclo;
    }
    public void run(){
        Lee[] l = new Lee[canal_in.length];
        Escribe[] e = new Escribe[canal_out.length];
        
        do{
            System.out.println("--------[JUGADORES ELIGIENDO NUMEROS]--------");
            for(int i = 0; i < l.length; i++)
                l[i] = new Lee(canal_in[i]);
            new Paralelo(l).run();
            System.out.println("--------[ADMINISTRACION RECIBIO TODOS LOS NUMEROS]--------");
            jugadores = new MsgJugador[l.length];
            for(int i = 0; i < l.length; i++)
                jugadores[i] = l[i].getMsg();
            num = (Integer)in_sorteo.receive();
            System.out.println("[Administracion]>Se recibio de sorteo el numero ganador");
            out_escru.send(new MsgAdm(jugadores, num));
            MsgAdm respuesta = (MsgAdm)in_escru.receive();
            System.out.println("--------[ADMINISTRACION ENVIANDO RESULTADOS]--------");
            for(int i = 0; i < e.length; i++){
                e[i] = new Escribe(canal_out[i], respuesta.jugadores[i]);
            }
            new Paralelo(e).run();
        }while(ciclo);
    }
    
}
