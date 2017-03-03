/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import org.sql2o.*;

public class ProtectedAnimalTest {
  @Rule
  public DatabaseRule database = new DatabaseRule();
	
	 @Test
  public void animal_instantiatesCorrectly_true() 
	{
    ProtectedAnimal testAnimal = new ProtectedAnimal("chicken");
    assertEquals(true, testAnimal instanceof ProtectedAnimal);
  }
	
	@Test
  public void getName_animalInstantiatesWithName_Chicken() 
	{
    ProtectedAnimal testAnimal = new ProtectedAnimal("chicken");
    assertEquals("chicken", testAnimal.getName());
  }
	
	@Test
  public void equals_returnsTrueIfNameAreSame_true() 
	{
   ProtectedAnimal testAnimal = new ProtectedAnimal("chicken");
   ProtectedAnimal anotherAnimal = new ProtectedAnimal("chicken");
    assertTrue(testAnimal.equals(anotherAnimal));
  }
//	
	@Test
  public void save_insertsObjectIntoDatabase_ProtectedAnimal() 
	{
    ProtectedAnimal testAnimal = new ProtectedAnimal("chicken");
    testAnimal.save();
    assertEquals(true, ProtectedAnimal.all().get(0).equals(testAnimal));
  }
//	
	 @Test
  public void all_returnsAllInstancesOfPerson_true() 
	{
    
		ProtectedAnimal firstAnimal = new ProtectedAnimal("chicken");
    firstAnimal.save();
   	ProtectedAnimal secondAnimal = new ProtectedAnimal("elephant");
    secondAnimal.save();
    assertEquals(true, ProtectedAnimal.all().get(0).equals(firstAnimal));
    assertEquals(true, ProtectedAnimal.all().get(1).equals(secondAnimal));
  }

	@Test
	public void save_assignsIdToObject(){
    Animal testAnimal = new Animal("chicken");
		testAnimal.save();
		Animal savedAnimal = Animal.all().get(0);
		assertEquals(testAnimal.getId(),savedAnimal.getId());
	}
	
}