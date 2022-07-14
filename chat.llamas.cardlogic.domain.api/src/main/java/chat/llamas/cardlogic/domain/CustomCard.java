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
package chat.llamas.cardlogic.domain;

import java.util.Objects;
import java.util.function.Function;

public class CustomCard implements Card {
	private Function<Card, Color> getColorFunction = null;
	private Function<Card, Rank> getRankFunction = null;
	private Function<Card, Suit> getSuitFunction = null;
	private Function<Card, Boolean> isWildFunction = null;
	
	public static final Card build(
			Function<Card, Color> getColorFunction,
			Function<Card, Rank> getRankFunction,
			Function<Card, Suit> getSuitFunction,
			Function<Card, Boolean> isWildFunction) {
		return null;
		
	}
	@Override
	public boolean isWild() {
		if (Objects.nonNull(isWildFunction)) {
			return isWildFunction.apply(this);
		}
		else {
			return false;
		}
	}

	@Override
	public Color getColor() {
		if (Objects.nonNull(getColorFunction)) {
			return getColorFunction.apply(this);
		}
		else {
			return Color.OTHER;
		}
	}

	@Override
	public Rank getRank() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit getSuit() {
		// TODO Auto-generated method stub
		return null;
	}

}
