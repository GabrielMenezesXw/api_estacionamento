package com.fundatec.ti20.estacionamento.service;

import com.fundatec.ti20.estacionamento.exceptions.ConflitoException;
import com.fundatec.ti20.estacionamento.exceptions.ObjectNotFoundException;
import com.fundatec.ti20.estacionamento.model.Assinante;
import com.fundatec.ti20.estacionamento.model.Conta;
import com.fundatec.ti20.estacionamento.repository.AssinanteRepository;
import com.fundatec.ti20.estacionamento.repository.ContaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AssinanteService {

    @Autowired
    private final AssinanteRepository repository;



    public Assinante findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Assinante"));
    }

    public List<Assinante> findAll() {
        if(repository.findAll().isEmpty()){
            throw new ObjectNotFoundException("nenhum assinante, o banco de dados está vazio");
        }
        return repository.findAll();
    }

    public Assinante salvar(Assinante assinante) {
        if (cpfExists(assinante)){
            throw new ConflitoException("assinante");
        }
        return repository.save(assinante);
    }

    public Assinante atualizar(Assinante assinante) {
        if (repository.findAll().contains(assinante)){
            throw new ConflitoException("assinante");
        }
        return repository.save(assinante);
    }

    public void delete(Integer id) {
        if (!repository.findAll().contains(id)){
            throw new ObjectNotFoundException("assinante");
        }
        repository.deleteById(id);
    }

    private boolean cpfExists(Assinante assinante){
        if(repository.countAssinanteByCpf(assinante.getCpf()) == 1){
            return true;
        }
        return false;
    }

}
