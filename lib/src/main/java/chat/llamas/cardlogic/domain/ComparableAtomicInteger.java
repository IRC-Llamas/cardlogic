package chat.llamas.cardlogic.domain;

import java.util.concurrent.atomic.AtomicInteger;

public class ComparableAtomicInteger extends AtomicInteger implements Comparable<AtomicInteger> {

	private static final long serialVersionUID = 1L;

	public ComparableAtomicInteger(int i) {
		super(i);
	}

	@Override
	public int compareTo(AtomicInteger arg0) {
		return this.get() > arg0.get() ? 1 : this.get() < arg0.get() ? -1 : 0;

	}

}
