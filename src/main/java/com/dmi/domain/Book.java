package com.dmi.domain;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * 
 * The Book class is an model object witch describe each book
 * 
 * @author Robson Martins
 *
 */

@Entity
public class Book extends BookBase{

    /**
     * The default serial version UID.
     */
    private static final long serialVersionUID = 1L;
    
    @NotNull
    private String author;
    
    private String image;

    public Book(){}
    		
	public Book(Long id, String title, Double price, String link) {
		super(id, title, price, link);
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		return true;
	}

	
}
