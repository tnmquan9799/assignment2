package vn.edu.vnuk.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import vn.edu.vnuk.define.Define;
import vn.edu.vnuk.model.Lecturer;

public class LecturerTest {
	
	Lecturer lecturer;
	private final double delta = 0.00001;
	
	@Before
	public void setUp() throws Exception {
		lecturer = new Lecturer.LecturerBuilder(Define.latestId, Define.TYPE_OF_LECTURER)
							   .setYearOfBirth(1999)
							   .setName("Quan Minh")
							   .setHometown("Da Nang")
							   .setDepartment("CSE")
							   .setQualification(Define.QUALIFICATION_OF_MASTER)
							   .setYearOfWork(20)
							   .setPeriodsInMonth(80)
							   .setMinimumWage(Define.DEFAULT_MINIMUM_WAGE)
							   .setSalaryRatio((float) 2.0)
							   .setAllowance(Define.ALLOWANCE_OF_MASTER)
							   .build();
	}
	
	
	@Test
	public void testGetId() {
		assertEquals(0, lecturer.getId());
	}
	
	@Test
	public void testGetType() {
		assertEquals(Define.TYPE_OF_LECTURER, lecturer.getType());
	}
	
	@Test
	public void testGetName() {
		assertEquals("Quan Minh", lecturer.getName());
	}
	
	@Test
	public void testGetYearOfBirth() {
		assertEquals(1999, lecturer.getYearOfBirth());
	}
	
	@Test
	public void testToString() {
		assertEquals("Lecturer [hometown=Da Nang, department=CSE"
						+ ", qualification=MASTER, allowance=900"
						+ ", periodsInMonth=80, salaryRatio=2.0"
						+ ", yearOfWork=20, minimumWage=730.0"
						+ ", id=0, yearOfBirth=1999"
						+ ", type=1, name=Quan Minh]"
						, lecturer.toString());
	}
	
	@Test
	public void testSetYearOfBirth() {
		lecturer.setYearOfBirth(1998);
		assertEquals(1998, lecturer.getYearOfBirth());
	}
	
	@Test
	public void testSetName() {
		lecturer.setName("Quan Hoang");
		assertEquals("Quan Hoang", lecturer.getName());
	}
	
	@Test
	public void testSetHometown() {
		lecturer.setHometown("Sai Gon");
		assertEquals("Sai Gon", lecturer.getHometown());
	}
	
	@Test
	public void testSetDepartment( ) {
		lecturer.setDepartment("IBM");
		assertEquals("IBM", lecturer.getDepartment());
	}
	
	@Test
	public void testSetQualification() {
		lecturer.setQualification(Define.QUALIFICATION_OF_BACHELOR);
		assertEquals(Define.QUALIFICATION_OF_BACHELOR, lecturer.getQualification());
	}
	
	@Test
	public void testYearOfWork() {
		lecturer.setYearOfWork(10);
		assertEquals(10, lecturer.getYearOfWork());
	}
	
	@Test 
	public void testPeriodsInMonth() {
		lecturer.setPeriodsInMonth(100);
		assertEquals(100, lecturer.getPeriodsInMonth());
	}
	

	@Test
	public void testMinimumWage() {
		lecturer.setMinimumWage(Define.DEFAULT_MINIMUM_WAGE);
		assertEquals(730, Define.DEFAULT_MINIMUM_WAGE, delta);
	}
	
	@Test
	public void testSalaryRatio() {
		lecturer.setSalaryRatio((float) 5.0);
		assertEquals(5.0, lecturer.getSalaryRatio(), delta);
	}
	
	@Test
	public void testAllowance() {
		lecturer.setAllowance(Define.ALLOWANCE_OF_BACHELOR);
		assertEquals(300, Define.ALLOWANCE_OF_BACHELOR);
	}
	
	@Test
	public void testUpdate() {
		lecturer.update(900);
		assertEquals(900, lecturer.getMinimumWage(), delta);
	}
	
	@Test
	public void testGetSalary() {
		assertEquals(5960, lecturer.getSalary(), delta);
	}
	
}
