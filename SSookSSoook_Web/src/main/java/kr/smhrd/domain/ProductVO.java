package kr.smhrd.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ProductVO {
	private int idx; //상품번호
	private String name; //상품이름
	private int price; //상품가격
	private String desc; //상품 상세정보
	private String url; //상품이미지 경로
	//private MultipartFile photo;// 상품이지미파일
	

}
