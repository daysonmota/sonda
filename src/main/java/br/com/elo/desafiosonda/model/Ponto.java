package br.com.elo.desafiosonda.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.elo.desafiosonda.enums.Direcao;

public class Ponto {

	private int abscissaX;
	private int ordenadaY;
	@JsonProperty("direção da sonda sentido")
	private Direcao direcao;

	public Ponto(int abscissaX, int ordenadaY, Direcao direcao) {
		this.abscissaX = abscissaX;
		this.ordenadaY = ordenadaY;
		this.direcao = direcao;
	}

	public int getAbscissaX() {
		return abscissaX;
	}

	public int getOrdenadaY() {
		return ordenadaY;
	}

	public Direcao getDirecao() {
		return direcao;
	}

	public void setDirecao(Direcao direcao) {
		this.direcao = direcao;
	}

	public void incrementaAbscissaX() {
		this.abscissaX++;
	}

	public void decrementaAbscissaX() {
		this.abscissaX--;
	}

	public void incrementaOrdenadaY() {
		this.ordenadaY++;
	}

	public void decrementaOrdenadaY() {
		this.ordenadaY--;
	}

	@Override
	public String toString() {
		return ("(" + abscissaX + "," + ordenadaY + ") apontando para direção: " + direcao);
	}

	@Override
	public int hashCode() {
		return Objects.hash(abscissaX, direcao, ordenadaY);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ponto other = (Ponto) obj;
		return abscissaX == other.abscissaX && direcao == other.direcao && ordenadaY == other.ordenadaY;
	}
}
