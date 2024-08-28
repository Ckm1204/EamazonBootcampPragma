package com.Eamazon.Stock.domain.usecase;


import com.Eamazon.Stock.domain.api.ICategoryServicePort;
import com.Eamazon.Stock.domain.model.request.CategoryModelRequest;
import com.Eamazon.Stock.domain.model.response.CategoryModelResponse;
import com.Eamazon.Stock.domain.spi.ICategoryPersistencePort;
import com.Eamazon.Stock.infraestructure.exception.*;


import java.util.List;
public class CategoryUseCase implements ICategoryServicePort {

    private final ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override

    public void saveCategory(CategoryModelRequest categoryModelRequest) {
        if(categoryModelRequest.getName().length() > 50){
            throw new NameTooLongException();
        }else if (categoryModelRequest.getDescription().length() > 90){
            throw new DescriptionTooLongException();
        } else if (categoryPersistencePort.findByName(categoryModelRequest.getName()).isPresent()) {
            throw new CategoryNameAlreadyExistException();
        }else {
            categoryPersistencePort.createCategory(categoryModelRequest);
        }
    }

    @Override
    public List<CategoryModelResponse> getAllCategories() {
        if (categoryPersistencePort.getAllCategories().isEmpty()) {
            throw new NoDataFoundException();
        }
        return categoryPersistencePort.getAllCategories();
    }




}