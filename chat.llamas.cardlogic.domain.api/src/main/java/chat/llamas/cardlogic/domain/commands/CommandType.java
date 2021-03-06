// Copyright 2022 Llamas
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package chat.llamas.cardlogic.domain.commands;

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
