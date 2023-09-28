package com.inventine.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class SHA256Test {

    SHA256 hasher;

    @BeforeEach
    void setUp() {
        hasher = new SHA256();
    }

    @Test
    void TestHasher() throws NoSuchAlgorithmException {

        assertEquals(hasher.getHexString("safrbaedgnrn+r64hrn1wr2nwy5tw5n13gwt231"),"c5e14140412b18cb042d06ea360474ba58d321a0e4aa51841ae0cc87671c238d");
    }


}