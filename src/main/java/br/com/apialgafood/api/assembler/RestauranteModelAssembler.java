package br.com.apialgafood.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.apialgafood.api.model.RestauranteModel;
import br.com.apialgafood.api.model.input.RestauranteInput;
import br.com.apialgafood.domain.model.Restaurante;

@Component
public class RestauranteModelAssembler {

	@Autowired
	private ModelMapper mapper;
	
	public RestauranteModel toModel(Restaurante restaurante) {
		return mapper.map(restaurante, RestauranteModel.class);
	}
	
	public List<RestauranteModel> toCollection(List<Restaurante> list){
		return list.stream()
				.map(res -> toModel(res))
				.distinct()
				.collect(Collectors.toList());
		
	}
	
	public Restaurante toDomainObject(RestauranteInput input) {
		
		return mapper.map(input, Restaurante.class);
	}
}
