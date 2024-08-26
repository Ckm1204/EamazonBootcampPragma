package com.Eamazon.Stock.infraestructure.out.jpa.adapter;


import com.Eamazon.Stock.infraestructure.exception.NoDataFoundException;
import com.Eamazon.Stock.infraestructure.out.jpa.Entity.Category;
import com.Eamazon.Stock.infraestructure.out.jpa.mapper.CategoryMapperJPA;
import com.Eamazon.Stock.domain.model.CategoryModel;
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
    public void createCategory(CategoryModel categoryModel) {
        if (categoryRepository.findByName(categoryModel.getName()).isPresent()) {
            throw new CategoryNameAlreadyExistException();
        } else categoryRepository.save(categoryMapper.toCategory(categoryModel));
    }

    @Override
    public List<CategoryModel> getAllCategories() {
        List<Category> categoryEntityList = categoryRepository.findAll();
        if (categoryEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return categoryMapper.toCategoryList(categoryEntityList);
    }

    @Override
    public Page<CategoryModel> getCategoriesPage(PageRequest pageRequest) {
        return categoryRepository.findAll(pageRequest)
                .map(categoryMapper::toCategoryModel);
    }

    @Override
    public Optional<CategoryModel> findByName(String name) {
        return categoryRepository.findByName(name)
                .map(categoryMapper::toCategoryModel);
    }
}