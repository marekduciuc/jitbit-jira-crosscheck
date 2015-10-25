package eu.pricefx.monitoring.tickets.crossChecker.model.jitbit;

import java.util.HashMap;
import java.util.Map;

public class Tag {

	private Integer TagID;
	private String Name;
	private Integer TagCount;

	/**
	 * 
	 * @return The TagID
	 */
	public Integer getTagID() {
		return TagID;
	}

	/**
	 * 
	 * @param TagID
	 *            The TagID
	 */
	public void setTagID(Integer TagID) {
		this.TagID = TagID;
	}

	/**
	 * 
	 * @return The Name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * 
	 * @param Name
	 *            The Name
	 */
	public void setName(String Name) {
		this.Name = Name;
	}

	/**
	 * 
	 * @return The TagCount
	 */
	public Integer getTagCount() {
		return TagCount;
	}

	/**
	 * 
	 * @param TagCount
	 *            The TagCount
	 */
	public void setTagCount(Integer TagCount) {
		this.TagCount = TagCount;
	}


}