package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.config.FixedMovingStrategy;
import racingcar.strategy.MovingStrategy;

class RacingGameTest {

    MovingStrategy movingStrategy = new FixedMovingStrategy();
    RacingGame racingGame;

    @BeforeEach
    void setUp() {
        Cars cars = new Cars(
            List.of(new Car("joy"),
                new Car("pobi"))
        );
        racingGame = new RacingGame(1, cars, movingStrategy);
    }

    @DisplayName("생성된 수에 따라 차를 이동시키고 현재 상태를 제대로 출력하는지 확인")
    @Test
    void playSingleRoundTest() {
        assertEquals(racingGame.playSingleRound(),
            Map.of("joy", 1, "pobi", 1));
    }

    @DisplayName("차들의 위치 값을 비교해 최종 우승자들을 구한다.")
    @Test
    void getWinnersTest() {
        assertEquals(racingGame.getWinners(),
            List.of("joy", "pobi")
        );
    }
}
