package data.response;

import com.google.gson.annotations.SerializedName;

public class CategoriesItem{

	@SerializedName("name")
	private String name;

	public String getName(){
		return name;
	}
}