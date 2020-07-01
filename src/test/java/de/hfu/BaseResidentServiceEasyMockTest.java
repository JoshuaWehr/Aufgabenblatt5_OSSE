package de.hfu;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.easymock.EasyMock.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.*;
import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;
import de.hfu.residents.service.*;
public class BaseResidentServiceEasyMockTest {
	private Resident josh;
	private Resident nico;
	private BaseResidentService testBaseService=new BaseResidentService();
	private ResidentRepository testR;
	
	
	public BaseResidentServiceEasyMockTest() {
		this.nico=new Resident("Nico","Dietz","Teststrasse","Furtwangen",new Date(2017-02-02));
		this.josh = new Resident("Joshua","Wehr","Teststrasse","Furtwangen",new Date(1804-12-05));
		List<Resident> residents = Arrays.asList(this.nico, this.josh);
		this.testR= createMock(ResidentRepository.class);
		
		expect(testR.getResidents()).andReturn(residents);
		testBaseService.setResidentRepository(testR);
		
		replay(testR);
	}
    @Test
    public void testGetUniqueResident() throws Exception {
    	Resident gesucht=new Resident("Joshua","Wehr","Teststrasse","Furtwangen",new Date(1804-12-05));
    	
    	assertThat(gesucht.getFamilyName(), equalTo(testBaseService.getUniqueResident(gesucht).getFamilyName()));
        verify(testR);
    }
}
