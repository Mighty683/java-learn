package Engine.Entities;

public interface InterfaceLivingEntity extends InterfaceEntity, InterfaceDamageableEntity, InterfaceMovableEntity {
    int getHp();

    boolean isAlive();
}
