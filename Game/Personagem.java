package com.abner.game.personagem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.print.attribute.standard.OutputDeviceAssigned;

public class Personagem {

	private int vida;
	private int ataque;
	private int defesa;
	private int velocidade;
	private String nome;
	private ArrayList<Artefato> artefato;
	private final String PATH = "C:\\personagemTexto.txt";

	public Personagem(int vida, int ataque, int defesa, int velocidade, String nome) {
		super();
		this.vida = vida;
		this.ataque = ataque;
		this.defesa = defesa;
		this.velocidade = velocidade;
		this.nome = nome;
		this.artefato = new ArrayList<Artefato>();
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefesa() {
		return defesa;
	}

	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Artefato> getArtefato() {
		return artefato;
	}

	public void setArtefato(ArrayList<Artefato> artefato) {
		this.artefato = artefato;
	}

	public void pegarItem(Artefato art) {
		if (art.getPersonagem() == null) {
			art.setUso(true);
			art.setPersonagem(this);
			getArtefato().add(art);
		} else {
			System.out.println("Objeto: "+ art.getNome()+" em uso pelo personagem: " + art.getPersonagem().nome);}
	}

	public void soltarrItem(Artefato art) {
		if (art.getPersonagem().equals(this)) {
			art.setUso(false);
			art.setPersonagem(null);
			getArtefato().removeIf(i -> i.equals(art));
		} else {
			System.out.println("Objeto: "+ art.getNome()+" em uso pelo personagem: " + art.getPersonagem().nome);}
	}

	public void equiparItem(Artefato art) {
		if (art.getPersonagem() != null && art.getPersonagem().equals(this)) {
			this.setVida(this.getVida() + art.getVida());
			this.setAtaque(this.getAtaque() + art.getAtaque());
			this.setDefesa(this.getDefesa() + art.getDefesa());
			this.setVelocidade(this.getVelocidade() + art.getVelocidade());
		} else {
			System.out.println("Objeto: "+ art.getNome()+" em uso pelo personagem: " + art.getPersonagem().nome);}
	}

	public void desequiparItem(Artefato art) {
		if (art.getPersonagem().equals(this)) {
			this.setVida(this.getVida() - art.getVida());
			this.setAtaque(this.getAtaque() - art.getAtaque());
			this.setDefesa(this.getDefesa() - art.getDefesa());
			this.setVelocidade(this.getVelocidade() - art.getVelocidade());
		} else {
			System.out.println("Objeto: "+ art.getNome()+" em uso pelo personagem: " + art.getPersonagem().nome);}
		
	}
	
	public String verInventario() {
		StringBuilder sb = new StringBuilder();
		getArtefato().forEach(i -> sb.append(i.getNome() + "|"));
		return sb.toString();
	}

	private Artefato findArtefatoById(Artefato art) {
		var index = getArtefato().indexOf(art);
		return getArtefato().get(index);
	}

	public void guardarPersonagensTexto() throws IOException {
		File file = new File(PATH);
		FileOutputStream os = new FileOutputStream(file);
		OutputStreamWriter  osw = new OutputStreamWriter(os);

		osw.write(toString());
		osw.write("\nArtefactos: " + verInventario());
		osw.close();

	}
	

	public void lutar(Personagem p) {
		System.out.println();
		System.out.println(" ------- ");
		System.out.println("Atacante: " + this.nome);
		System.out.println("Defensor: " + p.nome);
		calcularAtaque(p);
		calcularDefesa(p);
	}

	private Integer numeroAleatorio() {
		Random random = new Random();
		return random.nextInt(25);
	}

	private void calcularAtaque(Personagem p) {
		System.out.println(" ------- ");
		System.out.println("Ataque: " + this.nome);
		System.out.println("Defensor: " + p.nome);
		int dano;
		int vidaAux = p.vida;
		int golpes = getVelocidade() / p.getVelocidade();
		if (golpes < 1)
			golpes = 2;
		else
			golpes += 1;
		System.out.println();
		System.out.println("Golpes do ataque foi: " + golpes);
		int num = numeroAleatorio();
		dano = getAtaque() - p.getDefesa() - num;
		if (dano < 0)
			dano = 0;
		System.out.println("Dano do ataque foi: " + dano);
		vidaAux = vidaAux - (dano * golpes);
		System.out.println("Vida do defensor: " + vidaAux);

	}

	private void calcularDefesa(Personagem p) {
		System.out.println(" ------- ");
		System.out.println("Ataque: " + p.nome);
		System.out.println("Defensor: " + this.nome);
		int dano;
		int vidaAux = this.vida;
		Integer golpes = p.getVelocidade() / getVelocidade();
		if (golpes < 1)
			golpes = 1;
		System.out.println();
		System.out.println("Golpes da defensa: " + golpes);
		int num = numeroAleatorio();
		dano = p.getAtaque() - getDefesa() - num;
		if (dano < 0)
			dano = 0;
		System.out.println("Dano da defesa foi: " + dano);
		vidaAux = vidaAux - (dano * golpes);
		System.out.println("Vida do atacante: " + vidaAux);
		System.out.println(" ------- ");
	}

	public String toString() {
		return "Nome do personage: " + this.nome + "\n Vida do personagem: " + this.vida + "\n Ataque do personagem: "
				+ this.ataque + "\n Defesa do personagem: " + this.defesa + "\n Velocidade do personagem: "
				+ this.velocidade + "\n Classe do personagem: " + this.getClass().getSimpleName();

	}

}
