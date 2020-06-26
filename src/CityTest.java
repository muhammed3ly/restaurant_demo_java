import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;

public class CityTest extends TestCase {
    DataLoader dataLoader;
    City city;

    @BeforeClass
    public void setUp()throws Exception{
        dataLoader = new DataLoader();
        city = dataLoader.loadCity();
    }
    @Test
    public void testFindNearestBranch() {
        int branchID = city.findNearestBranch(4);
        int branchBN = -1;
        for(int i = 0 ; i  < city.getBranches().size() ; i++)
        {
            if(city.getBranches().elementAt(i).getId() == branchID)
            {
                branchBN = city.getBranches().elementAt(i).getBlockNumber();
                break;
            }
        }

        assertEquals(3, branchBN);
    }

    @Test
    public void testFindNearestBranchFar() {
        int branchID = city.findNearestBranch(5);
        int branchBN = -1;
        for(int i = 0 ; i  < city.getBranches().size() ; i++)
        {
            if(city.getBranches().elementAt(i).getId() == branchID)
            {
                branchBN = city.getBranches().elementAt(i).getBlockNumber();
                break;
            }
        }

        assertEquals(3, branchBN);
    }
}