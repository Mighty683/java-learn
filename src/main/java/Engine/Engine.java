package Engine;

import Engine.Entities.AbstractInterfaceEntity;
import Engine.Entities.InterfaceDamageableEntity;
import Engine.Entities.InterfaceEntity;
import Engine.Events.InterfaceDamageLocationEvent;
import Engine.Events.InterfaceMoveEvent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Engine implements InterfaceEngine {
    List<InterfaceEntity> entities = new ArrayList<>();
    List<InterfaceDamageLocationEvent> locationEvents = new ArrayList<>();
    List<InterfaceMoveEvent> moveEvents = new ArrayList<>();

    @Override
    public void tick() {
        applyLocationEvents();
        applyMoveEvents();
    }

    @Override
    public void addEntity(final AbstractInterfaceEntity entity) {
        this.entities.add(entity);
    }

    @Override
    public void addDamageLocationEvent(final InterfaceDamageLocationEvent locationEvent) {
        this.locationEvents.add(locationEvent);
    }

    @Override
    public void addMoveEvent(final InterfaceMoveEvent event) {
        this.moveEvents.add(event);
    }

    private void applyLocationEvents() {
        this.locationEvents
                .forEach(event -> this.entities.forEach(entity -> {
                    if (entity instanceof InterfaceDamageableEntity && entity.getLocation().equals(event.getLocation())) {
                        event.applyEffect((InterfaceDamageableEntity) entity);
                    }
                }));
    }

    private void applyMoveEvents() {
        final Iterator<InterfaceMoveEvent> iterator = this.moveEvents.iterator();
        while (iterator.hasNext()) {
            final InterfaceMoveEvent event = iterator.next();
            if (this.entities.stream().allMatch(
                    entity -> entity.getLocation().equals(event.getLocation()) && entity.canMoveHere())
            ) {
                event.applyMoveEffect();
            }
            iterator.remove();
        }
    }
}
