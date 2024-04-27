package com.example.webpos.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.webpos.biz.PosService;
import com.example.webpos.mapper.ProductMapper;
import com.example.webpos.model.Product;
import com.example.webpos.rest.api.ProductApi;
import com.example.webpos.rest.dto.ProductDto;
// import com.example.webpos.rest.dto.UpdatePartialProductRequestDto;

@CrossOrigin
@RestController
public class ProductRestController implements ProductApi{
  PosService posService;
  ProductMapper productMapper;

  public ProductRestController(PosService posService,ProductMapper productMapper){
    this.posService = posService;
    this.productMapper = productMapper;
  }

  @Override
  @CrossOrigin
  public ResponseEntity<ProductDto> getProduct(String productId) {
    ProductDto product = productMapper.toProductDto(this.posService.findProductById(productId));
    if (product == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(product, HttpStatus.OK);
  }


  @Override
  @CrossOrigin
  public ResponseEntity<List<ProductDto>> listProducts(){
    List<ProductDto> products = new ArrayList<>();
      try {
        products = new ArrayList<>(productMapper.toProductsDto(this.posService.products()));
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    if (products.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(products,HttpStatus.OK);
  }

  @Override
  @CrossOrigin
  public ResponseEntity<ProductDto> updateProduct(String productId,ProductDto productDto){
    Product currentProduct = this.posService.findProductById(productId);
    if (currentProduct == null){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    currentProduct.name = productDto.getName();
    currentProduct.price = productDto.getPrice();
    currentProduct.img = productDto.getImg();
    currentProduct.quantity = productDto.getQuantity();
    currentProduct.category = productDto.getCategory();
    currentProduct.stock = productDto.getStock();
    this.posService.addProduct(currentProduct);
    return new ResponseEntity<>(productMapper.toProductDto(currentProduct),HttpStatus.NO_CONTENT);
  }

  @Override
  @CrossOrigin
  public ResponseEntity<ProductDto> deleteProduct(String productId){
    Product product = this.posService.findProductById(productId);
    if (product == null){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    this.posService.deleteProduct(productId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @Override
  @CrossOrigin
  public ResponseEntity<ProductDto> addProduct(ProductDto productDto){
    this.posService.addProduct(productMapper.toProduct(productDto));
    return new ResponseEntity<>(productDto,HttpStatus.OK);
  }


  // 存在问题 415media
  // @Override
  // @CrossOrigin
  // public ResponseEntity<ProductDto> updatePartialProduct(String productId,UpdatePartialProductRequestDto updatePartialProductRequestDto){
  //   Product product = this.posService.findProductById(productId);
  //   if (product == null){
  //     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  //   }
  //   product.quantity = updatePartialProductRequestDto.getQuantity();
  //   this.posService.addProduct(product);
  //   return new ResponseEntity<>(productMapper.toProductDto(product),HttpStatus.OK);
  // }
  @Override
  @CrossOrigin
  public ResponseEntity<ProductDto> updatePartialProduct(String productId,ProductDto productDto){
    Product product = this.posService.findProductById(productId);
    if (product == null){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    product.quantity = productDto.getQuantity();
    this.posService.addProduct(product);
    return new ResponseEntity<>(productMapper.toProductDto(product),HttpStatus.OK);
  }

}
