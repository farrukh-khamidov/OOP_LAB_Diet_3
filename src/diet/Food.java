package diet;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;


/**
 * Facade class for the diet management.
 * It allows defining and retrieving raw materials and products.
 *
 */
public class Food {
	Set<NutritionalElement> rawMaterials = new TreeSet<>(new ByNameRawMaterialComparator());
	Set<NutritionalElement> products = new TreeSet<>(new ByNameRawMaterialComparator());
	Set<NutritionalElement> recipes = new TreeSet<>(new ByNameRawMaterialComparator());

	/**
	 * Define a new raw material.
	 * The nutritional values are specified for a conventional 100g quantity
	 * @param name unique name of the raw material
	 * @param calories calories per 100g
	 * @param proteins proteins per 100g
	 * @param carbs carbs per 100g
	 * @param fat fats per 100g
	 */
	public void defineRawMaterial(String name,
									  double calories,
									  double proteins,
									  double carbs,
									  double fat){

		RawMaterial rawMaterial = new RawMaterial(name, calories, proteins, carbs, fat);
		rawMaterials.add(rawMaterial);
	}
	
	/**
	 * Retrieves the collection of all defined raw materials
	 * @return collection of raw materials though the {@link NutritionalElement} interface
	 */
	public Collection<NutritionalElement> rawMaterials(){
		return rawMaterials;
	}
	
	/**
	 * Retrieves a specific raw material, given its name
	 * @param name  name of the raw material
	 * @return  a raw material though the {@link NutritionalElement} interface
	 */
	public NutritionalElement getRawMaterial(String name){
		for (NutritionalElement rawMaterial : rawMaterials) {
			if (rawMaterial.getName().equals(name)) return rawMaterial;
		}
		return null;
	}

	/**
	 * Define a new packaged product.
	 * The nutritional values are specified for a unit of the product
	 * @param name unique name of the product
	 * @param calories calories for a product unit
	 * @param proteins proteins for a product unit
	 * @param carbs carbs for a product unit
	 * @param fat fats for a product unit
	 */
	public void defineProduct(String name,
								  double calories,
								  double proteins,
								  double carbs,
								  double fat){
		Product product = new Product(name, calories, proteins, carbs, fat);
		products.add(product);

	}
	
	/**
	 * Retrieves the collection of all defined products
	 * @return collection of products though the {@link NutritionalElement} interface
	 */
	public Collection<NutritionalElement> products(){
		return products;
	}
	
	/**
	 * Retrieves a specific product, given its name
	 * @param name  name of the product
	 * @return  a product though the {@link NutritionalElement} interface
	 */
	public NutritionalElement getProduct(String name){
		for (NutritionalElement product : products) {
			if (product.getName().equals(name)) return product;
		}
		return null;
	}
	
	/**
	 * Creates a new recipe stored in this Food container.
	 *  
	 * @param name name of the recipe
	 * @return the newly created Recipe object
	 */
	public Recipe createRecipe(String name) {
		Recipe recipe = new Recipe(name, this);
		recipes.add(recipe);
		return recipe;
	}
	
	/**
	 * Retrieves the collection of all defined recipes
	 * @return collection of recipes though the {@link NutritionalElement} interface
	 */
	public Collection<NutritionalElement> recipes(){
		return recipes;
	}
	
	/**
	 * Retrieves a specific recipe, given its name
	 * @param name  name of the recipe
	 * @return  a recipe though the {@link NutritionalElement} interface
	 */
	public NutritionalElement getRecipe(String name){
		for (NutritionalElement recipe : recipes) {
			if (recipe.getName().equals(name)) return recipe;
		}
		return null;
	}
	
	/**
	 * Creates a new menu
	 * 
	 * @param name name of the menu
	 * @return the newly created menu
	 */
	public Menu createMenu(String name) {
		Menu menu = new Menu(name, this);
		return menu;
	}

	private static class ByNameRawMaterialComparator implements Comparator<NutritionalElement> {


		@Override
		public int compare(NutritionalElement o1, NutritionalElement o2) {
			return o1.getName().compareTo(o2.getName());
		}
	}
	
}
