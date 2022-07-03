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
