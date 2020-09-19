package com.hcid.partner.notification.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class VersionControllerTest {

    @InjectMocks
    VersionController versionController;

    @Test
    public void test() {
        versionController.test();
    }
}