package com.tsilva.github;

import java.util.List;

public class DirectoryImpl
{
    // == variables ==
    private final String PATH;
    // List containing Directory or File objects contained inside this one
    private List<Object> layer;

    // == constructors ==
    public DirectoryImpl(String path, List<Object> layer)
    {
        this.PATH = path;
        this.layer = layer;

        // INIT Directory is only known the path not what it contains so pass null at layer
        if(this.layer == null)
        {
            // TODO: search the layer and put it inside the List layer
        }
    }

    // == public methods ==
    public String getPATH()
    {
        return PATH;
    }

    public List<Object> getLAYER()
    {
        return layer;
    }

    // == private methods
    private void setLayer(List<Object> layer)
    {
        this.layer = layer;
    }
}