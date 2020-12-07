package Engine;

import Entities.IEntity;

import java.util.Collection;
import java.util.List;

public class Engine implements IEngine {
    Collection<IEntity> entites;
    public Engine(Collection<IEntity> entities) {
        this.entites = entities;
    }

    @Override
    public void tick() {
        this.entites.forEach((entity) -> {
            // How implement tick effects?
        });
    }

    @Override
    public void addEntity(IEntity entity) {
        this.entites.add(entity);
    }

    @Override
    public void addEntitiesList(Collection<IEntity> list) {
        this.entites.addAll(list);
    }
}
