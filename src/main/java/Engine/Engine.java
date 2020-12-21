package Engine;

import Engine.Entities.Entity;
import Engine.Entities.IDamageableEntity;
import Engine.Events.IMoveEvent;
import Engine.Events.LocationEvent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Engine implements IEngine {
    List<Entity> entities = new ArrayList<>();
    List<LocationEvent> locationEvents = new ArrayList<>();
    List<IMoveEvent> moveEvents = new ArrayList<>();

    @Override
    public void tick() {
        applyLocationEvents();
        applyMoveEvents();
    }

    @Override
    public void addEntity(Entity entity) {
        this.entities.add(entity);
    }

    @Override
    public void addLocationEvent(LocationEvent locationEvent) {
        this.locationEvents.add(locationEvent);
    }

    @Override
    public void addMoveEvent(IMoveEvent event) {
        this.moveEvents.add(event);
    }

    private void applyLocationEvents() {
        this.locationEvents
                .forEach(event -> this.entities.forEach(entity -> {
                    if (entity instanceof IDamageableEntity && entity.getLocation().equals(event.getLocation())) {
                        event.applyEffect((IDamageableEntity) entity);
                    }
                }));
    }

    private void applyMoveEvents() {
        Iterator<IMoveEvent> iterator = this.moveEvents.iterator();
        while (iterator.hasNext()) {
            IMoveEvent event = iterator.next();
            if (this.entities.stream().allMatch(
                    entity -> entity.getLocation().equals(event.getLocation()) && entity.canMoveHere())
            ) {
                event.applyMoveEffect();
            }
            iterator.remove();
        }
    }
}
