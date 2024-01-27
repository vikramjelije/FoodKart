package Comparators;

import java.util.Comparator;

import OOPSDesign.Models.Restaurant;

public class SortByPrice implements Comparator<Restaurant> {
	@Override
	public int compare(Restaurant o1, Restaurant o2) {
		return (int) (o1.getPrice() - o2.getPrice());
	}

}
