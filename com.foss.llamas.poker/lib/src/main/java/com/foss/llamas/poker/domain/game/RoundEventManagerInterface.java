package com.foss.llamas.poker.domain.game;

import com.foss.llamas.poker.domain.commands.BetCommand;
import com.foss.llamas.poker.domain.commands.CallCommand;
import com.foss.llamas.poker.domain.commands.CheckCommand;
import com.foss.llamas.poker.domain.commands.FoldCommand;
import com.foss.llamas.poker.domain.commands.MuckCommand;
import com.foss.llamas.poker.domain.commands.RaiseCommand;
import com.foss.llamas.poker.domain.commands.ShowCommand;

import io.reactivex.rxjava3.core.Observable;

public interface RoundEventManagerInterface {
	Observable<FoldCommand> onFold();
	Observable<MuckCommand> onMuck();
	Observable<ShowCommand> onShow();
	Observable<CallCommand> onCall();
	Observable<RaiseCommand> onRaise();
	Observable<BetCommand> onBet();
	Observable<CheckCommand> onCheck();
	Observable<Player> onNextPlayerTurn();
	Observable<TurnType> onNextRoundTurn();
	Observable<RoundCompletionDetails> onRoundComplete();
}
