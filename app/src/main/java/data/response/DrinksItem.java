package data.response;

import com.google.gson.annotations.SerializedName;

public class DrinksItem{

	@SerializedName("name")
	private String name;

	public String getName(){
		return name;
	}
}