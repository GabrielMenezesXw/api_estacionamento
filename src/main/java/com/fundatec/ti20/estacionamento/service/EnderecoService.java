package com.fundatec.ti20.estacionamento.service;

import com.fundatec.ti20.estacionamento.exceptions.ConflitoException;
import com.fundatec.ti20.estacionamento.exceptions.ObjectNotFoundException;
import com.fundatec.ti20.estacionamento.model.Endereco;
import com.fundatec.ti20.estacionamento.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    @Autowired
    private final EnderecoRepository repository;

    public Endereco findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Endereço"));
    }

    public List<Endereco> findAll() {
        if(repository.findAll().isEmpty()){
            throw new ObjectNotFoundException("nenhum endereço, o banco de dados está vazio");
        }
        return repository.findAll();
    }

    public Endereco salvar(Endereco endereco) {
        if (repository.findAll().contains(endereco)){
            throw new ConflitoException("endereço");
        }
        return repository.save(endereco);
    }

    public Endereco atualizar(Endereco endereco){
        if (repository.findAll().contains(endereco)){
            throw new ConflitoException("endereço");
        }
        return repository.save(endereco);
    }

    public void delete(Integer id){
        if (!repository.findAll().contains(id)){
            throw new ObjectNotFoundException("cliente");
        }
        repository.deleteById(id);
    }

}
