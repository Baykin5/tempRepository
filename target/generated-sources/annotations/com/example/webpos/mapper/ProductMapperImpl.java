package com.example.webpos.mapper;

import com.example.webpos.model.Product;
import com.example.webpos.rest.dto.ProductDto;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto toProductDto(Product Product) {
        if ( Product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( Product.getId() );
        productDto.setTid( Product.tid );
        productDto.setPrice( Product.price );
        productDto.setCategory( Product.category );
        productDto.setQuantity( Product.quantity );
        productDto.setName( Product.name );
        productDto.setStock( Product.stock );
        productDto.setImg( Product.img );

        return productDto;
    }

    @Override
    public Collection<ProductDto> toProductsDto(Collection<Product> pets) {
        if ( pets == null ) {
            return null;
        }

        Collection<ProductDto> collection = new ArrayList<ProductDto>( pets.size() );
        for ( Product product : pets ) {
            collection.add( toProductDto( product ) );
        }

        return collection;
    }

    @Override
    public Collection<Product> toProducts(Collection<ProductDto> pets) {
        if ( pets == null ) {
            return null;
        }

        Collection<Product> collection = new ArrayList<Product>( pets.size() );
        for ( ProductDto productDto : pets ) {
            collection.add( toProduct( productDto ) );
        }

        return collection;
    }

    @Override
    public Product toProduct(ProductDto ProductDto) {
        if ( ProductDto == null ) {
            return null;
        }

        Product product = new Product();

        product.tid = ProductDto.getTid();
        if ( ProductDto.getPrice() != null ) {
            product.price = ProductDto.getPrice();
        }
        product.category = ProductDto.getCategory();
        if ( ProductDto.getQuantity() != null ) {
            product.quantity = ProductDto.getQuantity();
        }
        product.name = ProductDto.getName();
        if ( ProductDto.getStock() != null ) {
            product.stock = ProductDto.getStock();
        }
        product.img = ProductDto.getImg();
        product.id = ProductDto.getId();

        return product;
    }
}
