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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.Multimap;

public class RankValueMapBuilder {

	private Multimap<Rank, Integer> map = ArrayListMultimap.create();
	
	private List<Plugin<Multimap<Rank, Integer>>> plugins = new ArrayList<>();
	public static final RankValueMapBuilder builder() {
		return new RankValueMapBuilder();
	}
	public RankValueMapBuilder addStandardPokerMappings() {
		return this
		.addMapping(Rank.JOKER, -1)
		.addMapping(Rank.ANY, -1)
		.addMapping(Rank.OTHER, 0)
		.addMapping(Rank.ACE, 1)
		.addMapping(Rank.TWO, 2)
		.addMapping(Rank.THREE, 3)
		.addMapping(Rank.FOUR, 4)
		.addMapping(Rank.FIVE, 5)
		.addMapping(Rank.SIX, 6)
		.addMapping(Rank.SEVEN, 7)
		.addMapping(Rank.EIGHT, 8)
		.addMapping(Rank.NINE, 9)
		.addMapping(Rank.TEN, 10)
		.addMapping(Rank.JACK, 11)
		.addMapping(Rank.QUEEN, 12)
		.addMapping(Rank.KING, 13)
		.addMapping(Rank.ACE, 14)
		.addMapping(Rank.MAX, Integer.MAX_VALUE);
	}
	
	public RankValueMapBuilder addPlugin(Plugin<Multimap<Rank, Integer>> plugin) {
		plugins.add(plugin);
		return this;
	}
	
	public RankValueMapBuilder addMapping(Rank rank, Integer... values) {
		map.putAll(rank, Arrays.asList(values));
		return this;
	}
	
	public Multimap<Rank, Integer> build() {
		for (Plugin<Multimap<Rank, Integer>> plugin : plugins) {
			plugin.apply(map);
		}
		
		return ImmutableListMultimap.copyOf(map);
	}
}
