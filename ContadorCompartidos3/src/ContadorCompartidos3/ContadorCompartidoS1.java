package ContadorCompartidos3;

public class ContadorCompartidoS1 {
	public static void main(String[] args) {
		Contador cont = new Contador();
		ContadorHilo hilo1 = new ContadorHilo("Hilo1", cont);
		ContadorHilo hilo2 = new ContadorHilo("Hilo2", cont);
		ContadorHilo hilo3 = new ContadorHilo("Hilo3", cont);
		ContadorHilo hilo4 = new ContadorHilo("Hilo4", cont);

		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();

		try {
			hilo1.join();
			hilo2.join();
			hilo3.join();
			hilo4.join();
		} catch (InterruptedException ex) {
			System.out.println("Interrupción del hilo...");
		}
		System.out.println("El programa ha terminado");
	}
}

/*
 * Aurreko programa erabiltzea eta mantentzea errazagoa da, sinkronizazio-logika
 * metodo bakar batean zentralizatzen duelako (incContador) kontagailu klasearen
 * barruan. Horrek errore-arriskua murrizten du eta hari bakoitzean synchronized
 * blokeak eskuz maneiatzeko beharra ezabatzen du, bigarren programan gertatzen
 * den bezala.
 * 
 */
