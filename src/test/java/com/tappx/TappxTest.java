package com.tappx;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.json.JSONException;
import org.junit.jupiter.api.Test;

public class TappxTest {
    private Tappx tappx;
    
    @Test
    public void testCalculateURLBadJson() {
        tappx = new Tappx(1000, "documents/request_KO.txt");
        Exception exception = assertThrows(JSONException.class, () -> tappx.calculateURL());
        assertTrue(exception.toString().startsWith("org.json.JSONException"));
    }

    @Test
    public void testCalculateURLOKJson() {
        tappx = new Tappx(1000, "documents/request_OK.txt");
        String url = tappx.calculateURL();
        assert(url != null && url != "");
    }

    @Test
    public void checkFileExists() {
        tappx = new Tappx(1000, "documents/request_OK.txt");
        assertEquals(true, tappx.checkFileExists());
    }

    @Test
    public void checkFileNotExists() {
        tappx = new Tappx(1000, "documents/request_FALSE.txt");
        assertEquals(false, tappx.checkFileExists());
    }

    @Test
    public void sendHttpRequestBadRequest() {
        tappx = new Tappx(1000, "documents/request_BAD_REQUEST.txt");
        String url = tappx.calculateURL();
        tappx.sendHttpRequest(url);
        assertEquals(400, tappx.getStatusCode().longValue());
    }

    @Test
    public void sendHttpRequestOK() {
        tappx = new Tappx(1000, "documents/request_OK.txt");
        String url = tappx.calculateURL();
        tappx.sendHttpRequest(url);
        assertTrue(200 == tappx.getStatusCode() || 204 == tappx.getStatusCode());
    }
}
