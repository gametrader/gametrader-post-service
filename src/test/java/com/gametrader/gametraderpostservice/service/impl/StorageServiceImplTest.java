package com.gametrader.gametraderpostservice.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.StringInputStream;

import java.io.ByteArrayInputStream;

import java.io.DataInputStream;
import java.io.IOException;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MultipartFile;

@ContextConfiguration(classes = {StorageServiceImpl.class})
@ExtendWith(SpringExtension.class)
class StorageServiceImplTest {
    @MockBean
    private AmazonS3 amazonS3;

    @Autowired
    private StorageServiceImpl storageServiceImpl;

    /**
     * Method under test: {@link StorageServiceImpl#uploadFile(org.springframework.web.multipart.MultipartFile)}
     */
    @Test
    void testUploadFile() throws IOException {


        this.storageServiceImpl
                .uploadFile(new MockMultipartFile("Name", new ByteArrayInputStream("AAAAAAAA".getBytes("UTF-8"))));
    }

    /**
     * Method under test: {@link StorageServiceImpl#uploadFile(MultipartFile)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUploadFile2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.gametrader.gametraderpostservice.service.impl.StorageServiceImpl.uploadFile(StorageServiceImpl.java:29)
        //   In order to prevent uploadFile(MultipartFile)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   uploadFile(MultipartFile).
        //   See https://diff.blue/R013 to resolve this issue.

        this.storageServiceImpl.uploadFile(null);
    }

    /**
     * Method under test: {@link StorageServiceImpl#uploadFile(MultipartFile)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUploadFile3() {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access files outside the temporary directory (file 'foo.txt', permission 'write').
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        MultipartFile multipartFile = mock(MultipartFile.class);
        when(multipartFile.getOriginalFilename()).thenReturn("foo.txt");
        this.storageServiceImpl.uploadFile(multipartFile);
    }

    /**
     * Method under test: {@link StorageServiceImpl#downloadFile(String)}
     */
    @Test
    void testDownloadFile() throws SdkClientException, UnsupportedEncodingException {
        S3Object s3Object = new S3Object();
        s3Object.setObjectContent(new StringInputStream("Lorem ipsum dolor sit amet."));
        when(this.amazonS3.getObject((String) any(), (String) any())).thenReturn(s3Object);
        assertEquals(27, this.storageServiceImpl.downloadFile("foo.txt").length);
        verify(this.amazonS3).getObject((String) any(), (String) any());
    }

    /**
     * Method under test: {@link StorageServiceImpl#downloadFile(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDownloadFile2() throws SdkClientException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at java.io.DataInputStream.read(DataInputStream.java:149)
        //       at com.amazonaws.internal.SdkFilterInputStream.read(SdkFilterInputStream.java:90)
        //       at java.io.FilterInputStream.read(FilterInputStream.java:107)
        //       at com.amazonaws.util.IOUtils.toByteArray(IOUtils.java:44)
        //       at com.gametrader.gametraderpostservice.service.impl.StorageServiceImpl.downloadFile(StorageServiceImpl.java:41)
        //   In order to prevent downloadFile(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   downloadFile(String).
        //   See https://diff.blue/R013 to resolve this issue.

        S3Object s3Object = new S3Object();
        s3Object.setObjectContent(mock(DataInputStream.class));
        when(this.amazonS3.getObject((String) any(), (String) any())).thenReturn(s3Object);
        this.storageServiceImpl.downloadFile("foo.txt");
    }

    /**
     * Method under test: {@link StorageServiceImpl#deleteFile(String)}
     */
    @Test
    void testDeleteFile() throws SdkClientException {
        doNothing().when(this.amazonS3).deleteObject((String) any(), (String) any());
        assertEquals("foo.txtsuccessfully removed!", this.storageServiceImpl.deleteFile("foo.txt"));
        verify(this.amazonS3).deleteObject((String) any(), (String) any());
    }

    /**
     * Method under test: {@link StorageServiceImpl#deleteFile(String)}
     */
    @Test
    void testDeleteFile2() throws SdkClientException {
        doThrow(new RuntimeException("An error occurred")).when(this.amazonS3).deleteObject((String) any(), (String) any());
        assertThrows(RuntimeException.class, () -> this.storageServiceImpl.deleteFile("foo.txt"));
        verify(this.amazonS3).deleteObject((String) any(), (String) any());
    }
}

