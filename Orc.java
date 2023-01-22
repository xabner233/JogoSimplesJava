package com.abner.game.personagem;

public class Orc extends Personagem  {

	public Orc(int vida, int ataque, int defesa, int velocidade, String nome) {
		super(vida, ataque, defesa, velocidade, nome);
		
	}
	
	public void especialOrc() {
		this.setDefesa(getDefesa()+20);
		this.setVida(getVida()+10);
		
	}

}
