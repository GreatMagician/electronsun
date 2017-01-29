package web.product;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import service.ProductService;

import java.util.List;
import java.util.Objects;

/**
 * Created by Александр on 21.01.2017.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/products")
    public String login(ModelMap model) {
        return "admin/products";
    }

    @RequestMapping(value = "/loadproducts", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody List<Product> loadProducts (){
        return productService.getAll();
    }

    @RequestMapping(value = "/updateproduct", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody Product saveProduct(@RequestParam Long id, @RequestParam("column") String column,
                                             @RequestParam("value") String value ) {
        return productService.update(id, column, value);
    }

    @RequestMapping(value = "/deleteproduct", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody void deleteProduct(@RequestParam Long id) {
        productService.delete(id);
    }

    @RequestMapping(value = "/addproduct", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody Product addProduct(@RequestParam String name, @RequestParam String description,
                                         @RequestParam String price, @RequestParam String discount,
                                         @RequestParam String maxLed) {
        Product product = new Product(null, name, description, Double.parseDouble(price),
                Integer.parseInt(discount), Integer.parseInt(maxLed));
        return productService.save(product);
    }

}
