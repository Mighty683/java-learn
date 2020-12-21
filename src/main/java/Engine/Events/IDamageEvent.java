package Engine.Events;

import Engine.Entities.IDamageableEntity;
import Engine.Utils.Location;

public interface IDamageEvent {
    void applyEffect(IDamageableEntity entity);

    Location getLocation();
}
