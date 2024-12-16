package ContadorCompartidos3;

/*Cada hilo accederá 3 veces al recurso compartido Contador y lo incrementará en
 * 1, durmiendo un tiempo aleatorio en cada iteración*/
public class ContadorHilo extends Thread {
	Contador cont;

	ContadorHilo(String h_nombre, Contador h_cont) {
		super(h_nombre);
		this.cont = h_cont;
	}
	// Método para incrementar el contador
	// En este caso creamos la región crítica en el objeto
	// Al poner synchronized(cont) marcamos cont como ocupado desde que se abren
	// las llaves de después hasta que se cierran.
	// Cuando el segundo hilo intenta también su synchronized(cont), se queda ahí
	// bloqueado, en espera que de que el primero termine con cont.

	public void run() {
		for (int i = 0; i < 3; i++) {
			try {
				synchronized (cont) {
					int a = cont.getContador();
					sleep((long) (Math.random() * 10));
					cont.setContador(a + 1);
					System.out.println(getName() + " - contador: " + cont.getContador());
					sleep((long) (Math.random() * 10));
				}
			} catch (InterruptedException e) {
				System.out.println("Interrupción del hilo...");
			}
		}
		System.out.println("Fin " + getName() + "...");
	}
}