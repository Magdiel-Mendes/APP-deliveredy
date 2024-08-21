package br.com.apialgafood.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.apialgafood.api.assembler.EstadoInputDisassembler;
import br.com.apialgafood.api.assembler.EstadoModelAssembler;
import br.com.apialgafood.api.model.EstadoModel;
import br.com.apialgafood.api.model.input.EstadoInput;
import br.com.apialgafood.domain.model.Estado;
import br.com.apialgafood.domain.repository.EstadoRepository;
import br.com.apialgafood.domain.services.CadastroEstadoService;


@RestController
@RequestMapping("/estados")
public class EstadoController {
	
	@Autowired
	private EstadoModelAssembler assembler;
	
	@Autowired
	private EstadoInputDisassembler disassembler;
	
	@Autowired
	private EstadoRepository repository;
	
	@Autowired
	private CadastroEstadoService service;
	
	@GetMapping
	private List<EstadoModel> listar() {
		 List<Estado> todosEstaos = repository.findAll();
		 
		 return assembler.toCollectionModel(todosEstaos);
		
	}
	
	@GetMapping("/{estadoId}")
	private EstadoModel buscar(@PathVariable Long estadoId) {
		Estado estado = service.buscarOuFalhar(estadoId);
		
		return assembler.toModel(estado);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EstadoModel adicionar(@RequestBody @Valid EstadoInput estadoInput){
	
		Estado estado =  disassembler.toDomainObject(estadoInput);
		
		estado = service.salvar(estado);
		
		return assembler.toModel(estado);
	}
	
	
	
	@PutMapping("/{estadoId}")
	public EstadoModel atualizar(@PathVariable Long estadoId,
			@RequestBody @Valid EstadoInput estadoInput) {
		Estado estadoAtual = service.buscarOuFalhar(estadoId);
		
		disassembler.copyToDomainObject(estadoInput, estadoAtual);
		
		estadoAtual = service.salvar(estadoAtual);
		
		return assembler.toModel(estadoAtual);
	}
	
	@DeleteMapping("/{estadoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long estadoId) {
		service.excluir(estadoId);	
	}
	
}
