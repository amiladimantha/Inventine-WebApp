package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


import static org.junit.jupiter.api.Assertions.assertEquals;

class CreatorTest {
    Creator creator;

    @BeforeEach
    void setUp() {
        this.creator = new Creator();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Creator.csv", numLinesToSkip = 1)
    void getterSetter(String creator_id, String customer_id, String support_team_id) {

        this.creator.setCreatorId(creator_id);
        this.creator.setCustomerId(customer_id);
        this.creator.setSupportTeamId(support_team_id);

        assertEquals(creator_id, this.creator.getCreatorId());
        assertEquals(customer_id, this.creator.getCustomerId());
        assertEquals(support_team_id, this.creator.getSupportTeamId());

    }
}
