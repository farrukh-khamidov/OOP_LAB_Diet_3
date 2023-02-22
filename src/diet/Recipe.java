package diet;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a recipe of the diet.
 * 
 * A recipe consists of a a set of ingredients that are given amounts of raw materials.
 * The overall nutritional values of a recipe can be computed
 * on the basis of the ingredients' values and are expressed per 100g
 * 
 *
 */
public class Recipe implements NutritionalElement {

	private String name;
	private Food food;

	private Map<String, Double> ingredients = new HashMap<>();

	public Recipe(String name, Food food) {
		this.name = name;
		this.food = food;
	}

	/**
	 * Adds a given quantity of an ingredient to the recipe.
	 * The ingredient is a raw material.
	 * 
	 * @param material the name of the raw material to be used as ingredient
	 * @param quantity the amount in grams of the raw material to be used
	 * @return the same Recipe object, it allows method chaining.
	 */
	public Recipe addIngredient(String material, double quantity) {
		ingredients.put(material, quantity);
		return this;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getCalories() {
		double totalCalories = 0;
		double totalQuantity = 0;

		for (Map.Entry<String, Double> entry : ingredients.entrySet()) {
			totalCalories += food.getRawMaterial(entry.getKey()).getCalories() * entry.getValue() / 100;
			totalQuantity += entry.getValue();
		}

		return totalCalories * 100 / totalQuantity;
	}

	@Override
	public double getProteins() {
		double totalProteins = 0;
		double totalQuantity = 0;

		for (Map.Entry<String, Double> entry : ingredients.entrySet()) {
			totalProteins += food.getRawMaterial(entry.getKey()).getProteins() * entry.getValue() / 100;
			totalQuantity += entry.getValue();
		}

		return totalProteins * 100 / totalQuantity;
	}

	@Override
	public double getCarbs() {
		double totalCarbs = 0;
		double totalQuantity = 0;

		for (Map.Entry<String, Double> entry : ingredients.entrySet()) {
			totalCarbs += food.getRawMaterial(entry.getKey()).getCarbs() * entry.getValue() / 100;
			totalQuantity += entry.getValue();
		}

		return totalCarbs * 100 / totalQuantity;
	}

	@Override
	public double getFat() {
		double totalFat = 0;
		double totalQuantity = 0;

		for (Map.Entry<String, Double> entry : ingredients.entrySet()) {
			totalFat += food.getRawMaterial(entry.getKey()).getFat() * entry.getValue() / 100;
			totalQuantity += entry.getValue();
		}

		return totalFat * 100 / totalQuantity;
	}

	/**
	 * Indicates whether the nutritional values returned by the other methods
	 * refer to a conventional 100g quantity of nutritional element,
	 * or to a unit of element.
	 * 
	 * For the {@link Recipe} class it must always return {@code true}:
	 * a recipe expressed nutritional values per 100g
	 * 
	 * @return boolean indicator
	 */
	@Override
	public boolean per100g() {
	    // a recipe expressed nutritional values per 100g
		return true;
	}

}
