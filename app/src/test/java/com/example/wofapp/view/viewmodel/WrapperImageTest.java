package com.example.wofapp.view.viewmodel;

import com.google.gson.JsonArray;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class WrapperImageTest {

    @Mock
    private WrapperImage wrapperImage;

    @Before
    public void setUp() throws Exception {
        wrapperImage = new WrapperImage(new JsonArray(),"success");
    }

    @Test
    public void shouldResponseFailed() throws Exception{
        verify(wrapperImage.getStatus().equals("success"));
    }
}