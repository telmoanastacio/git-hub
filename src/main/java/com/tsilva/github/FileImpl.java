package com.tsilva.github;

public class FileImpl implements File
{
    // TODO: getFileContent()
    public final String PATH;

    public FileImpl(String path)
    {
        this.PATH = path;
    }

    public String getPATH()
    {
        return PATH;
    }
}