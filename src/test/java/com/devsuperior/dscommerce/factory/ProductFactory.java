package com.devsuperior.dscommerce.factory;

import com.devsuperior.dscommerce.entities.Category;
import com.devsuperior.dscommerce.entities.Product;

public class ProductFactory {

    public static Product createProduct(){
        Category category = CategoryFactory.createCategory();
        Product product = new Product(1l, "Console Playstation 5", "Descrição padrão", 3999.0, "https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg");
        product.getCategories().add(category);
        return product;
    }

    public static Product createProduct(String name){
        Product product = createProduct();
        product.setName(name);
        return product;
    }
}
