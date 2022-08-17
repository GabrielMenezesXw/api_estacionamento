package com.fundatec.ti20.estacionamento.service;
import com.fundatec.ti20.estacionamento.exceptions.ConflitoException;
import com.fundatec.ti20.estacionamento.exceptions.ObjectNotFoundException;
import com.fundatec.ti20.estacionamento.model.Veiculo;
import com.fundatec.ti20.estacionamento.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {


    @Autowired
    private final VeiculoRepository repository;

    public VeiculoService(VeiculoRepository repository) {
        this.repository = repository;
    }

    public Veiculo findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Veiculo"));
    }

    public Veiculo findByplaca(String placa) {
        return repository.findByPlaca(placa).orElseThrow(() -> new ObjectNotFoundException("Veículo, por favor tente " +
                "outra placa ou reveja as informações"));
    }
    public List<Veiculo> findAll() {
        if(repository.findAll().isEmpty()){
            throw new ObjectNotFoundException("nenhum veiculo, o banco de dados está vazio");
        }
        return repository.findAll();
    }

    public Veiculo salvar(Veiculo veiculo) {
        if (placaExists(veiculo)){
            throw new ConflitoException("veiculo");
        }
        return repository.save(veiculo);
    }

    public void delete(Integer id) {
        if (!repository.findAll().contains(id)){
            throw new ObjectNotFoundException("veiculo");
        }
        repository.deleteById(id);
    }

    private boolean placaExists(Veiculo veiculo){
        if(repository.countVeiculoByPlaca(veiculo.getPlaca()) == 1) {
            return true;
        }
        return false;
    }

}
