package com.github.katjahahn.parser.optheader;

import static org.testng.Assert.*;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

public class DllCharacteristicTest {
    @Test
    public void getAllSet() throws IOException {
        long value = 0xffffffff;
        List<DllCharacteristic> list = DllCharacteristic.getAllFor(value);
        assertEquals(list.size(), DllCharacteristic.values().length);
    }

    @Test
    public void getNothing() throws IOException {
        long value = 0x00000000;
        List<DllCharacteristic> list = DllCharacteristic.getAllFor(value);
        assertEquals(list.size(), 0);
    }

    @Test
    public void getOne() throws IOException {
        long value = 0x100;
        List<DllCharacteristic> list = DllCharacteristic.getAllFor(value);
        assertEquals(list.size(), 1);
        assertEquals(list.get(0).getDescription(),
                "Image is NX compatible.");
        assertEquals(list.get(0), DllCharacteristic.IMAGE_DLL_CHARACTERISTICS_NX_COMPAT);
    }
}
