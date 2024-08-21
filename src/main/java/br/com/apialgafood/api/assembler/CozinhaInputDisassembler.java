package br.com.apialgafood.api.assembler;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.apialgafood.api.model.input.CozinhaInput;
import br.com.apialgafood.domain.model.Cozinha;


@Component
public class CozinhaInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Cozinha toDomainObject(@Valid CozinhaInput cozinhaInput) {
		return modelMapper.map(cozinhaInput, Cozinha.class);
	}
	
	public void copyToDomainObject(CozinhaInput cozinhaInput, Cozinha cozinha) {
		modelMapper.map(cozinhaInput, cozinha);
	}
	
}