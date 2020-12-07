package Engine;

import Entities.IEntity;

import java.util.Collection;

public interface IEngine {
    void tick();
    void addEntity(IEntity entity);
    void addEntitiesList(Collection<IEntity> list);
}
