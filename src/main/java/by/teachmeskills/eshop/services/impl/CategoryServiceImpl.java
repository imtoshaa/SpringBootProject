package by.teachmeskills.eshop.services.impl;

import by.teachmeskills.eshop.dao.ICategoryDao;
import by.teachmeskills.eshop.dao.IProductDao;
import by.teachmeskills.eshop.domain.entities.Category;
import by.teachmeskills.eshop.domain.entities.Product;
import by.teachmeskills.eshop.services.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static by.teachmeskills.eshop.utils.EshopConstants.PRODUCTS_FROM_CATEGORY;
import static by.teachmeskills.eshop.utils.PagesPathEnum.CATEGORY_PAGE;
import static by.teachmeskills.eshop.utils.PagesPathEnum.HOME_PAGE;
import static by.teachmeskills.eshop.utils.EshopConstants.CATEGORIES;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements ICategoryService {

    private final ICategoryDao categoryDao;
    private final IProductDao productDao;

    @Override
    public ModelAndView getCategories() throws Exception {
        ModelMap modelMap = new ModelMap();
        List<Category> categories = categoryDao.read();
        modelMap.addAttribute(CATEGORIES, categories);
        return new ModelAndView(HOME_PAGE.getPath(), modelMap);
    }

    @Override
    public ModelAndView getCategoryData(int categoryId) throws Exception {
        ModelMap modelMap = new ModelMap();
        List<Product> products = productDao.getProductsByCategoryId(categoryId);
        modelMap.addAttribute(PRODUCTS_FROM_CATEGORY, products);
        return new ModelAndView(CATEGORY_PAGE.getPath(), modelMap);
    }
}