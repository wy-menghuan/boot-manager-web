package com.pinyougou.pojo;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class TbBrand implements Serializable{
    private Long id;

    private String name;

    private String firstChar;
    
    private String bic;
    
   // private MultipartFile file;

    /*public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}*/

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFirstChar() {
        return firstChar;
    }

    public void setFirstChar(String firstChar) {
        this.firstChar = firstChar == null ? null : firstChar.trim();
    }

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	@Override
	public String toString() {
		return "TbBrand [id=" + id + ", name=" + name + ", firstChar=" + firstChar + ", bic=" + bic + "]";
	}
	
	
    
    
}