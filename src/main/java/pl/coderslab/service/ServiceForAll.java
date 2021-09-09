package pl.coderslab.service;

import java.util.List;
import java.util.Optional;

public interface ServiceForAll<T, V> {

      List<T> getAll();

      void add(T t);

      Optional<T> get(V id);

      void delete(V id);

      void update(V id);


}
