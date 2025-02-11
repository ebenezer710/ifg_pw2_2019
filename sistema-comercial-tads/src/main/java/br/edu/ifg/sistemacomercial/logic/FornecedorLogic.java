package br.edu.ifg.sistemacomercial.logic;

import br.edu.ifg.sistemacomercial.dao.FornecedorDAO;
import br.edu.ifg.sistemacomercial.entity.Fornecedor;
import br.edu.ifg.sistemacomercial.util.Assert;
import br.edu.ifg.sistemacomercial.util.exception.NegocioException;
import br.edu.ifg.sistemacomercial.util.exception.SistemaException;
import java.util.List;
import javax.inject.Inject;

public class FornecedorLogic implements GenericLogic<Fornecedor, Integer> {
    
    @Inject
    private FornecedorDAO dao;
    
    @Override
    public Fornecedor salvar(Fornecedor entity) throws NegocioException, SistemaException{
        if("".equals(entity.getNome().trim())){
            throw new NegocioException("Nome do fornecedor é obrigatório.");
        }
        if(!Assert.isCnpjValido(entity.getCnpj())){
            throw new NegocioException("CNPJ inválido.");
        }
        if(!Assert.isCpf(entity.getCpf())){
             throw new NegocioException("CPF inválido.");
        }
         if(!Assert.isValidEmail(entity.getEmail())){
             throw new NegocioException("Email inválido.");
        }                  
        
        dao.salvar(entity);
        return null;    
    }

    @Override
    public void deletar(Fornecedor entity) throws NegocioException, SistemaException {
      dao.deletar(entity);
    }

    @Override
    public Fornecedor buscarPorId(Integer id) throws NegocioException, SistemaException {
       
        return dao.buscarPorId(id);    
    }

    @Override
    public List<Fornecedor> buscar(Fornecedor entity) throws NegocioException, SistemaException {
      return dao.listar();
    }
  
}
