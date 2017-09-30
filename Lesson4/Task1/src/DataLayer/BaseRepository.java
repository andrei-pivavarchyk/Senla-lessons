package DataLayer;

import Domain.Contracts.IRepository;
import Domain.Entities.Entity;

import java.util.ArrayList;

public class BaseRepository<T extends Entity> implements IRepository<T> {
    ArrayList<T> collection = new ArrayList<>();

    @Override
    public void Create(T entity) {
        collection.add(entity);
    }

    @Override
    public T Read(int id) {
        for (T ent : collection) {
            if (ent.id == id) {
                return ent;
            }
        }

        return null;
    }

    @Override
    public void Update(T entity) {
        for (T ent : collection) {
            if (ent.id == entity.id) {
                ent = entity;
                break;
            }
        }
    }

    @Override
    public void Delete(int id) {
        for (T ent : collection) {
            if (ent.id == id) {
                collection.remove(ent);
                break;
            }
        }
    }
}
