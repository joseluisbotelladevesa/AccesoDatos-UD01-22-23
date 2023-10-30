package model.repository;

import java.sql.SQLException;
import java.util.List;

public interface ICrudRepository <T, E> {

    public List<T> FindAll() throws SQLException; //Devuelve una List<T>

    public T FindById(E id) throws SQLException; //Devuelve un objeto de tipo T o null si no existe

    public boolean Save(T entity); //Inserta si no existe, actualiza si existe

    public boolean Delete(E id); // Borra el objeto T

    public boolean Update(T entity); //Actualiza el objeto T



}
