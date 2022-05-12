package kr.smhrd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.smhrd.mapper.ArduInMapper;

@Service
public class ArduInServiceImple implements ArduInService{

	@Autowired
	private ArduInMapper arduInMapper;
	
	/* 아두이노 → DB 값 Insert (토양수분 값, 수위센서 값) */
	@Override
	public void SensorValueIn(String value1, String value2) {
		arduInMapper.SensorValueIn(value1, value2);
		
		
	}

}
