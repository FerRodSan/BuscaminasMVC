package Modelo;

public class Casilla {
	private boolean mina=false;
	private boolean velada=true;
	private boolean marcada=false;
	private int minasAlrededor=0;

	public boolean isMina() {
		return mina;
	}
	void setMina(boolean mina) {
		this.mina = mina;
	}
	protected boolean isVelada() {
		return velada;
	}
	void setVelada(boolean velada) {
		this.velada = velada;
	}
	protected boolean isMarcada() {
		return marcada;
	}
	protected void setMarcada(boolean marcada) {
		this.marcada = marcada;
	}
	int getMinasAlrededor() {
		return minasAlrededor;
	}
	void setMinasAlrededor(int minasAlrededor) {
		this.minasAlrededor = minasAlrededor;
	}
	
}
