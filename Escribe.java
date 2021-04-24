import Jpmi.*;
public class Escribe implements Proceso {
 	CanalSimple canal_out;
 	MsgJugador msg;

 	public Escribe(CanalSimple canal_out, MsgJugador msg) {
		this.canal_out = canal_out;
		this.msg = msg;
 	}

 	public void run() {
		canal_out.send(msg);
  	}
}
