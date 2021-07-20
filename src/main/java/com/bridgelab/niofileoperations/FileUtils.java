package com.bridgelab.niofileoperations;

import java.io.File;

/***********************************************************
 * @author mihir
 *
 * @since 20-July-2021
 *
 * This class contains method that deletes files from system.
 ***********************************************************/
public class FileUtils
{
    public static boolean deleteFiles(File contentsToDelete)
    {
        File[] allContents = contentsToDelete.listFiles();
        if (allContents != null)
        {
            for (File file : allContents)
            {
                deleteFiles(file);
            }
        }
        return contentsToDelete.delete();
    }
}
