package com.example.webpos.biz;


import com.example.webpos.model.Product;

import java.io.IOException;
import java.util.List;

// 业务逻辑层，负责从下层获取数据，封装好处理逻辑供上层使用

public interface PosService {
    public List<Product> products() throws IOException;
    public Product findProductById(String id);
    public void addProduct(Product product);
    public void deleteProduct(String productId);

    

}
