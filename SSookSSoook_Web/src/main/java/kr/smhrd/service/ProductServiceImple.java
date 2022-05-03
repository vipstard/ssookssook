package kr.smhrd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.smhrd.domain.ProductVO;
import kr.smhrd.mapper.ProductMapper;

@Service
public class ProductServiceImple implements ProductService{
	

	@Autowired
	private ProductMapper productMapper;

	@Override
	public ArrayList<ProductVO> productList() {
		System.out.println("서비스 실행");
		return null;
	}

	@Override
	public ProductVO detailProduct(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProduct(ProductVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		
	}

}
