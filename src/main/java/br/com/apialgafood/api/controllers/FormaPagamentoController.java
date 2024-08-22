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

import br.com.apialgafood.api.assembler.FormaPagamentoAssembler;
import br.com.apialgafood.api.assembler.FormaPagamentoDesassembler;
import br.com.apialgafood.api.model.FormaPagamentoModel;
import br.com.apialgafood.api.model.input.FormaPagamentoInput;
import br.com.apialgafood.domain.model.FormaPagamento;
import br.com.apialgafood.domain.repository.FormaPagamentoRepository;
import br.com.apialgafood.domain.services.CadastroFormaPagamentoService;

@RestController
@RequestMapping("/formaPagamentos")
public class FormaPagamentoController {
	
	@Autowired
	private FormaPagamentoAssembler assembler;
	
	@Autowired
	private FormaPagamentoDesassembler disassembler;
	
	@Autowired
	private FormaPagamentoRepository repository;
	
	@Autowired
	private CadastroFormaPagamentoService service;
	
	@GetMapping
	private List<FormaPagamentoModel> listar() {
		 List<FormaPagamento> todasFormasPagamento = repository.findAll();
		 
		 return assembler.toCollectionModel(todasFormasPagamento);
		
	}
	
	@GetMapping("/{formaPagamentoId}")
	private FormaPagamentoModel buscar(@PathVariable Long formaPagamentoId) {
		FormaPagamento formaPagamento = service.buscarOuFalhar(formaPagamentoId);
		
		return assembler.toModel(formaPagamento);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public FormaPagamentoModel adicionar(@RequestBody @Valid FormaPagamentoInput formaPagamentoInput){
	
		FormaPagamento formaPagamento =  disassembler.toDomainObject(formaPagamentoInput);
		
		formaPagamento = service.salvar(formaPagamento);
		
		return assembler.toModel(formaPagamento);
	}
	
	
	
	@PutMapping("/{formaPagamentoId}")
	public FormaPagamentoModel atualizar(@PathVariable Long formaPagamentoId,
			@RequestBody @Valid FormaPagamentoInput formaPagamentoInput) {
		FormaPagamento formaPagamentoAtual = service.buscarOuFalhar(formaPagamentoId);
		
		disassembler.copyToDomainObject(formaPagamentoInput, formaPagamentoAtual);
		
		formaPagamentoAtual = service.salvar(formaPagamentoAtual);
		
		return assembler.toModel(formaPagamentoAtual);
	}
	
	@DeleteMapping("/{formaPagamentoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long formaPagamentoId) {
		service.excluir(formaPagamentoId);	
	}

}
