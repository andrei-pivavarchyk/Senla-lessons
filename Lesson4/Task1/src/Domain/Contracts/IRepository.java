package Domain.Contracts;

import Domain.Entities.Entity;

import java.util.ArrayList;

public interface IRepository<T extends Entity> {
    ArrayList<T> Fetch();
    void BulkCreate(ArrayList<T> entity);
    void Create(T entity);
    T Read(int id);
    void Update(T entity);
    void Delete(int id);
}