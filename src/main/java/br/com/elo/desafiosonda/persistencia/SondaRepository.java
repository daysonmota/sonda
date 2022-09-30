package br.com.elo.desafiosonda.persistencia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.elo.desafiosonda.model.Sonda;

@Repository
public class SondaRepository {

	private static List<Sonda> sondas = new ArrayList<>();
	private static long proximoId = 1;

	public void salva(Sonda sonda) {
		sonda.setId(proximoId);
		proximoId += 1; 
		sondas.add(sonda);
	}
	
	public List<Sonda> listar(){
		return sondas;
	}
	
}
