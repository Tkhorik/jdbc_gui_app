package com.application.framecujdbc.dao;

import com.application.framecujdbc.domain.Departament;

import java.util.List;

/**
 *
 * @author iurasun
 */
public interface DepartamentDaoIntf {

List<Departament> findAll(Departament departament) throws Exception;
    
    //CRUD  
    
    List<Departament> findAll() throws Exception;
    //Departament findById(int id)throws Exception;

    void save(Departament readForm) throws Exception;

    Departament findById(int id) throws Exception;

    void update(Departament departament)throws Exception;

    void delete(Departament departament)throws Exception;
    
}

