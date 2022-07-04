package com.foss.llamas.poker.domain.cardformatter;

import java.util.function.Function;

import com.foss.llamas.poker.domain.Card;

public interface CardStringFormatter extends Function<Card, String> {

}
