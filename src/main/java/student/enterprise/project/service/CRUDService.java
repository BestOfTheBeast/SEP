package student.enterprise.project.service;

import java.util.List;

public interface CRUDService<T> {

    T create(T t);

    T get(long id);

    List<T> getAll();

    T update(T t);

    void delete(long id);
}
