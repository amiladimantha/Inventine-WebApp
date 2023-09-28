package com.inventine.dao;

import com.inventine.model.Competition;
import com.inventine.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompetitionDaoImplementationTest {

    Competition competition;
    CompetitionDaoImplementation competitionDao;

    @BeforeEach
    void setUp() {
        this.competition = new Competition();
        this.competitionDao = new CompetitionDaoImplementation();
    }

    @Test
    void getCount() {
        assertEquals(competitionDao.getCount("organizationid=17"),2
        );
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Competition.csv", numLinesToSkip = 1)
    void create(String competition_Id,String organization_Id,String support_Team_Id, Timestamp created_At, Timestamp ending_at, int prize_money,  String rules,char c_type, char p_type,String competition_name,String header_Id,Timestamp staring_At,String over_view,char status) {
        this.competition.setCompetitionId(competition_Id);
        this.competition.setOrganizationId(organization_Id);
        this.competition.setSupportTeamId(support_Team_Id);
        this.competition.setCreatedAt(created_At);
        this.competition.setEndingAt(ending_at);
        this.competition.setPrizeMoney(prize_money);
        this.competition.setRules(rules);
        this.competition.setCType(c_type);
        this.competition.setPType(p_type);
        this.competition.setCompetitionName(competition_name);
        this.competition.setHeaderId(header_Id);
        this.competition.setStartingAt(staring_At);
        this.competition.setOverView(over_view);
        this.competition.setStatus(status);

        assertTrue(this.competitionDao.create(competition));
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/model/Competition.csv", numLinesToSkip = 1)
    void getCompetition(String competition_Id,String organization_Id,String support_Team_Id, Timestamp created_At, Timestamp ending_at, int prize_money,  String rules,char c_type, char p_type,String competition_name,String header_Id,Timestamp starting_At,String over_view,char status) {

        this.competition = this.competitionDao.getCompetition(competition_Id);

        assertEquals(competition_Id, this.competition.getCompetitionId());
        assertEquals(organization_Id, this.competition.getOrganizationId());
        assertEquals(support_Team_Id, this.competition.getSupportTeamId());
        assertEquals(created_At, this.competition.getCreatedAt());
        assertEquals(ending_at, this.competition.getEndingAt());
        assertEquals(prize_money, this.competition.getPrizeMoney());
        assertEquals(rules,this.competition.getRules());
        assertEquals(c_type, this.competition.getCType());
        assertEquals(p_type, this.competition.getPType());
        assertEquals(competition_name,this.competition.getCompetitionName());
        assertEquals(header_Id, this.competition.getHeaderId());
        assertEquals(starting_At, this.competition.getStartingAt());
        assertEquals(over_view,this.competition.getOverView());
        assertEquals(status,this.competition.getStatus());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Competition.csv", numLinesToSkip = 1)
    void getCompetitions(String competition_Id,String organization_Id,String support_Team_Id, Timestamp created_At, Timestamp ending_at, int prize_money,  String rules,char c_type, char p_type,String competition_name,String header_Id,Timestamp starting_At,String over_view,char status) {

        List<Competition> ls = this.competitionDao.getCompetitions("");

        this.competition.setCompetitionId(competition_Id);
        this.competition.setOrganizationId(organization_Id);
        this.competition.setSupportTeamId(support_Team_Id);
      //  this.competition.setProjectId(project_Id);
        this.competition.setCreatedAt(created_At);
        this.competition.setEndingAt(ending_at);
        this.competition.setPrizeMoney(prize_money);
        this.competition.setRules(rules);
        this.competition.setCType(c_type);
        this.competition.setPType(p_type);
        this.competition.setCompetitionName(competition_name);
        this.competition.setHeaderId(header_Id);
        this.competition.setStartingAt(starting_At);
        this.competition.setOverView(over_view);
        this.competition.setStatus(status);
        assertEquals(ls.get(0).getCompetitionId(),this.competition.getCompetitionId());
        assertEquals(ls.get(0).getOrganizationId(),this.competition.getOrganizationId());
        assertEquals(ls.get(0).getSupportTeamId(),this.competition.getSupportTeamId());
     //   assertEquals(ls.get(0).getProjectId(),this.competition.getProjectId());
        assertEquals(ls.get(0).getCreatedAt(),this.competition.getCreatedAt());
        assertEquals(ls.get(0).getEndingAt(),this.competition.getEndingAt());
        assertEquals(ls.get(0).getPrizeMoney(),this.competition.getPrizeMoney());
        assertEquals(ls.get(0).getRules(),this.competition.getRules());
        assertEquals(ls.get(0).getCType(),this.competition.getCType());
        assertEquals(ls.get(0).getPType(),this.competition.getPType());
        assertEquals(ls.get(0).getCompetitionName(),this.competition.getCompetitionName());
        assertEquals(ls.get(0).getHeaderId(),this.competition.getHeaderId());
        assertEquals(ls.get(0).getStartingAt(),this.competition.getStartingAt());
        assertEquals(ls.get(0).getOverView(),this.competition.getOverView());
        assertEquals(ls.get(0).getStatus(),this.competition.getStatus());


    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Competition.csv", numLinesToSkip = 1)
    void update(String competition_Id,String organization_Id,String support_Team_Id, Timestamp created_At, Timestamp ending_at, int prize_money,  String rules,char c_type, char p_type,String competition_name,String header_Id,Timestamp starting_At,String over_view,char status) {

        this.competition.setCompetitionId(competition_Id);
        this.competition.setOrganizationId(organization_Id);
        this.competition.setSupportTeamId(support_Team_Id);
   //     this.competition.setProjectId(project_Id);
       // this.competition.setCreatedAt(created_At);
        this.competition.setEndingAt(ending_at);
        this.competition.setPrizeMoney(prize_money);
        this.competition.setRules(rules);
        this.competition.setCType('T');
        this.competition.setPType('I');
        this.competition.setCompetitionName(competition_name);
        this.competition.setHeaderId(header_Id);
        this.competition.setStartingAt(starting_At);
        this.competition.setOverView(over_view);
        this.competition.setStatus(status);

        this.competitionDao.update(this.competition);

        Competition updated = this.competitionDao.getCompetition(competition_Id);

        assertEquals(this.competition.getCompetitionId(),updated.getCompetitionId());
        assertEquals(this.competition.getOrganizationId(),updated.getOrganizationId());
        assertEquals(this.competition.getSupportTeamId(),updated.getSupportTeamId());
      //  assertEquals(this.competition.getProjectId(),updated.getProjectId());
       // assertEquals(this.competition.getCreatedAt(),updated.getCreatedAt());
        assertEquals(this.competition.getEndingAt(),updated.getEndingAt());
        assertEquals(this.competition.getPrizeMoney(),updated.getPrizeMoney());
        assertEquals(this.competition.getRules(),updated.getRules());
        assertEquals('T',updated.getCType());
        assertEquals('I',updated.getPType());
        assertEquals(this.competition.getCompetitionName(),updated.getCompetitionName());
        assertEquals(this.competition.getHeaderId(),updated.getHeaderId());
        assertEquals(this.competition.getStartingAt(),updated.getStartingAt());
        assertEquals(this.competition.getOverView(),updated.getOverView());
        assertEquals(this.competition.getStatus(),updated.getStatus());





    }

}