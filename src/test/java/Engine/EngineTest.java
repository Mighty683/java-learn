package Engine;

import Engine.Entities.IMovableEntity;
import Engine.Entities.Player;
import Engine.Events.DamageLocationEvent;
import Engine.Events.MoveEntityEvent;
import Engine.Utils.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class EngineTest {
    private Location testLocation;

    @BeforeEach
    public void setUp() {
        testLocation = new Location(0, 0);
    }

    @Test
    public void addingEntities() {
        //given
        final Engine testedEngine = new Engine();
        final Player player = new Player(testLocation, 100, "player-name");

        //when
        testedEngine.addEntity(player);

        //then
        assertThat(testedEngine.entities).contains(player);
    }

    @Nested
    @DisplayName("Tests for engine tics")
    public class TickEffects {
        @Test
        public void tickLocationEffects() {
            //given
            final Engine testedEngine = new Engine();
            final Player secondPlayer = new Player(
                    new Location(0, 1),
                    100,
                    "player-event"
            );
            final Player playerMock = spy(new Player(testLocation, 100, "player-name"));
            final DamageLocationEvent damageEvent = new DamageLocationEvent(
                    20,
                    testLocation
            );
            final DamageLocationEvent damageEventSpy = spy(damageEvent);
            //when
            testedEngine.addLocationEvent(damageEventSpy);
            testedEngine.addEntity(playerMock);
            testedEngine.addEntity(secondPlayer);
            testedEngine.tick();
            //then
            verify(damageEventSpy, times(1)).applyEffect(playerMock);
            verify(damageEventSpy, never()).applyEffect(secondPlayer);
        }

        @Test
        public void tickMove() {
            //given
            final Engine testedEngine = new Engine();
            final MoveEntityEvent eventMock = new MoveEntityEvent(
                    testLocation,
                    mock(IMovableEntity.class)
            );
            //when
            testedEngine.addMoveEvent(eventMock);
            testedEngine.tick();
            //then
            verify(eventMock, times(1)).applyMoveEffect();
            assertThat(testedEngine.moveEvents.size()).isEqualTo(0);
        }

        @Test
        public void tickForbiddenMove() {
            //given
            final Engine testedEngine = new Engine();
            final MoveEntityEvent eventMock = spy(new MoveEntityEvent(
                    testLocation,
                    mock(IMovableEntity.class)
            ));
            final Player player = new Player(testLocation, 100, "player-name");
            //when
            testedEngine.addMoveEvent(eventMock);
            testedEngine.addEntity(player);
            testedEngine.tick();
            //then
            verify(eventMock, never()).applyMoveEffect();
            assertThat(testedEngine.moveEvents.size()).isEqualTo(0);
        }
    }
}
