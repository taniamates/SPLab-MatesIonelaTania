package ro.uvt.persistence;

import java.util.List;
import java.util.Optional;

// Interfata noastra: doar operatiile de care au nevoie straturile de sus (pasul 9)
public interface CrudRepository<T, ID> {
    List<T> findAll();
    Optional<T> findById(ID id);
    T save(T entity);
    void deleteById(ID id);
    boolean existsById(ID id);
}
