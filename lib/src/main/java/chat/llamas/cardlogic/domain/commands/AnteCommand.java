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

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.ParametersDelegate;

@Parameters(commandNames = AnteCommand.COMMAND_NAME, separators = "=")
public class AnteCommand {
	public static final String COMMAND_NAME = "ante";
	
	@Parameter(names = "--required", description = "Is the ante required to view the hole cards?")
	private boolean required = false;

	@ParametersDelegate
	private CommandDelegate delegate = new CommandDelegate();

	public CommandDelegate getDelegate() {
		return delegate;
	}
	
	public final boolean isRequired() {
		return required;
	}
	
}
