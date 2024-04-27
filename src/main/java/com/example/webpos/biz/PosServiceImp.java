package com.example.webpos.biz;

import com.example.webpos.repository.*;

import jakarta.annotation.PostConstruct;

import com.example.webpos.model.Product;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
@DependsOn("dataSource")
public class PosServiceImp implements PosService {

    private ProductRepository productRepository;

    public PosServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }

    @PostConstruct
    public void init() throws IOException{
        List<Product> JDProducts = parseJD("java");
        for (Product product:JDProducts){
            // addProduct(product);
            // System.out.println(product);
        }
    }

    
    public List<Product> parseJD(String keyword) throws IOException {
        //获取请求https://search.jd.com/Search?keyword=java
        String urlString = "https://search.jd.com/Search?keyword=" + keyword;

        String cookies = "__jdv=122270672%7Cdirect%7C-%7Cnone%7C-%7C1713875440571; mba_muid=17138754405711115796456; __jdu=17138754405711115796456; pinId=dGd7i9BxEGPsfClpsUXfeg; pin=jd_gFdYEwaCpFiq; unick=%E9%9C%9C%E5%BA%8F%E4%B8%89%E4%B8%83; _tp=Qu1Qn%2FncA%2B%2FrnI31N9IRAg%3D%3D; _pst=jd_gFdYEwaCpFiq; TrackID=1a3CK_vMtRhIQ5haSCkjpJo9TETX5ATPeBxcmcxAwARL6wWJgWG19KZGJwO4_DaoTMXKKM02klnSBbDexN38v6qQiTYrrKe4cODNISNN1_oc; thor=C2A85D57EB48160F5CAEBD4953C1C77B24718E43106D24195B08FB7F84FAE30E9EB766A16B994CBD1A8E815442AC1FE6FEB54107BDA93A3CB11EA2BEB630B871FFDE5783EA904F10D26D94A2D3638644198B8603FB5850AD7311C9378E510293BA45CA4325DE00CB7DB4F4F35B87A7F899797FEE59096E79969AE7574C3EFC1C48E2825F878103ED9BC74A5EF498323D4AB2907523ECA3F7E8671E561EF59128; flash=2_Z_Oboead8mWQ-yxykh442aS2e0wH2BRSP8zHpN-GQjA7DL6NJQ3WpQF_0fWE1Iyu2Z4CTiDzfpQKnvwoYCA2TFIvH_Fx111NTW-JrNLky1V*; ipLoc-djd=12-904-0-0; shshshfpa=e02e3c84-48ed-c497-379a-3cbd2a9101bc-1713871888; shshshfpx=e02e3c84-48ed-c497-379a-3cbd2a9101bc-1713871888; areaId=12; jsavif=1; jsavif=1; xapieid=jdd03QSH4EUO7B7FQUAC3K3EVTMOG25S5KVOED2PHV3RFZG7JTJ3354J7P3ZXMV72GZGP5UX2X52TOPZC3OLCHCUEZMHISEAAAAMPBLYILRAAAAAADBTFKDOIOFWK4EX; __jda=143920055.17138754405711115796456.1713875440.1713875440.1714026273.2; __jdb=143920055.1.17138754405711115796456|2.1714026273; __jdc=143920055; 3AB9D23F7A4B3CSS=jdd03QSH4EUO7B7FQUAC3K3EVTMOG25S5KVOED2PHV3RFZG7JTJ3354J7P3ZXMV72GZGP5UX2X52TOPZC3OLCHCUEZMHISEAAAAMPCPWWSZQAAAAAD2OG5AJMWW2HN4X; _gia_d=1; shshshfpb=BApXcTf_lEOpA2JKUuqoqI4VTVcqRV7BmBlHGH6dp9xJ1MqynOoC2; rkv=1.0; qrsc=2; 3AB9D23F7A4B3C9B=QSH4EUO7B7FQUAC3K3EVTMOG25S5KVOED2PHV3RFZG7JTJ3354J7P3ZXMV72GZGP5UX2X52TOPZC3OLCHCUEZMHISE";

        //解析网页
        Document document = Jsoup.connect(urlString)
                        .header("Cookie", cookies)
                            .get();
        //所有js的方法都能用
        Element element = document.getElementById("J_goodsList");
        //获取所有li标签
        Elements elements = element.getElementsByTag("li");
//        System.out.println(element.html());
        List<Product> list = new ArrayList<>();


        //获取元素的内容
        for (Element el : elements
        ) {
            //关于图片特别多的网站，所有图片都是延迟加载的
            String id = el.attr("data-spu");
            String img = "https:".concat(el.getElementsByTag("img").eq(0).attr("data-lazy-img"));
            String price = el.getElementsByAttribute("data-price").text();
            String title = el.getElementsByClass("p-name").eq(0).text();
            
            int quantity = 10;
            int stock = 1;
            String category = "item";
            String tid = id;
            if (title.indexOf("，") >= 0)
                title = title.substring(0, title.indexOf("，"));

            Product product = new Product(id,tid,Double.parseDouble(price),category,quantity,title,stock,img);

            //Product product = new Product(id, title, Double.parseDouble(price), img);

            list.add(product);
        }
        return list;
    }

    
    



    @Override
    public List<Product> products() throws IOException {
        // List<Product> JDProducts = parseJD("java");
        // for (Product product:JDProducts){
        //     addProduct(product);
        //     //System.out.println(product);
        // }
        return productRepository.findAll();
    }

    @Override 
    public Product findProductById(String id){
        return productRepository.findById(id).orElse(null);
    }
    @Override
    public void addProduct(Product product){
        productRepository.save(product);
    }
    @Override
    public void deleteProduct(String productId){
        productRepository.deleteById(productId);
    }



}
