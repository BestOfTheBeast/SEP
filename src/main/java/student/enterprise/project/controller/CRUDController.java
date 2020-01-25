package student.enterprise.project.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface CRUDController<T> {

  @GetMapping("/{id}")
  T get(@PathVariable Long id);

  @DeleteMapping("/{id}")
  void delete(@PathVariable Long id);

  @PutMapping
  T update(@RequestBody T updateDTO);

  @PostMapping
  T create(@RequestBody T newDTO);

  @GetMapping
  List<T> getAll();
}
