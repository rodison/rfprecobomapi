package br.com.rodison.rfprecobom.rfprecobomapi.utils;

public class BuildMap<K, V> extends java.util.HashMap<K, V> {

	public BuildMap<K, V> with(K key, V value) {
		put(key, value);
		return this;
	}

	public static <K, V> BuildMap<K, V> map(K key, V value) {
		return new BuildMap<K, V>().with(key, value);
	}


}
