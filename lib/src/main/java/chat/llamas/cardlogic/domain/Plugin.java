package chat.llamas.cardlogic.domain;

public interface Plugin<T> {
	
	void apply(T value);
}
