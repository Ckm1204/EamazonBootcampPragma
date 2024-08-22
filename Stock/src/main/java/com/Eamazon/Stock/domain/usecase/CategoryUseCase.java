package com.Eamazon.Stock.domain.usecase;


import com.Eamazon.Stock.domain.api.ICategoryServicePort;
import com.Eamazon.Stock.domain.model.CategoryModel;
import com.Eamazon.Stock.domain.spi.ICategoryPersistencePort;
import com.Eamazon.Stock.infraestructure.exception.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
public class CategoryUseCase implements ICategoryServicePort {

    private final ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override

    public void saveCategory(CategoryModel categoryModel) {
        if(categoryModel.getName().length() > 50){
            throw new NameTooLongException();
        }else if (categoryModel.getDescription().length() > 90){
            throw new DescriptionTooLongException();
        } else if (categoryPersistencePort.findByName(categoryModel.getName()).isPresent()) {
            throw new CategoryNameAlreadyExistException();
        }
        categoryPersistencePort.createCategory(categoryModel);

    }

    @Override
    public List<CategoryModel> getAllCategories() {
        if (categoryPersistencePort.getAllCategories().isEmpty()) {
            throw new NoDataFoundException();
        }
        return categoryPersistencePort.getAllCategories();
    }

    public Page<CategoryModel> getCategories(PageRequest pageRequest) {
        if (categoryPersistencePort.getCategoriesPage(pageRequest).isEmpty()) {
            throw new NoDataFoundException();
        }
        return categoryPersistencePort.getCategoriesPage(pageRequest);
    }


}