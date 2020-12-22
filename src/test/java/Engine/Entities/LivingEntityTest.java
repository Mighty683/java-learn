package Engine.Entities;

import Engine.Utils.Location;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class LivingEntityTest {
    @Test
    public void damageApply() {
        //given
        final AbstractInterfaceLivingEntity testEntity = new AbstractInterfaceLivingEntity(
                mock(Location.class),
                "test-entity",
                100
        ) {
            @Override
            public boolean canMoveHere() {
                return false;
            }
        };
        //when
        testEntity.applyDamage(20);
        //then
        assertThat(testEntity.getHp()).isEqualTo(80);
        assertThat(testEntity.isAlive()).isEqualTo(true);
    }

    @Test
    public void killingDamageApply() {
        //given
        final AbstractInterfaceLivingEntity testEntity = new AbstractInterfaceLivingEntity(
                mock(Location.class),
                "test-entity",
                100
        ) {
            @Override
            public boolean canMoveHere() {
                return false;
            }
        };
        //when
        testEntity.applyDamage(200);
        //then
        assertThat(testEntity.getHp()).isEqualTo(-100);
        assertThat(testEntity.isAlive()).isEqualTo(false);
    }
}
