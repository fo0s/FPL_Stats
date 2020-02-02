package model;

import com.fo0s.model.PersonalInfo;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PersonalInfoTest {
    private static final int randomIntNumber = 1;
    private static final long randomLongNumber = 1;
    private static final String randomString = "a";


    @Test
    public void setPersonalInfoBuilder_returnsPersonalInfoModel() {
        PersonalInfo.PersonalInfoBuilder personalInfoBuilder = new PersonalInfo.PersonalInfoBuilder();

        ArrayList<Long> leagueIds = new ArrayList<>();
        ArrayList<String> leagueNames = new ArrayList<>();

        leagueIds.add(randomLongNumber);
        leagueNames.add(randomString);

        personalInfoBuilder.setCurrentWeek(randomIntNumber);
        personalInfoBuilder.setOverallRank(randomIntNumber);
        personalInfoBuilder.setOverallPoints(randomIntNumber);
        personalInfoBuilder.setLastName(randomString);
        personalInfoBuilder.setFirstName(randomString);
        personalInfoBuilder.setLeagueIds(leagueIds);
        personalInfoBuilder.setLeagueNames(leagueNames);

        PersonalInfo personalInfo = personalInfoBuilder.build();

        assertEquals(randomIntNumber, personalInfo.getCurrentWeek());
        assertEquals(randomIntNumber, personalInfo.getOverallRank());
        assertEquals(randomIntNumber, personalInfo.getOverallPoints());
        assertEquals(randomString, personalInfo.getFirstName());
        assertEquals(randomString, personalInfo.getLastName());
        assertEquals(leagueIds, personalInfo.getLeagueIds());
        assertEquals(leagueNames, personalInfo.getLeagueNames());
    }
}
