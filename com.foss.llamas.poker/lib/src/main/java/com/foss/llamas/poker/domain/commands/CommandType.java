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
	GIVEMONEY,
	POKERSTATS,
	PLAYERSETTING,
	
	// Admin Commands
	GIVEMONEY_ALL,
	SETMONEY,
	RESETPLAYER,
	DELPLAYER,
	ADDPLAYER,
	APPSETTING,
}
