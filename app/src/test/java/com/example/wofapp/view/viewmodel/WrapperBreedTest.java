package com.example.wofapp.view.viewmodel;

import com.google.gson.JsonArray;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class WrapperBreedTest {

    @Mock private WrapperBreed wrapperBreed;

    @Before
    public void setUp() throws Exception{
        wrapperBreed = new WrapperBreed(new JsonArray(),"failed");
    }

    @Test
    public void shouldResponseFailed(){
        verify(wrapperBreed.getStatus().equalsIgnoreCase("succces"));
    }

}