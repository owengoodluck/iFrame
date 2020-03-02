package com.owen.iframe.http;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;


@Slf4j
@Ignore
public class GoogleHttpClientTest {

    @Test
    public void test() throws IOException {
        String url = "https://baidu.com";
        HttpRequestFactory requestFactory = new NetHttpTransport().createRequestFactory();
        HttpRequest request = requestFactory.buildGetRequest(  new GenericUrl(url));
        String rawResponse = request.execute().parseAsString();
        log.info("Response [{}] ",rawResponse);
    }


    @Test
    public void testIgnoreSSL() throws Exception {
        String url = "http://ptsv2.com/t/oushunwu/post"; //"https://baidu.com"
        HttpRequestFactory requestFactory =new NetHttpTransport.Builder().doNotValidateCertificate().build().createRequestFactory();
        HttpRequest request = requestFactory.buildGetRequest(  new GenericUrl(url));

        BasicAuthentication auth = new BasicAuthentication("username","password");
        request.setInterceptor(auth);
        //auth.intercept(request);

        String rawResponse = request.execute().parseAsString();
        log.info("Response [{}] ",rawResponse);
    }

    @Test
    public void requestWithHttpContent() throws Exception {
        String context = "RequestBody";
        HttpContent httpContent = new HttpContent() {
            @Override
            public long getLength() throws IOException {
                return 0;
            }

            @Override
            public String getType() {
                return null;
            }

            @Override
            public boolean retrySupported() {
                return false;
            }

            @Override
            public void writeTo(OutputStream outputStream) throws IOException {
                outputStream.write(context.getBytes());
                outputStream.flush();
                outputStream.flush();
            }
        };
        HttpRequestFactory requestFactory =new NetHttpTransport.Builder().doNotValidateCertificate().build().createRequestFactory();
        String url = "https://ptsv2.com/t/oushunwu/post"; //"https://baidu.com"
        HttpRequest request = requestFactory.buildPostRequest(new GenericUrl(url),httpContent);

        String rawResponse = request.execute().parseAsString();
        log.info("Response [{}] ",rawResponse);
    }
}
