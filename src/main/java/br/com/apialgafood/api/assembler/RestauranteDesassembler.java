package br.com.apialgafood.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.apialgafood.api.model.input.RestauranteInput;
import br.com.apialgafood.domain.model.Cidade;
import br.com.apialgafood.domain.model.Cozinha;
import br.com.apialgafood.domain.model.Restaurante;

@Component
public class RestauranteDesassembler {
	
	@Autowired
	private ModelMapper mapper;
	
	public Restaurante toDomainObject(RestauranteInput input) {
		return mapper.map(input, Restaurante.class);
	}
	public void copyToDomainObject(RestauranteInput input, Restaurante restaurante) {
		restaurante.setCozinha(new Cozinha());
		if(restaurante.getEndereco() != null) {
			restaurante.getEndereco().setCidade(new Cidade());
		}
		mapper.map(input, restaurante);
	}
}
