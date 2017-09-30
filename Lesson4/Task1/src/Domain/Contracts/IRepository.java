package Domain.Contracts;

import Domain.Entities.Entity;

public interface IRepository<T extends Entity> {
    void Create(T entity);
    T Read(int id);
    void Update(T entity);
    void Delete(int id);
}