package com.flashlogist.database.dao.someclass;

import com.flashlogist.database.entities.someclass.SomeClass;

import java.util.List;

public interface SomeClassDao {

    SomeClass save(SomeClass someClass);
    SomeClass getById(long id);
    List<SomeClass> getAll();
}
