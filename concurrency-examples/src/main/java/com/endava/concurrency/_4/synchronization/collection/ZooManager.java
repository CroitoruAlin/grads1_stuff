package com.endava.concurrency._4.synchronization.collection;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ZooManager {

	private Map<String, Integer> foodData = new ConcurrentHashMap<String, Integer>();

	public void put(final String animal, final Integer amount) {
		foodData.put(animal, amount);
	}

	public Integer get(final String animal) {
		return foodData.get(animal);
	}

	public Set<String> getKeySet() {
		return foodData.keySet();
	}

	public void remove(final String animal) {
		foodData.remove(animal);
	}

	public static void main(final String[] args) {
		final ZooManager mooManager = new ZooManager();
		mooManager.put("penguin", 1);
		mooManager.put("flamingo", 2);

		// mooManager.synchronizedMap();

		for (final String key : mooManager.getKeySet()) {
			mooManager.remove(key);
		}

		System.out.println("Done!");
	}

	/**
	 * 
	 */
	private void synchronizedMap() {
		foodData = Collections.synchronizedMap(foodData);
	}

}
