public class StudnetTest
{
	public static void main(String[] args)
	{
		Student account1 = new Student("Jane Green", 93.5);
		Student account2 = new Student("John Blue", 72.75);
		
		displayStudent(account1);
		displayStudent(account2);
	}
	
	public static void displayStudent(Student student)
	{
		System.out.printf("%s%s%n%s%.2f%n%s%s%n",
			"Name: ", student.getName(),
			"Average: ", student.getAverage(),
			"Letter grade: ", student.getLetterGrade());
	}
}
