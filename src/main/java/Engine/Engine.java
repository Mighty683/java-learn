package Engine;

import Engine.Entities.Entity;
import Engine.Entities.IDamageableEntity;
import Engine.Events.LocationEvent;

import java.util.ArrayList;
import java.util.List;

public class Engine implements IEngine {
    List<Entity> entities = new ArrayList<>();
    List<LocationEvent> locationEvents = new ArrayList<>();

    @Override
    public void tick() {
        applyLocationEffects();
    }

    private void applyLocationEffects() {
        this.locationEvents
                .forEach(effect -> this.entities.forEach(entity -> {
                    if (entity instanceof IDamageableEntity) {
                        effect.applyEffect((IDamageableEntity) entity);
                    }
                }));
    }

    @Override
    public void addEntity(Entity entity) {
        this.entities.add(entity);
    }

    public void addLocationEvent(LocationEvent locationEvent) {
        this.locationEvents.add(locationEvent);
    }
}
