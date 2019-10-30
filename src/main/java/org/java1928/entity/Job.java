package org.java1928.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 	职位信息实体类
 * @author junki
 * @date 2019年10月30日
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Job {
	
	private Long id;
	private String name;
	private String company;
	private String address;
	private String salary;
	private String date;
		
}
