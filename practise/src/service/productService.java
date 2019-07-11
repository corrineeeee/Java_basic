package service;

import dao.productDao;
import domain.product;

import java.sql.SQLException;
import java.util.List;

public class productService {

    public static List<product> findAll() throws SQLException {
        productDao dao = new productDao();

            return dao.findAll();

    }

}
