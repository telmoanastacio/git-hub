package com.tsilva;

import org.springframework.core.codec.DecodingException;

import java.util.Base64;

public class Base64DecoderImpl implements Base64Decoder
{
    public Base64DecoderImpl()
    {}

    public String getDecodedContent(String encodedContent)
    {
        try
        {
            byte[] decoded = Base64.getMimeDecoder().decode(encodedContent);
            String result = "";
            for(byte byteChar : decoded)
            {
                result = result + ((char) byteChar);
            }
            return result;
        }
        catch(DecodingException e)
        {
            e.printStackTrace();
            System.out.println("== decoding exception ==");
            return null;
        }
    }
}