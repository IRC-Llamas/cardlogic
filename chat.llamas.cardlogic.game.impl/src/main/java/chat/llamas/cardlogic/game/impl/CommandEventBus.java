package chat.llamas.cardlogic.game.impl;

import chat.llamas.cardlogic.domain.commands.BaseCommand;
import chat.llamas.cardlogic.game.api.CommandEventBusInterface;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class CommandEventBus implements CommandEventBusInterface {

	private PublishSubject<BaseCommand> commandPublisher;
	
	public CommandEventBus() {
		commandPublisher = PublishSubject.create();
	}
	
	@Override
	public <T extends BaseCommand> void executeCommand(T command) throws UnsupportedOperationException {
		commandPublisher.onNext(command);
	}

	@Override
	public <T extends BaseCommand> Observable<T> onCommand(Class<T> clazz) {
		return commandPublisher.ofType(clazz);
	}

}
