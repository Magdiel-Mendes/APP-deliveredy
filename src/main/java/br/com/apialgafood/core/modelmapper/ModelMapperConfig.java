package br.com.apialgafood.core.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.apialgafood.api.model.EnderecoModel;
import br.com.apialgafood.domain.model.Endereco;

@Configuration
public class ModelMapperConfig {
	
	@Bean
	public ModelMapper mapper() {
		var mapper = new ModelMapper();
		var enderecoToEnderecoModelTypMap = mapper.createTypeMap(
				Endereco.class, EnderecoModel.class);
		
		enderecoToEnderecoModelTypMap.<String>addMapping(
				enderecoSrc -> enderecoSrc.getCidade().getEstado().getNome(),
			    (enderecoModelDest, value) -> enderecoModelDest.getCidade().setEstado(value));
				
				return mapper;
	}
}
