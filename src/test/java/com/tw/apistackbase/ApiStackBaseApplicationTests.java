package com.tw.apistackbase;

import com.tw.apistackbase.controller.EmployeeController;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeController.class)
@SpringBootTest
public class ApiStackBaseApplicationTests {

	@Test
	public void should_return_employee_when_invoke_find_given_id() {



	}

}
