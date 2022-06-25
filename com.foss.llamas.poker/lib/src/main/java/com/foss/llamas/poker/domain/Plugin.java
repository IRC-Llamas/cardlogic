package com.foss.llamas.poker.domain;

public interface Plugin<T> {
	
	void apply(T value);
}
