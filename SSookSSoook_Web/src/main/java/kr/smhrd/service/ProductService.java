package kr.smhrd.service;

import java.util.ArrayList;
import java.util.List;

import kr.smhrd.domain.ProductVO;


public interface ProductService {
	
	// 01. 상품목록
	public ArrayList<ProductVO> productList();
	
	// 02. 상품상세
	public ProductVO detailProduct(int productId);
	
	// 03. 상품수정
	public void updateProduct(ProductVO vo);
	
	//04 상품 삭제
	public void deleteProduct(int productId);

	
}
