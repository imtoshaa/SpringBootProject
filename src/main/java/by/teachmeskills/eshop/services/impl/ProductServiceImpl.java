package by.teachmeskills.eshop.services.impl;

import by.teachmeskills.eshop.dao.IProductDao;
import by.teachmeskills.eshop.dao.impl.ProductDaoImpl;
import by.teachmeskills.eshop.domain.entities.Product;
import by.teachmeskills.eshop.services.IProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static by.teachmeskills.eshop.utils.PagesPathEnum.PRODUCT_PAGE;
import static by.teachmeskills.eshop.utils.EshopConstants.PRODUCT;

@Slf4j
@AllArgsConstructor
@Service
public class ProductServiceImpl implements IProductService {

    private final IProductDao productDao;

    @Override
    public List<Product> getProductsByCategoryId(int categoryId) throws Exception {
        log.info("Receiving products by categoryId=" + categoryId + " in the process.");
        return productDao.getProductsByCategoryId(categoryId);
    }

    @Override
    public Product getProductById(int productId) throws Exception {
        log.info("Receiving product by id=" + productId + " in the process.");
        return productDao.getProductById(productId);
    }

    @Override
    public ModelAndView getProductData(int productId) throws Exception {
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute(PRODUCT, productDao.getProductById(productId));
        log.info("Receiving product data by id=" + productId + " in the process.");
        return new ModelAndView(PRODUCT_PAGE.getPath(), modelMap);
    }
}
