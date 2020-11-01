package co.com.gsdd.knowledgedb.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import co.com.gsdd.knowledgedb.converter.GenericConverter;
import co.com.gsdd.knowledgedb.persistence.entity.common.AbstraccionEntidad;
import co.com.gsdd.knowledgedb.persistence.repository.GenericRepository;
import co.com.gsdd.knowledgedb.service.IGenericService;
import lombok.Getter;

@Getter
public abstract class AbstractGenericService<T extends AbstraccionEntidad, D, ID> implements IGenericService<D, ID> {

	private final GenericRepository<T, ID> repository;
	private final GenericConverter<T, D> converter;

	public AbstractGenericService(GenericRepository<T, ID> repository, GenericConverter<T, D> converter) {
		this.repository = repository;
		this.converter = converter;
	}

	@Override
	public List<D> listEnabled() {
		return getRepository().findByEstado(true).stream().map(getConverter()::convertToDomain)
				.collect(Collectors.toList());
	}

	@Override
	public D findById(ID id) {
		return getRepository().findById(id).map(getConverter()::convertToDomain).orElse(null);
	}
}