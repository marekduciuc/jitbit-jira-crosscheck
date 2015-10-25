package eu.pricefx.monitoring.tickets.crossChecker.model.jitbit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "FileName", "FileData", "FileID", "CommentID",
		"CommentDate", "FileHash", "FileSize", "IssueID", "UserID",
		"GoogleDriveUrl", "DropboxUrl", "ForTechsOnly", "Url" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class Attachment {

	@JsonProperty("FileName")
	private String FileName;
	@JsonProperty("FileData")
	private Object FileData;
	@JsonProperty("FileID")
	private Integer FileID;
	@JsonProperty("CommentID")
	private Integer CommentID;
	@JsonProperty("CommentDate")
	private String CommentDate;
	@JsonProperty("FileHash")
	private Object FileHash;
	@JsonProperty("FileSize")
	private Integer FileSize;
	@JsonProperty("IssueID")
	private Integer IssueID;
	@JsonProperty("UserID")
	private Integer UserID;
	@JsonProperty("GoogleDriveUrl")
	private Object GoogleDriveUrl;
	@JsonProperty("DropboxUrl")
	private Object DropboxUrl;
	@JsonProperty("ForTechsOnly")
	private Boolean ForTechsOnly;
	@JsonProperty("Url")
	private String Url;

	/**
	 * 
	 * @return The FileName
	 */
	@JsonProperty("FileName")
	public String getFileName() {
		return FileName;
	}

	/**
	 * 
	 * @param FileName
	 *            The FileName
	 */
	@JsonProperty("FileName")
	public void setFileName(String FileName) {
		this.FileName = FileName;
	}

	/**
	 * 
	 * @return The FileData
	 */
	@JsonProperty("FileData")
	public Object getFileData() {
		return FileData;
	}

	/**
	 * 
	 * @param FileData
	 *            The FileData
	 */
	@JsonProperty("FileData")
	public void setFileData(Object FileData) {
		this.FileData = FileData;
	}

	/**
	 * 
	 * @return The FileID
	 */
	@JsonProperty("FileID")
	public Integer getFileID() {
		return FileID;
	}

	/**
	 * 
	 * @param FileID
	 *            The FileID
	 */
	@JsonProperty("FileID")
	public void setFileID(Integer FileID) {
		this.FileID = FileID;
	}

	/**
	 * 
	 * @return The CommentID
	 */
	@JsonProperty("CommentID")
	public Integer getCommentID() {
		return CommentID;
	}

	/**
	 * 
	 * @param CommentID
	 *            The CommentID
	 */
	@JsonProperty("CommentID")
	public void setCommentID(Integer CommentID) {
		this.CommentID = CommentID;
	}

	/**
	 * 
	 * @return The CommentDate
	 */
	@JsonProperty("CommentDate")
	public String getCommentDate() {
		return CommentDate;
	}

	/**
	 * 
	 * @param CommentDate
	 *            The CommentDate
	 */
	@JsonProperty("CommentDate")
	public void setCommentDate(String CommentDate) {
		this.CommentDate = CommentDate;
	}

	/**
	 * 
	 * @return The FileHash
	 */
	@JsonProperty("FileHash")
	public Object getFileHash() {
		return FileHash;
	}

	/**
	 * 
	 * @param FileHash
	 *            The FileHash
	 */
	@JsonProperty("FileHash")
	public void setFileHash(Object FileHash) {
		this.FileHash = FileHash;
	}

	/**
	 * 
	 * @return The FileSize
	 */
	@JsonProperty("FileSize")
	public Integer getFileSize() {
		return FileSize;
	}

	/**
	 * 
	 * @param FileSize
	 *            The FileSize
	 */
	@JsonProperty("FileSize")
	public void setFileSize(Integer FileSize) {
		this.FileSize = FileSize;
	}

	/**
	 * 
	 * @return The IssueID
	 */
	@JsonProperty("IssueID")
	public Integer getIssueID() {
		return IssueID;
	}

	/**
	 * 
	 * @param IssueID
	 *            The IssueID
	 */
	@JsonProperty("IssueID")
	public void setIssueID(Integer IssueID) {
		this.IssueID = IssueID;
	}

	/**
	 * 
	 * @return The UserID
	 */
	@JsonProperty("UserID")
	public Integer getUserID() {
		return UserID;
	}

	/**
	 * 
	 * @param UserID
	 *            The UserID
	 */
	@JsonProperty("UserID")
	public void setUserID(Integer UserID) {
		this.UserID = UserID;
	}

	/**
	 * 
	 * @return The GoogleDriveUrl
	 */
	@JsonProperty("GoogleDriveUrl")
	public Object getGoogleDriveUrl() {
		return GoogleDriveUrl;
	}

	/**
	 * 
	 * @param GoogleDriveUrl
	 *            The GoogleDriveUrl
	 */
	@JsonProperty("GoogleDriveUrl")
	public void setGoogleDriveUrl(Object GoogleDriveUrl) {
		this.GoogleDriveUrl = GoogleDriveUrl;
	}

	/**
	 * 
	 * @return The DropboxUrl
	 */
	@JsonProperty("DropboxUrl")
	public Object getDropboxUrl() {
		return DropboxUrl;
	}

	/**
	 * 
	 * @param DropboxUrl
	 *            The DropboxUrl
	 */
	@JsonProperty("DropboxUrl")
	public void setDropboxUrl(Object DropboxUrl) {
		this.DropboxUrl = DropboxUrl;
	}

	/**
	 * 
	 * @return The ForTechsOnly
	 */
	@JsonProperty("ForTechsOnly")
	public Boolean getForTechsOnly() {
		return ForTechsOnly;
	}

	/**
	 * 
	 * @param ForTechsOnly
	 *            The ForTechsOnly
	 */
	@JsonProperty("ForTechsOnly")
	public void setForTechsOnly(Boolean ForTechsOnly) {
		this.ForTechsOnly = ForTechsOnly;
	}

	/**
	 * 
	 * @return The Url
	 */
	@JsonProperty("Url")
	public String getUrl() {
		return Url;
	}

	/**
	 * 
	 * @param Url
	 *            The Url
	 */
	@JsonProperty("Url")
	public void setUrl(String Url) {
		this.Url = Url;
	}

}
