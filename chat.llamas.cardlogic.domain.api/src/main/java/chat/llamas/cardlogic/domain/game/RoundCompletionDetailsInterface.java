package chat.llamas.cardlogic.domain.game;

import java.math.BigDecimal;
import java.util.Map;

public interface RoundCompletionDetailsInterface {

	Map<PlayerInterface, BigDecimal> getPotWinnings();
	
	RoundType getFinishTurn();
}
