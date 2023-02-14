package lk.sankalpa.dao;

import lk.sankalpa.entity.SuperEntity;

import java.util.List;

public interface CrudDao <T extends SuperEntity,K> extends  SuperDao{

    T save(T entity);
    T update(T entity);
    T search(K Id);
    void delete(K Id);
    List<T>allData();


}
