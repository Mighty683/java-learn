package Engine;

import Engine.Entities.InterfaceDamageableEntity;
import Engine.Entities.InterfaceEntity;
import Engine.Entities.InterfaceMovableEntity;
import Engine.Events.InterfaceDamageLocationEvent;
import Engine.Events.InterfaceMoveEvent;
import Engine.Events.MoveEntityEvent;
import Engine.Utils.DirectionEnum;

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
    public void addEntity(final InterfaceEntity entity) {
        this.entities.add(entity);
    }

    @Override
    public void removeEntity(final InterfaceEntity entity) {
        this.entities.remove(entity);
    }

    @Override
    public void addDamageLocationEvent(final InterfaceDamageLocationEvent locationEvent) {
        this.locationEvents.add(locationEvent);
    }

    @Override
    public void addMoveEvent(final InterfaceMoveEvent event) {
        this.moveEvents.add(event);
    }

    @Override
    public void moveEntityInDirection(final InterfaceEntity entity, final DirectionEnum direction) {
        this.addMoveEvent(
                new MoveEntityEvent(
                        direction.getNewLocation(entity.getLocation()),
                        (InterfaceMovableEntity) entity
                )
        );
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
