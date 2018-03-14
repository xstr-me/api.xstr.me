package me.xstr.api.batch.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.zip.GZIPInputStream;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

public class GzipLazyResource extends UrlResource implements Resource {

    public GzipLazyResource(URL url) {
        super(url);
    }

	@Override
    public InputStream getInputStream() throws IOException {
        return new GZIPInputStream(super.getInputStream());
    }
}
