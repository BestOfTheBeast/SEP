package student.enterprise.project.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CRUDService<T> {

    T create(T t);

    T get(long id);

    List<T> getAll();

    T update(T t);

    void delete(long id);
}
