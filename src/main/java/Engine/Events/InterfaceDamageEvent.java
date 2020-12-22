package Engine.Events;

import Engine.Entities.InterfaceDamageableEntity;
import Engine.Utils.Location;

public interface InterfaceDamageEvent {
    void applyEffect(InterfaceDamageableEntity entity);

    Location getLocation();
}
