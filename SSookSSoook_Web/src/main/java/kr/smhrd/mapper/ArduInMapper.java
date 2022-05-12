package kr.smhrd.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface ArduInMapper {
	
	/* 아두이노 → DB 센서값 넣기 (토양, 수분) */
	@Insert("insert into sensing_info(sensing_dt, user_id, soil, water) values(now(), 'admin', #{value1}, #{value2});")
	public void SensorValueIn(@Param("value1") String value1, @Param("value2") String value2);
	

}
