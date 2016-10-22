package com.flashlogist.database.dao;

import com.flashlogist.database.entities.SomeClass;

import java.util.List;

/**
 * Created by Lex on 22.10.2016.
 */
public interface SomeClassDao {

    SomeClass save(SomeClass someClass);
    SomeClass getById(long id);
    List<SomeClass> getAll();
}
