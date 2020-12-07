package Engine;

import Entities.EntityFactory;
import Entities.IEntity;
import Entities.Player;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.ArrayList;

public class EngineTest {
    @Test
    public void addingEntities() {
        //given
        Engine testedEngine = new Engine(new ArrayList<IEntity>());
        Player player = EntityFactory.createPlayer(0,0, "Tomek");

        //when
        testedEngine.addEntity(player);

        //then
        assertThat(testedEngine.entites).contains(player);
    }
}
