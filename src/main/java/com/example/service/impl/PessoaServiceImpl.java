package com.example.service.impl;

import com.example.model.Pessoa;
import com.example.service.PessoaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PessoaServiceImpl implements PessoaService{

    private static Set<Pessoa> pessoas;
    private static Long idCount = 0L;
    public PessoaServiceImpl() {
            if(pessoas == null){
            pessoas= new HashSet();
            idCount ++;
        }
    }
    
     
    

    @Override
    public Pessoa save(Pessoa pessoa) {
        pessoa.setId(idCount);
        idCount++;
        pessoas.add(pessoa);
        return pessoa;
    }

    @Override
    public Pessoa update(Pessoa pessoa) {
        if(!pessoas.contains(pessoa)){
            throw new RuntimeException("Registro não encontrado no banco de dados");
        }
        pessoas.add(pessoa);
        return pessoa;
    }

    @Override
    public void remove(Long id) {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        if(!pessoas.contains(pessoa)){
            throw new RuntimeException("Registro não encontrado no banco de dados");
        }
        pessoas.remove(pessoa);
    }

    @Override
    public Pessoa findOne(Long id) {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        if(!pessoas.contains(pessoa)){
            throw new RuntimeException("Registro não encontrado no banco de dados");
        }
        /*return pessoas
                .stream()
                .filter(p->p.getId().equals(id))
                .collect(Collectors.toList()).get(0);*/
        
        for(Pessoa p: pessoas){
            if(p.getId().equals(id)){
                return p;
            }
        }
        throw new RuntimeException("Registro não encontrado no banco de dados");
    }

    @Override
    public Collection<Pessoa> findAll() {
        return pessoas;
    }
    
}
