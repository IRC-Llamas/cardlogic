package chat.llamas.cardlogic;

import chat.llamas.cardlogic.domain.commands.BetCommand;
import chat.llamas.cardlogic.domain.commands.CallCommand;
import chat.llamas.cardlogic.domain.commands.CheckCommand;
import chat.llamas.cardlogic.domain.commands.FoldCommand;
import chat.llamas.cardlogic.domain.commands.MuckCommand;
import chat.llamas.cardlogic.domain.commands.RaiseCommand;
import chat.llamas.cardlogic.domain.commands.ShowCommand;
import chat.llamas.cardlogic.domain.commands.ViewCardsCommand;
import chat.llamas.cardlogic.domain.game.Player;
import chat.llamas.cardlogic.domain.game.RoundCompletionDetails;
import chat.llamas.cardlogic.domain.game.RoundType;
import io.reactivex.rxjava3.core.Observable;

public interface RoundEventManagerInterface {
	Observable<FoldCommand> onFold();
	
	Observable<MuckCommand> onMuck();
	
	Observable<ShowCommand> onShow();
	
	Observable<CallCommand> onCall();
	
	Observable<RaiseCommand> onRaise();
	
	Observable<BetCommand> onBet();
	
	Observable<CheckCommand> onCheck();
	
	Observable<ViewCardsCommand> onPeek();
	
	Observable<Player> onNextPlayerTurn();
	
	Observable<RoundType> onNextRoundTurn();
	
	Observable<RoundCompletionDetails> onRoundComplete(); 
	
	void doFold(FoldCommand command);
	
	void doMuck(MuckCommand command);
	
	void doCall(CallCommand command);
	
	void doRaise(RaiseCommand command);
	
	void doBet(BetCommand command);
	
	void doCheck(CheckCommand command);
	
	void doPeek(ViewCardsCommand command);
	
	void doShow(ShowCommand command);
}
