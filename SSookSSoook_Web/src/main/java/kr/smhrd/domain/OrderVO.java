package kr.smhrd.domain;

import lombok.Data;

@Data
public class OrderVO {
	
	private String order_date;
	private int order_total;
	private String pay_yn;
	private int discount;
	private int pay_amount;
	private String user_id;
	private String delivery_status;
	private String delivery_addr;
	private String receiver_phone;
	private String receiver_name;
	

}
