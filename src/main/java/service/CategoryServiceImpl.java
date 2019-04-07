package service;

import dao.CategoryDao;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao;

    public CategoryServiceImpl(CategoryService categoryService){
        this.categoryDao = categoryDao;
    }

    @Override
    public int getCategoryIdByCode(String code) {
        return categoryDao.findIdByCategoryCode(code);
    }
}
