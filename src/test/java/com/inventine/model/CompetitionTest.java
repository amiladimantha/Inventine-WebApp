package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompetitionTest {
    Competition competition;

    @BeforeEach
    void setUp() {
        this.competition = new Competition();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Competition.csv", numLinesToSkip = 1)
    void getterSetter(String competition_Id,String organization_Id,String support_Team_Id,String project_Id, Timestamp created_At, Timestamp ending_at, int prize_money,  String rules,char c_type, char p_type,String competition_name, String header_Id,Timestamp starting_At,String over_view, char status) {

        this.competition.setCompetitionId(competition_Id);
        this.competition.setOrganizationId(organization_Id);
        //this.competition.setProjectId(project_Id);
        this.competition.setSupportTeamId(support_Team_Id);
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

        assertEquals(competition_Id, this.competition.getCompetitionId());
        assertEquals(organization_Id, this.competition.getOrganizationId());
        assertEquals(support_Team_Id,this.competition.getSupportTeamId());
       // assertEquals(project_Id, this.competition.getProjectId());
        assertEquals(created_At, this.competition.getCreatedAt());
        assertEquals(ending_at, this.competition.getEndingAt());
        assertEquals(prize_money, this.competition.getPrizeMoney());
        assertEquals(rules, this.competition.getRules());
        assertEquals(c_type,this.competition.getCType());
        assertEquals(p_type,this.competition.getPType());
        assertEquals(competition_name,this.competition.getCompetitionName());
        assertEquals(header_Id,this.competition.getHeaderId());
        assertEquals(starting_At,this.competition.getStartingAt());
        assertEquals(over_view,this.competition.getOverView());
        assertEquals(status,this.competition.getStatus());
    }
}
