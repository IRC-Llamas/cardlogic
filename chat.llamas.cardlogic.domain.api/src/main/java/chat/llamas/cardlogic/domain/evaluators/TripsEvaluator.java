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
package chat.llamas.cardlogic.domain.evaluators;

import chat.llamas.cardlogic.domain.HandResultType;
import chat.llamas.cardlogic.domain.Rank;
import com.google.common.collect.Multimap;

public class TripsEvaluator extends MultiplesEvaluator {

	public TripsEvaluator(Multimap<Rank, Integer> rankValueMap) {
		super(HandResultType.THREE_KIND, 3, rankValueMap);
	}

	public TripsEvaluator() {
		super(HandResultType.THREE_KIND, 3);
	}
}
