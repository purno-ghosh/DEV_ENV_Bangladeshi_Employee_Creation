package DEV_Employee_Create;

import Setup_All.Setup;
import org.testng.annotations.Test;

import java.io.IOException;

public class DEV_ENV_Bangladeshi_Employee_Create_Runner extends Setup {
   @Test
   public void testEmployeeCreation() throws IOException, InterruptedException {
       DEV_ENV_Bangladeshi_Employee_Create employeeCreate = new DEV_ENV_Bangladeshi_Employee_Create(driver);
       employeeCreate.create_employee();

   }

}
