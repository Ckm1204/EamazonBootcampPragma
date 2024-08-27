package com.Eamazon.Stock.infraestructure.out.jpa.adapter;


import com.Eamazon.Stock.domain.model.request.CategoryModelRequest;
import com.Eamazon.Stock.domain.model.response.CategoryModelResponse;
import com.Eamazon.Stock.infraestructure.exception.NoDataFoundException;
import com.Eamazon.Stock.infraestructure.out.jpa.Entity.Category;
import com.Eamazon.Stock.infraestructure.out.jpa.mapper.CategoryMapperJPA;
import com.Eamazon.Stock.domain.spi.ICategoryPersistencePort;
import com.Eamazon.Stock.infraestructure.out.jpa.repository.ICategoryRepository;
import com.Eamazon.Stock.infraestructure.exception.CategoryNameAlreadyExistException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;
import java.util.Optional;


public class CategoryJpaAdapter implements ICategoryPersistencePort {

    private final ICategoryRepository categoryRepository;
    private final CategoryMapperJPA categoryMapper;


    public CategoryJpaAdapter(ICategoryRepository categoryRepository, CategoryMapperJPA categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }


    @Override
    public void createCategory(CategoryModelRequest categoryModelRequest) {
        if (categoryRepository.findByName(categoryModelRequest.getName()).isPresent()) {
            throw new CategoryNameAlreadyExistException();
        } else categoryRepository.save(categoryMapper.toCategory(categoryModelRequest));
    }

    @Override
    public List<CategoryModelResponse> getAllCategories() {
        List<Category> categoryEntityList = categoryRepository.findAll();
        if (categoryEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return categoryMapper.toCategoryList(categoryEntityList);
    }

    @Override
    public Optional<CategoryModelRequest> findByName(String name) {
        return categoryRepository.findByName(name)
                .map(categoryMapper::toCategoryModel);
    }
}