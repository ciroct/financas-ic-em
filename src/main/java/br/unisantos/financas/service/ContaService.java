package br.unisantos.financas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisantos.financas.model.Conta;
import br.unisantos.financas.repository.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository repository;

	public ContaService() {
	}

	public Conta create(Conta obj) {
		return repository.save(obj);
	}

	public Conta findById(Long id) {
		Optional<Conta> _conta = repository.findById(id);
		return _conta.orElse(null);
	}

	public List<Conta> findAll() {
		return repository.findAll();
	}

	public boolean update(Conta obj) {
		if (repository.existsById(obj.getId())) {
			repository.save(obj);
			return true;
		}
		return false;
	}

	public boolean delete(Long id) {
		Optional<Conta> _conta = repository.findById(id);
		if (_conta.isPresent()) {
			repository.delete(_conta.get());
			return true;
		}
		return false;
	}
}
