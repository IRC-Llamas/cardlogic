package com.foss.llamas.poker.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.Multimap;

public class RankValueMapBuilder {

	private Multimap<Rank, Integer> map = ArrayListMultimap.create();
	
	private List<Plugin<Multimap<Rank, Integer>>> plugins = new ArrayList<>();
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
