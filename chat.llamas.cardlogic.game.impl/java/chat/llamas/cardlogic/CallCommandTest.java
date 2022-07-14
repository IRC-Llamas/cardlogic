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
package chat.llamas.cardlogic;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import chat.llamas.cardlogic.domain.commands.CallCommand;

public class CallCommandTest extends BaseCommandTest<CallCommand>{

	private CallCommand command;
	
	private Map<String, Optional<String>> input;
	
	@Override
	protected String getCommandName() {
		return CallCommand.COMMAND_NAME;
	}

	@ParameterizedTest
	@MethodSource
	@Override
	public void testCommand(Map<String, Optional<String>> input) {
 
		this.input = input;
    	
    	this.command = getCommandFromJCommander(input);

		checkPlayerName();
	}

	@Override
	protected Map<String, Optional<String>> getInput() {
	    return input;
	}

	@Override
	protected CallCommand getCommand() {
		return command;
	}
	
	private static Stream<Map<String, Optional<String>>> testCommand() {
	    return Stream.of(
	    	getCommandWithFlags(
    			getPlayerArgument(getPlayerName())));
	}

}
