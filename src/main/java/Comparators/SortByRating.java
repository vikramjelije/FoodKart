package Comparators;

import java.util.Comparator;

import OOPSDesign.Models.Restaurant;

public class SortByRating implements Comparator<Restaurant> {

	@Override
	public int compare(Restaurant o1, Restaurant o2) {
		if (o1.getRating() == o2.getRating()) {
			return 0;
		}
		else if (o1.getRating() > o2.getRating()) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
}
