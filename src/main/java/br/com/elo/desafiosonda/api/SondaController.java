package br.com.elo.desafiosonda.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.elo.desafiosonda.exception.ApiException;
import br.com.elo.desafiosonda.exception.ComandoNaoInformadoException;
import br.com.elo.desafiosonda.exception.MovimentacaoInvalidaException;
import br.com.elo.desafiosonda.exception.PosicaoInvalidaException;
import br.com.elo.desafiosonda.model.Ponto;
import br.com.elo.desafiosonda.model.Sonda;
import br.com.elo.desafiosonda.persistencia.SondaRepository;

@RestController
@RequestMapping(value = "/sondas")
public class SondaController {

	@Autowired
	public SondaRepository sondaRepository;

	@PostMapping
	public ResponseEntity<Sonda> criaSonda(@RequestBody Ponto ponto, @RequestParam (required = false) String comando) throws ApiException {

		Sonda sonda = new Sonda(ponto);
		
		try {
			sonda.movimentaSonda(comando);
			sondaRepository.salva(sonda);
		} 
			catch ( MovimentacaoInvalidaException e) {
			throw new ApiException(HttpStatus.BAD_REQUEST, "Nao foi possivel realizar a requisição", e.getMessage());
		} catch(PosicaoInvalidaException e) {
			throw new ApiException(HttpStatus.NOT_FOUND, "A sonda não conseguiu chegar na posição esperada", e.getMessage());
		}
		catch (ComandoNaoInformadoException e) {
			throw new ApiException(HttpStatus.BAD_REQUEST, "Não foi possivel realizar a requisicao", e.getMessage());
		}
		return ResponseEntity.ok(sonda);
	} 

	@GetMapping
	public List<Sonda> listar() {
		return sondaRepository.listar();
	}
}
