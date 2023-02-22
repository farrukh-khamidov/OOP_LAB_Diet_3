package diet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Represents a complete menu.
 * 
 * It can be made up of both packaged products and servings of given recipes.
 *
 */
public class Menu implements NutritionalElement {
	private String name;
	private Food food;

	private Map<NutritionalElement, Double> recipes = new HashMap<>();
	private Set<NutritionalElement> products = new HashSet<>();

	public Menu(String name, Food food) {
		this.name = name;
		this.food = food;
	}

	/**
	 * Adds a given serving size of a recipe.
	 * The recipe is a name of a recipe defined in the {@code food}
	 * argument of the constructor.
	 * 
	 * @param recipe the name of the recipe to be used as ingredient
	 * @param quantity the amount in grams of the recipe to be used
	 * @return the same Menu to allow method chaining
	 */
	public Menu addRecipe(String recipe, double quantity) {
		NutritionalElement recipeObject = food.getRecipe(recipe);
		recipes.put(recipeObject, quantity);
		return this;
	}

	/**
	 * Adds a unit of a packaged product.
	 * The product is a name of a product defined in the {@code food}
	 * argument of the constructor.
	 * 
	 * @param product the name of the product to be used as ingredient
	 * @return the same Menu to allow method chaining
	 */
	public Menu addProduct(String product) {
		NutritionalElement productObject = food.getProduct(product);
		products.add(productObject);
		return this;
	}

	@Override
	public String getName() {
		return name;
	}

	/**
	 * Total KCal in the menu
	 */
	@Override
	public double getCalories() {
		double totalRecipeCalories = 0;
		double totalProductCalories = 0;

		for (Map.Entry<NutritionalElement, Double> entry : recipes.entrySet()) {
			totalRecipeCalories += entry.getKey().getCalories() * entry.getValue() / 100;
		}
		for (NutritionalElement product : products) {
			totalProductCalories += product.getCalories();
		}

		return totalRecipeCalories + totalProductCalories;
	}

	/**
	 * Total proteins in the menu
	 */
	@Override
	public double getProteins() {
		double totalRecipeCalories = 0;
		double totalProductCalories = 0;

		for (Map.Entry<NutritionalElement, Double> entry : recipes.entrySet()) {
			totalRecipeCalories += entry.getKey().getProteins() * entry.getValue() / 100;
		}
		for (NutritionalElement product : products) {
			totalProductCalories += product.getProteins();
		}

		return totalRecipeCalories + totalProductCalories;
	}

	/**
	 * Total carbs in the menu
	 */
	@Override
	public double getCarbs() {
		double totalRecipeCalories = 0;
		double totalProductCalories = 0;

		for (Map.Entry<NutritionalElement, Double> entry : recipes.entrySet()) {
			totalRecipeCalories += entry.getKey().getCarbs() * entry.getValue() / 100;
		}
		for (NutritionalElement product : products) {
			totalProductCalories += product.getCarbs();
		}

		return totalRecipeCalories + totalProductCalories;
	}

	/**
	 * Total fats in the menu
	 */
	@Override
	public double getFat() {
		double totalRecipeCalories = 0;
		double totalProductCalories = 0;

		for (Map.Entry<NutritionalElement, Double> entry : recipes.entrySet()) {
			totalRecipeCalories += entry.getKey().getFat() * entry.getValue() / 100;
		}
		for (NutritionalElement product : products) {
			totalProductCalories += product.getFat();
		}

		return totalRecipeCalories + totalProductCalories;
	}

	/**
	 * Indicates whether the nutritional values returned by the other methods
	 * refer to a conventional 100g quantity of nutritional element,
	 * or to a unit of element.
	 * 
	 * For the {@link Menu} class it must always return {@code false}:
	 * nutritional values are provided for the whole menu.
	 * 
	 * @return boolean indicator
	 */
	@Override
	public boolean per100g() {
		// nutritional values are provided for the whole menu.
		return false;
	}
}
