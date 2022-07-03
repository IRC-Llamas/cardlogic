package com.foss.llamas.poker.domain.commands;

public enum CommandType {
	// Game commands
	STARTGAME,
	CANCELGAME,
	JOINGAME,
	LEAVEGAME,
	
	// Round Commands
	CHECK,
	BET,
	RAISE,
	FOLD,
	/* SHOW can be used at any time,
	 * but usually it is only performed
	 * in the last round. This means the
	 * player is revealing their cards.
	 * 
	 * A winner can only be decided if at least
	 * one player shows their cards. 
	 * Of all the players who show their cards,
	 * the best hand wins.
	 */
	SHOW,
	/*
	 * MUCK can only be used in the showdown
	 * round, it is the opposite of SHOW
	 * and a variation of FOLD.
	 * The player gives up without showing
	 * their cards, acknowledging defeat
	 * by the hand(s) that are shown.
	 */
	MUCk,
	
	// External Commands
	CHECKMONEY,
	POKERSTATS,
	PLAYERSETTING,
	
	// Admin Commands
	TAKEMONEY,
	GIVEMONEY_ALL,
	SETMONEY,
	RESETPLAYER,
	DELPLAYER,
	ADDPLAYER,
	APPSETTING,
}
