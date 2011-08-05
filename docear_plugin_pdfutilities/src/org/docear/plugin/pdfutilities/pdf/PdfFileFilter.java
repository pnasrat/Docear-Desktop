package org.docear.plugin.pdfutilities.pdf;

import java.io.File;
import java.io.FileFilter;
import java.net.URI;

import org.docear.plugin.pdfutilities.util.Tools;

public class PdfFileFilter implements FileFilter{
	
	public boolean accept(File file) {
        if(file == null) return false;
        
        String path = file.getPath();

        return file.exists() && accept(path);
    }
	
	public boolean accept(URI uri){
		File file = Tools.getFilefromUri(uri);
		if(file == null){
			return false;
		}
		else{
			return this.accept(file);
		}	
	}

    public boolean accept(String path) {
        if(path == null || path.trim().length()==0) return false;
        
        if(path.matches(".*[.][pP][dD][fF]")){
            return true;
        }        
        else{
            return false;
        }
    }

    

}
