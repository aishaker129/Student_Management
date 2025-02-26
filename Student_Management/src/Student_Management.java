import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Student_Management {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("Press 1 to Add student:");
			System.out.println("Press 2 to delete student:");
			System.out.println("Press 3 to display student:");
			System.out.println("Press 4 to Update student: ");
			System.out.println("Press 5 to exit app:");
			
			int choose = Integer.parseInt(br.readLine());
			
			if(choose==1) {
				// Add student...
				System.out.println("Enter user name: ");
				String name = br.readLine();
				System.out.println("Enter user Phone number: ");
				String ph = br.readLine();
				System.out.println("Enter user City: ");
				String city = br.readLine();
				
				// create student object to store student
				Student st = new Student(name,ph,city);
				boolean ans = StudentDao.insertStudentToDB(st);
				if(ans) {
					System.out.println("Successfully store the data");
				}
				else {
					System.out.println("Something went to wrong.try again to store the data");
					
				}
				
				
			}
			else if(choose==2) {
				// delete student...
				System.out.println("Enter user id to delete: ");
				int userId = Integer.parseInt(br.readLine());
				
				boolean f = StudentDao.deleteStudent(userId);
				if(f) {
					System.out.println("Successfully deleted...");
				}else {
					System.out.println("Something went to wrong.try again to delete the data");
				}
			}
			else if(choose == 3) {
				// display student ....
				StudentDao.showAlldata();
			}
			else if(choose == 4) {
				// Update student...
				System.out.println("Enter user id: ");
				int id = Integer.parseInt(br.readLine());
				System.out.println("Enter user name: ");
				String name = br.readLine();
				System.out.println("Enter user phone: ");
				String phone = br.readLine();
				System.out.println("Enter user city: ");
				String city = br.readLine();
				
				Student st = new Student(id,name,phone,city);
				
				boolean f = StudentDao.modify(st);
				if(f) {
					System.out.println("Updated successfully....");
				}
				else {
					System.out.println("Something went to wrong.....");
				}
				
			}
			else if(choose == 5) {
				// exit;
				break;
			}else {
				
			}
			
		}
		
		System.out.println("Thank you for using my application");
		

	}

}
