package br.com.apialgafood.api.assembler;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.apialgafood.api.model.FormaPagamentoModel;
import br.com.apialgafood.domain.model.FormaPagamento;

@Component
public class FormaPagamentoAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public FormaPagamentoModel toModel(FormaPagamento formaPagamento) {
		return modelMapper.map(formaPagamento, FormaPagamentoModel.class);
	}

	public List<FormaPagamentoModel> toCollectionModel(Collection<FormaPagamento> formaPagamentos) {
		return formaPagamentos.stream().map(fmp -> toModel(fmp)).collect(Collectors.toList());
	}
}

