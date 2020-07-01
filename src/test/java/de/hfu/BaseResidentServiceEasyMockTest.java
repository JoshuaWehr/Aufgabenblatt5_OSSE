package de.hfu;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.easymock.EasyMock.*;
import java.util.Date;
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
		this.testR=createMock(ResidentRepository.class);
		testBaseService.setResidentRepository(testR);
		replay(testR);
	}
    @Test
    public void testGetUniqueResident() throws Exception {
    	assertThat(nico.getFamilyName(), equalTo(testBaseService.getUniqueResident(nico).getFamilyName()));
    	assertThat(josh.getFamilyName(), equalTo(testBaseService.getUniqueResident(josh).getFamilyName()));
        verify(testR);
    }
}
