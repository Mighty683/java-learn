package Engine.Events;

import Engine.Entities.IDamageableEntity;

public interface IDamageEvent {
    void applyEffect(IDamageableEntity entity);
}
