package chat.llamas.cardlogic.domain.evaluators;

import java.util.List;

import chat.llamas.cardlogic.domain.Card;
import chat.llamas.cardlogic.domain.HandResult;
import chat.llamas.cardlogic.domain.HandResultType;
import chat.llamas.cardlogic.domain.Rank;
import com.google.common.collect.Multimap;

public class TwoPairEvaluator extends HandResult {

	public TwoPairEvaluator(Multimap<Rank, Integer> rankValueMap) {
		super(HandResultType.TWO_PAIR, rankValueMap);
	}

	@Override
	public boolean test(List<Card> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
