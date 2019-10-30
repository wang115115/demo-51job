package org.java1928.test;

import org.java1928.service.JobService;

/**
 * 	测试用类
 * @author junki
 * @date 2019年10月30日
 */
public class MyTest {

	public static void main(String[] args) {
		
		JobService jobService = new JobService();
		
		jobService.init(1, 20);
		
	}
	
}
