package implementations;

import interfaces.UrlContentReader;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlContentReaderImpl implements UrlContentReader
{
    private String content = "";

    public UrlContentReaderImpl()
    {}

    public String urlRead(String urlString)
    {
        try
        {
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            InputStream in = con.getInputStream();
            String encoding = con.getContentEncoding();  // ** WRONG: should use "con.getContentType()" instead but it returns something like "text/html; charset=UTF-8" so this value must be parsed to extract the actual encoding
            encoding = encoding == null ? "UTF-8" : encoding;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buf = new byte[8192];
            int len = 0;
            while ((len = in.read(buf)) != -1) {
                baos.write(buf, 0, len);
            }
            this.content = new String(baos.toByteArray(), encoding);
            in.close();
        }
        // MalformedURLException contained in IOException
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return this.content;
    }
}