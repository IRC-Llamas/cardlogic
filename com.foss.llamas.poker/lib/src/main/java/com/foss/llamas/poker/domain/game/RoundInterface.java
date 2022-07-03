package com.foss.llamas.poker.domain.game;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.foss.llamas.poker.domain.Card;
import com.foss.llamas.poker.domain.Deck;
import com.foss.llamas.poker.domain.commands.BetCommand;
import com.foss.llamas.poker.domain.commands.CallCommand;
import com.foss.llamas.poker.domain.commands.CheckCommand;
import com.foss.llamas.poker.domain.commands.FoldCommand;
import com.foss.llamas.poker.domain.commands.MuckCommand;
import com.foss.llamas.poker.domain.commands.RaiseCommand;
import com.foss.llamas.poker.domain.commands.ShowCommand;

import io.reactivex.rxjava3.core.Observable;

public interface RoundInterface {
	Map<Player, Boolean> getPlayers();
	
	IPot getPot();
	
	int getRoundCount();
	
	Deck getDeck();
	
	List<Card> getBurnCards();
		
	void join(Player player);
	
	void leave(Player player);
	
	void nextTurn();
	
	void nextRound();
	
	boolean isPotSatisfied();
	
	TurnType getTurnType();
	
	TurnType getNextTurnType();

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
