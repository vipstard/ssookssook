package kr.smhrd.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.smhrd.domain.ProductVO;

public interface ProductMapper {
	
	//전체 상품리스트 가지고오기
	public List<ProductVO> productList();

				
	
}
